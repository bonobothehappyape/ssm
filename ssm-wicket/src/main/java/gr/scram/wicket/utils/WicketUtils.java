package gr.scram.wicket.utils;

import java.util.Collection;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.Model;


/**
 * Common utility functions.
 * 
 * @author asvesdi
 */
public final class WicketUtils {
	
	/**
	 * String.
	 */
	private static final String CLASS = "class";

	/**
	 * Error class appender.
	 */
	public static final AttributeAppender ERR_CLASS_APPENDER = new AttributeAppender(
			WicketUtils.CLASS, new Model<String>("ErrorData"));
	
	/**
	 * required appender.
	 */
	public static final AttributeAppender REQU_CLASS_APPENDER = new AttributeAppender(
			WicketUtils.CLASS, new Model<String>("RequiredData"));

	/**
	 * disable appender.
	 */
	public static final AttributeAppender DISABLED_CLASS_APPENDER = new AttributeAppender(
			WicketUtils.CLASS, new Model<String>("DisabledData"));


	/**
	 * Checks nullability of objects passed as parameters.
	 * 
	 * @param obj
	 *            the objects to check.
	 * @return <code>true</code> if any of the parameters is null or empty
	 *         string or empty collection.
	 */
	public static boolean isNullOrEmpty(Object... obj) {
		if (obj == null || obj.length == 0) {
			return true;
		}
		for (Object value : obj) {
			if (value == null) {
				return true;
			}
			if (value instanceof String) {
				return String.class.cast(value).trim().length() == 0;
			} else if (value instanceof Collection<?>) {
				return ((Collection<?>) value).isEmpty();
			}
		}
		return false;
	}

	/**
	 * defeat instantiation.
	 * @throws IllegalAccessException thrown when accessed inside class
	 */
	private WicketUtils() throws IllegalAccessException{
		throw new IllegalAccessException();
	}

	/**
	 * Assigns css classes to the given component according to its state.
	 * 
	 * @param component
	 *            the component to be used.
	 */
	public static void renderComponentClasses(Component component) {
		removeComponentBehavior(component, REQU_CLASS_APPENDER,
				ERR_CLASS_APPENDER, DISABLED_CLASS_APPENDER);
		if (!component.isEnabled()) {
			component.add(DISABLED_CLASS_APPENDER);
			return;
		}
	}

	/**
	 * Removes the given behaviors from the given component.
	 * 
	 * @param component
	 *            the component to be used.
	 * @param behaviors
	 *            the behaviors to be removed.
	 */
	private static void removeComponentBehavior(Component component,
			Behavior... behaviors) {
		for (Behavior b : behaviors) {
			if (component.getBehaviors().contains(b)) {
				component.remove(b);
			}
		}
	}
}