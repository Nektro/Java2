package io.nub.core.math;

/**
 * @author Nektro
 */
public class Pointd
{
	public double x;
	public double y;
	public double z;
	
	public Pointd(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Pointd(double x, double y) { this(x, y, 0); }
	public Pointd(double x) { this(x, 0); }
	public Pointd() { this(0); }
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
	
}
