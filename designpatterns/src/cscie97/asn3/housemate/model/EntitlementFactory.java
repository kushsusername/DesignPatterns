package cscie97.asn3.housemate.model;

public class EntitlementFactory extends AbstractEntitlementFactory {

	@Override
	User createUser(String id, String name) {
		return new User(id, name);
	}

	@Override
	ResourceRole createResourceRole(String id, String name, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Role createRole(String id, String name, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Permission createPermission(String id, String name, String description) {
		// TODO Auto-generated method stub
		return null;
	}
}
