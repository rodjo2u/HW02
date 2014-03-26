package hr.fer.zemris.java.custom.collections;

public class ObjectStack {

	private ArrayBackedIndexedCollection stack;
	
	public ObjectStack() {
		stack = new ArrayBackedIndexedCollection();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int size() {
		return stack.size();
	}
	
	/**
	 * Pushes <code>value</code> to the end of the stack.
	 * @param value Object to push to the stack. Must be not null.
	 * @throws IllegalArgumentException If <code>value</code> is null reference.
	 */
	public void push(Object value) {
		if (value == null)
			throw new IllegalArgumentException();
		stack.add(value);
	}
	
	public Object pop() {
		if (stack.size() == 0)
			throw new EmptyStackException("You are trying to pop an empty stack.");
		Object poppedObject = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return poppedObject;
	}
	
	/**
	 * Method returns reference to an Object at the top of the stack.
	 * @return Reference to an Object at the top of the stack.
	 * @throws EmptyStackException If stack is empty.
	 */
	public Object peek(){
		if (stack.size() == 0)
			throw new EmptyStackException("You are trying to pop an empty stack.");
		return stack.get(stack.size()-1);
	}
	
	void clear() {
		stack.clear();
	}
}
