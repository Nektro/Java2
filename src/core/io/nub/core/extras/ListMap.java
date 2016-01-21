package io.nub.core.extras;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.nub.core.util.MapEntry;

/**
 * An associative List that works in the same way Map does.
 * 
 * @author Nektro
 *
 * @param <K>
 * @param <V>
 * 
 * @see com.zylonik.java2.util.ArrayAssoc
 */
public class ListMap<K,V> implements Map<K,V>
{
	private List<K> k = new ArrayList<K>();
	private List<V> v = new ArrayList<V>();
	
	@Override
	public int size()
	{
		return k.size();
	}
	
	@Override
	public boolean isEmpty()
	{
		return k.size() == 0 && v.size() == 0;
	}

	@Override
	public boolean containsKey(Object key)
	{
		return k.contains(key);
	}

	@Override
	public boolean containsValue(Object value)
	{
		return v.contains(value);
	}
	
	@Override
	public V get(Object key)
	{
		try {
			return v.get(k.indexOf(key));
		}
		catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public V put(K key, V value)
	{
		if (k.contains(key)) {
			v.set(k.indexOf(key), value);
		}
		else {
			k.add(key);
			v.add(value);
		}
		return null;
	}
	
	@Override
	public V remove(Object key)
	{
		v.remove(k.indexOf(key));
		k.remove(k.indexOf(key));
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m)
	{
		for (int i = 0; i < m.size(); i++)
		{
			this.put(m.keySet().iterator().next(), m.values().iterator().next());
		}
	}

	@Override
	public void clear()
	{
		k.clear();
		v.clear();
	}
	
	@Override
	public Set<K> keySet()
	{
		return new HashSet<>(k);
	}

	@Override
	public Collection<V> values()
	{
		return v;
	}
	
	@Override
	public Set<Entry<K, V>> entrySet()
	{
		Set<Entry<K,V>> set = new HashSet<Entry<K,V>>();
		for (int i = 0; i < k.size(); i++)
		{
			set.add(new MapEntry<K,V>(k.get(i),v.get(i)));
		}
		return set;
	}
	
	public K getKey(int index)
	{
		return k.get(index);
	}
	
	public V getValue(int index)
	{
		return v.get(index);
	}
	
	public Object[][] toArrayArray()
	{
		Object[][] result = new Object[this.size()][2];
		for (int i = 0; i < this.size(); i++)
		{
			result[i][0] = this.getKey(i);
			result[i][1] = this.getValue(i);
		}
		return result;
	}
	
	public ListMap<K,V> put(K key, V value, int index)
	{
		this.k.add(index, key);
		this.v.add(index, value);
		return this;
	}
	
	public ListMap<K,V> switchWith(int a, int b)
	{
		K k0 = this.k.get(a);
		K k1 = this.k.get(b);
		V v0 = this.v.get(a);
		V v1 = this.v.get(b);
		
		this.put(k0, v0, b);
		this.put(k1, v1, a);
		
		return this;
	}
	
	public List<K> keys()
	{
		return this.k;
	}
}
