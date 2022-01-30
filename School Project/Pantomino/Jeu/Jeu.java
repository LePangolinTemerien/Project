import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class principal qui va gérer essentiellement
 * la création du jeu ainsi que sa sauvegarde et son chargement
 */
public  class Jeu implements Serializable {

    /**
     * Liste des joueur du jeu
     */
    private  ArrayList<Joueur> listeJoueur;

    public Jeu(){
        this.listeJoueur =new ArrayList<Joueur>();
    }

    /**
     * création des joueurs
     * @param n , nom du joueur
     * @param ni , niveeau du joueur
     * @throws IOException : remonter si le constructeur de joueur n'as pas pu crée de partie
     */
    public  void creeJoueur(String n, int ni) throws  IOException {
        Joueur j = null;
            if (ni == 1) {
                j = new JoueurDebutant(n);
            } else if (ni == 2) {
                j = new JoueurIntermediaire(n);
            } else if (ni == 3) {
                j = new JoueurAvance(n);
            }
        listeJoueur.add(j);
    }

    /**
     * Methode qui permet de démarer la partie et propose plusieurs choix à l'uttilisateur
     * @throws IOException : exception remonter lorsque le fichier n'est pas trouver
     * @throws ClassNotFoundException : excpetion remonter lorsque  la class n'est pas trouvé
     */
    public void demmarer() throws IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        boolean arret = false;
        int res;
        while (!arret) {
            this.afficher();
            System.out.println("0 : Arrêt du jeu | 1 : Choisir un joueur et jouer | 2 : Crée un nouveau joueur | 3 : Supprimer Joueur");
            res = sc.nextInt();
            if (res == 1 && this.listeJoueur.size() == 0) {
                System.out.println("Créez d'abord un joueur !");
            } else {
                switch (res) {
                    case 0:
                        arret = true;
                        System.out.println("A bientot !");
                        break;
                    case 1:
                        System.out.println(" ");
                        System.out.print("Entrez le numéro se situant devant le joueur : ");
                        int num = sc.nextInt();
                        if (num < 0 || num > this.listeJoueur.size()) {
                            if (num < 0) {
                                System.out.println("Crée d'abord un joueur !");
                            } else if (num > this.listeJoueur.size()) {
                                System.out.println("Ce joueur n'existe pas !");
                            }
                        } else {
                            Joueur joueur = this.listeJoueur.get(num);
                            arret = joueur.jeu();
                        }
                        break;
                    case 2 :
                        System.out.println(" ");
                        System.out.print("Entrez votre nom : ");
                        String nom = sc.next();
                        System.out.print("Entrez votre niveau (1 : Débutant | 2 : intermédiaire | 3 : Avance)  : ");
                        int ni = sc.nextInt();
                        if (ni < 0 || ni > 3) {
                            System.out.println("Mauvaise donnée, création du joueur impossible");
                        } else {
                            this.creeJoueur(nom, ni);
                            System.out.println("Joueur crée !");
                        }
                        break;
                    case 3:
                        System.out.println(" ");
                        System.out.print("Saisissez le numéro du joueur a supprimer : ");
                        int i = sc.nextInt();
                        if (this.listeJoueur.size() == 0 || i>listeJoueur.size()) {
                            System.out.println("Il n'y a aucun joueur à supprimer !");
                        } else {
                            this.listeJoueur.remove(i);
                            System.out.println(" ");
                            System.out.println("Joueur supprimer !");
                        }
                    default:
                        break;
                }
            }
        }
        this.sauve();
    }

    /**
     * Souvegarde
     * @throws IOException : exception lorsque le fichier n'est pas trouver
     */
    public void sauve() throws IOException{
        System.out.println("Sauvegarde en cours !");
        ObjectOutputStream sauv = new ObjectOutputStream(new FileOutputStream("sauvegarde.bin"));
        sauv.writeObject(this);
        sauv.close();
    }

    /**
     * charge d'une sauvegarde
     * @return : le fichier jeu contenu dans le fichier de sauvegarde ou bien un nouveau jeu lorsque le fichier de sauvegarde n'est pas trouvé
     * @throws IOException : exception remonter si on ne trouve pas le fichier
     * @throws ClassNotFoundException : excpetion remonter lorsque on ne trouve pas la classe
     */
    public static Jeu charge() throws IOException, ClassNotFoundException{
        File f = new File("sauvegarde.bin");
        if(!f.exists()){
            f.createNewFile();
            System.out.println("Fichier de sauvegarde non trouvé ! Création d'un nouveau Jeu !");
            Jeu j = new Jeu();
            return j;
        }
        System.out.println("Chargement de votre fichier !");
        ObjectInputStream charge = new ObjectInputStream(new FileInputStream("sauvegarde.bin"));
        Jeu j = (Jeu)(charge.readObject());
        charge.close();
        return j;
    }

    /**
     * triage par nom
     */
    public  void trierListe(){
        listeJoueur.sort(Joueur.ComparateurNom);
    }

    /**
     * triage par score
     */
    public  void trierScore(){
        listeJoueur.sort(Joueur.ComparateurScore);
    }

    /**
     *
     */
    public void afficher(){
        System.out.println(" ");
        System.out.println("//////////////////////////////");
        System.out.println(" ");
        if(listeJoueur.size() == 0){
            System.out.println("Aucun Joueur n'est enregistrer");
        }else {
            System.out.println("Liste des joueurs :");
            this.trierListe();
            for (int i = 0; i < listeJoueur.size(); i++) {
                System.out.println(i + " : " + listeJoueur.get(i));
            }
            System.out.println("Classement des joueurs :");
            this.trierScore();
            for(int j = 0; j<listeJoueur.size(); j++){
                System.out.println(j + " : " + listeJoueur.get(j));
            }
        }
        System.out.println(" ");
        System.out.println("//////////////////////////////");
        System.out.println(" ");
    }

    /**
     * Main
     * @param args : argument
     */
    public static void main(String[] args) {
        try {
            Jeu j = Jeu.charge();
            j.demmarer();
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
