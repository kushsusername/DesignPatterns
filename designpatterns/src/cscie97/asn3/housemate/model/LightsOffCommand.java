package cscie97.asn3.housemate.model;

public class LightsOffCommand implements Command {

	@Override
	public void execute(Location location) throws HouseNotFoundException, RoomNotFoundException {
		HouseMateModelService hmms = HouseMateModelService.getInstance();
		hmms.setAppliancesByType("light", location.getHouseName(), location.getRoomName(), "mode", "off");
	}

	@Override
	public void logEvent(String command) {
		System.out.println("Command: " + command + " Result: Lights Off");
	}

}
