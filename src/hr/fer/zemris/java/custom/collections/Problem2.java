package hr.fer.zemris.java.custom.collections;

public class Problem2 {

	public static void main(String[] args) {
		
		ObjectStack stack = new ObjectStack();
		stack.push(1);
		stack.push(2);
		stack.clear();
		stack.push("k");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
