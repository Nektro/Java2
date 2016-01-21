package io.nub.core.i;

/**
 * @author Nektro
 * @since  1.0
 * 
 * An interface to describe a class whose value in some way represents a 2-dimensional array of values
 */
public interface ITable
{
	/**
	 * Get the value in this table at the coordinate (x, y)
	 * 
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the value at (x, y) in this table
	 */
	public Object getValue(int x, int y);
}
