package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Clione extends Creature implements Poisson, Serializable {
    private static Clione singleton;
    private Clione() throws ParseException {
        super("La clione est disponible de Décembre à Mars 24h/24h dans les mer\n il est minuscule et plutôt commun\n il se vendra 1500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922544684629372938/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(12);}},"00:00:00","23:59:59","Clione");
    }

    public static synchronized Clione getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Clione();
        }
        return singleton;
    }
}
