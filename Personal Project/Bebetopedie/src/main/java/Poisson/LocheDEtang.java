package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class LocheDEtang extends Creature implements Poisson, Serializable {
    private static LocheDEtang singleton;
    private LocheDEtang() throws ParseException {
        super("La Loche d'Etang est disponible de Mars à Mai 24h/24h dans les rivières\n il est petit et est commun\n il se vendra 400 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922864800822865940/128.png","commun",new ArrayList<>(){{add(3);add(4);add(5);}},"00:00:00","23:59:59","Loche d'Etang");
    }

    public static synchronized LocheDEtang getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new LocheDEtang();
        }
        return singleton;
    }
}
