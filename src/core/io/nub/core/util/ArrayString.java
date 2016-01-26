package io.nub.core.util;

import java.util.Arrays;

/**
 * @author Nektro
 */
public class ArrayString extends Array<String>
{
	private static final long serialVersionUID = -6238867536747515337L;
	
	public ArrayString(Array<String> fromArray) {
		this(fromArray.toArray(new String[fromArray.size()]));
	}
	
	public ArrayString(String[] fromArray) {
		super(fromArray);
	}
	
	public ArrayString(Object[] array) {
		for (Object o : array)
			if (o instanceof String)
				add((String) o);
	}
	
	@Override
	public String toString() {
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
}
