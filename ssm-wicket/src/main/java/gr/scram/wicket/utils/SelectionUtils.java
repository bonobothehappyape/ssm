package gr.scram.wicket.utils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Utility class with methods that select items from Collections.
 */
public class SelectionUtils {

	/**
	 * Gets the element of a collection that has the maximum value in a
	 * specified property.
	 * 
	 * Example, if the collection contains elemetns of type Person, and the
	 * class Person has a property age that is of type Integer, then calling
	 * this method on the collection with argument age for property name, would
	 * return the oldest person.
	 * 
	 * @param collection Collection with the elements in which the element with the
	 *            maximum value of an element is searched.
	 * @param propertyName  Name of the property that is used for the comparison. The type
	 *            of this property must be comparable with it self.
	 * @param <T> Type of elements in the collection.
	 * @param <V> Type of the property specified by <code>propertyName</code>
	 * 
	 * 
	 * @return Returns the element that has the maximum property with the name
	 *         specified by <code>propertyName</code> in the collection. If the
	 *         collection is empty, then returns null.
	 * @throws Exception 
	 */
	public static <T, V extends Comparable<? super V>> T max(
			Collection<T> collection, String propertyName) throws Exception {
		V maxElement = null;
		T maxElementOwner = null;
		for (T t : collection) {
			@SuppressWarnings("unchecked")
			V v = (V) ReflectionUtils.getProperty(propertyName, t);
			if (maxElementOwner == null
					|| Utils.nullSafeCompare(maxElement, v) < 0) {
				maxElementOwner = t;
				maxElement = v;
			}
		}
		return maxElementOwner;
	}

	/**
	 * Gets the element of a collection that has the maximum value in a
	 * specified property.
	 * 
	 * Example, if the collection contains elements of type Person, and the
	 * class Person has a property age that is of type Integer, then calling
	 * this method on the collection with argument age for property name, would
	 * return the oldest person.
	 * 
	 * @param collection
	 *            Collection with the elements in which the element with the
	 *            maximum value of an element is searched.
	 * @param propertyName
	 *            Name of the property that is used for the comparison. The type
	 *            of this property must be comparable with it self.
	 * @param <T>
	 *            Type of elements in the collection.
	 * @param <V>
	 *            Type of the property specified by <code>propertyName</code>
	 * 
	 * 
	 * @return Returns the element that has the maximum property with the name
	 *         specified by <code>propertyName</code> in the collection. If the
	 *         collection is empty, then returns null.
	 * @throws Exception 
	 */
	public static <T, V extends Comparable<? super V>> T min(
			Collection<T> collection, String propertyName) throws Exception {
		V minElement = null;
		T minElementOwner = null;
		for (T t : collection) {
			@SuppressWarnings("unchecked")
			V v = (V) ReflectionUtils.getProperty(propertyName, t);

			if (minElementOwner == null
					|| Utils.nullSafeCompare(minElement, v) > 0) {
				minElement = v;
				minElementOwner = t;
			}
		}
		return minElementOwner;
	}

	/**
	 * Gets the items with the specified name from a collection of object's that
	 * have a property name.
	 * 
	 * @param name
	 *            Name being searched.
	 * @param collection
	 *            Collection of objects.
	 * @param type
	 *            Type of objects in the collection.
	 * @param <T>
	 *            Type of objects in the collection.
	 * 
	 * @return Returns a list with all elements of the specified collection that
	 *         have the specified name.
	 * @throws Exception 
	 */
	public static <T> List<T> selectByName(final String name,
			final Collection<T> collection,final Class<T> type) throws Exception {
		return selectByProperty("name", name, collection, type); //$NON-NLS-1$
	}

	/**
	 * Gets the items with the specified name from a collection of object's that
	 * have a property name.
	 * 
	 * @param property
	 *            Name of property being used as selection criterion.
	 * @param value
	 *            Value of selection criterion. It can be null.
	 * @param collection
	 *            Collection of objects.
	 * @param type
	 *            Type of objects in the collection.
	 * @param <T>
	 *            Type of objects in the collection.
	 * 
	 * @return Returns a list with all elements of the specified collection that
	 *         have the specified property equal to the specified value.
	 * @throws Exception 
	 */
	public static <T> List<T> selectByProperty(String property, Object value,
			Collection<T> collection, Class<T> type) throws Exception {
		PropertyDescriptor pd = ReflectionUtils.getPropertyDescriptor(type,
				property);
		if (pd == null) {
			ReflectionUtils.invalidPropertyName(type, property);
		}
		List<T> selection = new ArrayList<T>();
		for (T t : collection) {
			Object actual = ReflectionUtils.getProperty(pd, t);
			if (Utils.equals(value, actual)) {
				selection.add(t);
			}
		}
		return selection;
	}

}