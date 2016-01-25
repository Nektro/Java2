package io.nub.core.extras;

/**
 * @author Nektro
 */
public class Loop
{
	private int value;
	
	public int min;
	public int max;
	
	public Loop(int min, int max, int def)
	{
		this.min = min;
		this.max = max;
		this.value = def;
	}
	
	public int val()
	{
		return value;
	}
	
	public void inc()
	{
		value += 1;
		if (value > max)
			value = min;
	}
	
	public void dec()
	{
		value -= 1;
		if (value < min)
			value = max;
	}
}
