package cscie97.asn4.housemate.model;

public class Location {

	private String houseName;
	private String roomName;
	
	public Location() {
		
	}
	public Location(String houseName, String roomName) {
		this.houseName = houseName;
		this.roomName = roomName;
	}
	
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String toString() {
		return " house: " + this.houseName + " room: " + this.roomName == null ? "unknown" : this.roomName;
	}
}
