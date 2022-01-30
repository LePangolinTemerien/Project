import Interface.Boutons;
import MVC.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        JFrame fenetre =new JFrame(" Eteint la Lumière ");
        fenetre.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        fenetre.setLayout(new BorderLayout());
        JPanel interfaceBoutons = new JPanel();
        TabLumiere tabLumiere = new TabLumiere();
        VueLumiere vueLumiere = new VueLumiere();
        Boutons boutons = new Boutons(tabLumiere);
        ControleurGraph controleurGraph = new ControleurGraph(tabLumiere, boutons);
        interfaceBoutons.add(boutons);
        tabLumiere.addObserver(vueLumiere);
        vueLumiere.setPreferredSize(new Dimension(250,250));
        vueLumiere.addMouseListener(controleurGraph);
        fenetre.add(vueLumiere, BorderLayout.CENTER);
        fenetre.add(interfaceBoutons, BorderLayout.WEST);
        fenetre.pack();
        fenetre.setVisible (true);
    }
}
