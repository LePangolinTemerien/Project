package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Gar extends Creature implements Poisson, Serializable {
    private static Gar singleton;
    private Gar() throws ParseException {
        super("Le Gar est disponible de Juin à Septembre de 16h à 9h dans les étangs\n il est tès gros et très rare\n il se vendra 6 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922858455537164329/128.png","trare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"16:00:00","09:00:00","Gar");
    }

    public static synchronized Gar getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Gar();
        }
        return singleton;
    }
}
