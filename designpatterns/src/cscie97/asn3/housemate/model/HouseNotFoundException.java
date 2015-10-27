package cscie97.asn3.housemate.model;

public class HouseNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HouseNotFoundException(String houseName) {
		super("Cannot find house: " + houseName + ".");
	}
}
