public class Fichier extends Chemin
{
    private String contenu;

    public Fichier(String nom)
    {
        this.setNom(nom);
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
