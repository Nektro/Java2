package io.nub.core.util.arrays;

import java.util.Arrays;

/**
 * @author Nektro
 */
public class ArrayString extends Array<String>
{
	private static final long serialVersionUID = -6238867536747515337L;
	
	public ArrayString()
	{
		super();
	}
	
	public ArrayString(Array<?> fromArray)
	{
		this();
		for (Object o : fromArray)
			this.add(o.toString());
	}
	
	public ArrayString(Object... array)
	{
		for (Object o : array)
			add(o.toString());
	}
	
	
	@Override
	public String toString()
	{
		return Arrays.toString(toArray());
	}
	
	public String[][] split(String regex)
	{
		String[][] saa = new String[this.size()][];
		for (int i = 0; i < this.size(); i++)
		{
			saa[i] = this.get(i).split(regex);
		}
		return saa;
	}
	
	public ArrayString toLowerCase()
	{
		for (int i = 0; i < this.size(); i++)
			this.set(i, this.get(0).toLowerCase());
		return this;
	}
	
	/**
	 * Removes any indexes of this {@link ArrayString} where this[i] == ""
	 * 
	 * @return {@code this}
	 */
	public ArrayString trim()
	{
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).equals("")) {
				this.remove(i);
				trim();
				break;
			}
		}
		return this;
	}
	
	public String join(String x)
	{
		if (this.size() == 0)
			return "";
		
		String res = "";
		for (String s : this)
			res += s + x;
		res.substring(0, res.length() - x.length());
		return res;
	}
	
	public String[] toSArray()
	{
		String[] res = new String[size()];
		for (int i = 0; i < res.length; i++)
			res[i] = this.get(i);
		return res;
	}
	
	public ArrayString reverseR()
	{
		return new ArrayString(this.reverse());
	}
}
