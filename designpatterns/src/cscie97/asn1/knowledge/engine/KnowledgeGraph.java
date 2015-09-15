package cscie97.asn1.knowledge.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class KnowledgeGraph {

	HashMap<String, Node> nodeMap;
	HashMap<String, Predicate> predicateMap;
	HashMap<String, Triple> tripleMap;
	HashMap<String, Set<Triple>> queryMapSet;
	
	
	public static KnowledgeGraph knowledgeGraph = new KnowledgeGraph();
	
	public static KnowledgeGraph getInstance() {
		knowledgeGraph.nodeMap = new HashMap<String, Node>();
		knowledgeGraph.predicateMap = new HashMap<String, Predicate>();
		knowledgeGraph.tripleMap = new HashMap<String, Triple>();
		knowledgeGraph.queryMapSet = new HashMap<String, Set<Triple>>();
		return knowledgeGraph;
	}

	public void importTriples(ArrayList<Triple> triplesList) {
		
	}
	public void executeQuery(Set<Triple> tripleDataSet) {
		
	}
	
}
