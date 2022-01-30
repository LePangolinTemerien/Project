package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Carangue extends Creature implements Poisson, Serializable {
    private static Carangue singleton;
    private Carangue() throws ParseException {
        super("La Carangue à grosse tête est disponible de Mai à Octobre 24h/24h dans au ponton\n il est très gros et très rare\n il se vendra 4 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922532107681693816/128.png","trare",new ArrayList<>(){{add(5);add(6);add(7);add(8);add(9);add(10);}},"00:00:00","23:59:59","Carangue � grosse t�te");
    }

    public static synchronized Carangue getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Carangue();
        }
        return singleton;
    }
}
