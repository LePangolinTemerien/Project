package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonRuban extends Creature implements Poisson, Serializable {
    private static PoissonRuban singleton;
    private PoissonRuban() throws ParseException {
        super("Le Poisson Ruban est disponible de Decembre à Mai 24h/24h dans les mer\n il est énorme et très rare \n il se vendra 9 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922888372178026596/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(12);}},"00:00:00","23:59:59","Poisson Ruban");
    }

    public static synchronized PoissonRuban getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonRuban();
        }
        return singleton;
    }
}
