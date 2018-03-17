package main;


public class Main {

    public static void main(String[] args) {


        String s = Util.getIpAddress();
        main.Location myLocation = new main.Location(s);

        Weather weather = new Weather(myLocation);


        // Tervitus ja info asukohast
        System.out.println("Tere!");
        System.out.println("Teie asukoht on " + myLocation.getCity() + ", "
                + myLocation.getRegionName() + ", "  + myLocation.getCountry() + ".\n");
        System.out.println("Ilm hetkel:");

        // Prindib välja ilma näitajad
        System.out.println(weather.getWeatherState());
        System.out.println("Temperatuur:  " + weather.getTemp() + "\u00b0C");
        System.out.println("Tuulesuund: " + weather.getWindDirection());
        System.out.println("Tuulekiirus: " + weather.getWindSpeed() + " m/s");
        System.out.println("Sademed: " + weather.getPrecipitation() + " mm");
        //System.out.println(weather.getLocation()); Minu arust tagastab liiga palju infot tava kasutajale

        // Printib välja, et me kasutame www.yr.no. Nii on nõutud nende XML's.
        // Midagi ei juhtu, kui me seda teeme, kuid parem mainida.
        System.out.println("\n\nWeather forecast from Yr, delivered by the Norwegian Meteorological Institute and the NRK.");
    }


}
