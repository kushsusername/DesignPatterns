package cscie97.asn1.knowledge.engine;

public class Triple {

	Node subject;
	Predicate predicate;
	Node object;
	String identifier;

	public Triple(Node subject, Predicate predicate, Node object) {
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
		this.identifier = subject.getIdentifier() + " " + predicate.getIdentifier() + " " + object.getIdentifier() + ".";
	}
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	
	
}
