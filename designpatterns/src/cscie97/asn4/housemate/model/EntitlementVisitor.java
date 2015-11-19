package cscie97.asn4.housemate.model;

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
	
	/**the method that the visitor uses to interact with User Entities 
	 * and used to set accessTokens at the end of the visitation
	 * 
	 */
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

	/**the method that the visitor uses to interact with ResourceRole
	 * Used to validate that the resource matches
	 */
	@Override
	public void visit(ResourceRole resourceRole) {
		if(resourceRole.getId().equals(resourceId)) {
			visit(resourceRole.getRole());
		}
	}

	/**the method that the visitor uses to interact with a Role
	 * This will loop each role and call visit for each role and then visit the permission foreach role
	 */
	@Override
	public void visit(Role role) {
		for (Entitlement entitlement : role.getEntitlements()) {
			if(entitlement.getClass().equals(Permission.class)){
				visit((Permission) entitlement);
			}
		}
	}

	/**the method that the visitor uses to interact with Permission
	 * Sets the "status" to true if the permission is found for this given command
	 * 
	 */
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
