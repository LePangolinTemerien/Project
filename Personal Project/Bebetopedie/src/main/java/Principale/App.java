rpackage Principale;

import Insecte.*;
import Poisson.*;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class App extends ListenerAdapter implements Serializable{

    private static final ArrayList<Creature> creatures = new ArrayList<>();
    private int i;
    private static int iToutPoisson;
    private int poisson;
    private long idMessagePoisson;
    private long idMessageToutPoisson;
    private int reactBasePoisson;
    private static int poissonDispo;
    private transient MessageReceivedEvent messageReceivedEvent;
    private HashMap<String,ArrayList<Creature>> poissonPosseder;
    private boolean nouveau;

    public App() throws IOException {
        poissonPosseder = new HashMap<>();
        i = 0;
        iToutPoisson = 0;
        reactBasePoisson = 0;
        poissonDispo = 1;
        poisson =1;
        nouveau = true;
    }

    private static void remplir() throws ParseException {
        creatures.add(Bouviere.getSingleton());
        creatures.add(Anchois.getSingleton());
        creatures.add(PoissonPorcEpic.getSingleton());
        creatures.add(Arapaima.getSingleton());
        creatures.add(Arowana.getSingleton());
        creatures.add(Ayu.getSingleton());
        creatures.add(Bar.getSingleton());
        creatures.add(BarCommun.getSingleton());
        creatures.add(Bichir.getSingleton());
        creatures.add(Brochet.getSingleton());
        creatures.add(Calamar.getSingleton());
        creatures.add(Carangue.getSingleton());
        creatures.add(Carassin.getSingleton());
        creatures.add(Cardeau.getSingleton());
        creatures.add(Crapet.getSingleton());
        creatures.add(CarpeKoi.getSingleton());
        creatures.add(Chevaine.getSingleton());
        creatures.add(Chinchard.getSingleton());
        creatures.add(Clione.getSingleton());
        creatures.add(Coelacanthe.getSingleton());
        creatures.add(Combattant.getSingleton());
        creatures.add(Coryphene.getSingleton());
        creatures.add(CrabeChinois.getSingleton());
        creatures.add(Araignee.getSingleton());
        creatures.add(Carpet.getSingleton());
        creatures.add(CyprinDore.getSingleton());
        creatures.add(DaiYu.getSingleton());
        creatures.add(Dorado.getSingleton());
        creatures.add(Ecrevisse.getSingleton());
        creatures.add(Eperlan.getSingleton());
        creatures.add(Esturgeon.getSingleton());
        creatures.add(FonduleBarre.getSingleton());
        creatures.add(Gar.getSingleton());
        creatures.add(Gobie.getSingleton());
        creatures.add(GrandRequinBlanc.getSingleton());
        creatures.add(Grenouille.getSingleton());
        creatures.add(Guppy.getSingleton());
        creatures.add(Hippocampe.getSingleton());
        creatures.add(Limande.getSingleton());
        creatures.add(LocheDEtang.getSingleton());
        creatures.add(LuneDeMer.getSingleton());
        creatures.add(Macropina.getSingleton());
        creatures.add(MarlinBleu.getSingleton());
        creatures.add(Murene.getSingleton());
        creatures.add(MureneRubanBleu.getSingleton());
        creatures.add(Napoleon.getSingleton());
        creatures.add(NeonBleu.getSingleton());
        creatures.add(Omble.getSingleton());
        creatures.add(PercheJaune.getSingleton());
        creatures.add(Piranha.getSingleton());
        creatures.add(PoissonArcEnCiel.getSingleton());
        creatures.add(PoissonChirurgien.getSingleton());
        creatures.add(PoissonDocteur.getSingleton());
        creatures.add(PoissonLanterne.getSingleton());
        creatures.add(PoissonRouge.getSingleton());
        creatures.add(PoissonAnge.getSingleton());
        creatures.add(PoissonBallon.getSingleton());
        creatures.add(PoissonClown.getSingleton());
        creatures.add(PoissonPapillion.getSingleton());
        creatures.add(PoissonRuban.getSingleton());
        creatures.add(PoissonScorpion.getSingleton());
        creatures.add(Raie.getSingleton());
        creatures.add(Ranchu.getSingleton());
        creatures.add(RemoraRaye.getSingleton());
        creatures.add(RequinMarteau.getSingleton());
        creatures.add(RequinScie.getSingleton());
        creatures.add(RequinBaleine.getSingleton());
        creatures.add(Saumon.getSingleton());
        creatures.add(SaumonMasou.getSingleton());
        creatures.add(SaumonRoi.getSingleton());
        creatures.add(Scarus.getSingleton());
        creatures.add(Silure.getSingleton());
        creatures.add(Tetard.getSingleton());
        creatures.add(TeteDeSerpent.getSingleton());
        creatures.add(Thon.getSingleton());
        creatures.add(Tilapia.getSingleton());
        creatures.add(TortueSerpentine.getSingleton());
        creatures.add(TortueTryonix.getSingleton());
        creatures.add(TruiteDroree.getSingleton());
        creatures.add(Vandoise.getSingleton());
        creatures.add(Vivaneau.getSingleton());
    }

    private void edit(MessageChannel channel, long id) throws ParseException, IOException {
        channel.deleteMessageById(id).queue();
        this.afficherPoisson(this.messageReceivedEvent);
        this.reactBasePoisson = 0;
    }

    private void editToutPoisson(MessageChannel channel, long id) throws ParseException, IOException {
        channel.deleteMessageById(id).queue();
        this.afficherToutPoisson(this.messageReceivedEvent);
        this.reactBasePoisson = 0;
    }

    private void afficherPoisson(@NotNull MessageReceivedEvent event) throws ParseException, IOException {
            MessageEmbed m = null;
            if(creatures.get(i).estDisponible() && creatures.get(i) instanceof Poisson){
                try {
                    m = creatures.get(i).createMesage().build();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(m != null){
                    event.getChannel().sendMessageEmbeds(m).queue(message -> {
                        idMessagePoisson = message.getIdLong();
                        message.addReaction("U+2B05").queue();
                        message.addReaction("U+27A1").queue();
                        message.addReaction("U+2705").queue();
                        //message.addReaction("U+274E").queue();
                    });
                }
            }
            this.sauve();
    }

    private void afficherToutPoisson(@NotNull MessageReceivedEvent event) throws IOException {
        MessageEmbed m = null;
            try {
                m = creatures.get(iToutPoisson).createMesageTout().build();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            if(m != null){
                event.getChannel().sendMessageEmbeds(m).queue(message -> {
                    idMessageToutPoisson = message.getIdLong();
                    message.addReaction("U+2B05").queue();
                    message.addReaction("U+27A1").queue();
                });
            }

        this.sauve();
    }

    public void ajouterCreaturePosseder(User user, Creature creature) throws IOException {
        if(creature instanceof Poisson){
            String u = user.toString();
            if(poissonPosseder.containsKey(u)){
                ArrayList<Creature> c = poissonPosseder.get(u);
                if(!c.contains(creature)){
                    c.add(creature);
                }
                poissonPosseder.put(u,c);
            }else{
                ArrayList<Creature> c = new ArrayList<>();
                c.add(creature);
                poissonPosseder.put(u,c);
            }
        }
        this.sauve();
    }

    public void envoyerLesPoisson(User user){
        String u = user.toString();
        if(poissonPosseder.containsKey(u)){
            ArrayList<Creature> c = poissonPosseder.get(u);
            EmbedBuilder embedBuilder = new EmbedBuilder();
            String t = "Poisson posséder : ("+c.size()+"/80)";
            byte[] b  = t.getBytes(StandardCharsets.ISO_8859_1);
            embedBuilder.setTitle(new String(b,StandardCharsets.UTF_8));
            String rs = "";
            for(Creature creature : c){
                String r = creature.getRarete();
                if(creature.getRarete().equals("trare")){
                    r = "très rare";
                }
                rs+=creature.getNom()+" : "+r+"\n";
            }
            byte[] d = rs.getBytes(StandardCharsets.ISO_8859_1);
            embedBuilder.setDescription(new String(d,StandardCharsets.UTF_8));
            embedBuilder.setColor(new Color(135, 206, 250));
            MessageEmbed msg = embedBuilder.build();
            TextChannel channel = messageReceivedEvent.getGuild().getTextChannelById(891358994080354366L);
            assert channel != null;
            channel.sendMessageEmbeds(msg).queue();
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        this.messageReceivedEvent = event;
        if(event.getMessage().getContentRaw().equals("!poisson")){
            this.reactBasePoisson = 0;
            try {
                this.afficherPoisson(event);
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }else if(event.getMessage().getContentRaw().equals("!mesPoisson")){
            this.envoyerLesPoisson(event.getAuthor());
        }else if(event.getMessage().getContentRaw().equals("!reload")){
            long id = event.getMessageIdLong();
            event.getChannel().deleteMessageById(id).queue();
            this.messageReceivedEvent = event;
        }else if(event.getMessage().getContentRaw().equals("!ToutPoisson")){
            try {
                this.reactBasePoisson = 0;
                this.afficherToutPoisson(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onGenericMessageReaction(@NotNull GenericMessageReactionEvent event) {
        if (event.getMessageIdLong() == idMessagePoisson && reactBasePoisson == 3) {
            if (event.getReaction().getReactionEmote().toString().equals("RE:U+2b05")) {
                i--;
                if (i < 0) {
                    i = creatures.size() - 1;
                }
                poissonDispo--;
                if (poissonDispo < 1) {
                    try {
                        poissonDispo = App.getTaillePoisson();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    if (!creatures.get(i).estDisponible()) {
                        while (!creatures.get(i).estDisponible()) {
                            i--;
                            if (i < 0) {
                                i = creatures.size() - 1;
                            }
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (event.getReaction().getReactionEmote().toString().equals("RE:U+27a1")) {
                i++;
                if (i > creatures.size() - 1) {
                    i = 0;
                }
                poissonDispo++;
                try {
                    if (poissonDispo > App.getTaillePoisson()) {
                        poissonDispo = 1;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    if (!creatures.get(i).estDisponible()) {
                        while (!creatures.get(i).estDisponible()) {
                            i++;
                            if (i > creatures.size() - 1) {
                                i = 0;
                            }
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (event.getReaction().getReactionEmote().toString().equals("RE:U+2705")) {
                try {
                    this.ajouterCreaturePosseder(event.getUser(), creatures.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                this.edit(event.getChannel(), idMessagePoisson);
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
            try {
                this.sauve();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getMessageIdLong() == idMessageToutPoisson && reactBasePoisson == 3) {
            if (event.getReaction().getReactionEmote().toString().equals("RE:U+2b05")) {
                iToutPoisson--;
                if (iToutPoisson < 0) {
                    iToutPoisson = creatures.size() - 1;
                }
                poisson--;
                if (poisson < 1) {
                    poissonDispo = App.getTailleToutPoisson();
                }
                if (!(creatures.get(iToutPoisson) instanceof Poisson)) {
                    while (!(creatures.get(iToutPoisson) instanceof Poisson)) {
                        iToutPoisson--;
                        if (iToutPoisson < 0) {
                            iToutPoisson = creatures.size() - 1;
                        }
                    }
                }
            }else if (event.getReaction().getReactionEmote().toString().equals("RE:U+27a1")) {
                iToutPoisson++;
                if (iToutPoisson > creatures.size() - 1) {
                    iToutPoisson = 0;
                }
                poisson++;
                if (poisson > App.getTailleToutPoisson()) {
                    poisson = 1;
                }
                if (!(creatures.get(iToutPoisson) instanceof Poisson)) {
                    while (!(creatures.get(iToutPoisson) instanceof Poisson)) {
                        iToutPoisson++;
                        if (iToutPoisson > creatures.size() - 1) {
                            iToutPoisson = 0;
                        }
                    }
                }
            }
            try {
                this.editToutPoisson(event.getChannel(), idMessageToutPoisson);
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
            try {
                this.sauve();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            this.reactBasePoisson++;
        }
    }

    public void setNouveau(boolean nouveau) {
        this.nouveau = nouveau;
    }

    public boolean isNouveau() {
        return nouveau;
    }

    public static int getPoissonDispo() {
        return poissonDispo;
    }

    public static int getiToutPoisson() {
        return iToutPoisson;
    }

    public static int getTailleToutPoisson(){
        int it = 0;
        for(Creature p : creatures){
            if(p instanceof Poisson){
                it++;
            }
        }
        return it;
    }

    public static int getTaillePoisson() throws ParseException {
        int it = 0;
        for(Creature p : creatures){
            if(p instanceof Poisson && p.estDisponible()){
                it++;
            }
        }
        return it;
    }

    public void sauve() throws IOException{
        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("sauv.bin"));
        oos.writeObject(this);
        oos.close();
    }

    public static App charge() throws IOException, ClassNotFoundException {
        File f = new File("sauv.bin");
        if(!f.exists()){
            f.createNewFile();
            return new App();
        }
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("sauv.bin"));
        App a = (App) (ooi.readObject());
        a.setNouveau(false);
        ooi.close();
        return a;
    }

    public static void onReload(TextChannel channel){
        channel.sendMessage("!reload").queue();
    }


    public static void main(String[] args) throws LoginException, ParseException, IOException, ClassNotFoundException, InterruptedException {
        JDABuilder jda = JDABuilder.createDefault(args[0]);
        jda.disableCache(CacheFlag.MEMBER_OVERRIDES,CacheFlag.VOICE_STATE);
        App a = App.charge();
        App.remplir();
        jda.addEventListeners(a);
        jda.setActivity(Activity.playing("Making Snowman"));
        JDA j = jda.build();
        j.awaitReady();
        TextChannel textChannel = j.getTextChannelById(891358994080354366L);
        assert textChannel != null;
        App.onReload(textChannel);
    }
}
