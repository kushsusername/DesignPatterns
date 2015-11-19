package cscie97.asn4.housemate.model;

public class Permission implements Entitlement {

	String id;
	String name;
	String description;
	
	public Permission(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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
	
	@Override
	public String toString() {
		return "Permission <" + this.id + ">";
	}
	
}
