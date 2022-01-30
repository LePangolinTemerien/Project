package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Esturgeon extends Creature implements Poisson, Serializable {
    private static Esturgeon singleton;
    private Esturgeon() throws ParseException {
        super("L'Esturgeon est disponible de Septembre à Mars 24h/24h dans les embouchures\n il est énorme et très rare\n il se vendra 10 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922857048868261908/128.png","trare",new ArrayList<>(){{add(1);add(2);add(3);add(9);add(10);add(11);add(12);}},"00:00:00","23:59:59","Esturgeon");
    }

    public static synchronized Esturgeon getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Esturgeon();
        }
        return singleton;
    }
}
