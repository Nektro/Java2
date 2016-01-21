package io.nub.core.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * A replacement for the plain old String with new methods you wish String had a long time ago.
 * 
 * @author Nektro
 */
public class String2
{
	private final char[] value;
	public final int length;
	private final List<Character> list;
	
	public String2(char[] c)
	{
		this.value = c;
		this.length = this.value.length;
		this.list = new ArrayList<Character>();
		
		for (char x : this.value) {
			this.list.add(x);
		}
	}
	
	public String2()          { this(new char[0]);        }
	public String2(String s)  { this(s.toCharArray());    }
	public String2(String2 s) { this(s.toString());       }
	public String2(Object o)  { this(String.valueOf(o));  }
	
	@Override
	public String toString()
	{
		return new String(this.value);
	}
	
	public boolean equals(String2 s)
	{
		return this.value == this.toCharArray();
	}
	public boolean equals(String s)
	{
		return this.value == s.toCharArray();
	}
	
	public char[] toCharArray()
	{
		return this.value;
	}
	
	public char charAt(int index)
	{
		return this.value[index];
	}
	
	public boolean contains(char c)
	{
		return this.list.indexOf(c) > 0 && this.list.contains(c);
	}
	
	public String2 concat(String2 s)
	{		
		return new String2(this.toString() + s.toString());
	}
	
	public String2 concat(char c)
	{
		return new String2(this.toString() + c);
	}
	
	public String2 concat(String s)
	{
		return this.concat(new String2(s));
	}
	
	public String2 substring(int amt)
	{
		char[] result = new char[this.length - amt];
		System.arraycopy(this.value, amt, result, 0, this.length - amt);
		return new String2(result);
	}
	
	public String2 substring(int start, int end)
	{
		char[] result = new char[end - start];
		System.arraycopy(this.value, start, result, 0, end - start);
		return new String2(result);
	}
	
	public String2 substr(int start, int len)
	{
		char[] res = new char[len];
		System.arraycopy(value, start, res, 0, len);
		return new String2(res);
	}
	
	public String2 superstring(int amt)
	{
		char[] result = new char[this.length - amt];
		System.arraycopy(this.value, 0, result, 0, this.length - amt);
		return new String2(result);
	}
	
	public int indexOf(char c)
	{
		return this.list.indexOf(c);
	}
	
	public String2 replace(char c, char d)
	{
		// TODO
		return new String2(this.toString().replace(c, d));
	}
	
	public String2 prepend(String2 text)
	{
		return text.concat(this);
	}

	public boolean startsWith(String2 string)
	{
		return this.toString().substring(0, string.length).equals(string);
	}

	public String[] split(String2 string)
	{
		// TODO
		return this.toString().split(string.toString());
	}
}
