public class Fichier extends Chemin
{
    private String contenu;

    public Fichier(String nom, Repertoire parent, String contenu)
    {
        this.setNom(nom);
        this.setParent(parent);
        this.contenu = contenu;
    }

    public String getContenu()
    {
        return contenu;
    }

    public void setContenu(String contenu)
    {
        this.contenu = contenu;
    }
}