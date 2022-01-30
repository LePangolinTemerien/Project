package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class TortueSerpentine extends Creature implements Poisson, Serializable {
    private static TortueSerpentine singleton;
    private TortueSerpentine() throws ParseException {
        super("La Tortue Serpentine est disponible de Avril à Octobre de 21h à 4h dans les rivières\n il est gros et rare \n il se vendra 5 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922899424894656552/128.png","rare",new ArrayList<>(){{add(4);add(5);add(6);add(7);add(8);add(9);add(10);}},"21:00:00","04:00:00","Tortue Serpentine");
    }

    public static synchronized TortueSerpentine getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new TortueSerpentine();
        }
        return singleton;
    }
}
