package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Ayu extends Creature implements Poisson, Serializable {

    private static Ayu singleton;
    private Ayu() throws ParseException {
        super("L'ayu est disponible de Juillet à Septembre 24h/24h dans les rivières\n il est de taille moyenne et plutôt commun\n il se vendra 900 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922526166043217920/128.png","commun",new ArrayList<>(){{add(7);add(8);add(9);}},"00:00:00","23:59:59","Ayu");
    }

    public static synchronized Ayu getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Ayu();
        }
        return singleton;
    }
}
