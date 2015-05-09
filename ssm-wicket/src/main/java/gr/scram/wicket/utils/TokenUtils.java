package gr.scram.wicket.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * Token utils.
 * @author asvesdi
 *
 */
public final class TokenUtils {

	/**
	 * Hidden private constructor of a utility class.
	 * 
	 */
	private TokenUtils() {
		/* empty */
	}

	/**
	 * Splits the specified string into tokens, as separated by the specified
	 * separator.
	 * 
	 * @param s
	 *            the string to split.
	 * @param separator
	 *            the separator to use to split the string
	 * 
	 * @return the array of tokens.
	 */
	public static String[] split(String s, String separator) {
		List<String> tokens = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(s, separator);
		while (st.hasMoreTokens()) {
			tokens.add(st.nextToken().trim());
		}
		return tokens.toArray(new String[0]);
	}

	/**
	 * Returns an array with the tokens that constitute a String.
	 * 
	 * The tokens are separated by the delimiter character. Empty tokens are
	 * included in the output.
	 * 
	 * @param str
	 *            input string
	 * @param delimiter
	 *            Character that separates the tokens
	 * 
	 * @return an array with the tokens that constitute the input String.
	 */
	public static String[] splitTrim(String str, char delimiter) {
		return splitTrim(str, String.valueOf(delimiter), true);
	}

	/**
	 * Returns an array with the tokens that constitute a String.
	 * 
	 * The tokens are separated by the delimiter character. Empty tokens are
	 * included in the output.
	 * 
	 * @param str
	 *            input string
	 * @param delimiter
	 *            Character that separates the tokens
	 * 
	 * @return an array with the tokens that constitute the input String.
	 */
	public static String[] splitTrim(String str, String delimiter) {
		return splitTrim(str, delimiter, true);
	}

	/**
	 * Returns an array with the tokens that constitute a String.
	 * 
	 * The tokens are separated by the delimiter character.
	 * 
	 * @param str
	 *            input string
	 * @param delimiter
	 *            Character that separates the tokens
	 * @param includeEmptyTokens
	 *            Defines if empty tokens are included in the output.
	 * 
	 * @return an array with the tokens that constitute the input String.
	 */
	public static String[] splitTrim(String str, char delimiter,
			boolean includeEmptyTokens) {
		return splitTrim(str, String.valueOf(delimiter), includeEmptyTokens);
	}

	/**
	 * Returns an array with the tokens that constitute a String.
	 * 
	 * The tokens are separated by any character included in the delimiter
	 * String.
	 * 
	 * @param str
	 *            input string
	 * @param delimiter
	 *            String containing all characters used as delimiters that
	 *            separate the tokens
	 * @param includeEmptyTokens
	 *            Defines if empty tokens are included in the output.
	 * 
	 * @return an array with the tokens that constitute the input String.
	 */
	public static String[] splitTrim(String str, String delimiter,
			boolean includeEmptyTokens) {
		String s = str.trim();
		int l = s.length();
		if (l == 0) {
			return (new String[0]);
		}
		ArrayList<String> tokens = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(s, delimiter, false);
		while (st.hasMoreTokens()) {
			String token = st.nextToken().trim();
			boolean addToken = (includeEmptyTokens)
					|| (!StringUtils.isNullOrBlank(token));
			/*
			 * isNullOrBlank , T - F - T - F ..............................
			 * !isNullOrBlank, F - T - F - F includeEmpty , T - T - F - F
			 * -------------------------------- addToken , T - T - F - T
			 */
			if (addToken) {
				tokens.add(token);
			}
		}
		tokens.trimToSize();
		return tokens.toArray(new String[tokens.size()]);
	}
}
