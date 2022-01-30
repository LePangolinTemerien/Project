package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class NeonBleu extends Creature implements Poisson, Serializable {
    private static NeonBleu singleton;
    private NeonBleu() throws ParseException {
        super("Le Néon Bleu est disponible de Avril à Novembre de 9h à 16h dans les rivières\n il est minuscule et rare \n il se vendra 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922872443545206834/128.png","rare",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);}},"09:00:00","16:00:00","Néon Bleu");
    }

    public static synchronized NeonBleu getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new NeonBleu();
        }
        return singleton;
    }
}
