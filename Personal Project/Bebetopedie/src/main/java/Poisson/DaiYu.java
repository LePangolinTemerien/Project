package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class DaiYu extends Creature implements Poisson, Serializable {
    private static DaiYu singleton;
    private DaiYu() throws ParseException {
        super("Le Dai Yu est disponible de Décembre à Mars  de 16h à 9h dans les cascade\n il est très gros et très rare\n il se vendra 15 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922852441077190696/128.png","trare",new ArrayList<>(){{add(1);add(2);add(3);add(12);}},"16:00:00","09:00:00","Dai Yu");
    }

    public static synchronized DaiYu getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new DaiYu();
        }
        return singleton;
    }
}
