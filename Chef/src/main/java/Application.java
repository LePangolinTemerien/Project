import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Application extends ListenerAdapter implements Serializable {

    int i = 0;
    private ArrayList<Menu> menus;
    private final Recup recup;

    public Application() throws IOException {
       recup = new Recup();
       menus = new ArrayList<>();
    }


    public void sauve() throws IOException {
        System.out.println("Sauvegarde en cours !");
        ObjectOutputStream sauv = new ObjectOutputStream(new FileOutputStream("sauvegarde.bin"));
        sauv.writeObject(this);
        sauv.close();
    }

    public static Application charge() throws IOException, ClassNotFoundException{
        File f = new File("sauvegarde.bin");
        if(!f.exists()){
            f.createNewFile();
            System.out.println("Fichier de sauvegarde non trouvé ! Création d'un nouveau !");
            return new Application();
        }
        System.out.println("Chargement de votre fichier !");
        ObjectInputStream charge = new ObjectInputStream(new FileInputStream("sauvegarde.bin"));
        Application j = (Application) (charge.readObject());
        charge.close();
        return j;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("!m")) {
            System.out.println("oui");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String s = simpleDateFormat.format(date).toString();
            Menu m = menus.get(0);
            int l =0;
            if(m.getTaille() == 1 || m.getTaille() == 0){
                while ((m.getTaille() == 1) || m.getTaille() == 0 || l == menus.size()-1){
                    l++;
                    m = menus.get(l);
                }
            }
            if (m != null) {
                event.getChannel().sendMessage(m.toString()).queue();
            } else {
                event.getChannel().sendMessage("Le menu est pas dispo , le crous sont des branleurs").queue();
            }
        } else if (event.getMessage().getContentRaw().contains("!m ")) {
            String s = event.getMessage().getContentRaw();
            s = s.replace("!m ", "");
            System.out.println(s);
            int i = Integer.parseInt(s);
            /*
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, i);
            String s1 = simpleDateFormat.format(calendar.getTime());
            */
            Menu m = menus.get(i);
            System.out.println("Taille de la liste : " +m.getTaille());
            int l = i;
            if(m.getTaille() == 1 || m.getTaille() == 0){
                while ((m.getTaille() == 1) || m.getTaille() == 0 || l == menus.size()-1){
                    l++;
                    m = menus.get(l);
                }
            }
            if (l == menus.size()-1) {
                event.getChannel().sendMessage("Le menu est pas dispo , le crous sont des branleurs").queue();
            } else {
                event.getChannel().sendMessage(m.toString()).queue();
            }
        } else if(event.getMessage().getContentRaw().equals("!recup")){
            long messId =  event.getMessage().getIdLong();
            event.getChannel().deleteMessageById(messId).queue();
            try {
                recup.creationMenuMap();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.menus = recup.getMenuMap();
            try {
                this.sauve();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(event.getMessage().getContentRaw().equals("!clearAll789")){
            menus.clear();
        }else if(event.getMessage().getContentRaw().equals("!menuAll")){
            long messId =  event.getMessage().getIdLong();
            event.getChannel().deleteMessageById(messId).queue();
            for(Menu m : menus){
                if((m.getTaille() != 1) && m.getTaille() != 0){
                    event.getChannel().sendMessageEmbeds(m.affichage()).queue();
                }
            }
        }
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public static void main(String[] args) throws LoginException, IOException, ClassNotFoundException {
        JDABuilder builder = JDABuilder.createDefault("ODkxNjkzOTg0MzM2OTY5NzY5.YVCEvA.1t2gIaDbU3UFa_7xKAaLgOq6nFk");
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        Application application = Application.charge();
        builder.addEventListeners(application);
        builder.build();
    }


}
