package cscie97.asn4.housemate.model;

import java.util.Set;

public class LocateOccupantCommand implements Command {

	/**The requirements asks to store the occupants in the KG. But during the implementation of
	 * the HMMS, the HMMS was designed as an evolved KG; thus implementing the same singleton design.
	 * So instead of executing a query against the KG, its more logical to get the data from the HMMS.
	 * 
	 */
	@Override
	public void execute(String name, Location location) throws HouseNotFoundException, RoomNotFoundException {
//		KnowledgeGraph kgraph = KnowledgeGraph.getInstance();
//		Set<Triple> result = kgraph.executeQuery(new Triple(name + " location ?"));
//		if(result.isEmpty()) {
//			System.out.println("Occupant:" + name + " was not found.");
//		} else {
//			System.out.println("Last known location:" + result.iterator().next().toString());
//		}
		
		HouseMateModelService hmms = HouseMateModelService.getInstance();
		Location occupantLocation = hmms.occupants.get(name).getLocation();
		if (occupantLocation != null) {
			System.out.println(name + " is located at " + hmms.occupants.get(name).getLocation().getHouseName() + ":" + hmms.occupants.get(name).getLocation().getRoomName());
		} else {
			System.out.println("Location of " + name + " was not found.");
		}
	}

	@Override
	public void logEvent(String command) {
		// Nothing since the execute command already prints out, we can see the responses there
	}
}
