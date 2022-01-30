package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Bar extends Creature implements Poisson, Serializable {
    private static Bar singleton;
    private Bar() throws ParseException {
        super("Le bar est disponible toute l'année de 24h/24h dans les rivières\n il est gros et plutôt commun\n il se vendra 400 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922527387319693332/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"00:00:00","23:59:59","Bar");
    }

    public static synchronized Bar getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Bar();
        }
        return singleton;
    }
}
