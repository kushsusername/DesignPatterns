package cscie97.asn4.housemate.model;

public interface AbstractEntitlementFactory {

	/**Interface method to create user
	 * 
	 * @param id used for userId
	 * @param name used for name of user
	 * @return
	 */
	public User createUser(String id, String name);
	/**Interface method to create resourceRole
	 * 
	 * @param id of the resourceRole
	 * @param name of the resourceRole
	 * @param description describe's which resource and which role it pertains too
	 * @return
	 */
	public ResourceRole createResourceRole(String id, String name, String description);
	/**Interface method to create Role
	 * 
	 * @param id the id with which the role can be identified
	 * @param name name of the role
	 * @param description a description of the role (ie. child proof permissions for children users.)
	 * @return
	 */
	public Role createRole(String id, String name, String description);
	/**Interface method to create permissions
	 * 
	 * @param id of the permission
	 * @param name of the permission
	 * @param description describes what this permission allows a user to do
	 * @return
	 */
	public Permission createPermission(String id, String name, String description);
}
