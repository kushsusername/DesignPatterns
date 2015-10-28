package cscie97.asn3.housemate.model;

public class CloseDoorCommand implements Command {

	@Override
	public void execute(String name, Location location) throws HouseNotFoundException, RoomNotFoundException {
		HouseMateModelService hmms = HouseMateModelService.getInstance();
		hmms.setAppliancesByType("door", location.getHouseName(), location.getRoomName(), "mode", "close");
	}

	@Override
	public void logEvent(String command) {
		System.out.println("Command: " + command + " Result: Doors Closed");
	}

}
