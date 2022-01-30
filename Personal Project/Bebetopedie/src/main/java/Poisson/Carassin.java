package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class Carassin extends Creature implements Poisson, Serializable {
    private static Carassin singleton;
    private Carassin() throws ParseException {
        super("Le Carassin est disponible toute l'année 24h/24h dans les rivières\n il est petit et plutôt commun\n il se vendra 160 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922532783467925554/128.png","commun",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"00:00:00","23:59:59","Carassin");
    }

    public static synchronized Carassin getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new Carassin();
        }
        return singleton;
    }
}
