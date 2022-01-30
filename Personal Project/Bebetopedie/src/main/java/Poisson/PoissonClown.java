package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonClown extends Creature implements Poisson, Serializable {
    private static PoissonClown singleton;
    private PoissonClown() throws ParseException {
        super("Le poisson Clown est disponible de Avril à Septembre 24h/24h dans les mer\n il est minuscule et rare \n il se vendra 650 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922887004100915270/128.png","rare",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);}},"00:00:00","23:59:59","Poisson Clown");
    }

    public static synchronized PoissonClown getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonClown();
        }
        return singleton;
    }
}
