package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonPapillion extends Creature implements Poisson, Serializable {
    private static PoissonPapillion singleton;
    private PoissonPapillion() throws ParseException {
        super("Le Poisson Papillon est disponible de Avril à Septembre 24h/24h dans les mer\n il est petit et rare \n il se vendra 1 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922887728738238464/128.png","rare",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);}},"00:00:00","23:59:59","Poisson Papillon");
    }

    public static synchronized PoissonPapillion getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonPapillion();
        }
        return singleton;
    }
}
