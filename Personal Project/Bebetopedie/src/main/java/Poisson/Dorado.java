package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Dorado extends Creature implements Poisson, Serializable {
    private static Dorado singleton;
    private Dorado() throws ParseException {
        super("L'anchois est disponible de Juin à Septembre de 4h à 21h dans les mer\n il très gros et très rare\n il se vendra 15 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922853731278659634/128.png","trare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"04:00:00","21:00:00","Dorado");
    }

    public static synchronized Dorado getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Dorado();
        }
        return singleton;
    }
}
