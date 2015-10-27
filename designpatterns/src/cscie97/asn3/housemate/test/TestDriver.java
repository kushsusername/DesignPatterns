package cscie97.asn3.housemate.test;

import cscie97.asn3.housemate.model.HouseMateCommandImporter;

public class TestDriver {

	public static void main(String[] args) {
		HouseMateCommandImporter hmmsController = new HouseMateCommandImporter();
		try {
			hmmsController.runCommands(args[0]);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please input filename.");
		}
		
	}
}
