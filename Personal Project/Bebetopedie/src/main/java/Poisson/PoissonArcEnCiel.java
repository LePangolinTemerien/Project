package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonArcEnCiel extends Creature implements Poisson, Serializable {
    private static PoissonArcEnCiel singleton;
    private PoissonArcEnCiel() throws ParseException {
        super("Le Poisson Arc-En-Ciel est disponible de Mai à Octobre de 9h à 16h dans les mer\n il est minuscule et rare\n il se vendra 800 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922879025100251187/128.png","rare",new ArrayList<>(){{add(5);add(6);add(7);add(8);add(9);add(10);}},"09:00:00","16:00:00","Poisson Arc-En-Ciel");
    }

    public static synchronized PoissonArcEnCiel getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonArcEnCiel();
        }
        return singleton;
    }
}
