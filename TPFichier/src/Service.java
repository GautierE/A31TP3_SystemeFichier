import java.io.*;
import java.util.ArrayList;

public class Service {

    public static String getChemin(Chemin file)
    {
        StringBuilder cheminRetour = new StringBuilder();
        ArrayList<Chemin> fileParents = new ArrayList<>();
        Chemin currentPath = file;

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

    public static ArrayList<String> getPathsFromAncestor(Repertoire dir)
    {
        ArrayList<String> listeRetour = new ArrayList<>();

        for(Chemin path: dir.getChildrens())
        {
            if(path instanceof Repertoire && ((Repertoire) path).getChildrens().size() > 0)
            {
                listeRetour.addAll(getPathsFromAncestor((Repertoire) path));
            }
            else
            {
                listeRetour.add(getChemin(path));
            }
        }

        return listeRetour;
    }

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

    public static int getDirSize(Repertoire dir)
    {
        // Initialise avec la taille du repertoire passe en parametre
        int dirSize = Repertoire.size;

        for(Chemin path: dir.getChildrens())
        {
            if(path instanceof Repertoire && ((Repertoire) path).getChildrens().size() > 0)
            {
                dirSize += getDirSize((Repertoire)path);
            }
            else
            {
                if(path instanceof Repertoire)
                {
                    dirSize += Repertoire.size;
                }
                else
                {
                    dirSize += ((Fichier) path).getContenu().length();
                }
            }
        }

        return dirSize;
    }

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
