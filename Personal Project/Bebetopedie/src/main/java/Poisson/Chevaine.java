package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Chevaine extends Creature implements Poisson, Serializable {
    private static Chevaine singleton;
    private Chevaine() throws ParseException {
        super("La chevaine est disponible toute l'année de 9h à 16h dans les rivières\n il est minuscule et plutôt commun\n il se vendra 200 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922541935808364634/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"09:00:00","16:00:00","Chevaine");
    }

    public static synchronized Chevaine getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Chevaine();
        }
        return singleton;
    }
}
