package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Grenouille extends Creature implements Poisson, Serializable {
    private static Grenouille singleton;
    private Grenouille() throws ParseException {
        super("La Grenouille est disponible de Mai à Aout 24h/24h dans les étangs\n il est petit et plutôt commun\n il se vendra 120 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922860732037611570/128.png","commun",new ArrayList<>(){{add(5);add(6);add(7);add(8);}},"00:00:00","23:59:59","Grenouille");
    }

    public static synchronized Grenouille getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Grenouille();
        }
        return singleton;
    }
}
