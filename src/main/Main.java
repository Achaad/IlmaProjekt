package main;



public class Main {
	
	public static void main(String[] args) {
		
		
		String s = Util.getIpAddress();
		Location myLocation = new Location(s);
		
		System.out.println(myLocation.getCity());

		
		
		

		
	}
	

}
