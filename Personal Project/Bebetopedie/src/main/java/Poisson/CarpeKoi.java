package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class CarpeKoi extends Creature implements Poisson, Serializable {
    private static CarpeKoi singleton;
    private CarpeKoi() throws ParseException {
        super("La Carpe Koi est disponible toute l'année de 16h à 9h dans les étangs\n il est gros et très rares\n il se vendra 4 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922541205059956736/128.png","tare",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"16:00:00","4:00:00","Carpe Koi");
    }

    public static synchronized CarpeKoi getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new CarpeKoi();
        }
        return singleton;
    }
}
