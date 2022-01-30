package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Silure extends Creature implements Poisson, Serializable {
    private static Silure singleton;
    private Silure() throws ParseException {
        super("La Silure est disponible de Mai à Octobre de 16h à 9h dans les étangs\n il est gros et plutôt commun\n il se vendra 800 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922896112438870036/128.png","commun",new ArrayList<>(){{add(5);add(6);add(7);add(8);add(9);add(10);}},"16:00:00","9:00:00","Silure");
    }

    public static synchronized Silure getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Silure();
        }
        return singleton;
    }
}
