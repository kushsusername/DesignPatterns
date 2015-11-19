package cscie97.asn4.housemate.model;

public class LightsOnCommand implements Command {

	@Override
	public void execute(String name, Location location) throws HouseNotFoundException, RoomNotFoundException {
		HouseMateModelService hmms = HouseMateModelService.getInstance();
		hmms.setAppliancesByType("light", location.getHouseName(), location.getRoomName(), "mode", "on");
	}

	@Override
	public void logEvent(String command) {
		System.out.println("Command: " + command + " Result: Lights On");
	}

}
