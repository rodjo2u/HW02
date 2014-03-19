package hr.fer.zemris.java.custom.scripting.tokens;

public class TokenConstantInteger extends Token {

	private int value;
	
	/**
	 * Method returns string representation of 
	 * TokenConstantInteger int value.
	 * @return String representation of TokenConstantInteger int value.
	 */
	@Override
	public String asText() {
		return Integer.toString(value);
	}
	
	/**
	 * Getter method for TokenConstantInteger int value.
	 * @return int value of TokenConstantInteger.
	 */
	public int getValue() {
		return value;
	}
}
