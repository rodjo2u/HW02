package hr.fer.zemris.java.custom.scripting.tokens;

public class TokenString extends Token {

	private String value;

	/**
	 * Creates TokenString with value <code>value</code>.
	 * 
	 * @param value
	 *            Value of TokenString.
	 */
	public TokenString(String value) {
		this.value = value;
	}

	/**
	 * Method returns string value of TokenString.
	 * 
	 * @return String value of TokenString.
	 */
	@Override
	public String asText() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
	
	/**
	 * Method returns string value of TokenString.
	 * 
	 * @return String value of TokenString.
	 */
	public String getValue() {
		return value;
	}

}
