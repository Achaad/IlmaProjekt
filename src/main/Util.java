package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Util {

    //Staatiliste abifunktsioonide klass
    //Abifunktsioon, mis pärib IP aadressi lehelt http://checkip.amazonaws.com/ ja tagastab Stringina.
    public static String getIpAddress() {

        String ip = "";

        try {

            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            ip = in.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ip;
    }

}
