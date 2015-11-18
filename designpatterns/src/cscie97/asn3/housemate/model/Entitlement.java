package cscie97.asn3.housemate.model;

public interface Entitlement {

	public String getId();
	public String getName();
	public String getDescription();
	public String toString();
	public void visit(Visitor visitor);
}
