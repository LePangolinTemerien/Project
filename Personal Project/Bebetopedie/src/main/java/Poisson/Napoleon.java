package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Napoleon extends Creature implements Poisson, Serializable {
    private static Napoleon singleton;
    private Napoleon() throws ParseException {
        super("Le Napoleon est disponible en Juillet et en Aout de 4h à 21h dans les mer\n il est énorme et très rare\n il se vendra 10 000 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922871815162966056/128.png","trare",new ArrayList<>(){{add(7);add(8);}},"04:00:00","21:00:00","Napoléon");
    }

    public static synchronized Napoleon getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Napoleon();
        }
        return singleton;
    }
}
