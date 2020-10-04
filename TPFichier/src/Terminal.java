import java.util.ArrayList;

public class Terminal
{
    private Repertoire currentDir;

    /**
     * Constructeur de Terminal
     *
     * @param currentDir repertoire courant a l'ouverture du terminal
     */
    public Terminal(Chemin currentDir)
    {
        if(currentDir == null)
            throw new IllegalArgumentException("Le dossier ne peut etre nul");
        else if(currentDir instanceof Fichier)
            throw new IllegalArgumentException("Le dossier courant ne peut etre un Fichier");

        this.currentDir = (Repertoire)currentDir;
    }

    /**
     * Cree un fichier dans le repertoire courant
     *
     * @param nomFichier nom du fichier
     */
    public void touch(String nomFichier)
    {
        if(nomFichier == null || nomFichier.equals(""))
            throw new IllegalArgumentException("Le nom du fichier ne peut etre nul");

        currentDir.addChild(CheminCreator.getInstance().createFichier(nomFichier));

    }

    /**
     * Cree un repertoire dans le repertoire courant
     *
     * @param nomRepertoire nom du repertoire
     */
    public void mkdir(String nomRepertoire)
    {
        if(nomRepertoire == null || nomRepertoire.equals(""))
            throw new IllegalArgumentException("Le nom du repertoire ne peut etre nul");

        currentDir.addChild(CheminCreator.getInstance().createRepertoire(nomRepertoire));
    }

    /**
     * Affiche le contenu du repertoire courant
     *
     * @return chaque chemin du repertoire courant sous forme de liste
     */
    public ArrayList<String> ls()
    {
        ArrayList<String> listeRetour = new ArrayList<>();

        for(Chemin path: currentDir.getChildrens())
        {
            listeRetour.add(path.getNom());
        }

        return listeRetour;
    }

    /**
     * Retourne le chemin absolu du repertoire courant
     *
     * @return retourne le chemin absolu du repertoire courant
     */
    public String pwd()
    {
        return Service.getChemin(currentDir);
    }

    /**
     * Change de repertoire dans le Terminal
     *
     * @param nomRepertoire nom du repertoire a atteindre
     */
    public void cd(String nomRepertoire)
    {
        if(nomRepertoire == null || nomRepertoire.equals(""))
            throw new IllegalArgumentException("Le nom du repertoire ne peut etre nul");

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

    /**
     * Supprime un fichier du repertoire courant
     *
     * @param nomFichier nom du fichier a supprimer
     */
    public void rm(String nomFichier)
    {
        if(nomFichier == null || nomFichier.equals(""))
            throw new IllegalArgumentException("Le nom du fichier ne peut etre nul");

        for(Chemin path : currentDir.getChildrens())
        {
            if(path.getNom().equals(nomFichier) && path instanceof Fichier)
            {
                currentDir.removeChild(path);
            }
        }
    }

    /**
     * Renomme un fichier du repertoire courant
     * @param ancienNom nom du fichier actuel
     * @param nouveauNom nouveau nom du fichier
     */
    public void mv(String ancienNom, String nouveauNom)
    {
        if(ancienNom == null || ancienNom.equals(""))
            throw new IllegalArgumentException("Le nom actuel du fichier ne peut etre nul");
        else if(nouveauNom == null || nouveauNom.equals(""))
            throw new IllegalArgumentException("Le futur nom du fichier ne peut etre nul");

        for(Chemin path : currentDir.getChildrens())
        {
            if(path.getNom().equals(ancienNom))
            {
                path.setNom(nouveauNom);
            }
        }
    }
}
