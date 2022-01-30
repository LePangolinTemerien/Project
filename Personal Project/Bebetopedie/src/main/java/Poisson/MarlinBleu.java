package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class MarlinBleu extends Creature implements Poisson, Serializable {
    private static MarlinBleu singleton;
    private MarlinBleu() throws ParseException {
        super("Le Marlin Bleu est disponible de Novembre à Décembre ainsi que de Juillet à Septembre 24h/24h dans au ponton\n il est énorme et est très rare\n il se vendra 10 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922869098633891850/128.png","trare",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(7);add(8);add(9);add(11);add(12);}},"00:00:00","23:59:59","Marlin Bleu");
    }

    public static synchronized MarlinBleu getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new MarlinBleu();
        }
        return singleton;
    }
}
