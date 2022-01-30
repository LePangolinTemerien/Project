package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Bichir extends Creature implements Poisson, Serializable {
    private static Bichir singleton;
    private Bichir() throws ParseException {
        super("Le Bichir est disponible de Juin à Septembre de 21h à 4h dans les rivières\n il est gros et très rare\n il se vendra 4000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922529253923368971/128.png","trare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"21:00:00","4:00:00","Bichir");
    }

    public static synchronized Bichir getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Bichir();
        }
        return singleton;
    }
}
