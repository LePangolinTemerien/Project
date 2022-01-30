package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonRouge extends Creature implements Poisson, Serializable {
    private static PoissonRouge singleton;
    private PoissonRouge() throws ParseException {
        super("Le Poisson Rouge est disponible toute l'année 24h/24h dans les étang\n il est minuscule et très rare\n il se vendra 1 300 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922883849074130954/128.png","trare",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"00:00:00","23:59:59","Poisson Rouge");
    }

    public static synchronized PoissonRouge getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonRouge();
        }
        return singleton;
    }
}
