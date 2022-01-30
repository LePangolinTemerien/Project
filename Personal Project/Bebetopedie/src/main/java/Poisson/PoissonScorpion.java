package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonScorpion extends Creature implements Poisson, Serializable {
    private static PoissonScorpion singleton;
    private PoissonScorpion() throws ParseException {
        super("Le Poisson Scorpion est disponible de Avril à Novembre 24h/24h dans les mer\n il est moyen et plutôt commun\n il se vendra 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922889082839900201/128.png","commun",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);}},"00:00:00","23:59:59","Poisson Scorpion");
    }

    public static synchronized PoissonScorpion getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonScorpion();
        }
        return singleton;
    }
}
