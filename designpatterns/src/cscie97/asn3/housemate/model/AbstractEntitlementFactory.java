package cscie97.asn3.housemate.model;

public abstract class AbstractEntitlementFactory {

	abstract User createUser(String id, String name);
	abstract ResourceRole createResourceRole(String id, String name, String description);
	abstract Role createRole(String id, String name, String description);
	abstract Permission createPermission(String id, String name, String description);
}
