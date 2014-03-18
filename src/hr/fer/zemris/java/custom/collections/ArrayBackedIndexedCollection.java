package hr.fer.zemris.java.custom.collections;


public class ArrayBackedIndexedCollection {

	private int size;
	private int capacity;
	private Object elements[];
	
	// TODO comment all methods
	
	public ArrayBackedIndexedCollection() {
		size = 0;
		capacity = 16;
		this.elements = new Object[16];
	}

	public ArrayBackedIndexedCollection(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("You have entered initial capacitiy smaller than 1");
		size = 0;
		capacity = initialCapacity;
		this.elements = new Object[initialCapacity];
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
		
		if (value == null) {
			throw new IllegalArgumentException("ArrayBackedIndexedcollection cannot add NULL reference");
		} 
		if (size == capacity) {
			doubleCapacity();
		} 
		elements[size] = value;
		this.size = this.size +1;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Object get(int index) {
		if (indexOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		} 
		else {
			return this.elements[index];
		}
	}
	
	/**
	 * This method removes element at desired index.
	 * @param index Index at which to remove an element.
	 * @throws IndexOutOfBoundsException
	 */
	public void remove(int index) {
		if (indexOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		} 
		if (size == 1) {
			this.elements[index] = null;
			this.size = 0;
		}
		else if (index == size-1) {
			this.elements[index] = null;
			this.size = this.size-1;
		}
		else {
			System.arraycopy(this.elements, index+1, this.elements, index, size-1-index);
			this.size = size-1;
		}
	}
	
	public void insert(Object value, int position) {
		if (position < 0 || position > size) {
			throw new IndexOutOfBoundsException();
		}
		else if (size == capacity) {
			doubleCapacity();
		} 
		if (position == size) {
			add(value);
		} 
		else {
			System.arraycopy(this.elements, position, this.elements, position+1, size-position);
			this.elements[position] = value;
			this.size += 1;
		}
	}
	
	public int indexOf(Object value) {
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(value))
				return i;
		}
		return -1;
	}
	
	public boolean contains(Object value) {
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(value))
				return true;
		}
		return false;
	}
	
	public void clear() {
		for (int i = 0; i < this.size; i++) {
			this.elements[i] = null;
		}
		this.size = 0;
	}
	
 	private boolean indexOutOfBounds(int index) {
		if (index < 0 || index > this.size-1) {
			return true;
		} 
		else
			return false;
	}
	
	/**
	 * This method doubles the size of elements array, 
	 * and updates capacity variable.
	 * @throws OutOfMemoryError
	 */
	private void doubleCapacity() {
		Object newElements[] = new Object[2*size];
		System.arraycopy(this.elements, 0, newElements, 0, size);
		this.elements = newElements;
		this.capacity = this.elements.length;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public Object getElements() {
		return this.elements;
	}
}
