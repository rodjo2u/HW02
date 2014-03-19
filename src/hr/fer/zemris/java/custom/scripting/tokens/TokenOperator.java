/**
 * 
 */
package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * @author Igor Petkovski
 *
 */
public class TokenOperator extends Token {

	private String symbol;
	
	/**
	 * Method returns the symbol of TokenOperator object.
	 * @return Symbol value of TokenOperator object.
	 */
	@Override
	public String asText() {
		return symbol;
	}
	
	/**
	 * Method returns the symbol of TokenOperator object.
	 * @return Symbol value of TokenOperator object.
	 */
	public String getSymbol() {
		return symbol;
	}
}
