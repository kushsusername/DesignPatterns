package cscie97.asn3.housemate.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HouseMateCommandImporter {

	public void runCommands(String fileName) {
		
		HouseMateModelService  hmms = HouseMateModelService.getInstance();
		HouseMateControllerService hmcs = new HouseMateControllerService();
		Path path = Paths.get(fileName);
		Location location = null;
		Pattern p = Pattern.compile("\\'([^\\\"]*)\\'");
		Matcher m = null;
		try {
			List<String> commandLines = Files.readAllLines(path);
			commandLines.removeAll(Arrays.asList("", null));
			for (String command : commandLines) {
				command = command.toLowerCase();
				String[] inputs = command.split(" ");
				for (int i=0; i < inputs.length ; i++){
					try{
						switch(inputs[i]){
							case "#":
								i = inputs.length;
								break;
							case "define":
								i++;
								switch(inputs[i]){
									case "house":
										hmms.addHouse(inputs[i+1]);
										i = inputs.length;
										break;
									case "room":
										hmms.addRoom(inputs[i+1], Integer.valueOf(inputs[i+3]), inputs[i+5], inputs[i+7]);
										i = inputs.length;
										break;
									case "occupant":
										hmms.addOccupant(inputs[i+1], inputs[i+3], inputs[i+5]);
										i = inputs.length;
										break;
									case "sensor":
										String[] sensorLocation = inputs[i+5].split(":");
										hmms.addSensor(inputs[i+1], inputs[i+3], sensorLocation[0], sensorLocation[1]);
										i = inputs.length;
										break;
									case "appliance":
										String[] applianceLocation = inputs[i+5].split(":");
										hmms.addAppliance(inputs[i+1], inputs[i+3], applianceLocation[0], applianceLocation[1]);
										i = inputs.length;
										break;
									default:
										i = inputs.length;
										break;
								}
								break;
							case "set":
								i++;
								switch(inputs[i]) {
									case "occupant":
										String[] occupantLocation = inputs[i+3].split(":");
										hmms.setOccupantLocation(inputs[i+1], occupantLocation[0], occupantLocation[1]);
										i = inputs.length;
										break;
									case "sensor":
										String[] sensorInput = inputs[i+1].split(":");
										location = new Location(sensorInput[0], sensorInput[1]);
										if(command.contains("occupant")) {
											hmcs.runSensorRule(inputs[i+5], inputs[i+3], location);
										} else {
											hmms.setSensor(sensorInput[2], sensorInput[0], inputs[i+3]);
										}
										i = inputs.length;
										break;
									case "appliance":
										String[] applicationInput = inputs[i+1].split(":");
										location = new Location(applicationInput[0], applicationInput[1]);
										m = p.matcher(command);
										if(m.find()) {
											hmcs.runApplianceRule(m.group(1), location);
										} else {
											hmms.setAppliance(applicationInput[2], applicationInput[0], applicationInput[1], inputs[i+3], inputs[i+5]);
										}
										i = inputs.length;
										break;
									default:
										i = inputs.length;
										break;
								}
								break;
							case "show":
								i++;
								if (inputs.length == 2){
									hmms.show();
								} else {
									switch(inputs[i]) {
										case "appliance":
											String[] applianceInput = inputs[i+1].split(":");
											if(inputs.length == 5) {
												hmms.showApplianceStatus(applianceInput[2], applianceInput[0], inputs[i+3]);
											} else {
												hmms.showAppliance(applianceInput[2], applianceInput[0]);
											}
											i = inputs.length;
											break;
										case "sensor":
											String[] sensorInput = inputs[i+1].split(":");
											hmms.showSensor(sensorInput[0], sensorInput[2]);
											i = inputs.length;
											break;
										case "configuration":
											if(inputs[i+1].equalsIgnoreCase("house")) {
												hmms.showHouse(inputs[i+2]);
											}
											if(inputs[i+1].equalsIgnoreCase("room")) {
												String[] roomInput = inputs[i+2].split(":");
												hmms.showRoom(roomInput[0], roomInput[1]);
											}
											i = inputs.length;
											break;
										default:
											i = inputs.length;
											break;
									}
								}
								break;
							default:
								break;
						}
					} catch (IndexOutOfBoundsException e) {
						System.out.println("One or more commands do not fulfill requirement; please check commands and try again.");
					} catch (HouseNotFoundException e) {
						System.out.println(e.getMessage());
					} catch (RoomNotFoundException e) {
						System.out.println(e.getMessage());
					} catch (SensorNotFoundException e) {
						System.out.println(e.getMessage());
					} catch (ApplianceNotFoundException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Failed to parse file; please check file and try again.");
		}
	}
}
