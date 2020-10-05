package controller;

import modele.*;

/**
 * Classe rerspectant le design pattern Fabrique permettant d'instancier des fichiers et des repertoires
 *
 * @author Gautier EDEL
 */
public class CheminCreator
{
    private static CheminCreator instance;

    /**
     * Singleton permettant d'acceder a l'instance de la classe et de la rendre unique
     * @return unique instance de CheminCreator
     */
    // Creation d'un singleton
    public static CheminCreator getInstance()
    {
        if(instance == null)
        {
            instance = new CheminCreator();
        }

        return instance;
    }

    /**
     * Cree un fichier
     *
     * @param nom nom du fichier
     * @return nouveau fichier
     */
    public Fichier createFichier(String nom)
    {
        return new Fichier(nom);
    }

    /**
     * Cree un repertoire
     *
     * @param nom nom du repertoire
     * @return nouveau repertoire
     */
    public Repertoire createRepertoire(String nom)
    {
        return new Repertoire(nom);
    }
}
