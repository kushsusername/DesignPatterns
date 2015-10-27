package cscie97.asn3.housemate.model;

public class SensorNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SensorNotFoundException(String sensorName) {
		super("Cannot find sensor: " + sensorName + ".");
	}
}
