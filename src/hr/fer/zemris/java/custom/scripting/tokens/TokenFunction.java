/**
 * 
 */
package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * @author Igor Petkovski
 *
 */
public class TokenFunction extends Token {

	public TokenFunction(String name) {
		super();
		this.name = name;
	}

	private String name;
	
	/**
	 * Method returns the name of TokenFunction object.
	 * @return Name value of TokenFunction object.
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
	 * Method returns the name of TokenFunction object.
	 * @return Name value of TokenFunction object.
	 */
	public String getName() {
		return name;
	}
}
