package cscie97.asn3.housemate.model;

public class Occupant {

	private String name;
	private String status;
	private String occupantType;
	private Location location;
	
	public Occupant() {}
	
	public Occupant(String name, String status, String occupantType) {
		this.name = name;
		this.status = status;
		this.occupantType = occupantType;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOccupantType() {
		return occupantType;
	}
	public void setOccupantType(String occupantType) {
		this.occupantType = occupantType;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String toString() {
		return " occupant: " + this.getName() + " type: " + this.getOccupantType() + " status: " + this.getStatus();
	}
	
}
