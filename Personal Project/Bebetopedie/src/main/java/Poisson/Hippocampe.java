package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Hippocampe extends Creature implements Poisson, Serializable {
    private static Hippocampe singleton;
    private Hippocampe() throws ParseException {
        super("L'Hippocampe est disponible de Avril à Novembre 24h/24h dans les mer\n il est minuscule et peu commun\n il se vendra 1 100 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922863334133465138/128.png","commun",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);}},"00:00:00","23:59:59","Hippocampe");
    }

    public static synchronized Hippocampe getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Hippocampe();
        }
        return singleton;
    }
}
