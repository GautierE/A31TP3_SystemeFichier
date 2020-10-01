public class Main
{
    public static void main(String[] args)
    {

        Repertoire a31 = new Repertoire("A31");
        Chemin.racine.addChild(a31);
        Fichier tp1 = new Fichier("TP1");
        tp1.setContenu("Le tp 1");
        a31.addChild(tp1);
        Fichier tp2 = new Fichier("TP2");
        tp2.setContenu("Le tp 2");
        a31.addChild(tp2);
        Fichier tp3 = new Fichier("TP3");
        tp3.setContenu("Le tp 3");
        a31.addChild(tp3);

        Repertoire projetA31 = new Repertoire("ProjetA31");
        projetA31.addChild(new Repertoire("vue"));
        projetA31.addChild(new Repertoire("modele"));
        projetA31.addChild(new Repertoire("controleur"));
        a31.addChild(projetA31);


        Repertoire w31 = new Repertoire("W31");
        Chemin.racine.addChild(w31);
        Fichier td1 = new Fichier("TD1");
        td1.setContenu("Le td1");
        w31.addChild(td1);
        Fichier td2 = new Fichier("TD2");
        td2.setContenu("Le td2");
        w31.addChild(td2);
        Fichier td3 = new Fichier("TD3");
        td3.setContenu("Le td3");
        w31.addChild(td3);

        System.out.println(Service.getDirSize(a31));

    }
}
