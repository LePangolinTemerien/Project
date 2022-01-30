import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Class qui gèrent les interaction du joueur lié
 * à la difficulté Debutant
 */
public class JoueurDebutant extends Joueur implements Serializable {

    /**
     * constructeur
     * @param n nom du joueur
     * @throws IOException : remonte cette erreur à l'initialisation de la liste de la partie si les piece comprenant cette partie n'ont pas pu être crée
     */
    public JoueurDebutant(String n) throws IOException {
        super(n);
    }

    /**
     * methode toString
     * @return string renseignant les infos sur le joueur débutant
     */
    public String toString(){
        return " "+this.getNom()+"   (Score : "+this.getScore()+")";
    }

    /**
     * methode vérifiant les régles de l'énoncé pour les joueurs avancé
     * @param x abscisse de la pièce
     * @param y ordonnée de la pièce
     * @param n numéro de la piece
     */
    public void gererException(int x, int y, int n){
        int max = 0;
        if(x<0){
            x=0;
        }else if(x>=9){
            x=9;
        }
        if(y<0){
            y=0;
        }else if(y>=9){
            y=9;
        }
        ArrayList<Partie> liste = this.getListePartie();
        Partie p =  liste.get(0);
        try {
            p.ajouterPiece(x,y,n);
        }catch(CaseDejaRemplieException ca){
            System.out.println("Deux même piece se superpose !");
            p.actualiserGrille();
        }catch(PieceDebordeException pi){
            System.out.println("La pièce dépasse de la grille !");
            p.actualiserGrille();
        }
        this.setScore(0.25);

    }
}