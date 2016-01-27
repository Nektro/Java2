package io.nub.core.math;

import io.nub.core.util.Math2;

/**
 * @author Nektro
 */
public class Pointi
{
	public int x;
	public int y;
	public int z;
	
	public Pointi(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Pointi(int x, int y) { this(x, y, 0); }
	public Pointi(int x)        { this(x, 0); }
	public Pointi()             { this(0); }
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
	public double distanceTo(Pointi pt)
	{
		double dx = Math2.pow(pt.x - x, 2);
		double dy = Math2.pow(pt.y - y, 2);
		double dz = Math2.pow(pt.z - z, 2);
		return Math2.sqrt(dx + dy + dz);
	}
	
	public String distanceFrom(Pointi pt)
	{
		double dx = Math2.pow(pt.x - x, 2);
		double dy = Math2.pow(pt.y - y, 2);
		double dz = Math2.pow(pt.z - z, 2);
		return "sqrt(" + (int)(dx + dy + dz) + ")";
	}
}
