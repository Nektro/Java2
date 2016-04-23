package io.nub.core.util.arrays;

import java.util.ArrayList;

/**
 * @author Nektro
 *
 * @param <T>
 */
public class Array<T> extends ArrayList<T> implements Cloneable
{
	private static final long serialVersionUID = -588781360801958621L;
	
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
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] ta = (T[]) new Object[size()];
		for (int i = 0; i < size(); i++)
			ta[i] = get(i);
		return ta;
	}
	
	@Override
	public Array<T> clone()
	{
		return new Array<>(this.toArray());
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
	
	@Override
	public T set(int index, T element)
	{
		int size = size();
		if (index >= size)
			for (int i = 0; i < index - size + 1; i++)
				add(null);
		return super.set(index, element);
	}
	
	@Override
	public T get(int index) {
		try {
			return super.get(index);
		}
		catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
}
