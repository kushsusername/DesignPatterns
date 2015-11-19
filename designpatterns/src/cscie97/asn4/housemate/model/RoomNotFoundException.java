package cscie97.asn4.housemate.model;

public class RoomNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomNotFoundException(String roomName) {
		super("Cannot find room: " + roomName + ".");
	}
}
