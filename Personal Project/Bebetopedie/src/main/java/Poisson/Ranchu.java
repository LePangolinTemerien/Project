package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Ranchu extends Creature implements Poisson, Serializable {
    private static Ranchu singleton;
    private Ranchu() throws ParseException {
        super("Le Ranchu est disponible toute l'année de 9h à 16h dans les étangs\n il est petit et très rare \n il se vendra 4 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922890197379723305/128.png","trare",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"09:00:00","16:00:00","Ranchu");
    }

    public static synchronized Ranchu getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Ranchu();
        }
        return singleton;
    }
}
