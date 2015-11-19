package cscie97.asn4.housemate.model;

public interface Visitor {

	/** the virtual method that the visitor uses to interact with User Entities 
	 * 
	 * @param user
	 */
	public void visit(User user);
	/**the virtual method that the visitor uses to interact with ResourceRole Entities 
	 * 
	 * @param resourceRole
	 */
	public void visit(ResourceRole resourceRole);
	/**the virtual method that the visitor uses to interact with Role Entities 
	 * 
	 * @param role
	 */
	public void visit(Role role);
	/**the virtual method that the visitor uses to interact with Permission Entities 
	 * 
	 * @param permission
	 */
	public void visit(Permission permission);
}
