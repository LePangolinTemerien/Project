package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class CrabeChinois extends Creature implements Poisson, Serializable {
    private static CrabeChinois singleton;
    private CrabeChinois() throws ParseException {
        super("Le crabe chinois est disponible de Septembre à Octobre de 16h à 9h dans les rivières\n il est petit et peu commun\n il se vendra 2000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922603706350977074/128.png","commun",new ArrayList<>(){{add(9);add(10);add(11);}},"16:00:00","9:00:00","Crabe Chinois");
    }

    public static synchronized CrabeChinois getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new CrabeChinois();
        }
        return singleton;
    }
}
