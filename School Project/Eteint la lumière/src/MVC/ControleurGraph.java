/**
 * @author TISSERANT Paul , SCHLOESSER Adrien
 */
package MVC;

import Interface.*;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Controleur de la grille de lumière
 */
public class ControleurGraph extends MouseInputAdapter {

    /**
     * tableau de lumières
     */
    private TabLumiere tabLumiere;
    /**
     * objet Boutons
     */
    private Boutons boutons;


    /**
     * constructeur qui initialise les deux attributs
     * @param lumieres : Tableau de lumière qui va être modifié
     * @param b : bouton qui va agir sur le controleur
     */
    public ControleurGraph(TabLumiere lumieres, Boutons b){
        this.tabLumiere = lumieres;
        this.boutons = b;
    }

    /**
     * methodes détectant l'evenement clique avec la position et change l'êtat de la lumière
     * @param e : Evenement de la souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (boutons.isConfiguration() || boutons.isJeu()) {
            super.mouseClicked(e);
            int posX = e.getX() / tabLumiere.getTailleX();
            int posY = e.getY() / tabLumiere.getTailleY();
            System.out.println(posY);
            tabLumiere.setAllume(posX, posY);
            if (!boutons.isConfiguration()) {
                int tmpX = posX - 1;
                int tmpY = posY - 1;
                if (tmpX > -1) {
                    tabLumiere.setAllume(tmpX, posY);
                }
                if (tmpY > -1) {
                    tabLumiere.setAllume(posX, tmpY);
                }
                tmpX = posX + 1;
                tmpY = posY + 1;
                if (tmpX < tabLumiere.getSize()) {
                    tabLumiere.setAllume(tmpX, posY);
                }
                if (tmpY < tabLumiere.getSize()) {
                    tabLumiere.setAllume(posX, tmpY);
                }
            }
            if(boutons.isJeu()) {
                boutons.setNbDeplacements();
            }

            if(boutons.isJeu()){
                boolean res = true;
                for(int i = 0; i< tabLumiere.getSize(); i++){
                    for(int j = 0; j< tabLumiere.getSize(); j++) {
                        if(tabLumiere.getTabLum(i,j).isAllume()){
                            res = false;
                        }
                    }
                }
                if(res){
                    JFrame jFrame = new JFrame();
                    JPanel jPanel = new JPanel();
                    JLabel jLabel = new JLabel("Felicitation vous avez gagné en "+boutons.getNbDeplacements()+" déplacments");
                    jPanel.add(jLabel);
                    jFrame.add(jPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);
                }
            }
        }
    }
}
