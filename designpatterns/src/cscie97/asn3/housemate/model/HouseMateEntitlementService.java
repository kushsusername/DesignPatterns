package cscie97.asn3.housemate.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseMateEntitlementService {

	public static HouseMateEntitlementService houseMateEntitlementService;
	
	public static HouseMateEntitlementService getInstance() {
		if(houseMateEntitlementService == null) {
			houseMateEntitlementService = new HouseMateEntitlementService();
		}
		return houseMateEntitlementService;
	}
	
	private Map<String, User> users = new HashMap<>();
	private AbstractEntitlementFactory entitlementFactory = null;
	
	/**This method gets the accessToken to allow the HMMS/HMCS to continue their action
	 * It will return null if there is no accessToken
	 * 
	 * @param userId the id of the user attemping the action
	 * @param resourceId the id of the house in which the action is being requested
	 * @param permissionId the permission required to complete such action
	 * @return
	 */
	public String getAccessToken(String userId, String resourceId, String permissionId) {
		EntitlementVisitor eVisitor = new EntitlementVisitor(resourceId, permissionId);
		eVisitor.visit(users.get(userId));
		
		// returns null if there is no access token, then HMMS/HMCS will not execute the commmand
		// doesn't matter if user was not found or if they don't have permissoin, we simply don't 
		// complete the action
		return eVisitor.getAccessToken();
	}
	
	/**If a user logs out, or leaves the house their access token gets cleared
	 * This prevents other malicious users to execute commands as said person
	 * Note: when a user enters the house, a new token will get generated for them 
	 * when they execute their first command
	 * 
	 * @param userId Id of the user logging out or leaving the house
	 * @throws UserNotFoundException Here, if the user was not found, we should notify the system
	 */
	public void removeAccessToken(String userId) throws UserNotFoundException {
		if(users.get(userId) != null) {
			users.get(userId).setToken(null);
		} else {
			throw new UserNotFoundException(userId);
		}
	}
	
	public void createOccupantUser(String occupantName) {
		entitlementFactory = new EntitlementFactory();
		User newUser = entitlementFactory.createUser(occupantName, occupantName);
		newUser.setVoicePrintOrPassword("--"+occupantName+"--");
		users.put(occupantName, newUser);
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}
	
	
}
