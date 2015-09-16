package cscie97.asn1.knowledge.engine;

public class Triple {

	Node subject;
	Predicate predicate;
	Node object;
	String identifier;

	/** The triple class essentially represents a basic sentance with components subject, predicate, object
	 * 
	 * @param subject
	 * @param predicate
	 * @param object
	 */
	public Triple(Node subject, Predicate predicate, Node object) {
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
		this.identifier = subject.getIdentifier() + " " + predicate.getIdentifier() + " " + object.getIdentifier() + ".";
	}
	
	public Triple(String identifier) {
		String[] words = identifier.replace(".", "").split(" ");
		this.subject = new Node(words[0]);
		this.predicate = new Predicate(words[1]);
		this.object = new Node(words[2]);
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
}
