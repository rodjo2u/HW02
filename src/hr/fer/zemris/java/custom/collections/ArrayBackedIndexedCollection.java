package hr.fer.zemris.java.custom.collections;

public class ArrayBackedIndexedCollection {

	private int size;
	private int capacity;
	private Object elements[];
	
	// TODO comment all methods
	
	public Object ArrayBackedIndexedCollection() {
		size = 16;
		capacity = 16;
		this.elements = new Object[16];
		return this;
	}

	public Object ArrayBackedIndexedCollection(int initialCapacity) {
		// TODO if capacity < 1 throw IllegalArgumentException
		size = initialCapacity;
		capacity = initialCapacity;
		this.elements = new Object[initialCapacity];
		return this;
	}
	
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return this.size;
	}

	public void add(Object value) {
		// TODO implement add(Object value)
	}
}
