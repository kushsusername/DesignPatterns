package cscie97.asn1.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import cscie97.asn1.knowledge.engine.Importer;

public class TestDriver {
	
	Importer importer = new Importer();
	
	/**
	 * Application to generate a knowledge graph and return possible answers to a query.
	 * <p>
	 * @author Kush
	 * @param args arg[0] = input data file | arg[1] = query file
	 */
	public void main(String[] args) {

		/*
		 * In the event that the user did not enter either one of the file names, 
		 * no need to continue running the program.
		 */
		if(args[0] == null || args[1] == null) {
			System.out.println("Please run application with two inputs: 1)input data file 2)query file");
			return;
		}
		
		String inputFile = args[0];
		String queryFile = args[1];
		
		try {
			importer.importTripleFile(inputFile);
		}catch (IOException e) {
			// Importer returns an error to the console. 
			// So here we just exit out.
			return;
		}
		
		//TODO: Add something here.
		//TODO: Adding crap to setup this damn branch
		
		// String = "mary works_at starbucks"
		
		HashMap<String, ArrayList<String>> knowledgeGraph = new HashMap<>();
		
	}
}
