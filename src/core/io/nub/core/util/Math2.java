package io.nub.core.util;

import java.util.Arrays;

import io.nub.core.lang.String2;
import io.nub.core.math.Pointd;

/**
 * A Helper class to help with the many endeavors of math. Many of the functions located here are
 * the same as in {@code java.util.Math} class, however if you are reading this you are either reading the
 * Javadoc on the html file or looking at the source. In the instance you are looking at the source
 * feel free to look at the math hidden by all of you favorite functions. None of the functions here
 * use native code and are completely accessible to look at.
 * 
 * @author Nektro
 */
public final class Math2
{
	private Math2() {}
	
	public static final double PI = 3.141592653589793;
	public static final double E  = 2.718281828459045;
	
	/**
	 * Solve the problem based on the parameters given. If c is not an operator returns -1.
	 * Acceptable operators are +, -, *, /, %, and ^
	 * @param x a number
	 * @param y another number
	 * @param c an operator
	 * @return the value of x c y
	 */
    public static int solve(int x, int y, char c)
    {
        switch (c) {
            case '+': return x + y;
            case '-': return x - y;
            case '*': return x * y;
            case '/': return x / y;
            case '%': return x % y;
            case '^': return (int) Math2.pow(x, y);
        }
        return -1;
    }
    
    /**
     * Determines whether or not {@code x} is a prime number or not
     * @param x
     * @return
     */
    public static boolean isPrime(int x)
	{
		for (int i = 2; i < x; i++) {
			if (x == 2)
				return true;
			if (x % i == 0)
				return false;
		}
		return true;
	}
    
    /**
     * Finds the first prime number after {@code x}
     * @param x start
     * @return a prime after x
     */
    public static int findFirstPrime(int x)
	{
		for (int i = x; true; i++) {
			if (isPrime(i))
				return i;
		}
	}
    
    /**
	 * Returns the greatest common factor of x and y using Euclid's Algorithm. i.e.<br>
	 * gcf(2520, 154) = 14<br>
	 * 2520 / 154 = 16 r56<br>
	 *  154 /  56 =  2 r42<br>
	 *   56 /  42 =  2 r14<br>
	 *   42 /  14 =  3 r0<br>
	 *   <br>
	 *   gcf = 14
	 * @param x
	 * @param y
	 * @return the GCF of x and y
	 */
	public static int gcf(int x, int y)
	{
		int a,b;
		a = x;
		b = y;
		while (true) {
			int c = a % b;
			a = b;
			b = c;
			if (c == 0)
				break;
		}
		return a;
	}
	
	/**
	 * Returns the greatest common factor of a list of integers
	 * @param x the list of numbers
	 * @return the GCF
	 */
	public static int gcf(int... x)
	{
		int a = x[0];
		int[] b = new int[x.length - 1];
		System.arraycopy(x, 1, b, 0, b.length);
		
		if (b.length == 1) {
			return gcf(a, b[0]);
		} else {
			return gcf(a, gcf(b));
		}
	}
	
	/**
	 * Round a value to a set number of places. For example, 3.965400 to two places = 3.96
	 * @param value a number
	 * @param places the number of places
	 * @return the rounded double
	 */
	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();
		String sv = String.valueOf(value);
		String nv = sv.substring(0, sv.indexOf('.') + 1 + min(places, sv.split("[.]")[1].length()));
		return Double.valueOf(nv);
	}
	
	/**
	 * Raise a specific number to an integer power
	 * @param x
	 * @param power
	 * @return
	 */
	public static double pow(double x, int power)
	{
		double a = 1;
		for (int i = 0; i < power; i++)
			a *= x;
		return a;
	}
	
	public static double pow(double x, double pow)
	{
		// TODO
		String[] s = String.valueOf(pow).split("[.]");
		if (s[1].equals("0")) {
			return pow(x, (int) pow);
		}
		System.err.println(Arrays.toString(s));
		return 0;
	}
	
	/**
	 * Return the root of the perfect square just below this number
	 * @param x
	 * @return
	 */
	public static int prevPSQrt(double x)
	{
		for (int i = 0; true; i++)
			if (pow(i, 2) > x)
				return i - 1;
	}
	
	/**
	 * Return the square root of a number within the range about as close as computers can get.
	 * @param x
	 * @return
	 */
	public static double sqrt(double x)
	{
		double a = prevPSQrt(x);
		while (true) {
			double b = x / a;
			double c = (b + a) / 2;
			if (c != a) {
				a = c;
			}
			else {
				return c;
			}
		}
	}
	
	/**
	 * See {@link java.lang.Math#cbrt(double)}
	 * @param x a number
	 * @return the cube root of x
	 */
	public static double cbrt(double x)
	{
		// TODO
		return 0;
	}
	
	public static int factorial(int x)
	{
		int n = 1;
		for (int i = x; i > 1; i--)
			n = n * i;
		return n;
	}
	
	public static double toRadians(double degs) { return degs * PI / 180; }
	public static double toDegrees(double rads) { return rads * 180 / PI; }
	public static double distance(double x1, double y1, double x2, double y2) { return sqrt(pow(x2 - x1, 2) + pow(y2 - y1,2)); }
	public static double distance(Pointd a, Pointd b) { return distance(a.x, a.y, b.x, b.y); }
	
	public static double sin(double rad) { return Math.sin(rad); } // return unitPoint(rad).y; }
	public static double cos(double rad) { return Math.cos(rad); } // return unitPoint(rad).x; }
	public static double tan(double rad) { return sin(rad) / cos(rad); }
	public static double csc(double rad) { return 1 / sin(rad); }
	public static double sec(double rad) { return 1 / cos(rad); }
	public static double cot(double rad) { return 1 / tan(rad); }
	
	public static Pointd unitPoint(double rad)
	{
		// cordic algorithm
		// http://en.wikipedia.org/wiki/CORDIC
		// TODO
		Pointd v0 = new Pointd(1,0);
		v0.x = trigR(v0.x);
		v0.y = trigR(v0.y);
		return v0;
	}
	
	private static double trigR(double i)
	{
		// TODO
		return trigK(i);
	}
	
	private static double trigK(double i)
	{
		return 1 / sqrt(1 + pow(2, -2 * i));
	}
	
	public static final String DIGITS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String convert(String input, int fromBase, int toBase)
	{
		return convertToBase(convertToDecimal(input, fromBase), toBase);
	}
	
	public static long convertToDecimal(String in, int fromBase)
	{
		if (fromBase > 62 || fromBase < 2) {
			return -1;
		}
		if (in.equals("0")) {
			return -1;
		}
		long value = 0;
		for (int i = 0; i < in.length(); i++) {
			value += (DIGITS.indexOf(in.charAt(i)) * Math2.pow(fromBase, in.length() - i - 1));
		}
		return value;
	}
	
	public static String convertToBase(long in, int toBase)
	{
		String2 returnv = new String2("");
		while (in != 0) {
			long a = in % toBase;
			returnv = returnv.prepend(new String2(DIGITS.charAt(Integer.valueOf(String.valueOf(a)))));
			in /= toBase;
		}
		return returnv.toString();
	}
	
	/**
	 * Returns {@code x}'s sign regardless of value
	 * @param x an integer
	 * @return 0, 1, or -1
	 */
	public static double signum(double x)
	{
		return x == 0 ? 0 : ( x / abs(x) );
	}
	
	/**
	 * Returns {@code x}'s value regardless of sign.
	 * @param x number
	 * @return x's distance from 0
	 */
	public static double abs(double x)
	{
		return x >= 0 ? x : -x;
	}
	
	public static int min(int a, int b)
	{
		return a <= b ? a : b;
	}
}
