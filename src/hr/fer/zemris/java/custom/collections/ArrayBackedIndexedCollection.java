package hr.fer.zemris.java.custom.collections;

/**
 * ArrayBackedIndexedCollection class is collection auto expanding array backed
 * collection for storing Objects.
 * 
 * @author Igor Petkovski
 * 
 */
public class ArrayBackedIndexedCollection {

	private int size;
	private int capacity;
	private Object elements[];

	/**
	 * Default constructor that creates new collection with capacity set to 16.
	 */
	public ArrayBackedIndexedCollection() {
		size = 0;
		capacity = 16;
		this.elements = new Object[16];
	}

	/**
	 * Constructor that creates new collection with capacity set to
	 * <code>initialCapacity</code>.
	 * 
	 * @param initialCapacity
	 *            Default size of a new collection. Must be >= 1.
	 */
	public ArrayBackedIndexedCollection(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException(
					"You have entered initial capacitiy smaller than 1");
		size = 0;
		capacity = initialCapacity;
		this.elements = new Object[initialCapacity];
	}

	/**
	 * Method checks if there are no elements in the collection.
	 * <p>
	 * Method checks if private variable <code>size == 0</code>.
	 * 
	 * @return <code>true</code> if collection is empty or <code>false</code>
	 *         otherwise.
	 */
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method returns the number of stored elements in the collection.
	 * <p>
	 * Method returns the value of private variable <code>size</code>.
	 * 
	 * @return Number of stored elements in the collection.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Method adds new Object to the end of array backed list collection.
	 * 
	 * @param value
	 *            Object reference cannot be <code>null</code>.
	 * @throws IllegalArgumentException
	 */
	public void add(Object value) {

		if (value == null) {
			throw new IllegalArgumentException(
					"ArrayBackedIndexedcollection cannot add NULL reference");
		}
		if (size == capacity) {
			doubleCapacity();
		}
		elements[size] = value;
		this.size = this.size + 1;
	}

	/**
	 * Method returns reference to an object at submitted index.
	 * 
	 * @param index
	 *            Must be in interval 0 to collection size-1.
	 * @return Returns reference to an object at submitted index.
	 * @throws IndexOutOfBoundsException
	 */
	public Object get(int index) {
		if (indexOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		} else {
			return this.elements[index];
		}
	}

	/**
	 * This method removes element at desired index.
	 * 
	 * @param index
	 *            Index at which to remove an element. Index must be in interval
	 *            from <code>0</code> to <cod>collection.size()-1</code>.
	 * @throws IndexOutOfBoundsException
	 */
	public void remove(int index) {
		if (indexOutOfBounds(index)) {
			throw new IndexOutOfBoundsException();
		}
		if (size == 1) {
			elements[index] = null;
			size = 0;
		} else if (index == size - 1) {
			elements[index] = null;
			size = this.size - 1;
		} else {
			System.arraycopy(this.elements, index + 1, this.elements, index,
					size - 1 - index);
			elements[size - 1] = null;
			size = size - 1;
		}
	}

	/**
	 * Inserts Object value at submitted position.
	 * 
	 * @param value
	 *            Object to insert to collection.
	 * @param position
	 *            Index at which the object is to be added.
	 * @throws IndexOutOfBoundsException
	 */
	public void insert(Object value, int position) {
		if (position < 0 || position > size) {
			throw new IndexOutOfBoundsException();
		} else if (size == capacity) {
			doubleCapacity();
		}
		if (position == size) {
			add(value);
		} else {
			System.arraycopy(this.elements, position, this.elements,
					position + 1, size - position);
			this.elements[position] = value;
			this.size += 1;
		}
	}

	/**
	 * Method returns index of a submitted object.
	 * 
	 * @param value
	 *            Object to look for. Must be not null.
	 * @return Index of a Object in the collection. If Object is not found
	 *         returns -1.
	 * @throws IllegalArgumentException
	 */
	public int indexOf(Object value) {
		if (value == null) {
			throw new IllegalArgumentException(
					"You have submitted null reference.");
		}
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(value))
				return i;
		}
		return -1;
	}

	/**
	 * Method returns true or false if the collection contains submitted Object.
	 * 
	 * @param value
	 *            Object to look for. Must be not null.
	 * @return <code>true</code> if value is found, <code>false</code>
	 *         otherwise.
	 * @throws IllegalArgumentException
	 */
	public boolean contains(Object value) {
		if (value == null) {
			throw new IllegalArgumentException(
					"You have submitted null reference.");
		}
		for (int i = 0; i < this.size; i++) {
			if (this.elements[i].equals(value))
				return true;
		}
		return false;
	}

	/**
	 * Method sets all contained references to null, and sets size to 0.
	 */
	public void clear() {
		for (int i = 0; i < this.size; i++) {
			this.elements[i] = null;
		}
		this.size = 0;
	}

	/**
	 * Method checks if submitted index is out of bounds.
	 * 
	 * @param index
	 *            Submitted index to check.
	 * @return <code>true</code> if index is out of bounds, <code>false</code>
	 *         otherwise
	 */
	private boolean indexOutOfBounds(int index) {
		if (index < 0 || index > this.size - 1) {
			return true;
		} else
			return false;
	}

	/**
	 * This method doubles the size of elements array, and updates capacity
	 * variable.
	 * 
	 * @throws OutOfMemoryError
	 */
	private void doubleCapacity() {
		Object newElements[] = new Object[2 * size];
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
