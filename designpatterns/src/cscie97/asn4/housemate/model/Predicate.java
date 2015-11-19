package cscie97.asn4.housemate.model;

public class Predicate {

	String identifier;
	
	/** Interprets the predicate portion of the triple
	 * 
	 * @param identifier the string that identifies the predicate
	 */
	public Predicate(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setPredicate(String identifier) {
		this.identifier = identifier;
	}
}