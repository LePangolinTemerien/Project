package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class MureneRubanBleu extends Creature implements Poisson, Serializable {
    private static MureneRubanBleu singleton;
    private MureneRubanBleu() throws ParseException {
        super("La Murène Ruban Bleu est disponible de Juin à Octobre 24h/24h dans les mer\n il est long et rare\n il se vendra 600 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922871040370163803/128.png","rare",new ArrayList<>(){{add(6);add(7);add(8);add(9);add(10);}},"00:00:00","23:59:59","Murène Ruban Bleu");
    }

    public static synchronized MureneRubanBleu getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new MureneRubanBleu();
        }
        return singleton;
    }
}
