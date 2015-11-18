package cscie97.asn3.housemate.model;

import java.util.ArrayList;
import java.util.List;

public class User implements Entitlement{

	String id;
	String name;
	private String token;
	private String voicePrint;
	
	List<ResourceRole> resourceRoles = new ArrayList<>();
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public List<ResourceRole> getResourceRoles() {
		return resourceRoles;
	}
	public void setResourceRoles(List<ResourceRole> roles) {
		this.resourceRoles = roles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getVoicePrint() {
		return voicePrint;
	}
	public void setVoicePrint(String voicePrint) {
		this.voicePrint = voicePrint;
	}

	@Override
	public String toString() {
		return "User <" + this.name + "> ";
	}
}
