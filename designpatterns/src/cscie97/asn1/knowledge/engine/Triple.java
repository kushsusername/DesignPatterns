package cscie97.asn1.knowledge.engine;

public class Triple {

	String identifier;
	Node subject;
	Predicate predicate;
	Node object;
	
	public Triple() {
		
	}
	public Triple(Node subject, Predicate predicate, Node object) {
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	
	
}
