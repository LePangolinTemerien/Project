package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class LuneDeMer extends Creature implements Poisson, Serializable {
    private static LuneDeMer singleton;
    private LuneDeMer() throws ParseException {
        super("L'anchois est disponible de Juillet à Septembre de 4h à 21h dans les mer\n il à une forme d'aileron et est très rare\n il se vendra 4 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922865970161266718/128.png","trare",new ArrayList<>(){{;add(7);add(8);add(9);}},"04:00:00","21:00:00","Lune de mer");
    }

    public static synchronized LuneDeMer getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new LuneDeMer();
        }
        return singleton;
    }
}
