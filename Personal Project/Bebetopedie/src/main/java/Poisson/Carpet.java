package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Carpet extends Creature implements Poisson, Serializable {
    private static Carpet singleton;
    private Carpet() throws ParseException {
        super("Le Carpet est disponible toute l'année de 9h à 16h dans les rivières\n il est petit et plutôt commun\n il se vendra 180 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922767089071169546/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"09:00:00","16:00:00","Carpet");
    }

    public static synchronized Carpet getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Carpet();
        }
        return singleton;
    }
}
