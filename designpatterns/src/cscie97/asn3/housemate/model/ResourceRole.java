package cscie97.asn3.housemate.model;

public class ResourceRole implements Entitlement {

	String id;
	String name;
	String description;
	Role role;
	Resource resource;
	
	public ResourceRole (String id, Role role, Resource resource) {
		this.id = id;
		this.role = role;
		this.resource = resource;
	}
	
	@Override
	public void visit(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public String toString() {
		return this.id;
	}

}
