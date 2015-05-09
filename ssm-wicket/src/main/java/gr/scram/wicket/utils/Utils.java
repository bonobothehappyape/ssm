package gr.scram.wicket.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

/**
 * Utility class.
 */
public final class Utils {

	/**
	 * Hidden constructor.
	 * 
	 * This is a utility class having only static methods. There is no need to
	 * create any instance of this class.
	 */
	private Utils() {
		/* empty */
	}

	/**
	 * Replaces a null with a default value.
	 * 
	 * @param <T>
	 *            Type of method arguments and return value.
	 * 
	 * @param val
	 *            Value checked.
	 * @param defaultVal
	 *            Default value
	 * @return Returns <code>val</code> if it is not null. Otherwise returns
	 *         <code>defaultVal</code>
	 */
	public static <T> T notNull(T val, T defaultVal) {
		return val != null ? val : defaultVal;
	}

	/**
	 * Generates a hashcode from the hashcodes of the elements of an array.
	 * @param array array of elements
	 * @return Returns a hashcode.
	 */
	public static int generateHashCode(Object[] array) {
		int hash = 0;
		int magicHash = 17;
		for (int i = 0; i < array.length; i++) {
			int elementHash = array[i] == null ? 0 : array[i].hashCode();
			hash = hash + magicHash + elementHash;
		}
		return hash;
	}

	/**
	 * Equality check.
	 * 
	 * @param one object one
	 * @param two object two
	 * @return Returns true if one equals two.
	 */
	public static boolean equals(Object one, Object two) {
		if (one == two) {
			return true;
		}
		if (one == null || two == null) {
			return (one == null && two == null);
		}
		
		if (Iterable.class.isAssignableFrom(one.getClass())) {
			Iterable<?> iterOne = (Iterable<?>) one;
			Iterable<?> iterTwo = (Iterable<?>) two;
			return iterableEquals(iterOne, iterTwo);
		}
		if (Object[].class.isAssignableFrom(one.getClass())) {
			
			Object[] arrOne = (Object[]) one;
			Object[] arrTwo = (Object[]) two;
			return iterableEquals(Arrays.asList(arrOne), Arrays.asList(arrTwo));
		}
		if (one.getClass().isAssignableFrom(two.getClass())) {
			return one.equals(two);
		}
		if (two.getClass().isAssignableFrom(one.getClass())) {			
			return two.equals(one);
		}
		
		return one.equals(two);
	}
	
	/**
	 * Checks equality between two collections.
	 * 
	 * Puts all objects of each collection to an OrderedSet and then checks
	 * equality of the two ordered sets.
	 * 
	 * @param one First collection.
	 * @param two Second collection.
	 * 
	 * @return Returns true if both collections have the same count of elements
	 *         and all corresponding elements of both collections are equal. 
	 */
	private static boolean iterableEquals(Iterable<?> one, Iterable<?> two) {
		Object o1 = comparableCollection(one);
		Object o2 = comparableCollection(two);
		return o1.equals(o2);
	}
	
	/**
	 * Gets a hash-map that can be used to check equality of the 
	 * elements of two iterables.
	 * 
	 * @param iterable iterable object
	 * @return Returns a hash-map.
	 */
	private static Object comparableCollection(Iterable<?> iterable) {
		HashMap<Integer, Object> map = new HashMap<Integer, Object>();
		for (Object object : iterable) {
			int hashcode = 0;
			if (object!=null) {
				hashcode = object.hashCode();
			}
			map.put(hashcode,object);			
		}
		return map;
	}
	

	/**
	 * Creates a Properties object and loads it from a resource.
	 * The properties file is loaded from the specified resource. The class
	 * delegates loading the resource to the system to its class loader.
	 * @param resource
	 *            Resource name.
	 * @return Returns a properties object.
	 * @throws IOException 
	 */
	public static Properties getPropertiesFromResource(String resource) throws IOException {
		InputStream stream = Utils.class.getResourceAsStream(resource);
		if (stream == null) {
			String msg = "Resource " + resource + " not found."; //$NON-NLS-1$ //$NON-NLS-2$
			throw new IOException(msg);
		}
		Properties prop = new Properties();
		prop.load(stream);
		return prop;
	}

	/**
	 * Null safe comparison.
	 * 
	 * @param <T> type to compare
	 * @param left left side
	 * @param right right side
	 * @return If both arguments are null, otherwise returns the result of their comparison.
	 *         If one of the arguments is null, then it is assumed to be less than the other. 
	 */
	public static <T extends Comparable<? super T>> int nullSafeCompare(
			final T left, final T right) {
		if (left==null & right==null) {
			return 0;
		}
		if (left==null) {
			return -1;
		}
		if (right==null) {
			return 1;
		}
		return left.compareTo(right);
	}
}