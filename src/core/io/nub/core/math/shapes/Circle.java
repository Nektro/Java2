package io.nub.core.math.shapes;

import io.nub.core.math.Pointd;
import io.nub.core.util.Math2;

public class Circle
{
	private Pointd center;
	private double radius;
	
	public Circle(Pointd c, double r)
	{
		this.center = c;
		this.radius = r;
	}
	
	public Circle()
	{
		this(new Pointd(), 1);
	}
	
	public Pointd getCenter()
	{
		return center;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public Circle setCenter(Pointd c)
	{
		this.center = c;
		return this;
	}
	
	public Circle setRadius(double r)
	{
		if (r > 0) {
			this.radius = r;
		}
		return this;
	}
	
	public double getArea()
	{
		return Math2.PI * Math2.pow(radius, 2);
	}
	
	public double getVolume()
	{
		return 4.0 / 3.0 * Math2.pow(radius, 3);
	}
	
	@Override
	protected Object clone()
	{
		return new Circle(center, radius);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Circle) {
			Circle ci = (Circle) obj;
			return center.equals(ci.center) && radius == ci.radius;
		}
		return false;
	}
}
