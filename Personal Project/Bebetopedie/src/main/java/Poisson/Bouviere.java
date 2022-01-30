package Poisson;
import Principale.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Bouviere extends Creature implements Poisson, Serializable {

    private static Bouviere singleton;

    private Bouviere() throws ParseException {
        super("La bouvière est de Novembre à Mars 24h/24h dans les rivières\n il est minuscule et plutôt commun\n il se vendra 900 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922498149346590811/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(11);add(12);}},"00:00:00","23:59:59","Bouvière");
    }

    public static synchronized Bouviere getSingleton() throws ParseException {
        if(singleton == null){
            singleton = new Bouviere();
        }
        return singleton;
    }
}
