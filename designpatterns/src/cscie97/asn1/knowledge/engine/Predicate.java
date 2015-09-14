package cscie97.asn1.knowledge.engine;

public class Predicate {

	String identifier;
	
	public Predicate(String identifier) {
		this.identifier = identifier;
	}

	public String getPredicate() {
		return identifier;
	}

	public void setPredicate(String identifier) {
		this.identifier = identifier;
	}
}
