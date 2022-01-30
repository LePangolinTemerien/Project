package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Arowana extends Creature implements Poisson, Serializable {

    private static Arowana singleton;
    private Arowana() throws ParseException {
        super("L'anchois est disponible l'été et en Septembre de 16h à 9h dans les rivières\n il est gros et très rare\n il se vendra 10 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922524501395275876/128.png","trare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"16:00:00","09:00:00","Arowana");
    }

    public static synchronized Arowana getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Arowana();
        }
        return singleton;
    }
}
