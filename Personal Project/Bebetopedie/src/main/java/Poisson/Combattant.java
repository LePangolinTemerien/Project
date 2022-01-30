package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Combattant extends Creature implements Poisson, Serializable {
    private static Combattant singleton;
    private Combattant() throws ParseException {
        super("Le combattant est disponible de Mai à Octobre de 9h à 16h dans les rivières\n il est petit et très rare\n il se vendra 200 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922547185613168670/128.png","trare",new ArrayList<>(){{add(5);add(6);add(7);add(8);add(9);add(10);}},"09:00:00","16:00:00","Combattant");
    }

    public static synchronized Combattant getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Combattant();
        }
        return singleton;
    }
}
