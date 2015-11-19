package cscie97.asn4.housemate.model;

public interface Entitlement {

	/**gets the id of the object
	 * 
	 * @return string ID of object
	 */
	public String getId();
	/**gets the name of the object
	 * 
	 * @return string name of object
	 */
	public String getName();
	/**gets the description of the object
	 * 
	 * @return string description of object
	 */
	public String getDescription();
	/**each implementation of this interface should overwrite toString with a custom specific output
	 * 
	 * @return whatever the implementation chooses as a good representation of the object
	 */
	public String toString();
	/** Allows the class to accept a visitor and call upon the custom methods for the visitor within the class itself.
	 * 
	 * 
	 * @param visitor the visitor object looking to validate permissions and obtain access tokens
	 */
	public void visit(Visitor visitor);
}
