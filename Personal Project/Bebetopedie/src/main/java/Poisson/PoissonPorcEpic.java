package Poisson;
import Principale.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class PoissonPorcEpic extends Creature implements Poisson, Serializable {

    private static PoissonPorcEpic singleton;

    private PoissonPorcEpic() throws ParseException {
        super("Le poisson-porc-epic est disponible toute l'année 24h/24h dans la mer\n il est moyen et plutôt commun\n il se vendra 250 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922515697534369823/60.png","commun",new ArrayList<>(){{add(7);add(8);add(9);}},"00:00:00","23:59:59","Poisson-porc-epic");
    }

    public static synchronized PoissonPorcEpic getSingleton() throws ParseException {
        if(singleton == null){
            singleton = new PoissonPorcEpic();
        }
        return singleton;
    }
}