package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonLanterne extends Creature implements Poisson, Serializable {
    private static PoissonLanterne singleton;
    private PoissonLanterne() throws ParseException {
        super("Le Poisson Lanterne est disponible de Novembre à Mars de 16h à 9h dans les mer\n il est gros et rare \n il se vendra 2 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922882680918519898/128.png","trare",new ArrayList<>(){{add(1);add(2);add(3);add(11);add(12);}},"16:00:00","9:00:00","Poisson Lanterne");
    }

    public static synchronized PoissonLanterne getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonLanterne();
        }
        return singleton;
    }
}
