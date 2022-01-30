package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Limande extends Creature implements Poisson, Serializable {
    private static Limande singleton;
    private Limande() throws ParseException {
        super("La Limande est disponible de Avril à Octobre 24h/24h dans les mer\n il est de taille moyenne et est commun\n il se vendra 300 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922864059475427358/128.png","commun",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);add(10);}},"00:00:00","23:59:59","Limande");
    }

    public static synchronized Limande getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Limande();
        }
        return singleton;
    }
}
