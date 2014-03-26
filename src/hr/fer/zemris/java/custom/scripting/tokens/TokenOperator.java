/**
 * 
 */
package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * @author Igor Petkovski
 *
 */
public class TokenOperator extends Token {

	public TokenOperator(String symbol) {
		super();
		this.symbol = symbol;
	}

	private String symbol;
	
	/**
	 * Method returns the symbol of TokenOperator object.
	 * @return Symbol value of TokenOperator object.
	 */
	@Override
	public String asText() {
		return symbol;
	}
	
	@Override
	public String toString() {
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
