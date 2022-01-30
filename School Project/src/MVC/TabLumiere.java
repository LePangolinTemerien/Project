/**
 * @author TISSERANT Paul , SCHLOESSER Adrien
 */
package MVC;


import java.util.Observable;
import java.util.Random;

/**
 * Classe representant un tableau de lumière
 */
public class TabLumiere extends Observable {

    /**
     * création d'un tableau a 2 dimensions d'objet lumiere
     */
    private final Lumiere[][] tabLum = new Lumiere[5][5];
    /**
     * taille des carrés
     */
    private int tailleX, tailleY;


    /**
     * constructeur qui rempli de tableau avec des lumières
     * et initialise la taille.
     */
    public TabLumiere(){
        for(int i = 0; i< tabLum.length; i++){
            for(int j = 0; j< tabLum[i].length; j++){
                tabLum[i][j] = new Lumiere();
                tabLum[i][j].setPosX(i);
                tabLum[i][j].setPosY(j);
            }
        }
        tailleX = 50;
        tailleY = 50;
    }

    /**
     * getteur
     * @return taille du tableau de lumiere
     */
    public int getSize(){
        return tabLum.length;
    }

    /**
     * getteur
     * @param i : position i du tableau
     * @param j : position j du tableau dans sa deuxieme dimension
     * @return lumiere à la position i, j.
     */
    public Lumiere getTabLum(int i, int j) {
        return tabLum[i][j];
    }

    /**
     * setteur qui allume une lampe dans le tableau
     * @param i : position i du tableau
     * @param j : position j du tableau dans sa deuxieme dimension
     */
    public void setAllume(int i, int j) {
        if(this.tabLum[i][j].isAllume()) {
            this.tabLum[i][j].setAllume(false);
        }else {
            this.tabLum[i][j].setAllume(true);
        }
        setChanged();
        notifyObservers();
    }

    /**
     * méthode qui allume des lampes aléatoires
     * @param nbFois : nombre de lampes à allumer
     */
    public void aleatoire(int nbFois) {
        for (int i = 0; i < tabLum.length; i++) {
            for (int j = 0; j < tabLum[i].length; j++) {
                tabLum[i][j].setAllume(false);
            }
        }
        Random rand = new Random();
        for (int f = 0; f < nbFois; f++) {
            int i = rand.nextInt(5);
            int j = rand.nextInt(5);
            boolean ok = false;
            while (!ok) {
                if (this.tabLum[i][j].isAllume()) {
                    i = rand.nextInt(5);
                    j = rand.nextInt(5);
                } else {
                    this.tabLum[i][j].setAllume(true);
                    ok = true;
                }
            }
            setChanged();
            notifyObservers();
        }
    }

    /**
     * methode qui eteint toutes les lumières du tableau
     */
    public void remiseAZero(){
        for (int i = 0; i < tabLum.length; i++) {
            for (int j = 0; j < tabLum[i].length; j++) {
                tabLum[i][j].setAllume(false);
            }
        }
        setChanged();
        notifyObservers();
    }

    /**
     * setteur qui change tailleX
     * @param tailleX : Nouvelle taille X
     */
    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
        setChanged();
        notifyObservers();
    }

    /**
     * setteur qui change tailleY
     * @param tailleY :  nouvelle taille Y
     */
    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
        setChanged();
        notifyObservers();
    }

    /**
     * getteur
     * @return tailleX
     */
    public int getTailleX() {
        return tailleX;
    }

    /**
     * getteur
     * @return tailleY
     */
    public int getTailleY() {
        return tailleY;
    }
}
