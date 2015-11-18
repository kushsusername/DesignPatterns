package cscie97.asn3.housemate.model;

public interface AbstractEntitlementFactory {

	public User createUser(String id, String name);
	public ResourceRole createResourceRole(String id, String name, String description);
	public Role createRole(String id, String name, String description);
	public Permission createPermission(String id, String name, String description);
}
