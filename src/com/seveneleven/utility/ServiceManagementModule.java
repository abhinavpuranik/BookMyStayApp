
/*
 * @author Developer
 * @version 5.0
 * Utility to manage services and service catalog
 */

package com.seveneleven.utility;
import java.util.*;
import com.seveneleven.model.Service;
public class ServiceManagementModule {

		private Map<String, List<Service>> reservationServices = new HashMap<>();
		private Map<String, Double> serviceCatalog = new HashMap<>();
		
		public ServiceManagementModule() {
			serviceCatalog.put("Breakfast", 500.0);
			serviceCatalog.put("Spa", 2000.0);
		    serviceCatalog.put("Airport Pickup", 1500.0);
		}
		
		public Service createService(String serviceName) {
			if(!serviceCatalog.containsKey(serviceName)) {
				return null;
			}
			
			double price = serviceCatalog.get(serviceName);
			
			return new Service(serviceName, price);
			
		}
		public void showAvailableServices() {

		    System.out.println("Available Services:");

		    for (String service : serviceCatalog.keySet()) {
		        System.out.println(service + " : " + serviceCatalog.get(service));
		    }
		}
		public void addService(String reservationId, Service service) {
			
			reservationServices
				.computeIfAbsent(reservationId, k -> new ArrayList<>())
				.add(service);
			
			System.out.println(service.getName() + " added to reservation " + reservationId);
			
		}
		
		public void showServices(String reservationId) {
			List<Service> services = reservationServices.get(reservationId);
			
			if(services == null || services.isEmpty()) {
				System.out.println("No services attached.");
				return;
			}
			
			System.out.println("Services for " + reservationId);
			
			for(Service s : services) {
				System.out.println(s);
				
			}
		}
		
		public double calculateServiceCost(String reservationId) {
			List<Service> services = reservationServices.get(reservationId);
			if(services == null) return 0;
			
			double total = 0;
			
			for(Service s : services) {
				total += s.getPrice();
			}
			
			return total;
		}
}
