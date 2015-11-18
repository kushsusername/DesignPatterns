package cscie97.asn3.housemate.model;

public class EntitlementVisitor implements Visitor {

	private String accessToken = null;
	
	@Override
	public void visit(User user) {
		
	}

	@Override
	public void visit(ResourceRole resourceRole) {

	}

	@Override
	public void visit(Role role) {

	}

	@Override
	public void visit(Permission permission) {

	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
