package cscie97.asn2.housemate.test;

import cscie97.asn2.housemate.model.HouseMateModelServiceController;

public class TestDriver {

	public static void main(String[] args) {
		HouseMateModelServiceController hmmsController = new HouseMateModelServiceController();
		try {
			hmmsController.runCommands(args[0]);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please input filename.");
		}
		
	}
}
