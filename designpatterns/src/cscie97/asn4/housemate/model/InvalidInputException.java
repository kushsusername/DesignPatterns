package cscie97.asn4.housemate.model;

public class InvalidInputException extends Exception {

	/**Just a specific exception that we can catch aside from other exceptions
	 * 
	 * @param message
	 */
	public InvalidInputException(String message) {
		super(message);
	}
}