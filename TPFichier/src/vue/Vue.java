package vue;

import modele.*;
import javax.swing.*;

/**
 * Cette classe permet d'afficher l'arborescence du système de fichiers à l'aide d'un JTree
 *
 * @author Gautier EDEL
 */
public class Vue extends JFrame {

    public Vue(Repertoire racine)
    {
        this.add(new JTree(racine));
        setTitle("Système de fichier");
        setSize(500, 400);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addJTree(Repertoire racine)
    {
        this.add(new JTree(racine));
    }
}
