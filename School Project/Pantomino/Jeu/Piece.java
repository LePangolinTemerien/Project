import java.util.ArrayList;
import java.io.*;

/**
*Class qui permet de crée les pièce en ouvrant les fichiers 
*texte correspondant à la piece
*/
public class Piece implements Serializable{

    /**
    *coordonée x de la piece
    */
    private int x;
    /**
    *coordonée y de la piece
    */
    private int y;
    /**
    *Liste de carrée de la piece
    */
    private ArrayList<Carre> listeCarre = new ArrayList<Carre>();
    /**
    *Lettre de la piece
    */
    private char lettre;

    /**
     *Constructeur de la class piece
     *@param fich : nom du fichier txt comprenant la piece
     *@param l : lettre de la piece a crée
     *@throws IOException : remonter si le fichier de la piece n'est pas trouvé
     */
    public Piece(String fich, char l) throws IOException{
        BufferedReader lecteur = new BufferedReader(new FileReader(fich));
        String ligne;
        int nbligne= 0;          //y
        while((ligne = lecteur.readLine()) != null){

            int nbcharactere = 0;    //x
            for (int i=0;i<ligne.length(); i++){
                char ch= ligne.charAt(i);
                char htag= '#';

                if (ch==htag) {
                    Carre c = new Carre(nbcharactere,nbligne);
                    this.setListeCarre(c);
                    nbcharactere ++;
                }else{
                    nbcharactere ++;
                }
            }
            nbligne ++;

        }
        lecteur.close();
        this.lettre= l;
    }

    /**
    *getteur de la lettre
    *@return lettre de la piece
    */
    public char getLettre(){
      return this.lettre;
    }

    /**
    *setteur 
    *@param  car : ajoute des carrée a la liste
    */
    public void setListeCarre(Carre car){
      listeCarre.add(car);
    }

    /**
    *getteur
    *@return la liste des carrée
    */
    public ArrayList<Carre> getCarreListe(){
      return this.listeCarre;
    }

    /**
    *setteur
    *@param x : paramètre x de la piece
    */
    public void setX(int x) {
        this.x = x;
    }

    /**
    *setteur
    *@param y : paramètre y de la piece
    */
    public void setY(int y) {
        this.y = y;
    }

    /**
    *getteur
    *@return paramètre x de la piece
    */
    public int getX() {
        return x;
    }

    /**
    *getteur
    *@return y : paramètre y de la piece
    */
    public int getY() {
        return y;
    }
}
