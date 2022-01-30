package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Raie extends Creature implements Poisson, Serializable {
    private static Raie singleton;
    private Raie() throws ParseException {
        super("La Raie est disponible de Aout à Novembre de 4h à 21h dans les mer\n il est très gros et rare \n il se vendra 3 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922889735888851004/128.png","rare",new ArrayList<>(){{add(8);add(9);add(10);add(11);}},"04:00:00","21:00:00","Raie");
    }

    public static synchronized Raie getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Raie();
        }
        return singleton;
    }
}
