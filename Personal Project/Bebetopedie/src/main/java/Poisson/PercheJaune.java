package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PercheJaune extends Creature implements Poisson, Serializable {
    private static PercheJaune singleton;
    private PercheJaune() throws ParseException {
        super("La Perche Jaune est disponible d'Octobre à Mars 24h/24h dans les rivières\n il est de taille Moyenne et plutôt commun\n il se vendra 300 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922874133245739098/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(10);add(11);add(12);}},"00:00:00","23:59:59","Perche Jaune");
    }

    public static synchronized PercheJaune getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PercheJaune();
        }
        return singleton;
    }
}
