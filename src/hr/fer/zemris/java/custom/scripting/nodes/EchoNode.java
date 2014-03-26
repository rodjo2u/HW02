package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.custom.scripting.tokens.Token;

/**
 * @author Igor Petkovski
 *
 */
public class EchoNode extends Node {

	private Token[] tokens;

	public EchoNode(Token[] tokens) {
		super();
		this.tokens = tokens;
	}
	
	@Override
	public String toString() {
		String output = "{$= ";
		for (Token token : tokens)
			output += token.toString() + " " ;
		output += "$}";
		return output;
	}
}
