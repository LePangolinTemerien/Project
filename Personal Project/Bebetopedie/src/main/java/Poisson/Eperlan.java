package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Eperlan extends Creature implements Poisson, Serializable {
    private static Eperlan singleton;
    private Eperlan() throws ParseException {
        super("L'Éperlan est disponible de Décembre à Février 24h/24h dans les rivières\n il est petit et plutôt commun\n il se vendra 400 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922856223223722004/128.png","commun",new ArrayList<>(){{add(1);add(2);add(12);}},"00:00:00","23:59:59","Éperlan");
    }

    public static synchronized Eperlan getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Eperlan();
        }
        return singleton;
    }
}
