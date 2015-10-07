package cscie97.asn2.housemate.model;

public class Room {

	private String name;
	private Integer floor;
	private String type;
	private String houseName;
	
	public Room() {}
	
	public Room(String name, Integer floor, String type, String houseName) {
		this.name = name;
		this.floor = floor;
		this.type = type;
		this.houseName = houseName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	public String toString() {
		return (" room: " + this.name + " floor: " + (floor.toString()) + " type: " + this.type);
	}
}
