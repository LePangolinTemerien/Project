package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonChirurgien extends Creature implements Poisson, Serializable {
    private static PoissonChirurgien singleton;
    private PoissonChirurgien() throws ParseException {
        super("Le Poisson Chirurgien est disponible de Avril à Septembre 24h/24h dans les mer\n il est petit et rare\n il se vendra 1 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922880218199363625/128.png","commun",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);}},"00:00:00","23:59:59","Poisson Chirurgien");
    }

    public static synchronized PoissonChirurgien getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonChirurgien();
        }
        return singleton;
    }
}
