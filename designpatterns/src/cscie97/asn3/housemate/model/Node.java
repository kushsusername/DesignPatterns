package cscie97.asn3.housemate.model;

public class Node {

	String identifier;
	
	/** represents the subjects and objects part of a sentence 
	 * 
	 * @param identifier unique string identity of the node
	 */
	public Node(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}