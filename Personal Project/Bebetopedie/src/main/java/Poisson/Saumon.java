package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Saumon extends Creature implements Poisson, Serializable {
    private static Saumon singleton;
    private Saumon() throws ParseException {
        super("Le Saumon est disponible en Septembre 24h/24h dans les embouchures\n il est gros et plutôt commun\n il se vendra 700 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922893584015982602/128.png","commun",new ArrayList<>(){{add(9);}},"00:00:00","23:59:59","Saumon");
    }

    public static synchronized Saumon getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Saumon();
        }
        return singleton;
    }
}
