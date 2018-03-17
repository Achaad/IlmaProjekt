package main;


import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {


        String s = Util.getIpAddress();
        main.Location myLocation = new main.Location(s);

        Weather weather = new Weather(myLocation);


        // Tervitus ja info asukohast
        System.out.println("Tere!");
        System.out.println("Teie asukoht on " + myLocation.getCity() + ", "
                + myLocation.getRegionName() + ", "  + myLocation.getCountry() + ".\n");

        // Küsime, kas kasutaja soovib hetke ilma või ilmaprognoosi
        UserQuery küsitleja = new UserQuery();
        int misIlm = küsitleja.askWhichForecast(); // "0" = ilm hetkel, "1" = päeva prognoos, "2" = nödala prognoos
        switch (misIlm) {
            case 0 : {
                System.out.println();
                weather.printWeatherNow();
                break;
            }

            case 1 : {
                weather.printWeatherHourly();
                break;
            }

            case 2: {
                weather.printWeatherForWeek();
                break;
            }
            default : weather.printWeatherNow();
        }
    }


}
