package cscie97.asn4.housemate.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnowledgeGraphImporter {
	/** Import file, reads the file into list of strings per line, setups up minor components of the 
	 * knowledge graph then calls the knowledge graph to setup queryMapSet passing it a list of triples
	 * 
	 * @param inputFileName 
	 * @throws InvalidInputException Input data is invalid
	 * @throws IOException File not found
	 */
	public void importFile(String inputFileName) throws InvalidInputException, IOException {
		
		Path path = Paths.get(inputFileName);
		KnowledgeGraph kGraph = KnowledgeGraph.getInstance();
		try {
			List<String> inputLines = Files.readAllLines(path);
			List<Triple> tripleList = new ArrayList<>();
			inputLines.removeAll(Arrays.asList("", null));
			for (String sentance : inputLines) {
				sentance = sentance.toLowerCase();
				String[] words = sentance.replace(".", "").split(" ");
				if (words[0] != null && words[1] != null && words[2] != null) {
					kGraph.nodeMap.put(words[0], new Node(words[0]));
					kGraph.predicateMap.put(words[1], new Predicate(words[1]));
					kGraph.nodeMap.put(words[2], new Node(words[2]));
					kGraph.tripleMap.put(sentance, new Triple(new Node(words[0]), new Predicate(words[1]), new Node(words[2])));
					tripleList.add(new Triple(sentance.replace(".", "")));
				} else {
					throw new InvalidInputException("Input data is invalid. Please check file and try again.");
				}
			}
			kGraph.importTriples(tripleList);
		} catch (IOException e) {
			// The user doesn't need to see a whole stack trace, so just a simple english answer should suffice
			System.out.println("Unable to locate/read file; please check input and try again.");
			// We will catch this exception in the main program and just peacefully exit.
			throw e;
		}
	}
	/**This will add an occupant if the occupant is new, otherwise it will update the occupant's information.
	 * It will load the occupant's information into the KnowledgeGraph singleton.
	 * 
	 * @param occupantInfo string with all information. Example: "john location house1:bedroom1"
	 */
	public void updateOccupant(String occupantInfo) {
		KnowledgeGraph kGraph = KnowledgeGraph.getInstance();
		List<Triple> tripleList = new ArrayList<>();
		String[] words = occupantInfo.split(" ");
		Triple occupantTriple = new Triple(new Node(words[0]), new Predicate(words[1]), new Node(words[2]));
		kGraph.importTriples(tripleList);
	}
	
}
