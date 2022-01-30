package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class RequinBaleine extends Creature implements Poisson, Serializable {
    private static RequinBaleine singleton;
    private RequinBaleine() throws ParseException {
        super("Le Requin Baleine est disponible de Juin à Septembre 24h/24h dans les mer\n il possède un aileron et très rare \n il se vendra 13 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922893022230872114/128.png","trare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"00:00:00","23:59:59","Requin Baleine");
    }

    public static synchronized RequinBaleine getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new RequinBaleine();
        }
        return singleton;
    }
}
