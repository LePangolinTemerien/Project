package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Arapaima extends Creature implements Poisson, Serializable {

    private static Arapaima singleton;

    private Arapaima() throws ParseException {
        super("L'Arapaïma est disponible en été et en Septembre de 16h à 9h dans les rivières\n il est énorme et très rare\n il se vendra 10 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922520826148954162/128.png","trare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"16:00:00","09:00:00","Arapaïma");
    }

    public static synchronized Arapaima getSingleton() throws ParseException {
        if(singleton == null){
            singleton = new Arapaima();
        }
        return singleton;
    }
}
