/**
 * 
 */
package hr.fer.zemris.java.custom.scripting.tokens;

/**
 * @author Igor Petkovski
 *
 */
public class TokenConstantDouble extends Token {

	private double value;
	
	/**
	 * Method returns string representation of 
	 * TokenConstantDouble double value.
	 * @return String representation of TokenConstantDouble double value.
	 */
	@Override
	public String asText() {
		return Double.toString(value);
	}
	
	/**
	 * Getter method for TokenConstantDouble double value.
	 * @return double value of TokenConstantDouble.
	 */
	public double getValue() {
		return value;
	}
}
