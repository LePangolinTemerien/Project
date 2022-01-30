package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class SaumonRoi extends Creature implements Poisson, Serializable {
    private static SaumonRoi singleton;
    private SaumonRoi() throws ParseException {
        super("Le Saumon Roi est disponible en Septembre 24h/24h dans les embouchure\n il est très gros et rare \n il se vendra 1 800 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922895000654725200/128.png","rare",new ArrayList<>(){{add(9);}},"00:00:00","23:59:59","Saumon Roi");
    }

    public static synchronized SaumonRoi getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new SaumonRoi();
        }
        return singleton;
    }
}
