import controller.*;
import modele.*;
import vue.*;

public class Main
{
    public static void main(String[] args)
    {
        //Test des methodes de Service, CheminCreator, Chemin, Fichier, Repertoire
        System.out.println("--- Test des methodes de Service, CheminCreator, Chemin, Fichier, Repertoire");
        testServiceCreator();

        // Test du Terminal via le main car l'interactive shell ne fonctionne pas
        System.out.println("--- Test du Terminal ---");
        testTerminal();

        Vue vue = new Vue();

    }

    public static void testTerminal()
    {
        Terminal t = new Terminal(Repertoire.racine);

        t.mkdir("D31");
        t.cd("D31");
        t.mkdir("Projet D31");
        t.touch("TP 1");
        t.touch("TP 2");
        System.out.println("Le chemin absolu du repertoire courant: ");
        t.pwd();
        System.out.println("Contenu du repertoire courant: ");
        t.ls();
        t.mv("TP 2", "TD 2");
        t.rm("TP 1");
        System.out.println("Contenu du repertoire courant apres suppression de TP1 et renommage de TP2 en TD2: ");
        t.ls();
    }

    public static void testServiceCreator()
    {
        CheminCreator creator = CheminCreator.getInstance();

        Repertoire a31 = creator.createRepertoire("A31");
        Repertoire.racine.addChild(a31);

        Fichier tp1 = creator.createFichier("TP1");
        tp1.setContenu("Le tp 1");
        a31.addChild(tp1);

        Fichier tp2 = creator.createFichier("TP2");
        tp2.setContenu("Le tp 2");
        a31.addChild(tp2);

        Fichier tp3 = creator.createFichier("TP3");
        tp3.setContenu("Le tp 3");
        a31.addChild(tp3);

        Repertoire projetA31 = creator.createRepertoire("ProjetA31");
        projetA31.addChild(creator.createRepertoire("vue"));
        projetA31.addChild(creator.createRepertoire("modele"));
        projetA31.addChild(creator.createRepertoire("controleur"));
        a31.addChild(projetA31);


        Repertoire w31 = creator.createRepertoire("W31");
        Repertoire.racine.addChild(w31);

        Fichier td1 = creator.createFichier("TD1");
        td1.setContenu("Le td1");
        w31.addChild(td1);

        Fichier td2 = creator.createFichier("TD2");
        td2.setContenu("Le td2");
        w31.addChild(td2);

        Fichier td3 = creator.createFichier("TD3");
        td3.setContenu("Le td3");
        w31.addChild(td3);


        System.out.println("Chemin absolu du fichier TD1: " + Service.getChemin(td1));
        System.out.println("Tous les enfants de A31: " + Service.getPathsFromAncestor(a31));
        System.out.println("Tous les chemins absolus depuis la racine portants le nom W31 " + Service.getChildsByName("W31"));
        System.out.println("Taille de la racine: " + Service.getDirSize(Repertoire.racine) + '\n');
    }
}
