package cscie97.asn1.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import cscie97.asn1.knowledge.engine.Importer;
import cscie97.asn1.knowledge.engine.InvalidInputException;
import cscie97.asn1.knowledge.engine.KnowledgeGraph;
import cscie97.asn1.knowledge.engine.QueryEngine;

public class TestDriver {
	
	/**
	 * Application to generate a knowledge graph and return possible answers to a query.
	 * <p>
	 * @author Kush
	 * @param args arg[0] = input data file | arg[1] = query file
	 */
	public static void main(String[] args) {

		/*
		 * In the event that the user did not enter either one of the file names, 
		 * no need to continue running the program.
		 */

		Importer importer = new Importer();
		QueryEngine qEngine = new QueryEngine();
		KnowledgeGraph kGraph = KnowledgeGraph.getInstance();
		
		if(args[0] == null || args[1] == null) {
			System.out.println("Please run application with two inputs: 1)input data file 2)query file");
			return;
		}
		
		String inputFile = args[0];
		String queryFile = args[1];
		
		try {
			importer.importFile(inputFile);
		} catch (IOException e) {
			// Importer returns an error which we print to the console and then end the program
			// So here we just exit out.
			System.out.println(e.getMessage());
			return;
		} catch (InvalidInputException ie) {
			System.out.println(ie.getMessage());
			return;
		}
		
		try {
			qEngine.executeQueryFile(queryFile);
		} catch (IOException e) {
			System.out.println("File not found, please check query file and try again.");
		}
		
	}
}
