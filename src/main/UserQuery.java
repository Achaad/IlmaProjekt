package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserQuery {
    private Scanner sc;

    public UserQuery() {
        sc = new Scanner(System.in);
    }


    /**
     * Küsib kasutaja poolt, millist ilma ta soovib teada
     * @return "0" = ilm hetkel, "1" = päeva prognoos, "2" = nödala prognoos
     */
    public int askWhichForecast() {
        System.out.println("Kas Teie soovite teada hetkeilma või ilma prognoosi?");
        System.out.println("Palun sisestage üks järgmistest numbritest");
        System.out.println("Ilm hetkel: \"0\"");
        System.out.println("Tänase päeva prognoos: \"1\"");
        System.out.println("Nädala prognoos: \"2\"");
        int vastus = 0;

        // Tsükl lõppeb ainult siis, kui kasutaja on sisetanud õige number
        boolean correcct = false;
        while (true){
            try {
                System.out.print("Teie valik: ");
                vastus = sc.nextInt();
                if (vastus == 0 || vastus == 1 || vastus == 2) {
                    break;
                } else {
                    System.out.println("Vale sisend! Sisestage palun ainult \"0\", \"1\" või \"2\"");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vale sisend! Sisestage palun ainult \"0\", \"1\" või \"2\"");
                sc.next();
            }
        }
        return vastus;
    }
}
