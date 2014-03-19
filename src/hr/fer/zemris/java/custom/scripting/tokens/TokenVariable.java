package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * @author Igor Petkovski
 *
 */
public class TokenVariable extends Token {

	private int value;
	
	/**
	 * Method returns string representation of TokenVariable int value.
	 * @return String representation of TokenVariable int value.
	 */
	@Override
	public String asText() {
		return Integer.toString(value);
	}
	
	/**
	 * Getter method for TokenVariable int value.
	 * @return int value of TokenVariable.
	 */
	public int getValue() {
		return value;
	}
}
