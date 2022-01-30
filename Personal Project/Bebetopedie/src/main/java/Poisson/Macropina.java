package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Macropina extends Creature implements Poisson, Serializable {
    private static Macropina singleton;
    private Macropina() throws ParseException {
        super("Le Macropina est disponible toute l'année de 21h à 4h dans les mer\n il est petit et très rare\n il se vendra 15 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922868218652151848/128.png","trare",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"21:00:00","4:00:00","Macropina");
    }

    public static synchronized Macropina getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Macropina();
        }
        return singleton;
    }
}
