package modele;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Chemin implements Serializable, TreeModel {
    private String nom;
    private Repertoire parent;

    /**
     * Retourne le nom du Chemin
     *
     * @return nom du Chemin
     */
    public String getNom() {
        return nom;
    }

    /**
     * Defini le nom du Chemin
     *
     * @param nom nom du fichier
     */
    public void setNom(String nom) {
        if(nom == null || nom.equals(""))
            throw new IllegalArgumentException("Le nom ne peut etre nul");
        this.nom = nom;
    }

    /**
     * Retourne le parent du Chemin
     *
     * @return parent du chemin
     */
    public Repertoire getParent() {
        return parent;
    }

    /**
     * Defini le parent du Chemin
     *
     * @param parent nouveau parent du Chemin
     */
    public void setParent(Repertoire parent)
    {
        if(parent == null)
            throw new IllegalArgumentException("Le parent ne peut etre nul");
        this.parent = parent;
    }

    /**
     * Supprime un enfant d'un repertoire
     *
     * @param child Chemin enfant a supprimer
     * @throws IllegalArgumentException Un fichier ne possède pas de parents
     */
    public void removeChild(Chemin child) throws IllegalArgumentException
    {
        throw new IllegalArgumentException("Un fichier ne possède pas d'enfants");
    }

    /**
     * Ajoute un enfant a un repertoire
     *
     * @param child Chemin enfant a ajouter
     * @throws IllegalArgumentException Un fichier ne possède pas d'enfants
     */
    public void addChild(Chemin child) throws IllegalArgumentException
    {
        throw new IllegalArgumentException("Un fichier ne possède pas d'enfants");
    }

    /**
     * Retourne la liste des enfants du dossier appelant
     *
     * @return liste des enfants
     * @throws IllegalArgumentException Un fichier ne possede pas d'enfants
     */
    public ArrayList<Chemin> getChildrens() throws IllegalArgumentException
    {
        throw new IllegalArgumentException("Un fichier ne possède pas d'enfants");
    }


    @Override
    public Object getRoot() {
        return Repertoire.racine;
    }

    @Override
    public Object getChild(Object parent, int index)
    {
        if(parent instanceof Fichier)
        {
         throw new IllegalArgumentException("Un fichier ne possede pas d'enfants");
        }
        else
        {
            return ((Repertoire)parent).getChildrens().get(index);
        }
    }

    @Override
    public int getChildCount(Object parent)
    {
        if(parent instanceof Fichier)
        {
            throw new IllegalArgumentException("Un fichier ne possede pas d'enfants");
        }
        else
        {
            return ((Repertoire)parent).getChildrens().size();
        }
    }

    @Override
    public boolean isLeaf(Object node) {
        if(node instanceof Repertoire && ((Repertoire)node).getChildrens().size() == 0)
        {
            return true;
        }
        else return node instanceof Fichier;
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if(parent instanceof Fichier)
        {
            throw new IllegalArgumentException("Un fichier ne possede pas d'enfants");
        }
        else
        {
            Repertoire dir = (Repertoire) child;
            return ((Repertoire)parent).getChildrens().indexOf(dir);
        }
    }

    @Override
    public void addTreeModelListener(TreeModelListener l)
    {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l)
    {
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue)
    {

    }

    @Override
    public String toString() {
        return this.getNom();
    }
}
