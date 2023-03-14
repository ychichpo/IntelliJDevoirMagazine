package Entities;

public class Article
{
    private String titreArticle;
    private int nbPages;
    private Pigiste lePigiste;

    public Article(String titreArticle, int nbPages, Pigiste lePigiste) {
        this.titreArticle = titreArticle;
        this.nbPages = nbPages;
        this.lePigiste = lePigiste;
    }

    public String getTitreArticle() {
        return titreArticle;
    }

    public int getNbPages() {
        return nbPages;
    }

    public Pigiste getLePigiste() {
        return lePigiste;
    }

    // Cette méthode permet de calculer
    // le montant de l'article : nombre de pages * prix à la page
    public double CalculerMontantArticle()
    {
        double prixArticle=lePigiste.getPrixPage()*nbPages;
        return Math.round(prixArticle * 100.00) / 100.00;
    }
}
