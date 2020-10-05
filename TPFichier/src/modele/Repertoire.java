package modele;

import java.util.ArrayList;

/**
 * La clase Repertoire permet d'instancier un repertoire
 *
 * @author Gautier EDEL
 */
public class Repertoire extends Chemin
{
    public static final Repertoire racine = new Repertoire("racine");
    public static final int size = 4096;
    private final ArrayList<Chemin> childrens = new ArrayList<>();

    /**
     * Constructeur de Repertoire
     * @param nom nom du repertoire
     */
    // Constructeur de la racine
    public Repertoire(String nom)
    {
        if(nom == null || nom.equals(""))
            throw new IllegalArgumentException("Le nom du repertoire ne peut etre nul");

        this.setNom(nom);
    }

    /**
     * Redefinition de la methode provenant initialement de Chemin
     * Supprime un enfant du dossier appelant
     *
     * @param child Chemin enfant a supprimer
     */
    @Override
    public void removeChild(Chemin child)
    {
        if(!this.getChildrens().contains(child))
            throw new IllegalArgumentException("Le fichier ne peut etre supprime car il n'existe pas");

        this.childrens.remove(child);
    }

    /**
     * Redefinition de la methode provenant initialement de Chemin
     * Ajoute un enfant au dossier appelant
     *
     * @param child Chemin enfant a ajouter
     */
    @Override
    public void addChild(Chemin child)
    {
        if(this.getChildrens().contains(child))
            throw new IllegalArgumentException("Le fichier ne peut etre ajoute car il existe deja dans le dossier");

        this.childrens.add(child);
        child.setParent(this);
    }

    /**
     * Redefinition de la methode provenant initialement de Chemin
     * Retourne les enfants du dossier appelant
     *
     * @return liste des enfants
     */
    @Override
    public ArrayList<Chemin> getChildrens()
    {
        return this.childrens;
    }
}
