package gr.scram.wicket.components;

import gr.scram.wicket.utils.ReflectionUtils;
import gr.scram.wicket.utils.Utils;

import java.beans.PropertyDescriptor;
import java.util.Comparator;

import org.apache.wicket.WicketRuntimeException;


/**
 * Comparator based on the value of a property of two objects.
 * This comparator compares two objects that belong to the same type 
 * by comparing the values of a specified property on both objects.
 * The type of the property used for comparison must be a sub-type
 * of Comparable. <br/> 
 *  
 * @param <T> Type of objects being compared by this class.
 * @author asvesdi
 *
 * @param <T>
 */
public class PropertyBasedComparator<T> 
implements Comparator<T> {
	/**
	 * Property descriptor that describes the property of the class used to
	 * compare two different objects.
	 */
	private PropertyDescriptor pd;
	

	/**
	 * Creates a new PropertyBasedComparator object. 
	 * @param type the class type
	 * @param property  the order property.
	 */
	public PropertyBasedComparator(Class<T> type, String property) {
		super();
		this.pd = ReflectionUtils.getPropertyDescriptor(type, property);		
		if (this.pd == null) {
			try {
				ReflectionUtils.invalidPropertyName(type, property);
			} catch (Exception e) {
				throw new WicketRuntimeException(e);
			}
		}else{
			Class<?> propertyType = pd.getPropertyType();
			
			if ( ReflectionUtils.isPrimitive(propertyType) ){
				propertyType = ReflectionUtils.wrap(propertyType);
			}
			
			if (!Comparable.class.isAssignableFrom(propertyType)) {
				@SuppressWarnings("nls")
				String msg = "The property ".concat(property)
						.concat(" of type ").concat(type.getName())
						.concat(" is of type ").concat(propertyType.getName())
						.concat(" which is not Comparable");
				throw new RuntimeException(msg);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(T o1, T o2) {
		Object prop1= null;
		Object prop2 = null;
		try {
			prop1 = ReflectionUtils.getProperty(pd, o1);
			prop2 = ReflectionUtils.getProperty(pd, o2);
		} catch (Exception e) {
			throw new WicketRuntimeException(e);
		}
		Comparable c1 = (Comparable) prop1;
		Comparable c2 = (Comparable) prop2;
		return Utils.nullSafeCompare(c1, c2);
	}
	
	

}
