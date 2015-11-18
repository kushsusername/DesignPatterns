package cscie97.asn3.housemate.model;

public interface Visitor {

	public void visit(User user);
	public void visit(ResourceRole resourceRole);
	public void visit(Role role);
	public void visit(Permission permission);
}
