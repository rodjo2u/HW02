/**
 * 
 */
package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.custom.collections.ArrayBackedIndexedCollection;

/**
 * @author Igor Petkovski
 *
 */
public class Node {
	
	ArrayBackedIndexedCollection collection;
	
	public void addChildNode(Node child) {
		// TODO  implement addChildNode
	}
	
	// TODO comment this
	public int numberOfChildren() {
		if (collection != null)
			return collection.size();
		return 0;
	}
	
	public Node getChild(int index) {
		// TODO implement getChild
		return new Node();
	}
}
