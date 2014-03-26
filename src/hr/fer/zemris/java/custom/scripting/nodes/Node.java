/**
 * 
 */
package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.custom.collections.ArrayBackedIndexedCollection;

/**
 * This class is the root class for all other classes in this package.
 * All other classes must extend this class.
 * <p>
 * This class has internal ArrayBackedIndexedCollection instance which by default is null 
 * reference, and only instantiated if necesseary. Collection stores child nodes of this node.
 * 
 * @author Igor Petkovski
 *
 */
public class Node {
	
	ArrayBackedIndexedCollection collection;
	
	public void addChildNode(Node child) {
		if (collection == null)
			collection = new ArrayBackedIndexedCollection(2);
		try {
			collection.add(child);
		} catch (IllegalArgumentException e) {
			System.out.println("You are trying to add an empty node.");;
		}
		
	}
	
	// TODO comment this
	public int numberOfChildren() {
		if (collection != null)
			return collection.size();
		return 0;
	}
	
	public Object getChild(int index) {
		// TODO implement getChild
		return collection.get(index);
	}
}
