package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Thon extends Creature implements Poisson, Serializable {
    private static Thon singleton;
    private Thon() throws ParseException {
        super("Le Thons est disponible de Novembre à Avril 24h/24h au ponton\n il est énorme et rare \n il se vendra 7 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922898114132705330/128.png","rare",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(11);add(12);}},"00:00:00","23:59:59","Thon");
    }

    public static synchronized Thon getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Thon();
        }
        return singleton;
    }
}
