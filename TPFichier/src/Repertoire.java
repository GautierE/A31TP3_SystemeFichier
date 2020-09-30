import java.util.ArrayList;

public class Repertoire extends Chemin
{
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

    @Override
    public void removeChild(Chemin child)
    {
        this.getChildrens().remove(child);
    }

    @Override
    public void addChild(Chemin child)
    {
        this.getChildrens().add(child);
    }
}
