package io.nub.core.math;

import java.util.Iterator;

import io.nub.core.lang.Object2;
import io.nub.core.util.Arrays2;
import io.nub.core.util.arrays.Array;
import io.nub.core.util.arrays.ArrayString;

/**
 * A String based implementation of Integers, allowing for values greater than Integer.MAX_VALUE
 * and Long.MAX_VALUE that only deals with positive numbers
 * 
 * @author Nektro (Sean Denny)
 * @since  23-04-2016
 * @see    java.lang.String
 * @see    java.lang.Integer
 */
public class SInteger implements Comparable<SInteger>, Cloneable, Iterable<Integer>
{
	private Array<Integer> digits;
	private int base;
	
	private SInteger(String num, int base)
	{
		this.digits = new Array<>(Arrays2.valueOf(Arrays2.valueOf((new ArrayString(num.split("")).reverseR()).toSArray())));
		this.base = base;
	}
	
	public SInteger(String num)
	{
		this(num, 10);
	}
	
	public SInteger()
	{
		this("0");
	}
	
	@Override
	public String toString()
	{
		return new ArrayString(digits).reverseR().join("");
	}
	
	@Override
	protected SInteger clone()
	{
		return new SInteger(this.toString(), base);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof SInteger ? this.toString().equals(obj.toString()) : false;
	}
	
	private void simplify(int d)
	{
		int s = digits.size();
		Integer val = digits.get(d);
		Integer rval = val % base;
		Integer over = val / base;
		
		digits.set(d, rval);
		
		if (d != s - 1 || over > 0)
			digits.set(d + 1, Object2.orn(digits.get(d + 1), 0) + over);
		
		if (d > s || s != digits.size())
			simplify(d + 1);
		
		trim();
		
		for (int i = 0; i < digits.size(); i++) {
			if (digits.get(i) > base) {
				simplify(i);
				break;
			}
		}
		for (int i = 0; i < digits.size(); i++) {
			if (digits.get(i) < 0 && i != 0) {
				simplify(i);
				break;
			}
		}
		
		if (digits.lastIndex() < 0) {
			digits = new Array<>();
			digits.add(-1);
			return;
		}
	}
	
	private void trim()
	{
		if (digits.lastIndex() == 0 && digits.size() != 1) {
			digits.pop();
			trim();
		}
	}
	
	public SInteger add(SInteger num)
	{
		for (int i = 0; i < num.digits.size(); i++) {
			this.digits.set(i, Object2.orn(this.digits.get(i), 0) + Object2.orn(num.digits.get(i), 0 ));
		}
		this.simplify(0);
		return this;
	}
	
	public SInteger subtract(SInteger num)
	{
		if (num.compareTo(this) > 0)
			throw new NumberFormatException("SInteger does not suppor negative numbers.");
		
		for (int i = 0; i < num.digits.size(); i++) {
			this.digits.set(i, Object2.orn(this.digits.get(i), 0) - Object2.orn(num.digits.get(i), 0 ));
		}
		this.simplify(0);
		return this;
	}
	
	public SInteger multiply(SInteger num)
	{
		SInteger x = this.clone();
		SInteger i = new SInteger("1");
		
		while (i.compareTo(num) < 0) {
			this.add(x);
			i.add(new SInteger("1"));
		}
		
		return this;
	}
	
	public SInteger divide(SInteger num)
	{
		SInteger c = new SInteger("0");
		
		try {
			while (true) {
				this.subtract(num);
				c.add(new SInteger("1"));
				
				if (this.equals(new SInteger("0")))
					break;
			}
		}
		catch (NumberFormatException  e) {
			// number is negative and division is over
			c.subtract(new SInteger("1"));
		}
		
		return c;
	}
	
	public SInteger modulus(SInteger num)
	{
		// TODO
		return this;
	}
	
	public SInteger power(int x)
	{
		SInteger cv = this.clone();
		
		for (int i = 1; i < x; i++) {
			this.multiply(cv);
		}
		
		return this;
	}
	
	public SInteger root(int n)
	{
		// TODO
		return this;
	}
	
	@Override
	public int compareTo(SInteger o)
	{
		if (this.equals(o))
			return 0;
		
		if (this.digits.size() > o.digits.size())
			return 1;
		if (this.digits.size() < o.digits.size())
			return -1;
		
		Array<Integer> tld = this.digits.reverse();
		Array<Integer> old = o.digits.reverse();
		
		for (int i = 0; i < tld.size(); i++) {
			if (tld.get(i) > old.get(i)) {
				return 1;
			}
		}
		
		return -1;
	}
	
	@Override
	public Iterator<Integer> iterator()
	{
		return new Iterator<Integer>() {
			private int ind = 0;
			
			@Override
			public boolean hasNext() {
				return ind == digits.reverse().size();
			}
			@Override
			public Integer next() {
				ind += 1;
				return digits.reverse().get(ind);
			}
		};
	}
}
