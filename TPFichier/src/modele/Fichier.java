package modele;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

public class Fichier extends Chemin
{
    private String contenu;

    /**
     * Constructeur de Fichier
     *
     * @param nom nom du fichier
     */
    public Fichier(String nom)
    {
        if(nom == null || nom.equals(""))
            throw new IllegalArgumentException("Le nom du fichier ne peut etre nul");

        this.setNom(nom);
    }

    /**
     * Permet d'obtenir le contenu du fichier
     * @return contenu du fichier
     */
    public String getContenu()
    {
        return contenu;
    }

    /**
     * Definit le contenu du fichier
     *
     * @param contenu contenu du fichier
     */
    public void setContenu(String contenu)
    {
        this.contenu = contenu;
    }
}
