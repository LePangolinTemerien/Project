package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Omble extends Creature implements Poisson, Serializable {
    private static Omble singleton;
    private Omble() throws ParseException {
        super("L'anchois est disponible de Avril à Juin et de Septembre à Novembre\n de 16h à 9h pour la première periode et 24h/24h dans la deuxieme periode dans les cascades\n il est de taille moyenne et très rare \n il se vendra 3 800 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922873417655525437/128.png","trare",new ArrayList<>(){{add(3);add(4);add(5);add(6);add(9);add(10);add(11);}},"00:00:00","23:59:59","Omble");
    }

    public static synchronized Omble getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Omble();
        }
        return singleton;
    }
}
