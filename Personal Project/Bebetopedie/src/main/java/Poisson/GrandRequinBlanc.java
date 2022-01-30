package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class GrandRequinBlanc extends Creature implements Poisson, Serializable {
    private static GrandRequinBlanc singleton;
    private GrandRequinBlanc() throws ParseException {
        super("Le Grand Requin Blanc est de Juin à Septembre de 16h à 9h dans les mer\n il a une forme d'aileron et est rare\n il se vendra 15 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922859872024924190/128.png","rare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"16:00:00","09:00:00","Grand Requin Blanc");
    }

    public static synchronized GrandRequinBlanc getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new GrandRequinBlanc();
        }
        return singleton;
    }
}
