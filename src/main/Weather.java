package main;

import java.net.MalformedURLException;
import java.net.URL;

public class Weather {
	
	
	//Klass, mis tagastab ilmaelemente mingi "Location" objekti kohta
	/*
	 * TODO: mõelda välja mis väljasi me siis kasutada tahame.
	 * Näidislink XML: http://www.yr.no/place/Estonia/Harjumaa/Tallinn/forecast.xml
	 */
	
	private Location location; // vb pole seda siia vajagi kui konstruktoris kõik ära küsime.
	private XML xml;
	
	private double temp;     //temperatuur
	private double windSpeed; //Tuulekiirus
	private String weatherState; //ilmaolukord, pilvine/päikseline jne.
	
	
	public Weather(Location location) {
		
		this.location = location;
		try {
			
			xml = new XML(new URL("http://www.yr.no/place/" + location.getCountry() + "/"+ location.getRegionName() + "/"+ location.getCity() + "/forecast.xml"));
			
			weatherState = xml.getTagContentValue("symbol", "name");
			temp = Double.parseDouble(xml.getTagContentValue("temperature", "value"));
			windSpeed = Double.parseDouble(xml.getTagContentValue("windSpeed", "mps"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public String getLocation() {
		return location.toString();
	}


	public double getTemp() {
		return temp;
	}


	public double getWindSpeed() {
		return windSpeed;
	}


	public String getWeatherState() {
		return weatherState;
	}


	
	

}
