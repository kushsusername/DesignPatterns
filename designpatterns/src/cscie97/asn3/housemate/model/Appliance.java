package cscie97.asn3.housemate.model;

import java.util.HashMap;
import java.util.Map;

public class Appliance extends IOT {
	
	private Map<String, String> status;

	public Appliance() {
		super();
	}
	
	public Appliance(String name, String type, String houseName, String roomName) {
		super(name, type, houseName, roomName);
		this.status = new HashMap<String, String>();
	}
	
	public Map<String, String> getStatus() {
		return status;
	}

	public void setStatus(Map<String, String> status) {
		this.status = status;
	}
	
	public String toString() {
		
		return " appliance: " + this.getName() 
				+ " type: " + this.getType() 
				+ this.getStatus().toString();
	}
	public String toStringStatus(String applianceStatus) {
		return " appliance: " + this.getName() 
				+ " type: " + this.getType() 
				+ " status: " + applianceStatus
				+ " value: " + (this.getStatus().get(applianceStatus) == null ? "unknown" : this.getStatus().get(applianceStatus));
	}
}
