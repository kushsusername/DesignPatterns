package cscie97.asn3.housemate.model;

import java.util.HashMap;
import java.util.Map;

public class HouseMateModelService {

	Map<String, House> houses = new HashMap<>();
	Map<String, Occupant> occupants = new HashMap<>();
	
	public static HouseMateModelService houseMateModelService;
	
	public static HouseMateModelService getInstance() {
		if(houseMateModelService == null) {
			 houseMateModelService = new HouseMateModelService();
		}
		return houseMateModelService;
	}
	
	public void addHouse(String houseName) {
		// if the house exists, we'll just override it
		houses.put(houseName, new House(houseName));
	}
	public void showHouse(String houseName) throws HouseNotFoundException {
		if (houses.containsKey(houseName)) {
			System.out.println(houses.get(houseName).toString());
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	
	public void addRoom(String roomName, Integer floor, String roomType, String houseName) throws HouseNotFoundException {
		if (houses.containsKey(houseName)) {
			houses.get(houseName).addRoom(roomName, floor, roomType);
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	public void showRoom(String houseName, String roomName) throws RoomNotFoundException, HouseNotFoundException {
		if (houses.containsKey(houseName)) {
			if(houses.get(houseName).getRooms().containsKey(roomName)) {
				System.out.println(houses.get(houseName).getRooms().get(roomName).toString());
			} else {
				throw new RoomNotFoundException(roomName);
			}
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	
	public void addOccupant(String occupantName, String occupantType, String occupantStatus) {
		occupants.put(occupantName, new Occupant(occupantName, occupantStatus, occupantType));
	}
	public void setOccupantLocation(String occupantName, String houseName, String roomName) throws HouseNotFoundException {
		if (houses.containsKey(houseName)) {
			occupants.get(occupantName).setLocation(new Location(houseName, roomName));
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	
	public void addSensor(String sensorName, String sensorType, String houseName, String roomName) throws HouseNotFoundException, RoomNotFoundException {
		if (houses.containsKey(houseName)) {
			if(houses.get(houseName).getRooms().containsKey(roomName)) {
				houses.get(houseName).getIots().put(sensorName, new Sensor(sensorName, sensorType, houseName, roomName));
			} else {
				throw new RoomNotFoundException(roomName);
			}
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	public void setSensor(String sensorName, String houseName, String sensorStatus) throws SensorNotFoundException, HouseNotFoundException {
		if (houses.containsKey(houseName)) {
			if (houses.get(houseName).getIots().containsKey(sensorName)) {
				((Sensor)houses.get(houseName).getIots().get(sensorName)).setStatus(sensorStatus);
			} else {
				throw new SensorNotFoundException(sensorName);
			}
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	public void showSensor(String houseName, String sensorName) throws HouseNotFoundException, SensorNotFoundException {
		if (houses.containsKey(houseName)) {
			if (houses.get(houseName).getIots().containsKey(sensorName)) {
				System.out.println(((Sensor)houses.get(houseName).getIots().get(sensorName)).toString());
			} else {
				throw new SensorNotFoundException(sensorName);
			}
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	
	public void addAppliance(String applianceName, String applianceType, String houseName, String roomName) throws RoomNotFoundException, HouseNotFoundException {
		if (houses.containsKey(houseName)) {
			if(houses.get(houseName).getRooms().containsKey(roomName)) {
				houses.get(houseName).getIots().put(applianceName, new Appliance(applianceName, applianceType, houseName, roomName));
			} else {
				throw new RoomNotFoundException(roomName);
			}
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	public void setAppliance(String applianceName, String houseName, String roomName, String applianceStatus, String applianceStatusValue) throws ApplianceNotFoundException, HouseNotFoundException, RoomNotFoundException {
		if (houses.containsKey(houseName)) {
			if(houses.get(houseName).getRooms().containsKey(roomName)) {
				if (houses.get(houseName).getIots().containsKey(applianceName)) {
					((Appliance)houses.get(houseName).getIots().get(applianceName)).getStatus().put(applianceStatus, applianceStatusValue);
				} else {
					throw new ApplianceNotFoundException(applianceName);
				}
			} else {
				throw new RoomNotFoundException(roomName);
			}
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	public void showAppliance(String applianceName, String houseName) throws ApplianceNotFoundException, HouseNotFoundException {
		if (houses.containsKey(houseName)) {
			if (houses.get(houseName).getIots().containsKey(applianceName)) {
				System.out.println(((Appliance)houses.get(houseName).getIots().get(applianceName)).toString());
			} else {
				throw new ApplianceNotFoundException(applianceName);
			}
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	public void showApplianceStatus(String applianceName, String houseName, String applianceStatus) throws ApplianceNotFoundException, HouseNotFoundException {
		if (houses.containsKey(houseName)) {
			if (houses.get(houseName).getIots().containsKey(applianceName)) {
				System.out.println(((Appliance)houses.get(houseName).getIots().get(applianceName)).toStringStatus(applianceStatus));
			} else {
				throw new ApplianceNotFoundException(applianceName);
			}
		} else {
			throw new HouseNotFoundException(houseName);
		}
	}
	public void show() {
		String output = "";
		for (String house : houses.keySet()) {
			output = output + houses.get(house).toString();
		}
		for (String occupant : occupants.keySet()) {
			output = output + occupants.get(occupant).toString();
		}
		System.out.println(output);
	}
	
}
