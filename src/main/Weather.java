package main;

import java.net.MalformedURLException;
import java.net.URL;

public class Weather {


    //Klass, mis tagastab ilmaelemente mingi "Location" objekti kohta
    /*
     * TODO: m�elda v�lja mis v�ljasi me siis kasutada tahame.
     * N�idislink XML: http://www.yr.no/place/Estonia/Harjumaa/Tallinn/forecast.xml
     */

    private Location location; // vb pole seda siia vajagi kui konstruktoris k�ik �ra k�sime.
    private XML xml;

    private double temp;     //temperatuur
    private double windSpeed; //Tuulekiirus
    private String weatherState; //ilmaolukord, pilvine/p�ikseline jne.
    private String windDirection; // tuulesuund
    private Double precipitation; // sademed


    public Weather(Location location) {

        this.location = location;
        try {

            xml = new XML(new URL("http://www.yr.no/place/" + location.getCountry() + "/"+ location.getRegionName() + "/"+ location.getCity() + "/forecast.xml"));

            weatherState = xml.getTagContentValue("symbol", "name");
            temp = Double.parseDouble(xml.getTagContentValue("temperature", "value"));
            windSpeed = Double.parseDouble(xml.getTagContentValue("windSpeed", "mps"));
            windDirection = xml.getTagContentValue("windDirection", "code");
            precipitation = Double.parseDouble(xml.getTagContentValue("precipitation", "value"));

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

    public String getWindDirection() {
        return windDirection;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void printWeatherNow() {
        System.out.println("Ilm hetkel:");

        // Prindib välja ilma näitajad
        System.out.println(getWeatherState());
        System.out.println("Temperatuur:  " + getTemp() + "\u00b0C");
        System.out.println("Tuulesuund: " + getWindDirection());
        System.out.println("Tuulekiirus: " + getWindSpeed() + " m/s");
        System.out.println("Sademed: " + getPrecipitation() + " mm");
        //System.out.println(weather.getLocation()); Minu arust tagastab liiga palju infot tava kasutajale
    }

    public void printWeatherHourly() {
        /*NodeList nList = document.getElementsByTagName(tagName);

        Node nNode = nList.item(0);
        Element e = (Element)nNode;

        return e.getAttribute(attributeName);
        */
    }
}
