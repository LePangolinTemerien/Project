import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {

    private final ArrayList<String> listRepas;

    private String titre;


    public Menu(){
        this.listRepas = new ArrayList<String>();
    }

    public void addListe(String s){
        listRepas.add(s);
    }

    public void addListeDeb(String s){
        listRepas.add(0,s);
    }
    public ArrayList<String> getListRepas() {
        return listRepas;
    }

    public MessageEmbed affichage(){
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(this.titre);
        embedBuilder.setDescription(this.toString());
        embedBuilder.setColor(new Color(135,206,250));
        return embedBuilder.build();
    }

    public String toString(){
        String res = "";
        for(int i = 1; i<listRepas.size();i++){
            res+=listRepas.get(i)+"\n\n";
        }
        return res;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getTaille(){
        return listRepas.size();
    }
}
