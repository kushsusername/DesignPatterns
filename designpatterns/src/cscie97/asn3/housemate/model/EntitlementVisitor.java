package cscie97.asn3.housemate.model;

public class EntitlementVisitor implements Visitor {

	private String accessToken;
	private boolean verified;
	private String resourceId;
	private String permissionId;
	
	public EntitlementVisitor(String resourceId, String permissionId){
		this.resourceId = resourceId;
		this.permissionId = permissionId;
		accessToken = null;
		verified = false;
	}
	
	@Override
	public void visit(User user) {
		for (ResourceRole rRole : user.getResourceRoles()) {
			if(rRole.getResource().getId().equals(resourceId)) {
				visit(rRole);
			}
		}
		if(verified) {
			setAccessToken(user.getToken());
		}
	}

	@Override
	public void visit(ResourceRole resourceRole) {
		visit(resourceRole.getRole());
	}

	@Override
	public void visit(Role role) {
		for (Entitlement entitlement : role.getEntitlements()) {
			if(entitlement.getClass().equals(Permission.class)){
				visit((Permission) entitlement);
			}
		}
	}

	@Override
	public void visit(Permission permission) {
		if(permission.getId().equals(permissionId)) {
			setVerified(true);
		}
	}

	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

}
