package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Piranha extends Creature implements Poisson, Serializable {
    private static Piranha singleton;
    private Piranha() throws ParseException {
        super("Le Piranha est disponible de Juin à Septembre de 9h à 16h et de 21h à 4h dans les mer\n il est petit et très rare\n il se vendra 2 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922875339233984562/128.png","trare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"00:00:00","23:59:59","Piranha");
    }

    public static synchronized Piranha getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Piranha();
        }
        return singleton;
    }
}
