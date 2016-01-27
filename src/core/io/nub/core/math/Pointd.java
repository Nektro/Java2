package io.nub.core.math;

import io.nub.core.util.Math2;

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
	
	public double distanceTo(Pointd pt)
	{
		double dx = Math2.pow(pt.x - x, 2);
		double dy = Math2.pow(pt.y - y, 2);
		double dz = Math2.pow(pt.z - z, 2);
		return Math2.sqrt(dx + dy + dz);
	}
	
	public String distanceFrom(Pointd pt)
	{
		double dx = Math2.pow(pt.x - x, 2);
		double dy = Math2.pow(pt.y - y, 2);
		double dz = Math2.pow(pt.z - z, 2);
		return "sqrt(" + (dx + dy + dz) + ")";
	}
	
}
