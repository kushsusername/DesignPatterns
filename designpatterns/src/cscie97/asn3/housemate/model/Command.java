package cscie97.asn3.housemate.model;

public interface Command {

	/**Every command will execute some step 
	 * @param name TODO
	 * @param location The location where to execute the command (has houseName and roomName)
	 * 
	 * @throws HouseNotFoundException
	 * @throws RoomNotFoundException
	 */
	public abstract void execute(String name, Location location) throws HouseNotFoundException, RoomNotFoundException;
	
	/**Each command should implement its own logging method
	 * 
	 * @param command the command/rule that was run
	 */
	public abstract void logEvent(String command);
}
