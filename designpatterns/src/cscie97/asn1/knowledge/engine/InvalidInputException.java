package cscie97.asn1.knowledge.engine;

public class InvalidInputException extends Exception {

	/**Just a specific exception that we can catch aside from other exceptions
	 * 
	 * @param message
	 */
	public InvalidInputException(String message) {
		super(message);
	}
}
