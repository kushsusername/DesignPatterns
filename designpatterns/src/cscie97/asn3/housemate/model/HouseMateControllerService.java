package cscie97.asn3.housemate.model;

public class HouseMateControllerService {

	KnowledgeGraph kgraph = KnowledgeGraph.getInstance();
	KnowledgeGraphImporter kgImporter = new KnowledgeGraphImporter();
	HouseMateModelService hmms = HouseMateModelService.getInstance();
	Command command;
	
	/**When commands are provided to sensors such as the camera, they will call
	 * runSensorRule to apply the appropriate changes. This will take action based on sensor readings. 
	 * 
	 * The requirements state that the KG must be used to store the occupants information.
	 * During the implementation of the HMMS, it was designed as an evolved KG and designed as a singleton.
	 * So logically, its easier to store the location and status on the HMMS since it was implemented as a KG.
	 * 
	 * @param name
	 * @param rule
	 * @param location
	 * @throws HouseNotFoundException
	 * @throws RoomNotFoundException
	 */
	public void runSensorRule(String name, String rule, Location location) throws HouseNotFoundException, RoomNotFoundException {
		if (rule.equalsIgnoreCase("OCCUPANT_DETECTED")) {
			command = new LightsOnCommand();
			hmms.occupants.get(name).setLocation(location);
			kgImporter.updateOccupant(name + " location " + location.getHouseName() + ":" + location.getRoomName());
		} else if (rule.equalsIgnoreCase("OCCUPANT_LEAVING")){
			command = new LightsOffCommand();
			// here we don't update occupant location because we don't know where they went.
			// we want to keep record of their last known location
		} else if (rule.equalsIgnoreCase("OCCUPANT_ACTIVE")){
			command = new LightsOnCommand();
			hmms.occupants.get(name).setStatus("active");
			kgImporter.updateOccupant(name + " status active");
		} else if (rule.equalsIgnoreCase("OCCUPANT_INACTIVE")){
			command = new LightsOffCommand();
			hmms.occupants.get(name).setStatus("inactive");
			kgImporter.updateOccupant(name + " status inactive");
		}
		command.execute(name, location);
		command.logEvent(rule);
	}
	
	public void runApplianceRule(String userCommand, Location location) throws HouseNotFoundException, RoomNotFoundException {
		
		userCommand = userCommand.toLowerCase();
		String[] words = userCommand.replace("?", "").split(" ");
		String name = null;

		if (userCommand.contains("where")) {
			name = words[words.length - 1];
			command = new LocateOccupantCommand();
		} else if (userCommand.contains("door")) {
			if(userCommand.contains("open")) {
				command = new OpenDoorCommand();
			} else {
				command = new CloseDoorCommand();
			}
		} else if (userCommand.contains("window")) {
			if(userCommand.contains("open")) {
				command = new OpenWindowCommand();
			} else {
				command = new CloseWindowCommand();
			}
		} else if (userCommand.contains("light")) {
			if(userCommand.contains("on")) {
				command = new LightsOnCommand();
			} else {
				command = new LightsOffCommand();
			}
		}
		command.execute(name, location);
		command.logEvent(userCommand);
	}
}
