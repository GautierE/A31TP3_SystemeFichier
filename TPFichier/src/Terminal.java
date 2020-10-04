import java.util.ArrayList;

public class Terminal
{
    private Repertoire currentDir = Repertoire.racine;

    public void touch(String nomFichier)
    {
        if(nomFichier == null || nomFichier.equals(""))
            throw new IllegalArgumentException();

        currentDir.addChild(CheminCreator.getInstance().createFichier(nomFichier));

    }

    public void mkdir(String nomRepertoire)
    {
        if(nomRepertoire == null || nomRepertoire.equals(""))
            throw new IllegalArgumentException();

        currentDir.addChild(CheminCreator.getInstance().createRepertoire(nomRepertoire));
    }

    public ArrayList<String> ls()
    {
        ArrayList<String> listeRetour = new ArrayList<>();

        for(Chemin path: currentDir.getChildrens())
        {
            listeRetour.add(path.getNom());
        }

        return listeRetour;
    }

    public String pwd()
    {
        return Service.getChemin(currentDir);
    }

    public void cd(String nomRepertoire)
    {
        if(nomRepertoire == null || nomRepertoire.equals(""))
            throw new IllegalArgumentException();

        Repertoire currentDirTemp = currentDir;

        for(Chemin path : currentDir.getChildrens())
        {
            if(path.getNom().equals(nomRepertoire) && path instanceof Repertoire)
            {
                currentDirTemp = (Repertoire) path;
            }
        }
        currentDir = currentDirTemp;
    }

    public void rm(String nomFichier)
    {
        if(nomFichier == null || nomFichier.equals(""))
            throw new IllegalArgumentException();

        for(Chemin path : currentDir.getChildrens())
        {
            if(path.getNom().equals(nomFichier) && path instanceof Fichier)
            {
                currentDir.removeChild(path);
            }
        }
    }

    public void mv(String ancienNom, String nouveauNom)
    {
        if(ancienNom == null || ancienNom.equals("") || nouveauNom == null || nouveauNom.equals(""))
            throw new IllegalArgumentException();

        for(Chemin path : currentDir.getChildrens())
        {
            if(path.getNom().equals(ancienNom))
            {
                path.setNom(nouveauNom);
            }
        }
    }
}
