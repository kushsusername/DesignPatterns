package cscie97.asn3.housemate.model;

public class Sensor extends IOT {
	
	private String status;

	public Sensor() {
		super();
	}
	
	public Sensor(String name, String type, String houseName, String roomName) {
		super(name, type, houseName, roomName);
		this.status = "";
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return " sensor: " + this.getName() 
				+ " type: " + this.getType() 
				+ " status: " + ((this.getStatus() == null || this.getStatus() == "") ? "unknown" : this.getStatus());
	}

}
