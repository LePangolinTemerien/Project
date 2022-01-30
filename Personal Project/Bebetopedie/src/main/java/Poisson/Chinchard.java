package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Chinchard extends Creature implements Poisson, Serializable {
    private static Chinchard singleton;
    private Chinchard() throws ParseException {
        super("Le chinchard est disponible toute l'année 24h/24h dans les mer\n il est petit et plutôt commun\n il se vendra 150 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922542762828632074/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"00:00:00","23:59:59","Chinchard");
    }

    public static synchronized Chinchard getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Chinchard();
        }
        return singleton;
    }
}
