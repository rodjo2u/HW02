package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * @author Igor Petkovski
 *
 */
public class TokenVariable extends Token {

	private String name;
	
	public TokenVariable(String name) {
		this.name = name;
	}
	/**
	 * Method returns string representation of TokenVariable int value.
	 * @return String representation of TokenVariable int value.
	 */
	@Override
	public String asText() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Getter method for TokenVariable <code>name</code> value.
	 * @return String value of TokenVariable.
	 */
	public String getName() {
		return name;
	}
}
