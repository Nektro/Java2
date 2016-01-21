package io.nub.core.extras;

import java.io.PrintStream;
import java.util.List;

import io.nub.core.Java2;

/**
 * A new util object that use may end up using a lot more than you think. Table is a 2-Dimensional
 * array that can hold and recall objects just like a List.
 * 
 * @author Nektro
 */
public class Table
{
	private final List<List<Object>> value;
	
	public Table()
	{
		this.value = Java2.newList();
	}
	
	/**
	 * Add a row to this Table through a List
	 * 
	 * @param items
	 * @return this
	 */
	public Table addRow(List<Object> items)
	{
		this.value.add(items);
		return this;
	}
	
	/**
	 * Add an array of items to this Table
	 * 
	 * @param items
	 * @return this
	 */
	public Table addRow(Object... items)
	{
		List<Object> list = Java2.newList(Java2.newList(), items);
		this.value.add(list);
		return this;
	}
	
	/**
	 * Get the List at the Y index specified
	 * 
	 * @param index the "y" value of the row
	 * @return the row
	 */
	public List<Object> getRow(int index)
	{
		return this.value.get(index);
	}
	
	/**
	 * Get the specific element at (x,y)
	 * @param x
	 * @param y
	 * @return an Object
	 */
	public Object getElement(int x, int y)
	{
		return this.value.get(y).get(x);
	}
	
	/**
	 * Set the object at a specific position in this Table
	 * @param x
	 * @param y
	 * @param object
	 * @return this
	 */
	public Table setElement(int x, int y, Object object)
	{
		this.getRow(y).set(x, object);
		return this;
	}
	
	/**
	 * Use a PrintStream to print the data of this table
	 */
	public void export(PrintStream ps)
	{
		for (int i = 0; i < this.value.size(); i++)
		{
			for (int j = 0; j < this.value.get(i).size(); j++)
			{
				ps.print(this.getElement(j, i) + "\t");
			}
			ps.println();
		}
	}
}
