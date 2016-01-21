package io.nub.core.util;

import java.util.Map.Entry;

/**
 * @author Nektro
 *
 * @param <K>
 * @param <V>
 */
public class MapEntry<K,V> implements Entry<K,V>
{
	private K key;
	private V value;
	
	public MapEntry(K k, V v) {
		this.key = k;
		this.value = v;
	}
	
	@Override
	public K getKey() {
		return key;
	}
	
	@Override
	public V getValue() {
		return value;
	}
	
	@Override
	public V setValue(V value) {
		this.value = value;
		return value;
	}
}
