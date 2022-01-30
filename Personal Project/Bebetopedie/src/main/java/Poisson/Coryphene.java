package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Coryphene extends Creature implements Poisson, Serializable {
    private static Coryphene singleton;
    private Coryphene() throws ParseException {
        super("Le Coryphene est disponible de Mai à Octobre 24h/24h dans au ponton\n il est enorme et très rare\n il se vendra 6000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922597218039500810/128.png","trare",new ArrayList<>(){{add(5);add(6);add(7);add(8);add(9);add(10);}},"00:00:00","23:59:59","Coryphene");
    }

    public static synchronized Coryphene getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Coryphene();
        }
        return singleton;
    }
}
