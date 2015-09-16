package cscie97.asn1.knowledge.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class QueryEngine {

	public QueryEngine() {
		
	}
	
	public void executeQueryFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		List<String> queries = Files.readAllLines(path);
		for (String query : queries) {
			executeQuery(query.replace(".", "").toLowerCase());
		}
	}
	
	public void executeQuery(String query) {
		
		Triple queryTriple = new Triple(query);
		
		KnowledgeGraph kGraph = KnowledgeGraph.getInstance();
		Set<Triple> resultSet = kGraph.executeQuery(queryTriple);
		for (Triple triple : resultSet) {
			System.out.println(triple.getIdentifier());
		}
	}
}
