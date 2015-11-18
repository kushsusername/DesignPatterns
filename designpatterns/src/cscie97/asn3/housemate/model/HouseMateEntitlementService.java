package cscie97.asn3.housemate.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseMateEntitlementService {

	public static HouseMateEntitlementService houseMateEntitlementService;
	
	public static HouseMateEntitlementService getInstance() {
		if(houseMateEntitlementService == null) {
			houseMateEntitlementService = new HouseMateEntitlementService();
		}
		return houseMateEntitlementService;
	}
	
//	Map<String, User> users = new HashMap<>();
	
	List<String> users = new ArrayList<>();
	List<Entitlement> entitlements = new ArrayList<>();
	
	public Visitor acceptVisitor(Visitor visitor) {
		
		return visitor;
	}
	
	public String getAccessToken(User user) {
		EntitlementVisitor eVisitor = new EntitlementVisitor();
		
		eVisitor.visit(user);
		
		return eVisitor.getAccessToken();
	}
}
