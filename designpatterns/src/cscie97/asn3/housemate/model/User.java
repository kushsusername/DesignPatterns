package cscie97.asn3.housemate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		this.token = null;
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
		if(token == null) {
			setToken(generateToken());
		}
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
	
	/**Just a generic random token generator. 
	 * When a token exists, the user is active
	 * Token is cleared when the user becomes inactive (log out or leave house)
	 * 
	 * ++Source of this random generator idea comes from DZONE 
	 * ++(but there are 100s of websites with similar implementations)
	 * 
	 * @return a random 12 character alpha_numeric string
	 */
	private String generateToken() {
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sBuilder = new StringBuilder();
		for(int i=0; i<12; i++) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			sBuilder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return sBuilder.toString();
	}
}
