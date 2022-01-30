package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Calamar extends Creature implements Poisson, Serializable {
    private static Calamar singleton;
    private Calamar() throws ParseException {
        super("Le Calamar est disponible de Décembre à Aout 24h/24h dans les mer\n il est de taille moyenne et plutôt commun\n il se vendra 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922531108271325225/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(12);}},"00:00:00","23:59:59","Calamar");
    }

    public static synchronized Calamar getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Calamar();
        }
        return singleton;
    }
}
