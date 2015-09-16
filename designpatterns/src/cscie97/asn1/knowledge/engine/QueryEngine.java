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
	/** Single method that executes the executeQuery Method passing all the lines from the file it reads
	 * 
	 * @param fileName name of the query file
	 * @throws IOException throws error if it fails to read the file
	 */
	public void executeQueryFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		List<String> queries = Files.readAllLines(path);
		for (String query : queries) {
			executeQuery(query.replace(".", "").toLowerCase());
		}
	}
	
	/** Calls the knowledge graph with the query, find the result set and return it
	 * this prints out the query (even if there is no result) then the results, and a new line to keep it clean
	 * 
	 * @param query
	 */
	public void executeQuery(String query) {
		
		Triple queryTriple = new Triple(query);
		KnowledgeGraph kGraph = KnowledgeGraph.getInstance();
		Set<Triple> resultSet = kGraph.executeQuery(queryTriple);
		System.out.println(query);
		for (Triple triple : resultSet) {
			System.out.println(triple.getIdentifier());
		}
		System.out.println();
	}
}
