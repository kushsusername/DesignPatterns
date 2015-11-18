package cscie97.asn3.housemate.model;

public class EntitlementFactory implements AbstractEntitlementFactory {

	@Override
	public User createUser(String id, String name) {
		return new User(id, name);
	}

	@Override
	public ResourceRole createResourceRole(String id, String name, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role createRole(String id, String name, String description) {
		return new Role(id, name, description);
	}

	@Override
	public Permission createPermission(String id, String name, String description) {
		return new Permission(id, name, description);
	}
}
