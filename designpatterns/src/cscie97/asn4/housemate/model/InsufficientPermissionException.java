package cscie97.asn4.housemate.model;

public class InsufficientPermissionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9050358002767788876L;
	
	public InsufficientPermissionException(String user) {
		super("User <" + user + "> does not have sufficent permission to execute given command");
	}
}
