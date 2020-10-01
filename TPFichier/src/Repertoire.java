import java.util.ArrayList;

public class Repertoire extends Chemin
{
    private ArrayList<Chemin> childrens = new ArrayList<>();
    public static final int size = 4096;

    // Constructeur de la racine
    public Repertoire(String nom)
    {
        this.setNom(nom);
    }

    @Override
    public void removeChild(Chemin child)
    {
        this.childrens.remove(child);
    }

    @Override
    public void addChild(Chemin child)
    {
        this.childrens.add(child);
        child.setParent(this);
    }

    @Override
    public ArrayList<Chemin> getChildrens()
    {
        return this.childrens;
    }
}
