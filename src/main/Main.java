package main;



public class Main {
	
	public static void main(String[] args) {
		
		
		String s = Util.getIpAddress();
		Location myLocation = new Location(s);
		
		Weather weather = new Weather(myLocation);
		System.out.println(weather.getTemp());
		System.out.println(weather.getWeatherState());
		System.out.println(weather.getWindSpeed());
		System.out.println(weather.getLocation());
		
	}
	

}
