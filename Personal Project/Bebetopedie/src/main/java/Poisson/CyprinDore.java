package Poisson;

import Principale.Creature;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

public class CyprinDore extends Creature implements Poisson, Serializable {
    private static CyprinDore singleton;
    private CyprinDore() throws ParseException {
        super("Le Cyprin Dorée est disponible toute l'année de 9h à 16h dans les étangs\n il est minuscule et très rares\n il se vendra 1 300 clochettes", "https://media.discordapp.net/attachments/922482008750448670/922768088825487391/128.png","trare",new ArrayList<>(){{add(1);add(2);add(3);add(4);add(5);add(6);add(7);add(8);add(9);add(10);add(11);add(12);}},"09:00:00","16:00:00","Cyprin Dorée");
    }

    public static synchronized CyprinDore getSingleton() throws ParseException {
        if(singleton ==  null){
            singleton = new CyprinDore();
        }
        return singleton;
    }
}
