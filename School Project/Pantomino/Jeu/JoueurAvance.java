import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Class qui gèrent les interaction du joueur lié
 * à la difficulté Avance
 */
public class JoueurAvance extends Joueur implements Serializable {
    /**
     * constructeur
     * @param n : nom du joueur
     * @throws IOException : remonte cette erreur à l'initialisation de la liste de la partie si les piece comprenant cette partie n'ont pas pu être crée
     */
    public JoueurAvance(String n) throws  IOException {
        super(n);
    }

    /**
     * methode toString
     * @return string renseignant les infos sur le joueur avancé
     */
    public String toString(){
        return " "+this.getNom()+"   (Score : "+this.getScore()+")";
    }

    /**
     * methode vérifiant les régles de l'énoncé pour le joueurs avancé
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
            max = p.ajouterPiece(x,y,n);
        }catch(CaseDejaRemplieException e){
            System.out.println("Deux même piece se superpose !");
            p.retirerPiece(x,y,n);
            p.actualiserGrille();
            this.setScore(-1);

        }catch(PieceDebordeException t){
            System.out.println("La pièce dépasse de la grille !");
            p.retirerPiece(x,y,n);
            this.setScore(-1);
        }
        this.setScore(1);
    }
}
