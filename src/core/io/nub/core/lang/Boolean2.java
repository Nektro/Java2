package io.nub.core.lang;

/**
 * @author Nektro
 */
public class Boolean2
{
	/**
	 * @param s a String
	 * @return true if s is equal to "true" or "1"
	 */
	public static boolean valueOf(String2 s)
	{
		return s.equals("true") || s.equals("1");
	}
}
