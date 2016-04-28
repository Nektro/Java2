package io.nub.core.util.arrays;

import java.util.Arrays;

/**
 * A special handler for Boolean Arrays of type Array<Boolean>
 * 
 * @author Nektro
 * @since  26-04-2016
 * @see    java.lang.Boolean
 * @see    io.nub.core.util.arrays.Array
 */
public class ArrayBoolean extends Array<Boolean>
{
	private static final long serialVersionUID = -5255915783619325879L;
	
	public ArrayBoolean()
	{
		super();
	}
	
	public <T> ArrayBoolean(Array<T> fromArray)
	{
		super();
		for (T t : fromArray) {
			if (t instanceof Boolean) {
				this.add((Boolean) t);
			}
			else if (t instanceof String) {
				this.add(Boolean.valueOf((String) t));
			}
			else {
				throw new ClassFormatError("Cannot create ArrayBoolean from Array of type: " + t.getClass().getName());
			}
		}
		
		//this.addAll(fromArray);
	}
	
	@Override
	public String toString()
	{
		return Arrays.toString(toArray());
	}
	
	/**
	 * @return a new {@link ArrayBoolean} with all the values inversed from this.
	 */
	public ArrayBoolean complement()
	{
		ArrayBoolean ab = new ArrayBoolean();
		
		for (Boolean b : this) {
			ab.add(!b);
		}
		
		return ab;
	}
}
