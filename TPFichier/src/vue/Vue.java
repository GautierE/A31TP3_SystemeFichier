package vue;

import modele.*;
import javax.swing.*;
import java.awt.*;

/**
 * Cette classe sert à afficher graphiquement l'arborescence à l'aide d'une fenêtre graphique
 * @author Clément GEYER
 */
public class Vue extends JFrame {

    public Vue()
    {
        this.add(new JTree(Repertoire.racine));
        setTitle("Système de fichier");
        setSize(500, 400);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
