package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Brochet extends Creature implements Poisson, Serializable {
    private static Brochet singleton;
    private Brochet() throws ParseException {
        super("Le brochet est disponible de Septembre à Décembre 24h/24h dans les rivières\n il est très gros et très rare\n il se vendra 1 800 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922530379997511710/128.png","trare",new ArrayList<>(){{add(8);add(9);add(10);add(11);add(12);}},"00:00:00","23:59:59","Brochet");
    }

    public static synchronized Brochet getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Brochet();
        }
        return singleton;
    }
}
