package io.nub.core.lang;

/**
 * @author Nektro
 */
public class Object2
{
	/**
	 * A relatively simple function that I wish I had made a long long time ago. This function is
	 * much like Javascript's OR assignment operator. Basically if <i>object</i> is null, then <i>objIfNull<i>
	 * is returned.
	 * @param <T>
	 * 
	 * @param object an object
	 * @param objIfNull a default if object is null
	 * @return the best of the two
	 */
	public static <T> T orn(T object, T objIfNull)
	{
		return isNull(object) ? objIfNull : object;
	}
	
	public static boolean isNull(Object o)
	{
		try {
			if (o != null) {
				return false;
			}
			else {
				throw new NullPointerException();
			}
		}
		catch (NullPointerException e) {
			return true;
		}
	}
}
