package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Coelacanthe extends Creature implements Poisson, Serializable {
    private static Coelacanthe singleton;
    private Coelacanthe() throws ParseException {
        super("Le coelacanthe est disponible toute l'année 24h/24h dans les mer par temps de pluie\n il est énorme et très rare\n il se vendra 15 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922545547762614282/128.png","trare",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"00:00:00","23:59:59","Coelacanthe");
    }

    public static synchronized Coelacanthe getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Coelacanthe();
        }
        return singleton;
    }
}
