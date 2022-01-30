package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class TeteDeSerpent extends Creature implements Poisson, Serializable {
    private static TeteDeSerpent singleton;
    private TeteDeSerpent() throws ParseException {
        super("La Tête de Serpent est disponible de Juin à Aout de 9h à 16h dans les étangs\n il est gros et rare \n il se vendra 5 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922897478896984074/128.png","rare",new ArrayList<>(){{add(6);add(7);add(8);}},"09:00:00","16:00:00","Tête de Serpent");
    }

    public static synchronized TeteDeSerpent getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new TeteDeSerpent();
        }
        return singleton;
    }
}
