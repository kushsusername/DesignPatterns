package cscie97.asn2.housemate.model;

import java.util.HashMap;
import java.util.Map;

import javax.naming.spi.NamingManager;

public class House {
	
	private String name;
	private Map<String, Room> rooms;
	private Map<String, IOT> iots;
	
	public House(String name) {
		this.name = name;
		this.rooms = new HashMap<String, Room>();
		this.iots = new HashMap<String, IOT>();
	}

	public Map<String, Room> getRooms() {
		return rooms;
	}

	public void setRooms(Map<String, Room> rooms) {
		this.rooms = rooms;
	}

	public Map<String, IOT> getIots() {
		return iots;
	}

	public void setIots(Map<String, IOT> iots) {
		this.iots = iots;
	}
	
	public void addRoom(String roomName, Integer floor, String roomType) {
		if(!rooms.containsKey(roomName)){
			rooms.put(roomName, new Room());
		}
		rooms.get(roomName).setName(roomName);
		rooms.get(roomName).setHouseName(name);
		rooms.get(roomName).setFloor(floor);
		rooms.get(roomName).setType(roomType);
	}
	
	public String toString() {
		String output = " house: " + this.name;
		
		for (String room : rooms.keySet()) {
			output = output + (rooms.get(room).toString());
		}
		for (String iot : iots.keySet()) {
			output = output + (iots.get(iot).toString());
		}
		
		return output;
	}
	
}
