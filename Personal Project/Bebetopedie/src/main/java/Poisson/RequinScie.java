package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class RequinScie extends Creature implements Poisson, Serializable {
    private static RequinScie singleton;
    private RequinScie() throws ParseException {
        super("Le Requin Scie est disponible de Juin à Septembre de 16h à 9h dans les mer\n il possède une aileron et très rare \n il se vendra 12 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922892263212875827/128.png","trare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"16:00:00","09:00:00","Requin Scie");
    }

    public static synchronized RequinScie getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new RequinScie();
        }
        return singleton;
    }
}
