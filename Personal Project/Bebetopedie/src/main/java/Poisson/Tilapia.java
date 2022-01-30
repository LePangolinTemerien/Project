package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Tilapia extends Creature implements Poisson, Serializable {
    private static Tilapia singleton;
    private Tilapia() throws ParseException {
        super("Le Tilapia est disponible de Juin à Octobre 24h/24h dans les rivières\n il est de taille moyenne et plutôt commun\n il se vendra 800 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922898720113197167/128.png","commun",new ArrayList<>(){{add(6);add(7);add(8);add(9);add(10);}},"00:00:00","23:59:59","Tilapia");
    }

    public static synchronized Tilapia getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Tilapia();
        }
        return singleton;
    }
}
