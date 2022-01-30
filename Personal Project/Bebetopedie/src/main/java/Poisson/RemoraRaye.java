package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class RemoraRaye extends Creature implements Poisson, Serializable {
    private static RemoraRaye singleton;
    private RemoraRaye() throws ParseException {
        super("La Rémora Rayée est disponible de Juin à Septembre 24h/24h dans les mer\n il a une forme d'aileron et rare \n il se vendra 1 500 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922890922008666122/128.png","rare",new ArrayList<>(){{add(6);add(7);add(8);add(9);}},"00:00:00","23:59:59","Rémora Rayée");
    }

    public static synchronized RemoraRaye getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new RemoraRaye();
        }
        return singleton;
    }
}
