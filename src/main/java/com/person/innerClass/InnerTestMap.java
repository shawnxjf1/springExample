package com.person.innerClass;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InnerTestMap {

	private final Map<String, Object> _fields;
	private List<InnerTestMap> _childDocuments;

	public Map<String, Collection<Object>> getFieldValuesMap() {
		// The type new Map(){} must implement the inherited abstract method
		// Map.putAll(Map)
		return new Map() {

			@Override
			public Set<String> keySet() {
				return InnerTestMap.this._fields.keySet();
			}

			@Override
			public int size() {
				return InnerTestMap.this._fields.size();
			}

			@Override
			public boolean isEmpty() {
				return InnerTestMap.this._fields.isEmpty();
			}

			@Override
			public void clear() {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean containsValue(Object value) {
				throw new UnsupportedOperationException();
			}

			@Override
			public Set<Map.Entry<String, Collection<Object>>> entrySet() {
				throw new UnsupportedOperationException();
			}

			@Override
			public String toString() {
				return InnerTestMap.this._fields.toString();
			}

			@Override
			public Object put(Object key, Object value) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void putAll(Map<? extends String, ? extends Collection<Object>> t) {
				throw new UnsupportedOperationException();
			}

			@Override
			public Collection<Collection<Object>> values() {
				throw new UnsupportedOperationException();
			}

			public Collection<Object> put(String key, Collection<Object> value) {
				throw new UnsupportedOperationException();
			}

			@Override
			public Collection<Object> remove(Object key) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean containsKey(Object key) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Object get(Object key) {
				// TODO Auto-generated method stub
				return null;
			}

		};
	}

}
