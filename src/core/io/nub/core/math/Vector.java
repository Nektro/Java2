package io.nub.core.math;

/**
 * @author Nektro
 */
public class Vector
{
	private double vx;
	private double vy;
	private double vz;
	
	public Vector(double x, double y, double z)
	{
		this.vx = x;
		this.vy = y;
		this.vz = z;
	}
	
	public Vector(double x, double y)
	{
		this(x, y, 0);
	}
	
	public Vector(double x)
	{
		this(x, 0);
	}
	
	public Vector()
	{
		this(0);
	}
	
	public double getX()
	{
		return vx;
	}
	
	public double getY()
	{
		return vy;
	}
	
	public double getZ()
	{
		return vz;
	}
	
	public double magnitude()
	{
		return new Pointd(0,0,0).distanceTo(new Pointd(vx,vy,vx));
	}
	
	public Vector add(Vector vec)
	{
		return new Vector(vx + vec.vx, vy + vec.vy, vz + vec.vz);
	}
	
	public Vector subtract(Vector vec)
	{
		return new Vector(vec.vx - vx, vec.vy - vy, vec.vz - vz);
	}
	
	public Vector multiply(double sca)
	{
		return new Vector(vx * sca, vy * sca, vz * sca);
	}
	
	public Vector unitVec()
	{
		double mag = magnitude();
		return new Vector(vx / mag, vy / mag, vz / mag);
	}
}
