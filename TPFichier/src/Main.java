public class Main
{
    public static void main(String[] args)
    {

        Repertoire a31 = new Repertoire("A31", Chemin.racine);
        Chemin.racine.addChild(a31);
        Fichier tp1 = new Fichier("TD1", a31, "Le tp 1");
        a31.addChild(tp1);
        Fichier tp2 = new Fichier("TP2", a31, "Le tp 2");
        a31.addChild(tp2);
        Fichier tp3 = new Fichier("TP3", a31, "Le tp 3");
        a31.addChild(tp3);
        Repertoire projetA31 = new Repertoire("ProjetA31", a31);
        projetA31.addChild(new Repertoire("vue", projetA31));
        projetA31.addChild(new Repertoire("modele", projetA31));
        projetA31.addChild(new Repertoire("controleur", projetA31));
        a31.addChild(projetA31);


        Repertoire w31 = new Repertoire("W31", Chemin.racine);
        Chemin.racine.addChild(w31);
        Fichier td1 = new Fichier("TD1", w31, "Le td1");
        w31.addChild(td1);
        Fichier td2 = new Fichier("TD2", w31, "Le td2");
        w31.addChild(td2);
        Fichier td3 = new Fichier("TD3", w31, "Le td3");
        w31.addChild(td3);

        System.out.println(Service.getDirSize(a31));

    }
}
