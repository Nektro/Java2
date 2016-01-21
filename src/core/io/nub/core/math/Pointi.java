package io.nub.core.math;

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
}
