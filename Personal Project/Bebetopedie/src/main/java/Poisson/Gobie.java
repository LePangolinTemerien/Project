package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Gobie extends Creature implements Poisson, Serializable {
    private static Gobie singleton;
    private Gobie() throws ParseException {
        super("Le Gobie d'eau douce est disponible toute l'année de 16h à 9h dans les rivières\n il est petit et rare\n il se vendra 400 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922859054991302686/128.png","rare",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"16:00:00","09:00:00","Gobie d'eau douce");
    }

    public static synchronized Gobie getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Gobie();
        }
        return singleton;
    }
}
