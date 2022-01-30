/**
 * @author TISSERANT Paul , SCHLOESSER Adrien
 */
package MVC;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue sur la grille de lumière
 */
public class VueLumiere extends JPanel implements Observer {
    /**
     * Tableau de lumière
     */
    private TabLumiere tabLum;

    /**
     * constructeur qui crée un tableau de lumiere
     */
    public VueLumiere(){
        this.tabLum = new TabLumiere();
    }

    /**
     * méthode détectant si le joueur a fini (éteint toutes les lumières)
     * @return : boolean qui indique l'êtat
     */
    public boolean fini (){
        boolean res = true;
        for(int i = 0; i< tabLum.getSize(); i++){
            for(int j = 0; j< tabLum.getSize(); j++) {
                if(tabLum.getTabLum(i,j).isAllume()){
                    res = false;
                }
            }
        }
        return  res;
    }

    /**
     * methode paint component créant le carré vers et la grille
     * @param g : parametre de la classe graphics
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i< tabLum.getSize(); i++){
            for(int j = 0; j< tabLum.getSize(); j++){
                Lumiere l = tabLum.getTabLum(i,j);
                if(!l.isAllume()) {
                    g.setColor(new Color(9, 82, 50));
                }else {
                    g.setColor(Color.green);
                }
                g.fillRect(l.getPosX()*(getWidth()/5),l.getPosY()*(getHeight()/5),(getWidth()/5),(getHeight()/5));
                g.setColor(Color.black);
                g.drawRect(l.getPosX()*(getWidth()/5),l.getPosY()*(getHeight()/5),(getWidth()/5),(getHeight()/5));
            }
        }
        tabLum.setTailleX((getWidth()/5));
        tabLum.setTailleY((getHeight()/5));
    }

    /**
     * méthode uptdate qui fait un repaint lorsque la méthode est appelée
     * @param g : parametre de la classe Observable
     * @param arg : parametre de la classe Object
     */
    @Override
    public void update(Observable g, Object arg) {
        tabLum = (TabLumiere) g;
        repaint();
    }
}
