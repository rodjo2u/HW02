/**
 * 
 */
package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * @author Igor Petkovski
 *
 */
public class TokenFunction extends Token {

	private String name;
	
	/**
	 * Method returns the name of TokenFunction object.
	 * @return Name value of TokenFunction object.
	 */
	@Override
	public String asText() {
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
