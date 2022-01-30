package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonBallon extends Creature implements Poisson, Serializable {
    private static PoissonBallon singleton;
    private PoissonBallon() throws ParseException {
        super("Le Poisson Ballon est disponible de Novembre à Février de 21h à 4h dans les mer\n il est de taille moyenne et rare \n il se vendra 5 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922886153043058738/128.png","rare",new ArrayList<>(){{add(1);add(2);add(11);add(12);}},"21:00:00","04:00:00","Poisson Ballon");
    }

    public static synchronized PoissonBallon getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonBallon();
        }
        return singleton;
    }
}
