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
	public static Boolean valueOf(String s)
	{
		return s.equalsIgnoreCase("true") || s.equalsIgnoreCase("1");
	}
}
