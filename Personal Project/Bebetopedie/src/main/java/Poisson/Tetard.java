package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Tetard extends Creature implements Poisson, Serializable {
    private static Tetard singleton;
    private Tetard() throws ParseException {
        super("Le Têtard est disponible de Mars à Juillet 24h/24h dans les étangs\n il est minuscule et rare \n il se vendra 100 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922896731136458773/128.png","rare",new ArrayList<>(){{add(3);add(4);add(5);add(6);add(7);}},"00:00:00","23:59:59","Têtard");
    }

    public static synchronized Tetard getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Tetard();
        }
        return singleton;
    }
}
