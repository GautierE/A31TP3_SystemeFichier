import java.io.Serializable;

public abstract class Chemin implements Serializable {
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

    public void remove()
    {

    }
}
