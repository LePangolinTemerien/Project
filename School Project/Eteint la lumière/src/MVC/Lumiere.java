/**
 * @author TISSERANT Paul , SCHLOESSER Adrien
 */
package MVC;

import java.util.Observable;

/**
 * Classe representant les lumières
 */
public class Lumiere{
    /**
     * boolean qui indique si la lumière est allumée ou non
     */
    private boolean allume;
    /**
     * position de la lumière
     */
    private int posX, posY;

    /**
     * contructeur qui initialise allmue a false(eteint) et la position en 0, 0.
     */
    public Lumiere(){
        this.allume = false;
        this.posX = 0;
        this.posY = 0;
    }

    /**
     * setteur permettant de changer l'êtat de la lumière
     * @param allume : booleen qui change l'etat de la lumiere
     */
    public void setAllume(boolean allume) {
        this.allume = allume;
    }

    /**
     * methode permettant de savoir l'êtat de la lumière
     * @return boolean
     */
    public boolean isAllume() {
        return allume;
    }

    /**
     * getteur
     * @return abscisse de la lumière
     */
    public int getPosX() {
        return posX;
    }

    /**
     * getteur
     * @return ordonnée de la lumière
     */
    public int getPosY() {
        return posY;
    }

    /**
     * setteur permettant de changer l'emplacement
     * @param posX position ou déplacer
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * setteur permettant de changer l'emplacement
     * @param posY position ou déplacer
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }
}
