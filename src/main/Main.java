package main;


import java.text.ParseException;
import java.util.Scanner;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) throws ParseException{

        sc = new Scanner(System.in);
        Weather weather;
        System.out.println("Tere tulemust ilmaprogrammi.");
        System.out.println("Vajutage ENTER, kui soovite näha kohaliku ilma või sisestage asukoht formaadis (Riik,Maakond,Linn).");

        String vastus = sc.nextLine();

        if(vastus.equals("")){
            weather = localWeather();
        } else {
            weather = customWeather(vastus);
        }

        // Küsime, kas kasutaja soovib hetke ilma või ilmaprognoosi
        UserQuery user = new UserQuery();
        int misIlm = user.askWhichForecast(); // "0" = ilm hetkel, "1" = päeva prognoos, "2" = nödala prognoos
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

    //Pärime suvalise asukoha ilmaobjekti.
    private static Weather customWeather(String input){
        String[] lines = input.split(",");
        return new Weather(new Location(lines[0], lines[1], lines[2]));
    }


    //Pärime kohaliku asukoha ilmaobjekti, igal korral pole GEOIP query andmed sobitavad YR.NO'sse seega tuleb erindeid püüda.
    private static Weather localWeather(){

        Location myLocation = new Location(Util.getIpAddress());

        System.out.println("Teie asukoht IP järgi on " + myLocation.getCity() + ", "
                + myLocation.getRegionName() + ", "  + myLocation.getCountry() + ".\n");

        Weather w;
        try{
            w = new Weather(myLocation);
        }catch (Exception ex){
            System.out.println("Tundub, et IP järgi polnud võimalik ilma pärida.");
            System.out.println("Palun sisestage oma asukoht järgnevalt (Riik,Maakond,Linn) | (Estonia,Tartumaa,Tartu)");
            String[] read = sc.nextLine().split(",");
            w = new Weather(new Location(read[0], read[1], read[2]));
        }
        return w;

    }


}
