package cscie97.asn1.knowledge.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.IIOException;

public class Importer {

	public void importTripleFile(String inputFileName) throws IOException {
		
		Path path = Paths.get(inputFileName);
		try {
			List<String> inputLines = Files.readAllLines(path);
		} catch (IOException e) {
			// The user doesn't need to see a whole stack trace, so just a simple english answer should suffice
			System.out.println("Unable to locate/read file; please check input and try again.");
			// We will catch this exception in the main program and just peacefully exit.
			throw e;
		}
	}
}
