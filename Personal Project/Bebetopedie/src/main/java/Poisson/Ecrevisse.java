package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Ecrevisse extends Creature implements Poisson, Serializable {
    private static Ecrevisse singleton;
    private Ecrevisse() throws ParseException {
        super("L'Ecrevisse est disponible d'Avril à Septembre 24h/24h dans les étangs\n il est petit et très rare\n il se vendra 200 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922855546455990352/128.png","trare",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);}},"00:00:00","23:59:59","Ecrevisse");
    }

    public static synchronized Ecrevisse getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Ecrevisse();
        }
        return singleton;
    }
}
