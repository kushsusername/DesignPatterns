package cscie97.asn4.housemate.model;

public class OpenWindowCommand implements Command {

	@Override
	public void execute(String name, Location location) throws HouseNotFoundException, RoomNotFoundException {
		HouseMateModelService hmms = HouseMateModelService.getInstance();
		hmms.setAppliancesByType("window", location.getHouseName(), location.getRoomName(), "mode", "open");
	}

	@Override
	public void logEvent(String command) {
		System.out.println("Command: " + command + " Result: Windows Opened");
	}

}
