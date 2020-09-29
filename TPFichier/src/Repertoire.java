import java.util.ArrayList;

public class Repertoire extends Chemin
{
    private ArrayList<Chemin> childrens = new ArrayList<>();
    public static final int size = 4096;

    public Repertoire(String nom, Repertoire parent)
    {
        this.setNom(nom);
        this.setParent(parent);
    }
    // Constructeur de la racine
    public Repertoire(String nom)
    {
        this.setNom(nom);
    }

    public void removeChild(Chemin child)
    {
        this.childrens.remove(child);
    }

    public void addChild(Chemin child)
    {
       this.childrens.add(child);
    }

    public ArrayList<Chemin> getChildrens() {
        return childrens;
    }
}
