package cscie97.asn1.knowledge.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class KnowledgeGraph {

	HashMap<String, Node> nodeMap = new HashMap<String, Node>();
	HashMap<String, Predicate> predicate = new HashMap<String, Predicate>();
	HashMap<String, Triple> tripleMap = new HashMap<String, Triple>();
	HashMap<String, Set<Triple>> queryMapSet = new HashMap<String, Set<Triple
			>>();
	
	
	public static KnowledgeGraph knowledgeGraph = new KnowledgeGraph();
	
	public KnowledgeGraph getInstance() {
		return knowledgeGraph;
	}

	public void importTriples(ArrayList<Triple> triplesList) {
		
	}
	public void executeQuery(Set<Triple> tripleDataSet) {
		
	}
	
}
