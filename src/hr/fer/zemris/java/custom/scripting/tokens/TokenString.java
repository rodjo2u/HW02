package hr.fer.zemris.java.custom.scripting.tokens;

public class TokenString extends Token {
	
	private String value;
	
	/**
	 * Method returns string value of TokenString.
	 * @return String value of TokenString.
	 */
	@Override
	public String asText() {
		return value;
	}
	
	/**
	 * Method returns string value of TokenString.
	 * @return String value of TokenString.
	 */
	public String getValue() {
		return value;
	}

}
