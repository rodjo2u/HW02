package hr.fer.zemris.java.custom.scripting.nodes;

import hr.fer.zemris.java.custom.scripting.tokens.*;

/**
 * @author Igor Petkovski
 * 
 */
public class ForLoopNode extends Node {

	private TokenVariable variable;
	private Token startExpression;
	private Token endExpression;
	private Token stepExpression;

	public ForLoopNode(TokenVariable variable, Token startExpression,
			Token endExpression, Token stepExpression) {
		super();
		this.variable = variable;
		this.startExpression = startExpression;
		this.endExpression = endExpression;
		this.stepExpression = stepExpression;
		if (this.stepExpression == null) {
			this.stepExpression = new TokenString("");
		}
	}

	@Override
	public String toString() {
		return ("{$ FOR " + variable.toString() + " " + startExpression.toString() + " "
				+ endExpression.toString() + " " + stepExpression.toString() + " $}");
	}

	public TokenVariable getVariable() {
		return variable;
	}

	public Token getStartExpression() {
		return startExpression;
	}

	public Token getEndExpression() {
		return endExpression;
	}

	public Token getStepExpression() {
		return stepExpression;
	}

}
