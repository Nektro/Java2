package io.nub.core.util.arrays;

import java.util.ArrayList;

/**
 * @author Nektro
 *
 * @param <T>
 */
public class Array<T> extends ArrayList<T>
{
	private static final long serialVersionUID = -6223130567146190736L;
	
	public Array()
	{
		super();
	}
	
	public Array(int length)
	{
		super(length);
	}
	
	@SuppressWarnings("unchecked")
	public Array(T... array)
	{
		super();
		for (T o : array)
			this.add(o);
	}
	
	
	public boolean addAll(T[] c)
	{
		for (T t : c)
			this.add(t);
		return true;
	}
	
	public T lastIndex()
	{
		return this.get(size() - 1);
	}
	
	public Array<T> reverse()
	{
		Array<T> res = new Array<T>(this.size());
		for (int i = 0; i < this.size(); i++)
			res.add(this.get(this.size() - i - 1));
		return res;
	}
	
	public void pop()
	{
		this.remove(this.size()-1);
	}
	
	public void shift()
	{
		this.remove(0);
	}
}
