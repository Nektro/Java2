package io.nub.core.lang;

/**
 * A static class with some nice methods you might use
 * 
 * @author Nektro
 */
public class Character2
{
	public static boolean isLetter(char c)
	{
		switch (Character.toLowerCase(c))
		{
			case 'a': case 'b': case 'c':
			case 'd': case 'e': case 'f':
			case 'g': case 'h': case 'i':
			case 'j': case 'k': case 'l':
			case 'm': case 'n': case 'o':
			case 'p': case 'q': case 'r':
			case 's': case 't': case 'u':
			case 'v': case 'w': case 'x':
			case 'y': case 'z':
				return true;
		}
		return false;
	}
	
	/**
	 * An interesting function to "add" a number to a letter, while still remaining inside the
	 * alphabet. ie. a + 3 would return d and z + 4 would return d also.
	 * 
	 * @param c a letter
	 * @param r a number to add
	 * @return the sum
	 */
	public static char addChar(char c, int r)
	{
		if (Character2.isLetter(c)) {
			int i = Character.getNumericValue(c) + r;
			return Character.forDigit((((i - 10) % 26) + 10), 36);
		}
		else {
			return c;
		}
	}
}
