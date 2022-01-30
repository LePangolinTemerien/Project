package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class SaumonMasou extends Creature implements Poisson, Serializable {
    private static SaumonMasou singleton;
    private SaumonMasou() throws ParseException {
        super("Le Saumon Masou est disponible de Mars à Juin et de Septembre à Novembre\n de 16h à 9h pour la premiere periode et 24h/24h pour la deuxième dans les cascades\n il est de taille moyenne et plutôt commun\n il se vendra 1 000", "https://media.discordapp.net/attachments/922482008750448670/922894358095724584/128.png","commun",new ArrayList<>(){{add(3);add(4);add(5);add(6);add(9);add(10);add(11);}},"00:00:00","23:59:59","Saumon Masou");
    }

    public static synchronized SaumonMasou getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new SaumonMasou();
        }
        return singleton;
    }
}
