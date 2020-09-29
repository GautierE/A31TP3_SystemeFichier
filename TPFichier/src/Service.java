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

        // dirQueue contient tous les chemins à tester
        ArrayList<Chemin> dirQueue = dir.getChildrens();
        // dirList est une sous liste de dirQueue ne contenant que les dossiers non vide
        ArrayList<Repertoire> dirList = new ArrayList<>();

        while(dirQueue.size() != 0)
        {
            // Parcours la file d'attente
            for(Chemin path : dirQueue)
            {
                // Si c'est un repertoire non vide on l'ajoute a la liste des dossiers
                if(path instanceof Repertoire && ((Repertoire) path).getChildrens().size() > 0)
                {
                    dirList.add((Repertoire)path);
                }
                else
                {
                    listeRetour.add(Service.getChemin(path) + '\n');
                }
            }
            // Vide la liste d'attente
            dirQueue.clear();
            for(Repertoire directory : dirList)
            {
                // Parcours les enfants du dossier
                for(Chemin path : directory.getChildrens())
                {
                    // Si  l'enfant contient des elements on l'ajoute a la file
                    if (path instanceof Repertoire && ((Repertoire) path).getChildrens().size() > 0)
                    {
                        dirQueue.add(path);
                    }
                    // Sinon on l'ajoute au retour
                    else
                    {
                        listeRetour.add(Service.getChemin(path) + '\n');
                    }
                }
            }
            dirList.clear();
        }
        return listeRetour;
    }

    public static ArrayList<String> getChildsByName(String name)
    {
        ArrayList<String> listeRetour = new ArrayList<>();

        for(String str : getPathsFromAncestor(Chemin.racine))
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
        int dirSize = Repertoire.size;
        // dirQueue contient tous les chemins à tester
        ArrayList<Chemin> dirQueue = dir.getChildrens();
        // dirList est une sous liste de dirQueue ne contenant que les dossiers non vide
        ArrayList<Repertoire> dirList = new ArrayList<>();

        while(dirQueue.size() != 0)
        {
            // Parcours la file d'attente
            for(Chemin path : dirQueue)
            {
                // Si c'est un repertoire non vide on l'ajoute a la liste des dossiers
                if(path instanceof Repertoire && ((Repertoire) path).getChildrens().size() > 0)
                {
                    dirList.add((Repertoire)path);
                    dirSize += Repertoire.size;
                }
                else
                {
                    if(path instanceof Repertoire)
                    {
                        //System.out.println(path instanceof Repertoire);
                        dirSize += Repertoire.size;
                    }
                    else
                    {
                        dirSize += ((Fichier) path).getContenu().length();
                    }
                }
            }
            // Vide la liste d'attente
            dirQueue.clear();
            for(Repertoire directory : dirList)
            {
                // Parcours les enfants du dossier
                for(Chemin path : directory.getChildrens())
                {
                    // Si  l'enfant contient des elements on l'ajoute a la file
                    if (path instanceof Repertoire && ((Repertoire) path).getChildrens().size() > 0)
                    {
                        dirQueue.add(path);
                        dirSize += Repertoire.size;
                    }
                    // Sinon on l'ajoute au retour
                    else
                    {
                        if(path instanceof Repertoire)
                        {
                            System.out.println(path.getNom());
                            dirSize += Repertoire.size;
                        }
                        else
                        {
                            dirSize += ((Fichier) path).getContenu().length();
                        }
                    }
                }
            }
            dirList.clear();
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
