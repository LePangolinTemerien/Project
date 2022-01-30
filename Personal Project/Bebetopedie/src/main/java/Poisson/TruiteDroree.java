package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class TruiteDroree extends Creature implements Poisson, Serializable {
    private static TruiteDroree singleton;
    private TruiteDroree() throws ParseException {
        super("La Truite dorée est disponible de Mars à Mai et de Septembre à Novembre\n de 16h à 9h dans les cascade\n il est de taille moyenne et très rare \n il se vendra 200 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922900881152815215/128.png","trare",new ArrayList<>(){{add(3);add(4);add(5);add(9);add(10);add(11);}},"16:00:00","09:00:00","Truite Dorée");
    }

    public static synchronized TruiteDroree getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new TruiteDroree();
        }
        return singleton;
    }
}
