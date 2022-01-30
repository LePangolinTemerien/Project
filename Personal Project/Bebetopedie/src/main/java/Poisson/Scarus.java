package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Scarus extends Creature implements Poisson, Serializable {
    private static Scarus singleton;
    private Scarus() throws ParseException {
        super("Le Scarus est disponible de Février à Novembre 24h/24h dans les mer\n il est de taille moyenne et plutôt commun\n il se vendra 5 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922895584346660914/128.png","commun",new ArrayList<>(){{add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);}},"00:00:00","23:59:59","Scarus");
    }

    public static synchronized Scarus getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Scarus();
        }
        return singleton;
    }
}
