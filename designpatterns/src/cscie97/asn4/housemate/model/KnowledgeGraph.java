package cscie97.asn4.housemate.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KnowledgeGraph {

	Map<String, Node> nodeMap = new HashMap<String, Node>();
	Map<String, Predicate> predicateMap = new HashMap<String, Predicate>();
	Map<String, Triple> tripleMap = new HashMap<String, Triple>();
	Map<String, Set<Triple>> queryMapSet = new HashMap<String, Set<Triple>>();
	
	
	public static KnowledgeGraph knowledgeGraph;
	
	/** gets the instance of the KnowledgeGraph, if it doesn't exist, creates a new one
	 * 
	 * @return the KnowledgeGraph Singleton
	 */
	public static KnowledgeGraph getInstance() {
		if(knowledgeGraph == null) {
			knowledgeGraph = new KnowledgeGraph();
		}
		return knowledgeGraph;
	}

	/** Takes a list of triples and builds the querySetMap with all possible queires and adds the triple to each query
	 *  it checks to see if the query its adding exists, if it does, then it will simply add the triple to the set 
	 *  if it doesn't exist, it will add the query and a new set; then the triple will be added to the set after
	 * 
	 * @param tripleList a list of the triple (subject, predicate, object)
	 */
	public void importTriples(List<Triple> tripleList) {
		for (Triple triple : tripleList) {
			// if the mapset doest not have the query, then create new set<triple>
			if(!queryMapSet.containsKey(triple.getIdentifier())){
				queryMapSet.put(triple.getIdentifier(), new HashSet<Triple>());
			}
			// add the triple to the set<triple> 
			queryMapSet.get(triple.getIdentifier()).add(triple);
			
			// Subject predicate ?
			if(!queryMapSet.containsKey(triple.subject.getIdentifier() + " " + triple.predicate.getIdentifier() + " ?")){
				queryMapSet.put(triple.subject.getIdentifier() + " " + triple.predicate.getIdentifier() + " ?", new HashSet<Triple>());
			}
			queryMapSet.get(triple.subject.getIdentifier() + " " + triple.predicate.getIdentifier() + " ?").add(triple);
			
			// subject ? predicate
			if(!queryMapSet.containsKey(triple.subject.getIdentifier() + " ? " + triple.object.getIdentifier())){
				queryMapSet.put(triple.subject.getIdentifier() + " ? " + triple.object.getIdentifier(), new HashSet<Triple>());
			}
			queryMapSet.get(triple.subject.getIdentifier() + " ? " + triple.object.getIdentifier()).add(triple);
			
			// subject ? ?
			if(!queryMapSet.containsKey(triple.subject.getIdentifier() + " ? ?")){
				queryMapSet.put(triple.subject.getIdentifier() + " ? ?", new HashSet<Triple>());
			}
			queryMapSet.get(triple.subject.getIdentifier() + " ? ?").add(triple);
			
			// ? predicate object
			if(!queryMapSet.containsKey("? " + triple.predicate.getIdentifier() + " " + triple.object.getIdentifier())){
				queryMapSet.put("? " + triple.predicate.getIdentifier() + " " + triple.object.getIdentifier(), new HashSet<Triple>());
			}
			queryMapSet.get("? " + triple.predicate.getIdentifier() + " " + triple.object.getIdentifier()).add(triple);
			
			// ? predicate ?
			if(!queryMapSet.containsKey("? " + triple.predicate.getIdentifier() + " ?")){
				queryMapSet.put("? " + triple.predicate.getIdentifier() + " ?", new HashSet<Triple>());
			}
			queryMapSet.get("? " + triple.predicate.getIdentifier() + " ?").add(triple);
			
			// ? ? object
			if(!queryMapSet.containsKey("? ? " + triple.object.getIdentifier())){
				queryMapSet.put("? ? " + triple.object.getIdentifier(), new HashSet<Triple>());
			}
			queryMapSet.get("? ? " + triple.object.getIdentifier()).add(triple);
			
			// ? ? ?
			if(!queryMapSet.containsKey("? ? ?")){
				queryMapSet.put("? ? ?", new HashSet<Triple>());
			}
			queryMapSet.get("? ? ?").add(triple);
		}
	}
	/** Small method that gets the query, and returns the set of triples that qualify the query
	 * 
	 * @param query the string currently looking for possible triples
	 * @return the list of triples associated to that query
	 */
	public Set<Triple> executeQuery(Triple query) {
		Set<Triple> resultSet = queryMapSet.get(query.getIdentifier());
		if(resultSet == null){
			resultSet = new HashSet<>();
		}
		return resultSet;
	}

	public Map<String, Node> getNodeMap() {
		return nodeMap;
	}

	public void setNodeMap(Map<String, Node> nodeMap) {
		this.nodeMap = nodeMap;
	}

	public Map<String, Predicate> getPredicateMap() {
		return predicateMap;
	}

	public void setPredicateMap(Map<String, Predicate> predicateMap) {
		this.predicateMap = predicateMap;
	}

	public Map<String, Triple> getTripleMap() {
		return tripleMap;
	}

	public void setTripleMap(Map<String, Triple> tripleMap) {
		this.tripleMap = tripleMap;
	}

	public Map<String, Set<Triple>> getQueryMapSet() {
		return queryMapSet;
	}

	public void setQueryMapSet(Map<String, Set<Triple>> queryMapSet) {
		this.queryMapSet = queryMapSet;
	}
	
}