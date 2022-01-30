package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Vandoise extends Creature implements Poisson, Serializable {
    private static Vandoise singleton;
    private Vandoise() throws ParseException {
        super("La Vandoise est disponible toute l'année de 16h à 9h dans les rivières\n il est de taille Moyenne et plutôt commun\n il se vendra 240 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922901426676576276/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"16:00:00","09:00:00","Vandoise");
    }

    public static synchronized Vandoise getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Vandoise();
        }
        return singleton;
    }
}
