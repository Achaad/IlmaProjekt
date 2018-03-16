package main;

import java.net.MalformedURLException;
import java.net.URL;

public class Weather {
	
	
	//Klass, mis tagastab ilmaelemente mingi "Location" objekti kohta
	
	//XML peab siin klassis kasutama http://www.yr.no/place/" + riik + "/"+ maakond+"/"+ linn + "/forecast.xml
	
	private Location location; // vb pole seda siia vajagi
	private XML xml;
	
	private double temp;     //temperatuur
	private String weatherState; //ilmaolukord, pilvine/päikseline jne.
	
	
	
	
	private String apiKey = "2dcab11123ce0b560d14d50c479121c8";
	
	
	public Weather(Location location) {
		
		this.location = location;
		try {
			xml = new XML(new URL("http://www.yr.no/place/" + location.getCountry() + "/"+ location.getRegionName() + "/"+ location.getCity() + "/forecast.xml"));
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
