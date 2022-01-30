package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Crapet extends Creature implements Poisson, Serializable {
    private static Crapet singleton;
    private Crapet() throws ParseException {
        super("Le Crapet est disponible toute l'année 24h/24h dans les étangs\n il est gros et très rare\n il se vendra 4 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922534485021560852/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"00:00:00","23:59:59","Crapet");
    }

    public static synchronized Crapet getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Crapet();
        }
        return singleton;
    }
}
