package cscie97.asn4.housemate.model;

import java.util.ArrayList;
import java.util.List;

public class Role implements Entitlement {
	
	String id;
	String name;
	String description;
	
	List<Entitlement> entitlements = new ArrayList<>();
	
	public Role (String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	@Override
	public void visit(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void addEntitlement(Entitlement entitlement) {
		entitlements.add(entitlement);
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
	public List<Entitlement> getEntitlements() {
		return entitlements;
	}
	public void setEntitlements(List<Entitlement> entitlements) {
		this.entitlements = entitlements;
	}

	@Override
	public String toString() {
		String entitlementsString = "";
		for (Entitlement ent : entitlements) {
			entitlementsString.concat(ent.toString()).concat(", ");
		}
		// just to get rid of the last comma & space
		entitlementsString.substring(0, entitlementsString.length()-2);
		//if a role has a subrole, then that will show up as a nested entitlement and that role will list all of its entitlements
		return "Role <" + this.id + "> has entitlements <" + entitlementsString + ">";
	}

}
