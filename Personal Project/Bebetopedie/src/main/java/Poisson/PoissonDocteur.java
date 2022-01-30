package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonDocteur extends Creature implements Poisson, Serializable {
    private static PoissonDocteur singleton;
    private PoissonDocteur() throws ParseException {
        super("Le Poisson Docteur est disponible de Mai à Septembre de 9h à 16h dans les rivières\n il est minuscule et rare \n il se vendra 1 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922881236718985216/128.png","rare",new ArrayList<>(){{add(5);add(6);add(7);add(8);add(9);}},"09:00:00","16:00:00","Poisson Docteur");
    }

    public static synchronized PoissonDocteur getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new PoissonDocteur();
        }
        return singleton;
    }
}
