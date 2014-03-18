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
	
	public Object peek(){
		if (stack.size() == 0)
			throw new EmptyStackException("You are trying to pop an empty stack.");
		return stack.get(stack.size()-1);
	}
	
	void clear() {
		stack.clear();
	}
}
