package cscie97.asn2.housemate.model;

public class ApplianceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplianceNotFoundException(String sensorName) {
		super("Cannot find appliance: " + sensorName + ".");
	}
}
