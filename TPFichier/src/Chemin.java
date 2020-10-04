import java.io.Serializable;
import java.util.ArrayList;

public abstract class Chemin implements Serializable {
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
     * @throws Exception Un fichier ne possède pas de parents
     */
    public void removeChild(Chemin child) throws Exception
    {
        throw new Exception("Un fichier ne possède pas d'enfants");
    }

    /**
     * Ajoute un enfant a un repertoire
     *
     * @param child Chemin enfant a ajouter
     * @throws Exception Un fichier ne possède pas d'enfants
     */
    public void addChild(Chemin child) throws Exception
    {
        throw new Exception("Un fichier ne possède pas d'enfants");
    }

    /**
     * Retourne la liste des enfants du dossier appelant
     *
     * @return liste des enfants
     * @throws Exception Un fichier ne possede pas d'enfants
     */
    public ArrayList<Chemin> getChildrens() throws Exception
    {
        throw new Exception("Un fichier ne possède pas d'enfants");
    }
}
