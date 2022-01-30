package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class FonduleBarre extends Creature implements Poisson, Serializable {
    private static FonduleBarre singleton;
    private FonduleBarre() throws ParseException {
        super("La Fondule Barré est disponible d'Avril à Aout 24h/24h dans les étangs\n il est minuscule et peu commun\n il se vendra 300 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922857788223393822/128.png","commun",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);}},"00:00:00","23:59:59","Fondule Barré");
    }

    public static synchronized FonduleBarre getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new FonduleBarre();
        }
        return singleton;
    }
}
