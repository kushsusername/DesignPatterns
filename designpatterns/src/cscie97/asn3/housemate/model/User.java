package cscie97.asn3.housemate.model;

import java.util.ArrayList;
import java.util.List;

public class User implements Entitlement{

	String id;
	String name;
	String description;
	private String token;
	private String voicePrintOrPassword;
	
	List<ResourceRole> resourceRoles = new ArrayList<>();
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
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

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getVoicePrintOrPassword() {
		return voicePrintOrPassword;
	}
	public void setVoicePrintOrPassword(String voicePrintOrPassword) {
		this.voicePrintOrPassword = voicePrintOrPassword;
	}

	public List<ResourceRole> getResourceRoles() {
		return resourceRoles;
	}
	public void setResourceRoles(List<ResourceRole> resourceRoles) {
		this.resourceRoles = resourceRoles;
	}
	
	@Override
	public String toString() {
		return this.id;
	}
}
