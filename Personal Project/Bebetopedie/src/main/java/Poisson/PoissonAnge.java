package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonAnge extends Creature implements Poisson, Serializable {
    private static PoissonAnge singleton;
    private PoissonAnge() throws ParseException {
        super("Le Poisson Ange est disponible de Mai à Octobre de 16h à 9h dans les rivières\n il est petit et rare \n il se vendra 3 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922885392578015262/128.png","rare",new ArrayList<>(){{add(5);add(6);add(7);add(8);add(9);add(10);}},"16:00:00","09:00:00","Poisson Ange");
    }

    public static synchronized PoissonAnge getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonAnge();
        }
        return singleton;
    }
}
