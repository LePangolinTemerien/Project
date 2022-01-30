package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class RequinMarteau extends Creature implements Poisson, Serializable {
    private static RequinMarteau singleton;
    private RequinMarteau() throws ParseException {
        super("Le Requin Marteau est disponible de Juin à Septembre de 16h à 9h dans les mer\n il à une aileron et très rare \n il se vendra 8 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922891623162081340/128.png","trare",new ArrayList<>(){{add(6);add(7);add(8);add(9);;}},"16:00:00","9:00:00","Requin Marteau");
    }

    public static synchronized RequinMarteau getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new RequinMarteau();
        }
        return singleton;
    }
}
