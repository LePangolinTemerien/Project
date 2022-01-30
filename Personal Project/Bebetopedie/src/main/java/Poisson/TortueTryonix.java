package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class TortueTryonix extends Creature implements Poisson, Serializable {
    private static TortueTryonix singleton;
    private TortueTryonix() throws ParseException {
        super("La Tortue Tryonix est disponible en Aoute et en Septembre de 16h à 9h dans les rivières\n il est gros et peu commun\n il se vendra 3 750 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922900065872388116/128.png","commun",new ArrayList<>(){{add(8);add(9);}},"16:00:00","09:00:00","Tortue Tryonix");
    }

    public static synchronized TortueTryonix getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new TortueTryonix();
        }
        return singleton;
    }
}
