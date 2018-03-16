package main;



public class Main {
	
	public static void main(String[] args) {
		
		
		String s = Util.getIpAddress();
		Location myLocation = new Location(s);
		
		System.out.println(myLocation.getCity());
		System.out.println(myLocation.getCountryCode());
		System.out.println(myLocation.getCountry());
		System.out.println(myLocation.getLatitude());
		System.out.println(myLocation.getLongitude());
		
		
		

		
	}
	

}
