public class CheminCreator
{
    private static CheminCreator instance;

    public static CheminCreator getInstance()
    {
        if(instance == null)
        {
            instance = new CheminCreator();
        }

        return instance;
    }
    public Fichier createFichier(String nom)
    {
        return new Fichier(nom);
    }

    public Repertoire createRepertoire(String nom)
    {
        return new Repertoire(nom);
    }
}
