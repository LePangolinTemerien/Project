package Poisson;
import Principale.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Anchois extends Creature implements Poisson, Serializable {

    private static Anchois singleton;
    private Anchois() throws ParseException {
        super("L'anchois est disponible toute l'année de 4h à 21h dans les mer\n il est petit et plutôt commun\n il se vendra 200 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922482077440569424/unknown.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"04:00:00","21:00:00","Anchois");
    }

    public static synchronized Anchois getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Anchois();
        }
        return singleton;
    }
}
