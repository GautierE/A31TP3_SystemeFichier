import java.io.*;
import java.util.ArrayList;

public class Service {

    /**
     * Retourne le chemin absolu de file (depuis la racine)
     *
     * @param file Chemin dont on veut connaitre le chemin absolu
     * @return chemin absolu de file
     */
    public static String getChemin(Chemin file)
    {
        if(file == null)
            throw new IllegalArgumentException("Le fichier ne peut etre nul");

        StringBuilder cheminRetour = new StringBuilder();
        ArrayList<Chemin> fileParents = new ArrayList<>();
        Chemin currentPath = file;

        // Permet de recuperer le chemin dans le bon ordre
        while(!currentPath.getNom().equals("racine"))
        {
            fileParents.add(currentPath);
            currentPath = currentPath.getParent();
        }
        for(int i= fileParents.size()-1; i>=0; i--)
        {
            cheminRetour.append('/').append(fileParents.get(i).getNom());
        }

        return cheminRetour.toString();
    }

    /**
     * Retourne tous les descendants du dossier passe en parametre
     *
     * @param dir dossier dont on veut connaitre les enfants
     * @return liste des descendants de dir
     */
    public static ArrayList<String> getPathsFromAncestor(Chemin dir)
    {
        ArrayList<String> listeRetour = new ArrayList<>();

        try
        {
            listeRetour.add(getChemin(dir));

            for (Chemin path : dir.getChildrens())
            {
                if (path instanceof Repertoire && ((Repertoire) path).getChildrens().size() > 0)
                {
                    listeRetour.addAll(getPathsFromAncestor(path));
                }
                else
                {
                    listeRetour.add(getChemin(path));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return listeRetour;
    }

    /**
     * Retourne les chemins absolus de tous les chemins avec un nom correspondant a celui passe en parametre
     *
     * @param name nom du/des chemins que l'on recherche
     * @return  liste des chemins absolus des fichiers avec le meme nom que name
     */
    public static ArrayList<String> getChildsByName(String name)
    {
        ArrayList<String> listeRetour = new ArrayList<>();

        for(String str : getPathsFromAncestor(Repertoire.racine))
        {
            if(str.contains(name))
            {
                listeRetour.add(str);
            }
        }

        return listeRetour;
    }

    /**
     * Recupere la taille totale d'un Repertoire
     *
     * @param dir le repertoire dont on veut connaitre la taille
     * @return taille du Repertoire
     */
    public static int getDirSize(Chemin dir)
    {
        // Initialise avec la taille du repertoire passe en parametre
        int dirSize = Repertoire.size;

        try
        {
            for (Chemin path : dir.getChildrens()) {
                if (path instanceof Repertoire && ((Repertoire) path).getChildrens().size() > 0) {
                    dirSize += getDirSize(path);
                } else {
                    if (path instanceof Repertoire) {
                        dirSize += Repertoire.size;
                    } else {
                        dirSize += ((Fichier) path).getContenu().length();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return dirSize;
    }

    /**
     * Stocke les données de chemin dans un fichier afin de les conserver
     *
     * @param chemin Chemin que l'on souhaite sauvegarder
     */
    public void serialisation(Chemin chemin)
    {
        try
        {
            // Ouverture d'un flux en écriture vers un fichier
            FileOutputStream out = new FileOutputStream("cheminSerialise.txt");
            // Création d'un flux de sérialisation
            ObjectOutputStream ser = new ObjectOutputStream(out);

            // Écriture
            ser.writeObject(chemin);
            ser.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Recupere un objet Chemin a partir d'un fichier
     *
     * @return Chemin contenu dans le fichier
     */
    public Chemin deserialisation()
    {
        Chemin chemin = null;
        try
        {
            FileInputStream fis = new FileInputStream("cheminSerialise.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            chemin = (Chemin) ois.readObject();
            ois.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return chemin;
    }

}
