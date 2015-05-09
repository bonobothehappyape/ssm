package gr.scram.wicket.utils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

import com.google.common.collect.ImmutableMap;

/**
 * Utilities relevant with the java reflection API.
 * 
 * @author asvesdi
 * 
 */
public class ReflectionUtils {

	/**
	 * Constant.
	 */
	private static final String GET = "get";
	/**
	 * Constant.
	 */
	private static final String NO_SUCH_FIELD = "No such field: ";
	/**
	 * Gets all fields declared in a type's hierarchy including fields declared
	 * in super-types, as long as the super-type belongs to a base type.
	 * 
	 * @param type Type who's fields this method will return.
	 * @param baseType Base super-type beyond which, the type hierarchy will be
	 *            ignored.
	 * @return Returns a collection with all fields of the type.
	 */
	public static List<Field> allFields(final Class<?> type, final Class<?> baseType) {
		final ArrayList<Field> fields = new ArrayList<Field>();
		final List<Field> declaredFields = Arrays.asList(type.getDeclaredFields());
		for (final Field field : declaredFields) {
			if (!field.isSynthetic()) {
				fields.add(field);
			}
		}
		final Class<?> supertype = type.getSuperclass();
		if (supertype != null && baseType.isAssignableFrom(supertype)) {
			final List<Field> superTypeFields = allFields(supertype, baseType);
			fields.addAll(superTypeFields);
		}
		return fields;
	}
	/**
	 * Gets all methods declared in a type delegating to method {@link Class}
	 * getDeclareMethods Omits synthetic methods.
	 * @param type
	 *            Type who's fields this method will return.
	 * @return Returns a collection with all methods of the type.
	 * @throws Exception 
	 */
	public static List<Method> getDeclaredMethodsAsList(final Class<?> type) throws Exception {
		final Method[] methods = getDeclaredMethods(null, type);
		return Arrays.asList(methods);
	}
	/**
	 * Gets all methods declared in a type that are annotated with a specified
	 * annotation.
	 * @param type Type who's fields this method will return.
	 * @param annotation  Annotation
	 * @return Returns a collection with all annotated methods of the type.
	 * @throws Exception 
	 */
	public static List<Method> getAnnotatedMethods(final Class<?> type,
			final Class<? extends Annotation> annotation) throws Exception {
		final List<Method> annotated = new ArrayList<Method>();
		final List<Method> declared = getDeclaredMethodsAsList(type);
		for (final Method m : declared) {
			if (m.isAnnotationPresent(annotation)) {
				annotated.add(m);
			}
		}
		return annotated;
	}
	/**
	 * Copies common properties of an object to another.
	 * 
	 * The method will copy all properties of the source object to the target
	 * object. The property will be copied only if it has the same type in both
	 * objects. Source and target object don't need to be instances of the same
	 * class.
	 * 
	 * @param source
	 *            Object who's properties will be copied to the target object.
	 * @param target
	 *            Object to which the properties will be copied.
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void copyProperties(final Object source, final Object target)
			throws IllegalAccessException, InvocationTargetException {
		copyProperties(source, target, null);
	}
	/**
	 * Copies common properties of an object to another. The method will copy
	 * all properties of the source object that have their name included in the
	 * properties array, to the target object. The property will be copied only
	 * if it has the same type in both objects. Source and target object don't
	 * need to be instances of the same class.
	 * 
	 * @param source Object who's properties will be copied to the target object.
	 * @param target Object to which the properties will be copied.
	 * @param properties
	 *            Names of properties to copy. If this array is empty or null
	 *            then all properties of source will be copied to the target.
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void copyProperties(final Object source, final Object target,
			final String[] properties) throws IllegalAccessException,
			InvocationTargetException {
		final Map<String, PropertyDescriptor> targetProperties = ReflectionUtils
				.getBeansPropertiesMap(target.getClass());
		final Map<String, PropertyDescriptor> sourceProperties = ReflectionUtils
				.getBeansPropertiesMap(source.getClass());
		Map<String, PropertyDescriptor> propertiesToCopy 
			= null;

		if (properties != null && properties.length != 0) {
			propertiesToCopy = new HashMap<String, PropertyDescriptor>();
			for (int i = 0; i < properties.length; i++) {
				final PropertyDescriptor pd = sourceProperties.get(properties[i]
						.trim());
				if (pd != null) {
					propertiesToCopy.put(pd.getName(), pd);
				}
			}
		} else {
			propertiesToCopy = sourceProperties;
		}
		iterate(source, target, targetProperties, propertiesToCopy);
	}

	/**
	 * Iterate over properties.
	 * @param source source object
	 * @param target target object
	 * @param targetProperties target properties
	 * @param propertiesToCopy properties to copy
	 * @throws IllegalAccessException IllegalAccessException
	 * @throws InvocationTargetException InvocationTargetException
	 */
	private static void iterate(final Object source, final Object target,
			final Map<String, PropertyDescriptor> targetProperties,
			final Map<String, PropertyDescriptor> propertiesToCopy)
			throws IllegalAccessException, InvocationTargetException {
		for (final PropertyDescriptor sourcePD : propertiesToCopy.values()) {
			final String name = sourcePD.getName();
			final PropertyDescriptor targetPD = targetProperties.get(name);
			if (targetPD != null) {
				final Class<?> targetPdType = targetPD.getPropertyType();
				final Class<?> sourcePdType = sourcePD.getPropertyType();

				if (targetPdType.isAssignableFrom(sourcePdType)) {
					final Method getter = sourcePD.getReadMethod();
					if (getter != null) {
						final Object[] getterArgs = null;
						final Object value = ReflectionUtils.invoke(getter, source,
								getterArgs);
						final Method setter = targetPD.getWriteMethod();
						if (setter != null) {
							final Object[] setterArgs = { value };
							ReflectionUtils.invoke(setter, target, setterArgs);
						}
					}
				}
			}
		}
	}

	/**
	 * Gets all fields that have been marked with a specified annotation.
	 * 
	 * @param fields
	 *            Collection of fields.
	 * @param annotation
	 *            Annotation.
	 * @return Returns a list containing the eements of the fields collection
	 *         that have been marked with the specified annotation.
	 */
	public static List<Field> getAnnotated(final Collection<Field> fields,
			final Class<? extends Annotation> annotation) {

		final ArrayList<Field> list = new ArrayList<Field>();
		for (final Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(annotation)) {
				list.add(field);
			}
		}
		return list;
	}

	/**
	 * Gets the first field of type that can can be assigned to the
	 * requiredType.
	 * 
	 * @param requiredType
	 *            required type
	 * @param type
	 *            type
	 * @return Returns the first field of type that can can be assigned to the
	 *         requiredType.
	 */
	public static Field getFirstByType(final Class<?> requiredType, final Class<?> type) {
		final List<Field> fields = allFields(type, Object.class);
		for (final Field field : fields) {
			final Class<?> fieldType = field.getType();
			if (requiredType.isAssignableFrom(fieldType)) {
				field.setAccessible(true);
				return field;
			}
		}
		return null;
	}

	/**
	 * Finds the properties of a bean.
	 * 
	 * <li>If the bean is a concrete class the properties of the bean, for which
	 * there exists a setter method, a getter method or both. Properties of
	 * super-types are returned as well.</li> <li>If the bean is an abstract
	 * class, an empty array is returned</li> <li>If the bean is an interface,
	 * the properties of the bean are returned. The method also queries all
	 * super-interfaces and fetches their properties as well.</li>
	 * 
	 * @param type
	 *            the bean
	 * @return Returns the property descriptors of a java bean.
	 */
	public static PropertyDescriptor[] getBeansProperties(final Class<?> type) {
		final ArrayList<PropertyDescriptor> propertyDescriptor
			= new ArrayList<PropertyDescriptor>();
		for (final PropertyDescriptor p : PropertyUtils.getPropertyDescriptors(type)) {
			if (!propertyDescriptor.contains(p) && !"class".equals(p.getName())) {
				propertyDescriptor.add(p);
			}
		}
		if (type.isInterface()) {
			final Class<?>[] classArray = type.getInterfaces();
			PropertyDescriptor[] pdArray;
			for (final Class<?> next : classArray) {
				pdArray = getBeansProperties(next);
				for (final PropertyDescriptor pd : pdArray) {
					if (!propertyDescriptor.contains(pd)) {
						propertyDescriptor.add(pd);
					}
				}
			}
		}
		return propertyDescriptor.toArray(new PropertyDescriptor[0]);
	}

	/**
	 * Gets a method that has a specified name.
	 * 
	 * @param methodName
	 *            Method name.
	 * @param type
	 *            Type on which the method is searched.
	 * @param args
	 *            Argument types.
	 * @return Returns the method that matches the search criteria. If there is
	 *         no method matching the search criteria, returns null.
	 */
	public static Method getPublicMethod(final String methodName, final Class<?> type,
			final Class<?>... args) {
		try {
			return type.getMethod(methodName, args);
		} catch (final SecurityException e) {
			return null;
		} catch (final NoSuchMethodException e) {
			return null;
		}
	}

	/**
	 * Gets a method that takes no parameters and has a specified name.
	 * 
	 * @param methodName
	 *            Method name.
	 * @param type
	 *            Type on which the method is searched.
	 * @return Returns the method that matches the search criteria. If there is
	 *         no method matching the search criteria, returns null.
	 */
	public static Method getPublicMethodWithoutParamsByName(final String methodName,
			final Class<?> type) {
		final Class<?>[] paramTypes = null;
		try {
			return type.getMethod(methodName, paramTypes);
		} catch (final SecurityException e) {
			return null;
		} catch (final NoSuchMethodException e) {
			return null;
		}
	}

	/**
	 * Gets all methods of the specified class with the specified name.
	 * 
	 * @param methodName
	 *            Method name.
	 * @param type
	 *            Type on which the method is searched.
	 * @return Returns the method that matches the search criteria. If there is
	 *         no method matching the search criteria, returns null.
	 * @throws Exception 
	 */
	public static List<Method> getPublicMethodsByName(final String methodName,
			final Class<?> type) throws Exception {
		final List<Method> list = Arrays.asList(type.getMethods());
		return SelectionUtils.selectByName(methodName, list, Method.class);
	}

	/**
	 * Returns an array with all methods declared in the type that match one of
	 * the method names provided in the String[]. If the methodNames array is
	 * empty or null, then synthetic methods are ignored. Inherited methods are
	 * not included.
	 * 
	 * @param methodNames
	 *            methodNames to match
	 * @param type
	 *            the type to inspect
	 * @return an array of methods of the type that match a methodName within
	 *         methodNames
	 * @throws Exception 
	 */
	public static Method[] getDeclaredMethods(final String[] methodNames,
			final Class<?> type) throws Exception {
		final boolean methodNamesDefined = (methodNames != null && methodNames.length > 0);
		if (methodNamesDefined) {// get only the declared methods with the
									// specified names.
			final Method[] methods = new Method[methodNames.length];
			int ctr = 0;
			for (final String methodName : methodNames) {
				int countOfMethodsWithThisName = 0;
				for (final Method method : type.getDeclaredMethods()) {
					if (method.getName().equals(methodName)) {
						methods[ctr] = method;
						ctr++;
						countOfMethodsWithThisName++;
					}
				}
				if (countOfMethodsWithThisName == 0) {
					final StringBuilder sb = new StringBuilder();
					sb.append("Method ").append(methodName)
							.append(" not declared in class ")
							.append(type.getName());
					throw new Exception(sb.toString());
				}

			}
			return methods;
		} else {// get all declared methods

			final List<Method> list = new ArrayList<Method>();
			for (final Method method : type.getDeclaredMethods()) {
				if (!method.isSynthetic()) {
					list.add(method);
				}
			}
			return list.toArray(new Method[0]);
		}
	}

	/**
	 * Finds the properties of a bean and returns them in a {@link HashMap} with
	 * the property name as key.
	 * 
	 * @param type
	 *            the bean
	 * @return Returns the property descriptors of a java bean.
	 * @see #getBeansProperties(Class)
	 * 
	 */
	public static Map<String, PropertyDescriptor> getBeansPropertiesMap(
			final Class<?> type) {
		final PropertyDescriptor[] array = ReflectionUtils.getBeansProperties(type);
		final HashMap<String, PropertyDescriptor> properties 
			= new HashMap<String, PropertyDescriptor>();
		for (int i = 0; i < array.length; i++) {
			properties.put(array[i].getName(), array[i]);
		}
		return properties;
	}

	/**
	 * Gets the value of a field on an object. The method will box any
	 * {@link Exception} thrown during java reflection calls inside a
	 * {@link RuntimeException}.
	 * 
	 * @param field
	 *            Field that will be evaluated on an object.
	 * @param obj
	 *            Object on which the field is evaluated.
	 * @return Returns the value of the field on the specified object.
	 * @throws IllegalAccessException
	 *             illegale access exception.
	 * @throws
	 */
	public static Object get(final Field field, final Object obj)
			throws IllegalAccessException {
		return field.get(obj);
	}

	/**
	 * Gets the value of a field on an object. The method searches for the field
	 * in all super classes of the object. Because of the way the allFields()
	 * method works, priority is given on fields that are declared as close as
	 * possible to the class of parameter obj. For example, if the superclass of
	 * obj's class declares a private field that has the same name with one of
	 * the fields declared in obj's class, this will not be accessed. Instead,
	 * the method will access the field declared directly in obj's class.
	 * 
	 * @param fieldName
	 *            Name of the field that will be evaluated on an object.
	 * @param obj
	 *            Object on which the field is evaluated.
	 * @return Returns the value of the field on the specified object.
	 * @throws Exception 
	 */
	public static Object get(final String fieldName, final Object obj) throws Exception {
		final List<Field> allFields = allFields(obj.getClass(), Object.class);
		Field field = null;
		for (final Field f : allFields) {
			if (f.getName().equals(fieldName)) {
				field = f;
				break;
			}
		}
		if (field != null) {
			field.setAccessible(true);
			return get(field, obj);
		} else {
			final String msg = ReflectionUtils.NO_SUCH_FIELD + fieldName; //$NON-NLS-1$
			throw new Exception(msg);
		}
	}

	/**
	 * Indicates if the specified class has a field with the specified name and
	 * type.
	 * 
	 * @param type
	 *            Type checked for field excistence.
	 * @param fieldName
	 *            Name of field
	 * @param fieldType
	 *            Type of field.
	 * @return Returns true if the class has a field with this name and type.
	 * @throws NoSuchFieldException Signals that the class doesn't have a field of a specified name.
	 */
	public static boolean hasField(final Class<?> type, final String fieldName,
			final Class<?> fieldType) throws NoSuchFieldException {
			final Field field = type.getField(fieldName);
			return field.getType().equals(fieldType);
	}

	/**
	 * Sets the value of a field on an object.
	 * 
	 * The method will box any {@link Exception} thrown during java reflection
	 * calls inside a {@link RuntimeException}.
	 * 
	 * @param field
	 *            Field that will be set on an object.
	 * @param val
	 *            New value for the field.
	 * @param obj
	 *            Object on which the field value is changed.
	 * @throws IllegalAccessException 
	 */
	public static void set(final Field field, final Object val, final Object obj)
			throws  IllegalAccessException {
		if (!Modifier.isFinal(field.getModifiers())
				&& !Modifier.isStatic(field.getModifiers())) {
			field.set(obj, val);
		}
	}

	/**
	 * Sets the value of a field on an object.
	 * 
	 * The method searches for the field in all super classes of the object.
	 * Because of the way the allFields() method works, priority is given on
	 * fields that are declared as close as possible to the class of parameter
	 * obj. For example, if the superclass of obj's class declares a private
	 * field that has the same name with one of the fields declared in obj's
	 * class, this will not be accessed. Instead, the method will access the
	 * field declared directly in obj's class.
	 * 
	 * The method will box any {@link Exception} thrown during java reflection
	 * calls inside a {@link RuntimeException}.
	 * 
	 * @param fieldName
	 *            Name of the field that will be set on an object.
	 * @param val
	 *            New value for the field.
	 * @param obj
	 *            Object on which the field value is changed.
	 * @throws Exception 
	 */
	public static void set(final String fieldName, 
				final Object val, final Object obj) throws Exception {
		final List<Field> allFields = allFields(obj.getClass(), Object.class);
		Field field = null;
		for (final Field f : allFields) {
			if (f.getName().equals(fieldName)) {
				field = f;
				break;
			}
		}
		if (field != null) {
			field.setAccessible(true);
			set(field, val, obj);
		} else {
			final String msg = ReflectionUtils.NO_SUCH_FIELD + fieldName; //$NON-NLS-1$
			throw new Exception(msg);
		}

	}

	/**
	 * Sets the value of a property on an object.
	 * 
	 * If the property has a setter method, then it will be called. If the
	 * property does not have a setter method, the field will be set. If there
	 * is no such field, then the method will ignore it. <br/>
	 * The method will box any {@link Exception} thrown during java reflection
	 * calls inside a {@link RuntimeException}.
	 * 
	 * @param pd
	 *            Descriptor of the property.
	 * @param val
	 *            New value for the field.
	 * @param obj
	 *            Object on which the field value is changed.
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void setProperty(final PropertyDescriptor pd, final Object val, final Object obj)
			throws IllegalAccessException, InvocationTargetException {
		final Method setter = pd.getWriteMethod();
		if (setter != null) {
			final Object[] args = { val };
			ReflectionUtils.invoke(setter, obj, args);
		} else {
			final String fieldName = pd.getName();
			try {
				final Field field = obj.getClass().getDeclaredField(fieldName);
				field.setAccessible(true);
				ReflectionUtils.set(field, val, obj);
			} catch (final NoSuchFieldException nse) {
				nse.printStackTrace();
				/* do nothing, there is no such field */
			}

		}
	}

	/**
	 * Sets the value of a property on an object.
	 * 
	 * If the property has a setter method, then it will be called. If the
	 * property does not have a setter method, the field will be set. If there
	 * is no such field, then the method will ignore it. <br/>
	 * The method will box any {@link Exception} thrown during java reflection
	 * calls inside a {@link RuntimeException}.
	 * 
	 * @param property
	 *            Name of the property.
	 * @param val
	 *            New value for the field.
	 * @param obj
	 *            Object on which the field value is changed.
	 * @throws Exception 
	 */
	public static void setProperty(final String property,
				final Object val, final Object obj) throws Exception {
		final PropertyDescriptor pd = mandatoryProperty(property, obj);
		setProperty(pd, val, obj);
	}

	/**
	 * Gets the value of a property on an object.
	 * 
	 * If the property has a getter method, then it will be called. If the
	 * property does not have a getter method, the field will be get. If there
	 * is no such field, then a RuntimeException with cause a
	 * NoSuchFieldException will be thrown. <br/>
	 * The method will box any {@link Exception} thrown during java reflection
	 * calls inside a {@link RuntimeException}.
	 * 
	 * @param pd
	 *            Descriptor of the property.
	 * @param obj
	 *            Object on which the property is accessed.
	 * 
	 * @return Returns the value of this property.
	 * @throws Exception 
	 */
	public static Object getProperty(final PropertyDescriptor pd, final Object obj)
			throws Exception {
		final Method getter = pd.getReadMethod();
		if (getter != null) {
			return ReflectionUtils.invoke(getter, obj);
		} else {
			final String fieldName = pd.getName();
			try {
				final Field field = obj.getClass().getDeclaredField(fieldName);
				field.setAccessible(true);
				return ReflectionUtils.get(field, obj);
			} catch (final NoSuchFieldException nse) {
				throw new Exception(nse);
			}
		}
	}

	/**
	 * Gets the value of a property on an object.
	 * 
	 * If the property has a getter method, then it will be called. If the
	 * property does not have a getter method, the field will be get. If there
	 * is no such field, then a RuntimeException with cause a
	 * NoSuchFieldException will be thrown. <br/>
	 * The method will box any {@link Exception} thrown during java reflection
	 * calls inside a {@link RuntimeException}.
	 * 
	 * @param property
	 *            Name of the property.
	 * @param obj
	 *            Object on which the proeprty is accessed.
	 * 
	 * @return Returns the value of this property.
	 * @throws Exception 
	 */
	public static Object getProperty(final String property, final Object obj)
			throws Exception {
		final PropertyDescriptor pd = mandatoryProperty(property, obj);
		return getProperty(pd, obj);
	}

	/**
	 * Gets the values of a bean's properties in a map keyed with the property
	 * names.
	 * 
	 * This method transforms a javabean to a map.
	 * 
	 * @param obj
	 *            Java bean to transform to map.
	 * 
	 * @return Returns a map that has an entry for each property of the
	 *         specified object.
	 * @throws Exception 
	 */
	public static Map<String, Object> getProperties(final Object obj)
			throws Exception {
		final Map<String, PropertyDescriptor> descriptors = getBeansPropertiesMap(obj
				.getClass());
		final Map<String, Object> values = new HashMap<String, Object>();
		for (final Map.Entry<String, PropertyDescriptor> entry : descriptors
				.entrySet()) {
			final PropertyDescriptor pd = entry.getValue();
			final String name = entry.getKey();
			final Object v = getProperty(pd, obj);
			values.put(name, v);
		}
		return values;
	}

	/**
	 * Finds a property in an object.
	 * 
	 * @param property
	 *            Name of the property.
	 * @param obj
	 *            Object.
	 * @return Returns the property descriptor that describes the property.
	 * @throws Exception 
	 */
	public static PropertyDescriptor mandatoryProperty(final String property,
			final Object obj) throws Exception {
		final PropertyDescriptor pd = ReflectionUtils.getPropertyDescriptor(
				obj.getClass(), property);
		if (pd == null) {
			invalidPropertyName(obj.getClass(), property);
		}
		return pd;
	}

	/**
	 * Gets the field that has the specified annotation. The field must be
	 * unique.
	 * 
	 * @param fields
	 *            field collection
	 * @param annotation
	 *            annotation
	 * @return Returns the field with the specified annotation. Returns null if
	 *         there is no field with the specified annotation.
	 * @throws Exception 
	 */
	public static Field getUnique(final Collection<Field> fields,
			final Class<? extends Annotation> annotation) throws Exception {
		final List<Field> annotateds = getAnnotated(fields, annotation);
		if (annotateds.size() > 1) {
			final String message = "More than one fields marked with annotation " //$NON-NLS-1$
					+ annotation.getName();
			throw new Exception(message);
		}
		if (annotateds.size() == 0) {
			return null;
		}
		return annotateds.get(0);
	}

	/**
	 * Gets the getter methods of a list of properties..
	 * 
	 * @param properties
	 *            Names of properties.
	 * @param type
	 *            Type on which the getter methods is searched.
	 * @return Returns an array with the getter methods of the specified
	 *         properties.
	 */
	public static Method[] getPropertyGetters(final String[] properties, final Class<?> type) {
		final Method[] methods = new Method[properties.length];
		for (int i = 0; i < properties.length; i++) {
			final String property = firstCapital(properties[i]);
			final String getter = ReflectionUtils.GET + property; //$NON-NLS-1$
			methods[i] = getPublicMethodWithoutParamsByName(getter, type);
		}
		return methods;
	}

	/**
	 * Capitalizes the first character of string.
	 * 
	 * @param string the string to check.
	 * @return Returns the string with the first character capital.
	 */
	public static String firstCapital(final String string) {
		final char[] chars = string.toCharArray();
		if (chars.length > 0) {
			chars[0] = Character.toUpperCase(chars[0]);
		}
		return new String(chars);
	}

	/**
	 * Gets the constructor of a class given an array of argument types. All
	 * caught exceptions are re-thrown as a {@link RuntimeException}.
	 * 
	 * The constructor is found by checking all constructors of the class that
	 * have the same number of parameters as the length of the given array and
	 * the array element types are assignable from the constructor parameter
	 * types one-by-one.
	 * 
	 * Use this with caution, as it is possible this check to be true for more
	 * than one constructors of a class.
	 * 
	 * @param <T>
	 *            Type
	 * @param clazz
	 *            class
	 * @param args
	 *            arguments
	 * @return a {@link Constructor} of the class.
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public static <T> Constructor<T> getConstructor(final Class<T> clazz,
			final Class<?>... args) throws Exception {
		Constructor<T>[] constructors = null;
		try {
			constructors = (Constructor<T>[]) clazz.getConstructors();
		} catch (final SecurityException e) {
			throw new Exception(e);
		}

		for (final Constructor<T> c : constructors) {
			boolean matches = true;
			final Class<?>[] params = c.getParameterTypes();
			if (params.length == args.length) {
				for (int i = 0; i < params.length; i++) {
					if (!params[i].isAssignableFrom(args[i])) {
						matches = false;
					}
				}
			} else {
				matches = false;
			}
			if (matches) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Gets the copy constructor of a class, if this class has one. A copy
	 * constructor is a constructor that takes as argument an instance of the
	 * specified class and creates a new instance by copying the specified
	 * argument. According to Josh Bloch a copy-constructor is a better
	 * alternative to using <code>clone()</code>. <br/>
	 * This method returns the constructor that takes an instance of the
	 * specified class as argument. There is no guarantee that this constructor
	 * is actually a copy constructor, so this method should be used with
	 * caution.
	 * 
	 * @param clazz
	 *            the class
	 * @param <T>
	 *            the type
	 * @return Returns the copy-constructor of the specified class, if the class
	 *         has a copy-constructor. If the class does not have a
	 *         copy-constructor, returns null.
	 * @throws Exception 
	 */
	public static <T> Constructor<T> getCopyConstructor(final Class<T> clazz) throws Exception {
		final Class<?>[] args = { clazz };
		return getConstructor(clazz, args);
	}

	/**
	 * Gets the no argument constructor of a class, if this class has one.
	 * 
	 * @param clazz
	 *            class
	 * @param <T>
	 *            type
	 * @return Returns the copy-constructor of the specified class, if the class
	 *         has a copy-constructor. If the class does not have a
	 *         copy-constructor, returns null.
	 * @throws Exception 
	 */
	public static <T> Constructor<T> getNoArgConstructor(final Class<T> clazz) throws Exception {
		final Class<?>[] args = {};
		return getConstructor(clazz, args);
	}

	/**
	 * Creates a new instance of a class using a given constructor and an
	 * appropriate array of arguments. All caught exceptions are re-thrown as a
	 * {@link RuntimeException}.
	 * 
	 * @param <T>
	 *            type
	 * @param constructor
	 *            constructor
	 * @param args
	 *            ordered array of arguments.
	 * @return Returns a new instance of the class.
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T> T newInstance(final Constructor<T> constructor, final Object... args)
			throws  InstantiationException,
			IllegalAccessException, InvocationTargetException {
		return constructor.newInstance(args);
	}

	/**
	 * Loads the class with the specified name and creates a new instance using
	 * its public no-argument constructor.
	 * 
	 * @param className
	 *            Name of the class.
	 * @param <T>
	 *            Type of the new instance.
	 * 
	 * @return Returns a new instance of the class with the specified name.
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T> T newInstance(final String className)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		@SuppressWarnings("unchecked")
		final
		Class<T> clazz = (Class<T>) Class.forName(className);
		return clazz.newInstance();
	}

	/**
	 * Creates a new instance of a class using its no argument constructor.
	 * 
	 * @param <T>
	 *            type
	 * @param clazz
	 *            class
	 * @return Returns a new instance of the class.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T> T newInstance(final Class<T> clazz)
			throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

	/**
	 * Creates a new instance of a class given a list of arguments for one of
	 * its constructors.
	 * 
	 * @param <T>
	 *            type
	 * @param clazz
	 *            class
	 * @param args
	 *            arguments
	 * @return Returns a new instance of the class.
	 * @throws Exception 
	 */
	public static <T> T newInstance(final Class<T> clazz, final Object... args)
			throws Exception {
		final Class<?>[] argTypes = new Class<?>[args.length];
		for (int i = 0; i < args.length; i++) {
			argTypes[i] = args[i].getClass();
		}
		final Constructor<T> constructor = getConstructor(clazz, argTypes);
		if (constructor == null) {
			final String msg = "Np constructor with such arguments"; //$NON-NLS-1$
			throw new  Exception(msg);
		}
		return newInstance(constructor, args);
	}

	/**
	 * Finds the property descriptor that describes a property.
	 * 
	 * @param type
	 *            The bean class.
	 * @param name
	 *            The name of the property searched.
	 * 
	 * @return Returns the property descriptor that describes the property with
	 *         the specified name. If there is no property with ths name, then
	 *         the method returns null.
	 */
	public static PropertyDescriptor getPropertyDescriptor(final Class<?> type,
			final String name) {
		final Map<String, PropertyDescriptor> descriptors = getBeansPropertiesMap(type);
		return descriptors.get(name);
	}

	/**
	 * Creates a Map that maps each element of a set with the value of one of
	 * its properties as key.
	 * 
	 * There is no guarantee that all elements of the set will be included in
	 * the output map. In case more than one items of the set have the same
	 * value of the specified property then the last element will replace the
	 * previous in the map, as only one item can be associated with one key. If
	 * any element has null on the specified property, then it will not be
	 * included in the output map.
	 * 
	 * @param set
	 *            Set that contains the elements that will be put on the output
	 *            map.
	 * @param property
	 *            Property descriptor specifying the property used to get the
	 *            key.
	 * @param <K>
	 *            Type of property used as key. This will be the type of key in
	 *            the output map.
	 * @param <T>
	 *            Type of items.
	 * @return Returns a Map that maps items of the specified set with keys the
	 *         values of a property.
	 * @throws Exception 
	 */
	public static <K, T> Map<K, T> setAsMapUsingPropertyAsKey(final Set<T> set,
			final PropertyDescriptor property) throws Exception {
		final Map<K, T> map = new HashMap<K, T>();
		for (final T item : set) {
			final Object obj = getProperty(property, item);
			@SuppressWarnings("unchecked")
			final
			K key = (K) obj;
			if (key != null) {
				map.put(key, item);
			}
		}
		return map;
	}

	/**
	 * Sets null to all fields of the super type. This method is use
	 * 
	 * @param ob
	 *            object
	 * @param annotations
	 *            annotation type array.
	 * @throws IllegalAccessException
	 *             An IllegalAccessException is thrown when an application tries
	 *             to reflectively create an instance
	 */
	public static void setNullToDuplicateFieldsOfSuper(final Object ob,
			final Class<? extends Annotation>[] annotations) throws IllegalAccessException {
		final Class<?> myClass = ob.getClass();
		final Class<?> superClass = myClass.getSuperclass();
		final List<Field> superDeclaredFields = allFields(superClass, superClass);
		final Set<Field> annotated = new HashSet<Field>();
		for (final Class<? extends Annotation> annotation : annotations) {
			final List<Field> withThisAnno = getAnnotated(superDeclaredFields,
					annotation);
			annotated.addAll(withThisAnno);
		}
		for (final Field field : annotated) {
			if (!field.getType().isPrimitive()) {
				set(field, null, ob);
			}
		}
	}

	/**
	 * Throws a {@link RuntimeException} indicating that a class does not have a
	 * property.
	 * 
	 * @param type
	 *            Type that does not have a property.
	 * @param property
	 *            Property name.
	 * @throws Exception 
	 */
	public static void invalidPropertyName(final Class<?> type,
			final String property) throws Exception {
	final StringBuilder sb = new StringBuilder();
		sb.append(type.getName())
				.append("does not have a property with the name ")
				.append(property);
		throw new  Exception(sb.toString());
	}

	/**
	 * Shows if an object is instance of a class.
	 * 
	 * The method uses runtime class information in order to find if the object
	 * belongs to the class. Therefore if the object is null, the method will
	 * return null.
	 * 
	 * @param object
	 *            Object checked for being instance of a class.
	 * @param clazz
	 *            Class.
	 * @return Returns true if object is an instance of clazz.
	 */
	public static boolean isInstanceOf(final Object object, final Class<?> clazz) {
		if (object == null) {
			return false;
		}
		final Class<?> objectType = object.getClass();
		return clazz.isAssignableFrom(objectType);
	}

	/**
	 * Invokes a method on an object.
	 * 
	 * The method will box any {@link Exception} thrown during java reflection
	 * calls inside a {@link RuntimeException}.
	 * 
	 * @param method
	 *            Method to invoke.
	 * @param target
	 *            Object on which the method will be invoked.
	 * @param args
	 *            Arguments for the method invocation. If the method does not
	 *            have any arguments, then this parameter must be null.
	 * @return Returns the object that is returned by the method. If the method
	 *         is void, then returns null.
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static Object invoke(final Method method, final Object target, final Object... args)
			throws  IllegalAccessException,
			InvocationTargetException {
		method.setAccessible(true);
		return method.invoke(target, args);
	}

	/**
	 * Gets a list with the object that are returned as the values of fields for
	 * a list of fields.
	 * 
	 * @param <T>
	 *            Type of object.
	 * @param target
	 *            Target object.
	 * @param fields
	 *            List of field objects.
	 * @param type
	 *            Type of fields.
	 * @return Returns a list containing the values of the specified fields in
	 *         the target object. Only fields of the specified type are
	 *         included.
	 * @throws IllegalAccessException
	 *             An IllegalAccessException is thrown when an application tries
	 *             to reflectively create an instance (other than an array)
	 */
	public static <T> List<T> getValuesOfFields(final Object target,
			final List<Field> fields, final Class<T> type) throws IllegalAccessException {
		final List<T> list = new ArrayList<T>();
		for (final Field field : fields) {
			field.setAccessible(true);
			final Object obj = get(field, target);
			if (obj != null) {
				if (type.isAssignableFrom(obj.getClass())) {
					@SuppressWarnings("unchecked")
					final
					T t = (T) get(field, target);
					list.add(t);
				}
			}
		}
		return list;
	}

	/**
	 * Gets the getter method of a field.
	 * 
	 * @param field
	 *            field
	 * @param clazz
	 *            class
	 * @return Returns the getter method of a field.
	 */
	public static Method getGetter(final Field field, final Class<?> clazz) {
		final String getterName = ReflectionUtils.GET + firstCapital(field.getName());
		final Method getter = ReflectionUtils.getPublicMethodWithoutParamsByName(
				getterName, clazz);
		return getter;

	}

	/**
	 * Compares an object with a given search object for filtering. Returns true
	 * if the parent object has a field that 'matches' the filed of the target
	 * object.
	 * 
	 * @param parent
	 *            parent object
	 * @param target
	 *            target object
	 * @return boolean resembles
	 * @throws Exception 
	 */
	public static boolean resembles(final Object parent, final Object target) throws Exception {
		PropertyDescriptor[] props = null;
		if (target == null) {
			return false;
		}
		if (parent.getClass() != target.getClass()) {
			return false;
		}
		props = getBeansProperties(parent.getClass());
		if (props.length > 0) {
			String val1 = null;
			String val2 = null;
			for (final PropertyDescriptor prop : props) {
				if (prop.getPropertyType().equals(String.class)) {
					val1 = (String) getProperty(prop, parent);
					val2 = (String) getProperty(prop, target);
					if (val1 == null) {
						if (val2 != null) {
							return false;
						}
					} else if (val2 != null && !val1.contains(val2)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Gets the setter method of a field.
	 * 
	 * @param field
	 *            field
	 * @param clazz
	 *            class
	 * @return Returns the setter method of a field.
	 */
	public static Method getSetter(final Field field, final Class<?> clazz) {
		final String setterName = "set" + firstCapital(field.getName()); //$NON-NLS-1$
		final Method setter = ReflectionUtils.getPublicMethod(setterName, clazz,
				field.getType());
		return setter;
	}

	/**
	 * Checks if a given instance of a bean has at least one value.
	 * 
	 * @param fields
	 *            fields to check
	 * @param instance
	 *            given instance
	 * @return true if a not null value has been found
	 * @throws IllegalAccessException
	 *             An IllegalAccessException is thrown when an application tries
	 *             to reflectively create an instance (other than an array)
	 */
	public static boolean hasAtLeastOneValue(final List<Field> fields,
			final Object instance) throws IllegalAccessException {
		boolean found = false;
		Object val = null;
		for (final Field f : fields) {
			val = get(f, instance);
			found = val != null;
			if (found) {
				break;
			}
		}
		return found;
	}
	
	/**
	 * Wrapper types to primitive.
	 */
	private static final HashSet<Class<?>> WRAPPER_TYPES = getWrapperTypes();
	
	/**
	 * find if a type is a wrapper.
	 * @param clazz class
	 * @return true or false
	 */
	public static boolean isWrapperType(final Class<?> clazz){
	        return WRAPPER_TYPES.contains(clazz);
	}
	
	/**
	 * Primitive to wrapper converter.
	 */
	private static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS
		= new ImmutableMap.Builder<Class<?>, Class<?>>()
			.put(boolean.class, Boolean.class)
			.put(byte.class, Byte.class)
			.put(char.class, Character.class)
			.put(double.class, Double.class)
			.put(float.class, Float.class)
			.put(int.class, Integer.class)
			.put(long.class, Long.class)
			.put(short.class, Short.class)
			.put(void.class, Void.class)
			.build();
	
	/**
	 * Wrap primitive to Wrapper.
	 * @param c the type
	 * @return the wrapper 
	 */
	public static Class<?> wrap(final Class<?> c) {
		return c.isPrimitive() ? (Class<?>) PRIMITIVES_TO_WRAPPERS.get(c) : c;
	}
	
	/**
	 * Return true if a type is primitive.
	 * @param c the type
	 * @return true or false
	 */
	public static boolean isPrimitive(final Class<?> c){
		return PRIMITIVES_TO_WRAPPERS.containsKey(c);
		
	}

	
	/**
	 * get the wrapper types to primitive values.
	 * @return a HashSet containing the types.
	 */
	private static HashSet<Class<?>> getWrapperTypes(){
        final HashSet<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        return ret;
    }

}