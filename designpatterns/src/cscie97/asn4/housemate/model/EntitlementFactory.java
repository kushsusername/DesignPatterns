package cscie97.asn4.housemate.model;

public class EntitlementFactory implements AbstractEntitlementFactory {

	/**Implementation for the abstract factory. Creates a user specific to the entitlement interface
	 * 
	 */
	@Override
	public User createUser(String id, String name) {
		return new User(id, name);
	}

	/**Implementation for the abstract factory. Creates a ResourceRole specific to the entitlement interface
	 * 
	 */
	@Override
	public ResourceRole createResourceRole(String id, String name, String description) {
		return new ResourceRole(id, name, description);
	}

	/**Implementation for the abstract factory. Creates a Role specific to the entitlement interface
	 * 
	 */
	@Override
	public Role createRole(String id, String name, String description) {
		return new Role(id, name, description);
	}

	/**Implementation for the abstract factory. Creates a Permission specific to the entitlement interface
	 * 
	 */
	@Override
	public Permission createPermission(String id, String name, String description) {
		return new Permission(id, name, description);
	}
}
