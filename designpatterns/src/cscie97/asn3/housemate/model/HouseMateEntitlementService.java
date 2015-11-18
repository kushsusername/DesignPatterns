package cscie97.asn3.housemate.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HouseMateEntitlementService {

	public static HouseMateEntitlementService houseMateEntitlementService;
	
	Map<String, User> users = new HashMap<>();
	
	public static HouseMateEntitlementService getInstance() {
		if(houseMateEntitlementService == null) {
			houseMateEntitlementService = new HouseMateEntitlementService();
		}
		return houseMateEntitlementService;
	}
}
