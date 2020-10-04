import java.io.Serializable;
import java.util.ArrayList;

public abstract class Chemin implements Serializable {
    private String nom;
    private Repertoire parent;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Repertoire getParent() {
        return parent;
    }

    public void setParent(Repertoire parent)
    {
        this.parent = parent;
    }

    public void removeParent()
    {
        this.parent = null;
    }

    public void removeChild(Chemin child) throws Exception
    {
        throw new Exception("Un fichier ne possède pas de parents");
    }

    public void addChild(Chemin child) throws Exception
    {
        throw new Exception("Un fichier ne possède pas d'enfants");
    }

    public ArrayList<Chemin> getChildrens() throws Exception
    {
        throw new Exception("Un fichier ne possède pas d'enfants");
    }
}
