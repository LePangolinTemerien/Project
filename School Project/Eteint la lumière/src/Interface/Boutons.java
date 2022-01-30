/**
 * @author TISSERANT Paul , SCHLOESSER Adrien
 */

package Interface;

import MVC.TabLumiere;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe qui gère les interactions avec les boutons
 */
public class Boutons extends JPanel implements ActionListener, ChangeListener {

    /**
     * Nombre deplacement effectuer par le joueur
     */
    private  int nbDeplacements = 0;
    /**
     * JLabel affichant les tentatives du joueur
     */
    private final JLabel tentatives;
    /**
     * Bouton permettant d'effectuer l'aléatoire sur la grille
     */
    private  JButton Aleatoire;
    /**
     * Bouton permettant de configurer
     */
    private  JButton Configurer;
    /**
     * Bouton permettant de lancer la partie
     */
    private JButton Jouer;
    /**
     * Bouton permettant de quitter la partie en cours
     */
    private JButton Quitter;
    /**
     * JSlider gêrant le nombre de classe aléatoire
     */
    private JSlider slider;
    /**
     * Entier récuperant la valeur du JSlider
     */
    private int nbSlider;
    /**
     * Jlabel affichant la valeur du JSlider
     */
    private JLabel indicateurSlider = new JLabel("1");
    /**
     * Booléen gérant les états de la partie
     */
    private boolean jeu, configuration;
    /**
     * Tableau de lumière
     */
    private TabLumiere tab;

    /**
     * Constructeur des Boutons prenant en compte le tableau de lumière sur lequelle il va interragir
     * @param tabLumiere : tableau de lumière sur lequelle les boutons vont interragir
     */
    public Boutons(TabLumiere tabLumiere){
        setLayout(new GridLayout(0,1));
        tab = tabLumiere;
        tentatives = new JLabel("Nombre de Deplacements : "+ nbDeplacements);
        Aleatoire = new JButton("Aleatoire");
        Configurer = new JButton("Configurer");
        Jouer = new JButton("Jouer");
        Quitter = new JButton("Quitter");
        slider = new JSlider(0,25,1);
        nbSlider = slider.getValue();
        jeu = false;
        configuration = false;
        Jouer.setEnabled(false);
        Quitter.setEnabled(false);
        Configurer.addActionListener(this);
        Jouer.addActionListener(this);
        Aleatoire.addActionListener(this);
        slider.addChangeListener(this);
        Quitter.addActionListener(this);
        this.add(tentatives);
        this.add(Aleatoire);
        this.add(Configurer);
        this.add(Jouer);
        this.add(Quitter);
        this.add(slider);
        this.add(indicateurSlider);
        this.indicateurSlider.setText("                       "+nbSlider);
    }

    /**
     * Methode associant les boutons au actions
     * @param e : Evenement récuperant la source de l'action
     */
    public void actionPerformed(ActionEvent e){
        String bouton;
        bouton = ((JButton)e.getSource()).getText();
        switch (bouton) {
            case "Configurer" -> {
                configuration = true;
                Jouer.setEnabled(true);
                Quitter.setEnabled(true);
            }
            case "Jouer" -> {
                jeu = true;
                configuration = false;
                Aleatoire.setEnabled(false);
                Configurer.setEnabled(false);
            }
            case "Aleatoire" ->{
                Jouer.setEnabled(true);
                Quitter.setEnabled(true);
                tab.aleatoire(nbSlider);
            }
            case "Quitter" -> {
                Jouer.setEnabled(false);
                Quitter.setEnabled(false);
                Aleatoire.setEnabled(true);
                Configurer.setEnabled(true);
                nbDeplacements = 0;
                tab.remiseAZero();
                jeu = false;
                nbDeplacements = 0;
                tentatives.setText("Nombre de Deplacements : "+ nbDeplacements);
            }
        }
    }

    /**
     * Methode mettant a jour le JLabel indiquant la valeur du JLabel
     * @param e : Evenement detectant le changement dans le JSlider
     */
    public void stateChanged(ChangeEvent e){
        nbSlider = slider.getValue();
        indicateurSlider.setText("                       "+nbSlider);
    }

    /**
     * Methode retournant un booleen qui detecte si le jeu est en mode configuration
     * @return : booleen true si en configuration, false si hors configuration
     */
    public boolean isConfiguration() {
        return configuration;
    }

    /**
     * Methode retournant si le jeu est actif
     * @return :  true si le jeu est en cours
     */
    public boolean isJeu() {
        return jeu;
    }

    /**
     * Methode mettant a jour le nombre de déplacement lorque le jeu est actif
     */
    public void setNbDeplacements() {
        this.nbDeplacements += 1;
        tentatives.setText("Nombre de Deplacements : "+ nbDeplacements);
    }

    /**
     * Methode récupérant le nb de déplacement
     * @return : nombre de deplcement
     */
    public int getNbDeplacements() {
        return nbDeplacements;
    }
}
