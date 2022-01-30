import  java.util.ArrayList;
import java.io.*;
import java.util.Random;

/**
 * Class qui gèrent le placement des pièces dans la grille
 * ainsi que le fais de les retirées
 */
public class Partie implements Serializable{

    /**
     * grille de la partie
     */
    private char[][] grille = new char[10][10];
    /**
     * Liste des piece posée sur la grille de la partie
     */
    private ArrayList<Piece> piecePosee = new ArrayList<Piece>();
    /**
     * Liste des futur pièce a posée de la partie
     */
    private ArrayList<Piece> pieceFutur = new ArrayList<Piece>();

    /**
     * constructeur vide
     * @throws IOException
     * création de la grille
     * choix au hasard de pièces
     */
    public Partie() throws  IOException{
        for(int i = 0; i< grille.length; i++){
            for(int j = 0; j< grille[i].length; j++){
                grille[i][j] = '.';
            }
        }
        Random rand = new Random();
        String piece = "FIJLNOPSTUWXYZ";
        String piceN = "";
        while(pieceFutur.size() != 13){
            int k = rand.nextInt(piece.length());
            char l = piece.charAt(k);
            piece = piece.substring(0,k)+piece.substring(k+1);
            Piece p = null;
            switch (l) {
                case 'F':
                    p = new F();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'I':
                    p = new I();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'J':
                    p = new J();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'L':
                    p = new L();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'N':
                    p = new N();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'O':
                    p = new O();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'P':
                    p = new P();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'S':
                    p = new S();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'T':
                    p = new T();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'U':
                    p = new U();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'W':
                    p = new W();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'X':
                    p = new X();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'Y':
                    p = new Y();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                case 'Z':
                    p = new Z();
                    if (!pieceFutur.contains(p)) {
                        pieceFutur.add(p);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * methode permettant d'ajouter des pièces a la grille
     * @param x : coordonée x de la piece
     * @param y : coordonée y de la piece
     * @param n : numéro de la piece
     * @return max
     * @throws CaseDejaRemplieException : renvoie cette erreur si la piece est placé sur une même piece
     * @throws PieceDebordeException : renvoie cette erreur si la piece sort de la grille
     */
    public int ajouterPiece(int x, int y, int n)throws CaseDejaRemplieException, PieceDebordeException{
        int compt = 0;
        boolean init = false;
        int max  =0;
        Piece p = pieceFutur.get(n);
        ArrayList<Carre> liste = p.getCarreListe();
        for(int i = 0; i<liste.size(); i++){
            max = i;
            Carre c = liste.get(i);
            int h = c.getY() + y;
            int l = c.getX() + x;
            if(!init) {
                p.setX(l);
                p.setY(h);
                init = true;
            }
            if((h<0 || h> grille.length-1)||(l<0 || l>grille.length-1)){
                throw new PieceDebordeException("La piece est en dehors de la grille");
            }else if(grille[h][l] == p.getLettre()) {
                compt++;
                if(compt >= 5){
                    throw new CaseDejaRemplieException("Deux piece ne peuvent pas se superposée");
                }
            }else {
                grille[h][l] = p.getLettre();
            }
        }
        piecePosee.add(pieceFutur.get(n));
        pieceFutur.remove(n);
        pieceFutur.add(p);
        this.actualiserGrille();
        return max;

    }

    /**
     * méthode permettant d'actualiser la grille c.à.d faire apparaître les événement passé
     */
    public void actualiserGrille(){
        System.out.println(" ");
        System.out.println("//Grille//");
        for(int i = 0; i< grille.length; i++){
            for(int j = 0; j< grille[i].length; j++) {
                System.out.print(grille[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("//////////");
        System.out.println(" ");

        for(int i = 0; i<3; i++) {
            Piece p = pieceFutur.get(i);
            ArrayList<Carre> list = p.getCarreListe();
            char[][] base = new char[5][5];
            for(int  y= 0; y< base.length; y++){
                for(int z = 0; z< base[y].length; z++){
                    base[y][z] = '.';
                }
            }
            for(int w = 0; w<list.size(); w++){
                Carre c = list.get(w);
                base[c.getY()][c.getX()] = p.getLettre();
            }
            System.out.println(i+" : Lettre suivante :"+p.getLettre());
            for(int s = 0; s< base.length; s++){
                for(int t = 0; t< base[i].length; t++) {
                    System.out.print(base[s][t]);
                }
                System.out.println(" ");
            }
        }
    }

    /**
     * méthode permettant de retirer une pièce
     * @param x : coordonée x de la piece
     * @param y : coordonée y de la piece
     * @param n : numéro de la piece
     */
    public void retirerPiece(int x, int y, int n){
        Piece p = pieceFutur.get(n);
        ArrayList<Carre> liste = p.getCarreListe();
        for(int i = 0; i<liste.size(); i++) {
            Carre c = liste.get(i);
            int h = c.getY() + y;
            int l = c.getX() + x;
            p.setX(0);
            p.setY(0);
            if(l < 0){
                l=0;
            }else if(l>9){
                l=9;
            }
            if(h<0){
                h=0;
            }else if(h>9){
                h=9;
            }
            grille[h][l] = '.';
        }
        this.actualiserGrille();
        pieceFutur.remove(p);
        pieceFutur.add(p);
    }

    /**
     * méthode permettant de réinitialiser la grille
     */
    public void reset(){
        for(int i = 0; i< grille.length; i++){
            for(int j = 0; j< grille[i].length; j++){
                grille[i][j] = '.';
            }
        }
        this.actualiserGrille();
    }

    /**
     * getteur
     * @return grille
     */
    public char[][] getGrille() {
        return grille;
    }

}
