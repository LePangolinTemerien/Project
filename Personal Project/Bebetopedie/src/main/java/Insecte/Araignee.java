package Insecte;

import Poisson.Anchois;
import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Araignee extends Creature implements Insecte, Serializable {
    private static Araignee singleton;
    private Araignee() throws ParseException {
        super("L'araignée est disponible toute l'année de 19h à 8h dans les arbres\n il est plutôt commun\n il se vendra 600 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922604505944703006/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"19:00:00","08:00:00","Araignée");
    }

    public static synchronized Araignee getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Araignee();
        }
        return singleton;
    }
}
