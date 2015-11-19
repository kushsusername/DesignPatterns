package cscie97.asn3.housemate.model;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String userId) {
		super("User <" + userId + "> was not found.");
	}
}
