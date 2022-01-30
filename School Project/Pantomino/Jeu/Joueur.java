import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Class qui gèrent les interaction effectué par le joueur
 * elle est abstraite et sera complété par les différentes
 * difficulté
 */
public abstract class Joueur implements Serializable {

    /**
     * nom du joueur
     */
    private String nom;
    /**
     * Liste des parties du joueur
     */
    private ArrayList<Partie> listePartie = new ArrayList<Partie>();
    /**
     * Score du joueur
     */
    private double score;

    /**
     * constructeur
     * créer une partie
     * met le score a 0
     * @param n , nom du joueur
     * @throws IOException : remonte cette erreur à l'initialisation de la liste de la partie si les piece comprenant cette partie n'ont pas pu être crée
     */
    public Joueur(String n) throws IOException {
        this.nom = n;
        this.listePartie.add(new Partie());
        this.score= 0;
    }

    /**
     * méthode jeu qui gère le déroulement de la partie du joueur
     * @return boolean qui indique si la partie est terminée ou si on y a mis fin
     * @throws IOException : renvoie une exception si la partie n'as pas pu être crée dans le cas ou on en crée une
     */
    public boolean jeu() throws  IOException{
        Scanner sc = new Scanner(System.in);
        ArrayList<Partie> listePartie = this.getListePartie();
        System.out.println("Vous avez "+listePartie.size()+" parties !");;
        System.out.println(" ");
        System.out.println("Voulez vous créer une nouvelle partie : 1 : OUI | 2 : NON");
        int t = sc.nextInt();
        while(t != 2){
            if(t == 1){
                listePartie.add(new Partie());
                System.out.println("Voulez vous en ajouter une autre ? 1 : OUI | 2 : NON");
                t = sc.nextInt();
            }
        }
        System.out.println("Vous avez "+listePartie.size()+" parties !");
        System.out.println("Mettez le numéro de la partie voulue entre 0 et "+(listePartie.size()-1));
        int m = sc.nextInt();
        Partie partie = listePartie.get(m);
        partie.actualiserGrille();
        boolean arret = false;
        boolean arretpartie = false;
        while (!arretpartie) {
            System.out.println(" ");
            System.out.println("0 : Arrêt du jeu | 1 : Pose de piece | 2: Reset de la grille | 3 : Retour au menu principal");
            int res2 = sc.nextInt();
            switch (res2) {
                case 0:
                    arretpartie = true;
                    arret = true;
                    System.out.println("A bientot !");
                    break;
                case 1:
                    System.out.println(" ");
                    System.out.println("Entrez le coordonnée x");
                    int x = sc.nextInt();
                    System.out.println("Entrez le coordonnée y");
                    int y = sc.nextInt();
                    System.out.println("Entrez le numéro de la piece");
                    int n = sc.nextInt();
                    if (n > 2) {
                        System.out.println("Posez d'abord ces pieces avant les autres !");
                    } else {
                        this.gererException(x, y, n);
                    }
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Grille remis a Zero !");
                    partie.reset();
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println("Retour au menu principal !");
                    arretpartie = true;
                    break;
                default:
                    System.out.println("Ce n'est pas une option ça...");
                    break;
            }
        }
        return arret;
    }

    /**
     * getteur
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * methode toString
     * @return string contenant les infos du joueur
     */
    public String toString(){
        return " "+this.getNom()+"   (Score : "+this.getScore()+")";
    }

    /**
     * methode abstract qui permet la pose de pièce en fonction des difficulté
     * @param x abscisse de la pièce
     * @param y ordonnée de la pièce
     * @param n numéro de la piece
     */
    public abstract void gererException(int x, int y, int n);

    /**
     * getteur
     * @return listePartie
     */
    public ArrayList<Partie> getListePartie(){
        return listePartie;
    }


    /**
     * Methode qui permet de comparer les joueur en fonction de leurs noms
     */
    public static Comparator<Joueur> ComparateurNom = new Comparator<Joueur>() {
        /**
         *
         * @param s1 , joueur 1 a comparer
         * @param s2 , joueur 2 a comparer
         * @return un entier qui indique si le joueur doit etre placé au dessus ou en dessous en fonction de son nom
         */
        public int compare(Joueur s1, Joueur s2) {
            String Joueur1 = s1.getNom().toUpperCase();
            String Joueur2 = s2.getNom().toUpperCase();

            return Joueur1.compareTo(Joueur2);
        }
    };

    /**
     * methode qui permet de comparer les joueur en fonction de leur score dans l'ordre décroissant
     */
    public static Comparator<Joueur> ComparateurScore = new Comparator<Joueur>() {
        /**
         *
         * @param o1 joueur 1 a comparer
         * @param o2 joueur 2 a comparer
         * @return un entier qui indique si le joueur doit etre placé au dessus ou en dessous en fonction de son score
         */
        public int compare(Joueur o1, Joueur o2) {  // methode retournant @return un entier qui indique si le joueur doit etre placé au dessus ou en dessous enfonction de son score @param deux joueurs à comparer

            return Double.compare(o2.getScore(), o1.getScore());
        }
    };

    /**
     * getteur
     * @return score
     */
    public double getScore() {
        return score;
    }

    /**
     * setteur
     * @param score , score du joueur
     */
    public void setScore(double score) {
        this.score += score;
    }
}