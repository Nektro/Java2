package io.nub.core.util;

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
}
