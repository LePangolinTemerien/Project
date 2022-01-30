package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Guppy extends Creature implements Poisson, Serializable {
    private static Guppy singleton;
    private Guppy() throws ParseException {
        super("Le Guppy est disponible de Avril à Novembre de 9h à 16h dans les rivières\n il est minuscule et rare\nil se vendra 1 300 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922862573987196928/128.png","rare",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);}},"09:00:00","16:00:00","Guppy");
    }

    public static synchronized Guppy getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Guppy();
        }
        return singleton;
    }
}
