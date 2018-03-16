package main;

import java.net.MalformedURLException;
import java.net.URL;

public class Location {
	
	//API DARKSKY
	//freegeoip.net
	//jsonip.com
	
	private String ipAadress;
	
	private String apiAadress = "https://freegeoip.net/xml/";
	
	private XML xml;
	
	private String longitude;
	private String latitude;
	
	private String countryCode;
	
	private String country;
	private String regionName;
	
	private String city;
	
	

	public Location(String ipAadress) {
		super();
		this.ipAadress = ipAadress;
		
		try {
			
			xml = new XML(new URL(apiAadress + ipAadress));
			longitude = xml.getUnNestedTagContent("Longitude");
			latitude = xml.getUnNestedTagContent("Latitude");
			
			country = xml.getUnNestedTagContent("CountryName");
			countryCode = xml.getUnNestedTagContent("CountryCode");
			regionName = xml.getUnNestedTagContent("RegionName");
			
			city = xml.getUnNestedTagContent("City");
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public String getIpAadress() {
		return ipAadress;
	}
	
	public String getCountryCode() {
		return countryCode;
	}



	public void setIpAadress(String ipAadress) {
		this.ipAadress = ipAadress;
	}



	public String getLongitude() {
		return longitude;
	}



	public String getLatitude() {
		return latitude;
	}



	public String getCountry() {
		return country;
	}



	public String getRegionName() {
		return regionName;
	}



	public String getCity() {
		return city;
	}
	

	
	
	
	
	
	
	

}
