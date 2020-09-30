import java.io.Serializable;
import java.util.ArrayList;

public abstract class Chemin implements Serializable {
    private ArrayList<Chemin> childrens = new ArrayList<>();
    private String nom;
    private Repertoire parent;
    public static final Repertoire racine = new Repertoire("racine");

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Repertoire getParent() {
        return parent;
    }

    public void setParent(Repertoire parent) {
        this.parent = parent;
    }

    public void removeParent()
    {
        this.parent = null;
    }

    public abstract void removeChild(Chemin child);

    public void addChild(Chemin child)
    {
        this.childrens.add(child);
    }

    public ArrayList<Chemin> getChildrens() {
        return childrens;
    }
}
