package eecs2030.lab1;

/**
 * Short methods reviewing fundamental Java concepts covered in EECS1021,
 * EECS1022, and EECS1720
 * 
 * @author EECS2030 Fall 2020-2021
 *
 */
public class Lab1 {

	/**
	 * The course name for EECS2030.
	 */
	public static final String COURSE_NAME = "Advanced Object Oriented Programming";

	private Lab1() {
		// empty by design
	}

	/**
	 * Returns the maximum (most positive) value that an <code>int</code> can
	 * represent.
	 * 
	 * @return the maximum (most positive) value that an int can represent
	 */
	public static int maxInt() {
		return Integer.MAX_VALUE;
	}

	/**
	 * Returns the minimum positive value greater than zero that a
	 * <code>double</code> can represent.
	 * 
	 * @return the minimum positive value greater than zero that a double can
	 *         represent
	 */
	public static double minDouble() {
		return Double.MIN_VALUE;
	}

	/**
	 * Removes the last two digits of a positive integer base-10 number. If
	 * <code>n</code> is less than <code>100</code> then the value of
	 * <code>0</code> is returned.
	 * 
	 * 
	 * @param n
	 *            a positive integer
	 * @return the integer produced by removing the last two digits of n, or 0
	 *         if n is less than 100
	 */
	public static int removeLastTwoDigits(int n) {
		return n / 100;
	}

	/**
	 * Returns the last two digits of a positive integer base-10 number. If the
	 * second last digit is a <code>0</code> then only the last digit is
	 * returned. If <code>n</code> is less than <code>100</code> then the value
	 * of <code>n</code> is returned.
	 * 
	 * @param n
	 *            a positive integer
	 * @return the last two digits of n, or the last digit of n if the second
	 *         last digit is a 0
	 */
	public static int lastTwoDigits(int n) {
		return n % 100;
	}

	/**
	 * Compute the average of two values as a <code>double</code> value.
	 * 
	 * @param a
	 *            a value
	 * @param b
	 *            a second value
	 * @return the average of the two values
	 */
	public static double avg(int a, int b) {
		return (0.0 + a + b) / 2;
	}

	/**
	 * Returns the wind chill for air temperatures equal to or below 0 degrees
	 * Celcius and wind velocities equal to or greater than 5 km/h.
	 * 
	 * <p>
	 * Wind chill is an index that indicates how cold the weather feels to the
	 * average person when there is some wind. For example, if the air
	 * temperature is -5 degrees Celcius and the wind chill is -15 then it means
	 * that it feels similar to a windless day where the temperature is -15
	 * degrees Celcius.
	 * 
	 * @param airTemp
	 *            the temperature in degrees Celcius (must be 0 degrees or less)
	 * @param windSpeed
	 *            the wind speed in km/h (must be 5 km/h or greater)
	 * @return the wind chill index
	 * @see <a href="http://climate.weather.gc.ca/glossary_e.html#w">
	 *      Environment and Climate Change Canada wind chill definition</a>
	 */
	public static double windChill(double airTemp, double windSpeed) {

		final double A = 13.12;
		final double B = 0.6215;
		final double C = 0.3965;
		final double D = 11.37;
		final double E = 0.16;
		return A + B * airTemp + (C * airTemp - D) * Math.pow(windSpeed, E);
	}

	/**
	 * Determine if an integer <code>x</code> is odd.
	 * 
	 * @param x
	 *            a value
	 * @return true if x is odd and false otherwise
	 */
	public static boolean isOdd(int x) {
		int remainder = x % 2;
		boolean result = (remainder != 0);
		return result;
	}

	/**
	 * Determine if the point <code>(x, y)</code> is exactly on the perimeter of
	 * a circle with center <code>(0, 0)</code> and having radius equal to
	 * <code>1</code>.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is exactly on the perimeter of the unit circle,
	 *         and false otherwise
	 */
	public static boolean isOnUnitCircle(double x, double y) {
		boolean result = (x * x + y * y) == 1;
		return result;
	}

	/**
	 * Determine if the point <code>(x, y)</code> is inside the unit square. The
	 * unit square is the square whose sides have length 1, whose bottom left
	 * corner has coordinates (0, 0), and whose top right corner has coordinates
	 * (1, 1). A point on the perimeter of the unit square is considered to be
	 * inside the square.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is inside the unit square, and false otherwise
	 */
	public static boolean isInsideUnitSquare(double x, double y) {
		boolean result = (0 <= x) && (x <= 1) && (0 <= y) && (y <= 1);
		return result;
	}

	/**
	 * Determine if the point <code>(x, y)</code> is outside the unit square.
	 * The unit square is the square whose sides have length 1, whose bottom
	 * left corner has coordinates (0, 0), and whose top right corner has
	 * coordinates (1, 1). A point on the perimeter of the unit square is
	 * considered to be inside the square.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is outside the unit square, and false otherwise
	 */
	public static boolean isOutsideUnitSquare(double x, double y) {
		boolean result = (0 > x) || (x > 1) && (0 > y) || (y > 1);
		return result;
	}

	/**
     * Returns the result of flipping the specified bit.
     * 
     * <p>
     * A bit is the digit used in the binary number system. A bit 
     * can have a value of zero or one (with no other value allowed).
     * Flipping a bit changes the value of the bit to the other value;
     * flipping a bit that is zero changes it to one, and flipping 
     * a bit that is one changes it to zero.
     * 
     * @param x a bit
     * @return the flipped value of x 
     * @throws BadBitException 
     *           if x is not a bit (has a value that is not zero and not one).
     */
	public static int flipBit(int x) {
        if (x == 1) {
        	return 0;
        }
        if (x == 0) {
        	return 1;
        }
         throw new BadBitException("bad exception");
	}

	
	/**
	 * Determine if a value <code>x</code> is strictly inside the given
	 * <code>Range</code>. A value exactly at the minimum or maximum of the
	 * range is considered outside of the range.
	 * 
	 * @param x
	 *            a value
	 * @param range
	 *            a Range to check
	 * @return the value 1 if x is strictly inside the given Range, and 0
	 *         otherwise
	 */
	public static int contains(double x, Range range) {
		if (x < range.getMaximum() && x > range.getMinimum()) {
			return 1;
		}
		return 0;
	}

	/**
	 * Compares two <code>Range</code> instances by their widths.
	 * 
	 * @param r1
	 *            a Range
	 * @param r2
	 *            a second Range
	 * @return the value 0 if both Range instances have equal width; -1 if r1 is
	 *         narrower than r2; and 1 if r1 is wider than r2
	 */
	public static int compareTo(Range r1, Range r2) {
		if (r1.getMaximum() - r1.getMinimum() == r2.getMaximum() - r2.getMinimum()) {
			return 0;
		}
		else if (r1.getMaximum() - r1.getMinimum() < r2.getMaximum() - r2.getMinimum()) {
			return -1;
		}
		else {
			return 1;
		}
	}

	/**
	 * Returns the course name as the string.
	 * 
	 * @return the string equal to Lab1.COURSE_NAME
	 */
	public static String getCourseName() {
		return COURSE_NAME;
	}

	/**
	 * Returns a string representation of a <code>Range</code> that is different
	 * than the one returned by <code>Range.toString</code>.
	 * 
	 * <p>
	 * The returned string has the form <code>"range from x to y"</code> where x
	 * is the minimum value of the range and y is the maximum value of the
	 * range.
	 * 
	 * @param r
	 *            a Range instance
	 * @return a string representation of the range
	 */
	public static String toString(Range r) {
		return "range from " + r.getMinimum() + " to " + r.getMaximum();
	}

	/**
	 * Returns the character located in the middle of the string. If
	 * <code>s</code> has an even number of characters then the middle character
	 * is taken to be the first character in the second half of the string
	 * (i.e., the middle character of the string <code>"abcd"</code> is
	 * <code>'c'</code>.
	 * 
	 * @param s
	 *            a string of length 1 or greater
	 * @return the middle character of s
	 * @throws IllegalArgumentException
	 *             if s is empty
	 */
	public static char middleChar(String s) {
		if (s.isEmpty()) {
			throw new IllegalArgumentException("s is Empty");
		}
		else if (s.length() % 2 == 0) {
			return s.charAt(s.length() / 2);
		}
		else {
			return s.charAt((s.length() - 1) / 2);
		}
	}

	/**
	 * Returns the string formed by alternating the case of the characters in
	 * the specified string. The first character in the returned string is in
	 * lowercase, the second character is in uppercase, the third character is
	 * in lowercase, the fourth character is in uppercase, and so on.
	 * Examples:
	 * 
	 * <ul>
	 * <li><code>alternatingCaps("a")</code> returns <code>"a"</code>
	 * <li><code>alternatingCaps("ab")</code> returns <code>"aB"</code>
	 * <li><code>alternatingCaps("abc")</code> returns <code>"aBc"</code>
	 * <li><code>alternatingCaps("XYZ")</code> returns <code>"xYz"</code>
	 * <li><code>alternatingCaps("Toronto")</code> returns <code>"tOrOnTo"</code>
	 * <li><code>alternatingCaps("eecs2030")</code> returns <code>"eEcS2030"</code>
	 * </ul>
	 * 
	 * <p>
	 * The conversion of characters to lower or uppercase is identical to 
	 * that performed by the methods <code>Character.toLowerCase(int)</code>
	 * and <code>Character.toLowerCase(int)</code>
	 * 
	 * @param s
	 *            a string
	 * @return the string formed by alternating the case of the characters in s
	 */
	public static String alternatingCaps(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i = i + 1) {
			char n = s.charAt(i);
			if (i % 2 == 0) {
				result = result + Character.toLowerCase(n);
			}
			else {
				result = result + Character.toUpperCase(n);
			}
		}
		return result;
	}

}
