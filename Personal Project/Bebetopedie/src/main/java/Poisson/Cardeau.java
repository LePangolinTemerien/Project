package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Cardeau extends Creature implements Poisson, Serializable {
    private static Cardeau singleton;
    private Cardeau() throws ParseException {
        super("Le Cardeau est disponible toute l'année de 24h/24h dans les mer\n il est très gros et est peu commun\n il se vendra 800 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922533526002364556/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"00:00:00","23:59:59","Cardeau");
    }

    public static synchronized Cardeau getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Cardeau();
        }
        return singleton;
    }
}
