package cscie97.asn3.housemate.model;

public class IOT {

	private String name;
	private String type;
	private Location location;
	
	public IOT() {}
	
	public IOT(String name, String type, String houseName, String roomName) {
		this.name = name;
		this.type = type;
		this.location = new Location(houseName, roomName);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setLocation(String houseName, String roomName) {
		this.location = new Location(houseName, roomName);
	}
}
