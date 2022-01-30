package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Murene extends Creature implements Poisson, Serializable {
    private static Murene singleton;
    private Murene() throws ParseException {
        super("La Murene est disponible d'Aout à Octobre 24h/24h dans les mer\n il est long et rare\n il se vendra 2 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922869958650757130/128.png","rare",new ArrayList<>(){{add(8);add(9);add(10);}},"00:00:00","23:59:59","Murene");
    }

    public static synchronized Murene getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Murene();
        }
        return singleton;
    }
}
