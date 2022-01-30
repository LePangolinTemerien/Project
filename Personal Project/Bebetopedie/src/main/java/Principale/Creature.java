package Principale;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Creature implements Serializable {
    private String nom;
    private String description;
    private String url;
    private String rarete;
    private ArrayList<Integer> mois;
    private Calendar[] heures;

    public Creature(String description, String url, String rarete, ArrayList<Integer> mois, String heure1,String heure2, String nom) throws ParseException {
        this.nom = nom;
        this.description = description;
        this.url = url;
        this.rarete = rarete;
        this.mois = mois;
        this.heures = this.createHeures(heure1,heure2);
    }

    public EmbedBuilder createMesage() throws IOException, ParseException {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        byte[] byteBuffer = this.nom.getBytes(StandardCharsets.ISO_8859_1);
        String str = new String(byteBuffer,StandardCharsets.UTF_8);
        embedBuilder.setTitle(str+"\t("+App.getPoissonDispo()+"/"+App.getTaillePoisson()+")");
        byte[] byteBuffer1 = this.description.getBytes(StandardCharsets.ISO_8859_1);
        embedBuilder.setDescription(new String(byteBuffer1,StandardCharsets.UTF_8));
        embedBuilder.setImage(this.url);
        switch (this.rarete) {
            case "commun" -> embedBuilder.setColor(new Color(135, 206, 250));
            case "rare" -> embedBuilder.setColor(new Color(128, 0, 128));
            case "trare" -> embedBuilder.setColor(new Color(255, 255, 0));
        }
        return embedBuilder;
    }

    public EmbedBuilder createMesageTout() throws IOException, ParseException {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        byte[] byteBuffer = this.nom.getBytes(StandardCharsets.ISO_8859_1);
        String str = new String(byteBuffer,StandardCharsets.UTF_8);
        embedBuilder.setTitle(str+"\t("+App.getiToutPoisson()+"/"+App.getTailleToutPoisson()+")");
        byte[] byteBuffer1 = this.description.getBytes(StandardCharsets.ISO_8859_1);
        embedBuilder.setDescription(new String(byteBuffer1,StandardCharsets.UTF_8));
        embedBuilder.setImage(this.url);
        switch (this.rarete) {
            case "commun" -> embedBuilder.setColor(new Color(135, 206, 250));
            case "rare" -> embedBuilder.setColor(new Color(128, 0, 128));
            case "trare" -> embedBuilder.setColor(new Color(255, 255, 0));
        }
        return embedBuilder;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHeures(Calendar[] heures) {
        this.heures = heures;
    }

    public void setMois(ArrayList<Integer> mois) {
        this.mois = mois;
    }

    public void setRarete(String rarete) {
        this.rarete = rarete;
    }

    public ArrayList<Integer> getMois() {
        return mois;
    }

    public Calendar[] getHeures() {
        return heures;
    }

    public String getRarete() {
        return rarete;
    }

    public String getNom() {
        return nom;
    }

    private Calendar[] createHeures(String heure1, String heure2) throws ParseException {
        Date d = new SimpleDateFormat("HH:mm:ss").parse(heure1);
        Date d1 = new SimpleDateFormat("HH:mm:ss").parse(heure2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE,1);
        Calendar calendar1 =  Calendar.getInstance();
        calendar1.setTime(d1);
        calendar1.add(Calendar.DATE,1);
        return new Calendar[]{calendar, calendar1};
    }

    public boolean estDisponible() throws ParseException {
        boolean res = false;
        Calendar calendar = Calendar.getInstance();
        Integer i = calendar.getTime().getMonth()+1;
        int min = calendar.getTime().getMinutes();
        int s = calendar.getTime().getSeconds();
        int h = calendar.getTime().getHours();
        String heureAct = h + ":" + min + ":" + s;
        Date x = new SimpleDateFormat("HH:mm:ss").parse(heureAct);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(x);
        calendar1.add(Calendar.DATE, 1);
        x = calendar1.getTime();
        if(!this.heures[1].before(this.heures[0])){
            if (this.mois.contains(i) && (x.after(this.heures[0].getTime()) && x.before(this.heures[1].getTime()))) {
                res = true;
            }
        }else{
            String m = "00:00:00";
            Date minuit = new SimpleDateFormat("HH:mm:ss").parse(m);
            if(this.mois.contains(i) && ((x.after(this.heures[0].getTime()) && x.before(minuit)) || x.after(minuit) && x.before(this.heures[1].getTime()))){
                res =true;
            }
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return Objects.equals(nom, creature.nom) && Objects.equals(description, creature.description) && Objects.equals(url, creature.url) && Objects.equals(rarete, creature.rarete) && Objects.equals(mois, creature.mois) && Arrays.equals(heures, creature.heures);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nom, description, url, rarete, mois);
        result = 31 * result + Arrays.hashCode(heures);
        return result;
    }
}

