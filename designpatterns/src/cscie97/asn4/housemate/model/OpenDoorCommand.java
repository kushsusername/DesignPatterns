package cscie97.asn4.housemate.model;

public class OpenDoorCommand implements Command {

	@Override
	public void execute(String name, Location location) throws HouseNotFoundException, RoomNotFoundException {
		HouseMateModelService hmms = HouseMateModelService.getInstance();
		hmms.setAppliancesByType("door", location.getHouseName(), location.getRoomName(), "mode", "open");
	}

	@Override
	public void logEvent(String command) {
		System.out.println("Command: " + command + " Result: Doors Opened");
	}
}
