package io.nub.core.math;

/**
 * @author Nektro
 */
public class Range
{
	public double max;
	public double min;
	
	public Range(double top, double bottom)
	{
		this.max = top;
		this.min = bottom;
	}
	
	public boolean isNumInRange(boolean inclusive, double x)
	{
		return inclusive ? ( x >= min && x <= max ) : ( x > min && x < max);
	}
	
	public double size()
	{
		return max - min + 1;
	}
}
