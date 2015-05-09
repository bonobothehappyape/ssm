package gr.scram.wicket.utils;

import java.util.ArrayList;


/**
 * Utilities for string operations.
 * 
 * 
 */
public final class StringUtils {
	/**
	 * Cosntant boolean value.
	 */
	private static final String STR_TRUE = "true";
	
	/**
	 * Cosntant 1 value.
	 */
	private static final String STR_1 = "1";
	
	/**
	 * Cosntant apostrophe value.
	 */
	private static final String APOSTROPHE = "'";

	/**
	 * Hidden constructor.
	 * 
	 * This is a utility class having only static methods. There is no need to
	 * create any instance of this class.
	 */
	private StringUtils() {
		/* empty */
	}

	/**
	 * Creates a string with all arguments separated by comma.
	 * 
	 * @param args
	 *            arguments to present.
	 * 
	 * @return Returns a string consisting by all arguments separated by a
	 *         comma.
	 */
	public static String showArguments(final Object... args) {
		final StringBuilder sb = new StringBuilder();
		int i = 0;
		for (final Object object : args) {
			if (i != 0) {
				sb.append(", "); //$NON-NLS-1$
			}
			sb.append(object);
			i++;
		}
		return sb.toString();
	}

	/**
	 * 
	 * Creates a left justified string of specified length. Example
	 * leftJustify("test",10,'a'); "test" --> "testaaaaaa" |----10----| If the
	 * input string is lengthier than the <code>len</code> argument then the
	 * result string is not truncated, but rather is the same as the input
	 * string.
	 * 
	 * @param str
	 *            input String
	 * @param len
	 *            length of output String
	 * @param c
	 *            character that fills blanks
	 * @return a String of length <code>len</code> that has the input String
	 *         <code>str</code> in the left part. If length of <code>str</code>
	 *         is less than <code>len</code>, then the remaining characters on
	 *         the riht are filled with character <code>c</code>
	 */
	public static String leftJustify(final String str, final int len, final char c) {
		final int l = str.length();
		if (l == len || l > len) {
			return str;
		}
		final StringBuffer b = new StringBuffer(len);
		b.append(str);
		for (int i = 0; i < len - l; i++) {
			b.append(c);
		}
		return b.toString();
	}

	/**
	 * 
	 * Creates a right justified string of specified length. Example
	 * rightJustify("test",10,'a'); "test" --> "aaaaaatest" |----10----|
	 * 
	 * @param str
	 *            input String
	 * @param len
	 *            length of output String
	 * @param c
	 *            character that fills blanks
	 * @return a String of length <code>len</code> that has the input String
	 *         <code>str</code> in the right part. If length of <code>str</code>
	 *         is less than <code>len</code>, then the remaining characters on
	 *         the left are filled with character <code>c</code>
	 */
	public static String rightJustify(final String str, final int len, final char c) {
		final int l = str.length();
		if (l == len || l > len) {
			return str;
		}
		final StringBuffer b = new StringBuffer(len);
		b.append(str);
		for (int i = 0; i < len - l; i++) {
			b.insert(0, c);
		}
		return b.toString();
	}

	/**
	 * Converts a string to boolean.
	 * 
	 * String values 1 and true will result to true. Any other value will result
	 * to false.
	 * 
	 * @param s the string yo make boolean.
	 * @return returns a boolean value for the input string.
	 */

	public static boolean string2Bool(final String s) {

		if (s == null) {
			return false;
		}

		if (s.trim().equals(StringUtils.STR_1)) {
			return true;
		}

		if (s.trim().equalsIgnoreCase(StringUtils.STR_TRUE)) {
			return true;
		}

		return false;

	}

	/**
	 * converts a boolean to 1 or 0.
	 * 
	 * @param b boolean value.
	 * @return returns 1 or 0
	 **/
	public static String bool2String(final boolean b) {
		return b ? StringUtils.STR_1 : "0"; //$NON-NLS-1$ //$NON-NLS-2$ 
	}

	/**
	 * Removes leading zeros from a string.
	 * 
	 * The method does not remove any leading spaces, so if the string starts
	 * with spaces, and then has leading zeros, they will not be removed.
	 * 
	 * @param s
	 *            String from which the method will remove any leading zeros.
	 * 
	 * @return returns the string after it is striped from any leading zeros.
	 */
	public static String removeLeadingZeros(final String s) {
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				idx++;
			} else {
				break;
			}
		}
		return s.substring(idx);
	}

	/**
	 * Capitalises the first character of string.
	 * 
	 * @param string string to convert.
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
	 * Prints an integer to a string, adding leading zeroes so that the string
	 * has a specified length.
	 * 
	 * If the length is less than the actual length of the input integer, then
	 * the output will be truncated. <br/>
	 * Examples: <li>for integer 3 and length 4 returns 0003 <li>for integer
	 * 3005 and length 3 returns 300 (truncates the digits from the right side).
	 * 
	 * 
	 * @param num
	 *            integer that will be printed to string
	 * @param length
	 *            length of output string.
	 * 
	 * @return Returns a string for the int, that has a fixed length.
	 */
	public static String int2str(final int num, final int length) {
		final boolean negative = (num < 0);
		final int number = negative ? -num : num;
		final String str = Integer.toString(number).trim();
		final StringBuilder sb = new StringBuilder();
		int zeroes = length - str.length();
		if (negative) {
			sb.append("-");
			zeroes--;
		}
		for (int i = 0; i < zeroes; i++) {
			sb.append("0");
		}
		sb.append(str);
		return sb.toString().substring(0, length);
	}

	/**
	 * Creates a string of specified length consisting by the same character.
	 * 
	 * @param length
	 *            length of new string
	 * @param c
	 *            character creating the new string.
	 * @return a String of defined length that contains only the character c
	 */
	public static String sameCharacterString(final int length, final char c) {
		final StringBuffer b = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			b.append(c);
		}
		return new String(b);
	}

	/**
	 * padRight the argument, but truncates it to the specified length if the
	 * argument exceeds it.
	 * 
	 * @param arg argument to pad
	 * @param length length
	 * @return padRight of the argument
	 */
	public static String fixedLengthPadRight(final String arg, final int length) {
		final String s = padRight(arg.trim(), length);
		final int i = s.length() - length;
		if (i > 0) {
			return mid(s, i);
		} else {
			return s;
		}
	}

	/**
	 * same as substring but throws no 
	 * IndexOutOfBoundsException works exactly
	 * as Visual Basic's mid.
	 * 
	 * @param s string
	 * @param start start position
	 * @param length lenght of string
	 * @return the substring starting from start and until length
	 */
	public static String mid(final String s, final int start, final int length) {
		final int len = s.length();
		if ((start > len) || (length == 0)) {
			return "";
		}
		int l = length;
		if (l > len - start) {
			l = len - start;
		}
		return s.substring(start, start + l);
	}

	/**
	 * same as substring but throws no IndexOutOfBoundsException works well even
	 * if start is greater than the string length works exactly as Visual
	 * Basic's mid.
	 * 
	 * @param s string 
	 * @param start start position
	 * @return the substring starting from start
	 */
	public static String mid(final String s, final int start) {
		final int len = s.length();
		if (start > len) {
			return "";
		}
		final int length = len - start;
		return s.substring(start, start + length);
	}

	/**
	 * Replaces a part of String with another String Same functionality as
	 * Visual Basic mid. Throws no runtime exceptions
	 * 
	 * @param arg
	 *            String to change
	 * @param start
	 *            Part of the String where the new String will be inserted
	 * @param len
	 *            Length of the part that will be replaced by the new String
	 * @param newPart
	 *            New String to insert inside the old String
	 * @return String
	 */
	public static String mid(final String arg, final int start, final int len,
			final String newPart) {
		if (start > arg.length()) {
			return arg;
		}
		final int l = arg.length() - start + 1;
		if (arg.length() < start + len) {
			final String p1 = mid(arg, 0, start - 1);
			final String newP = mid(newPart, 0, l);
			return p1 + newP;
		} else {
			final String newP = fixedLengthPadLeft(newPart, len);
			final String p1 = mid(arg, 0, start);
			final String p2 = mid(arg, start + len);
			return p1 + newP + p2;
		}
	}

	/**
	 * padLeft the argument, but truncates it to the specified length if the
	 * argument exceeds it.
	 * 
	 * @param arg argument
	 * @param length length to pad.
	 * @return padLeft of the argument
	 */
	public static String fixedLengthPadLeft(final String arg, final int length) {
		final String s = padLeft(arg.trim(), length);
		if (s.length() > length) {
			return mid(s, 0, length);
		} else {
			return s;
		}
	}

	/**
	 * 
	 * @param arg argument to pad
	 * @param length length
	 * @return a String of defined length with the argument arg justified left
	 *         and filled with spaces
	 */
	public static String padLeft(final String arg, final int length) {
		final int l = arg.length();
		if (l > length) {
			return arg;
		} else {
			return arg + spaces(length - l);
		}
	}

	/**
	 * 
	 * @param arg argument to pad
	 * @param length length
	 * @return a String of defined length with the argument arg justified right
	 *         and filled with spaces
	 */
	public static String padRight(final String arg, final int length) {
		final int l = arg.length();
		if (l > length) {
			return arg;
		} else {
			return spaces(length - l) + arg;
		}
	}

	/**
	 * Space String.
	 * 
	 * @param length string length
	 * @return a blank string of defined length
	 */
	public static String spaces(final int length) {
		return sameCharacterString(length, ' ');
	}

	/**
	 * Checks if a String is null or blanc.
	 * 
	 * @param s
	 *            String examined.
	 * @return Returns true if <code>s</code> is null or blank.
	 */
	public static boolean isNullOrBlank(final String s) {
		return (s == null || s.trim().length() == 0);
	}

	/**
	 * Checks if a string is contained in an array of strings. Returns the index
	 * position if it is contained, else -1.
	 * 
	 * @param array
	 *            the array of strings
	 * @param string
	 *            the string
	 * @return the index position if it is contained, else -1.
	 */
	public static int arrayContainsString(final String[] array, final String string) {

		int i = 0;
		for (final String s : array) {
			if (s.equals(string)) {
				return i;
			}
			i++;
		}
		return -1;

	}

	/**
	 * Removes any empty element from an array.
	 * 
	 * Nulls, empty strings and strings containing only spaces are considered
	 * empty and are omitted from the returned array. The strings that are
	 * contained in the returned array are trimmed.
	 * 
	 * @param array
	 *            Array
	 * @return Returns an array containing no empty elements.
	 */
	public static String[] removeEmpty(final String[] array) {
		final ArrayList<String> list = new ArrayList<String>();
		for (final String string : array) {
			if (string != null && string.trim().length() != 0) {
				list.add(string.trim());
			}
		}
		return list.toArray(new String[0]);
	}

	/**
	 * Puts a string in single quotes.
	 * 
	 * @param string the string to quote.
	 * @return returns the string in quotes.
	 */
	public static String quotes(final String string) {
		return StringUtils.APOSTROPHE + string + StringUtils.APOSTROPHE; //$NON-NLS-1$//$NON-NLS-2$
	}

	/**
	 * Inserts string B in string A after the first occurrence of a specific
	 * char sequence in string A. If the input is not valid, string A is
	 * returned unchanged.
	 * 
	 * @param original
	 *            the original string
	 * @param mark
	 *            a string to specify the mark after which the insertion takes
	 *            place.
	 * @param toAdd
	 *            the string to insert
	 * 
	 * @return the final string after the insertion
	 */
	public static String insertAfter(final String original, final String mark, final String toAdd) {

		if (original.indexOf(mark) == -1) {
			return original;
		}

		final int markIndex = original.indexOf(mark);
		final String temp = original.substring(markIndex + mark.length());
		final String result = original.replace(temp, toAdd + temp);
		return result;
	}


	/**
	 * Null safe trim().
	 * 
	 * @param s
	 *            String to trim.
	 * @return Returns s.trim() if s is not null, otherwise returns null.
	 */
	public static String trim(final String s) {
		if (s == null) {
			return null;
		}
		return s.trim();
	}

	/**
	 * Shows if a string starts with an uppercase character.
	 * 
	 * @param string
	 *            String.
	 * @return Returns true if string starts with an uppercase.
	 */
	public static boolean startsWithUpperCase(final String string) {
		if (string == null || string.length() == 0) {
			return false;
		}
		final Character initial = string.charAt(0);
		return Character.isUpperCase(initial);
	}

	/**
	 * Concatenates strings.
	 * 
	 * @param strings
	 *            Strings to concatenate.
	 * 
	 * @return Return the concatenation of the strings.
	 */
	public static String concat(final String... strings) {
		final StringBuilder sb = new StringBuilder();
		for (final String string : strings) {
			sb.append(string);
		}
		return sb.toString();
	}

	/**
	 * Adds a string to the left of an other string, only if none of the strings
	 * is null.
	 * 
	 * @param string
	 *            String on which a prefix is added.
	 * @param prefix
	 *            prefix to add to the string.
	 * 
	 * @return Returns the string with the additional part on its left if both
	 *         strings are not null, otherwise returns the initial string.
	 */
	public static String addPrefix(final String string, final String prefix) {
		if (string != null && prefix != null) {
			return prefix + string;
		}
		return string;
	}

	/**
	 * Adds a string to the right of an other string, only if none of the
	 * strings is null.
	 * 
	 * @param string
	 *            String on which a postfix is added.
	 * @param postfix
	 *            postfix to add to the string.
	 * 
	 * @return Returns the string with the additional part on its right if both
	 *         strings are not null, otherwise returns the initial string.
	 */
	public static String addPostfix(final String string, final String postfix) {
		if (string != null && postfix != null) {
			return string + postfix;
		}
		return string;
	}

	/**
	 * Adds a string to the right of an other string, only if none of the
	 * strings is null.
	 * 
	 * @param string
	 *            String to surround with the specified string.
	 * @param surround
	 *            String that will surround the initial string.
	 * 
	 * @return Returns the string surrounded by the additional part if both
	 *         strings are not null, otherwise returns the initial string.
	 */
	public static String surround(final String string, final String surround) {
		if (string != null && surround != null) {
			return surround + string + surround;
		}
		return string;
	}

	/**
	 * Gets the first character of a string.
	 * 
	 * @param string
	 *            String to get the first character from.
	 * 
	 * @return Returns the first character of the specified string, if it is not
	 *         null or empty. Otherwise returns null.
	 * 
	 */
	public static Character firstChar(final String string) {
		if (string == null) {
			return null;
		}
		if (string.length() == 0) {
			return null;
		}
		return string.charAt(0);
	}

	/**
	 * Adds a space before each occurence of the specified character.
	 * 
	 * @param string
	 *            Parsed string.
	 * @param character
	 *            Character after who's occurences a space is added.
	 * 
	 * @return Returns the string with the added characters.
	 */
	public static String addSpaceBeforeChar(final String string, final char character) {
		final char[] chars = string.toCharArray();
		final StringBuilder sb = new StringBuilder();
		for (final char c : chars) {
			if (c == character) {
				sb.append(' ');
			}
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * Adds a space before each occurence of the specified character.
	 * 
	 * @param string
	 *            Parsed string.
	 * @param character
	 *            Character after who's occurences a space is added.
	 * 
	 * @return Returns the string with the added characters.
	 */
	public static String addSpaceAfterChar(final String string, final char character) {
		final char[] chars = string.toCharArray();
		final StringBuilder sb = new StringBuilder();
		for (final char c : chars) {
			sb.append(c);
			if (c == character) {
				sb.append(' ');
			}
		}
		return sb.toString();
	}

	/**
	 * Removes any parentheses from string.
	 * 
	 * @param string string to remove the parenthesis from.
	 * 
	 * @return Returns the string having removed its parenthesis.
	 */
	public static String removeParenthesis(final String string) {
		return removeCharacters(string, '(', ')');
	}

	/**
	 * Removes a character from a string.
	 * 
	 * @param string
	 *            String to clear from any appearance of the specified
	 *            character.
	 * @param character
	 *            Character to remove.
	 * 
	 * @return Returns the string having removed the character.
	 */
	public static String removeCharacter(final String string, final char character) {
		final StringBuilder sb = new StringBuilder();

		for (final char c : string.toCharArray()) {
			if (c != character) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * Removes a string from any appearance of specified characters.
	 * 
	 * @param string
	 *            String to clear from any appearance of the specified
	 *            character.
	 * @param characters
	 *            Character to remove.
	 * 
	 * @return Returns the string having removed the character.
	 */
	public static String removeCharacters(final String string,
			final Character... characters) {
		String s = string;
		for (final Character character : characters) {
			s = removeCharacter(s, character);
		}
		return s;
	}

}
