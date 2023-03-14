package Entities;

public class Pigiste
{
    private int numPigiste;
    private String nomPigiste;
    private double prixPage;

    public Pigiste(int numPigiste, String nomPigiste, double prixPage) {
        this.numPigiste = numPigiste;
        this.nomPigiste = nomPigiste;
        this.prixPage = prixPage;
    }

    public int getNumPigiste() {
        return numPigiste;
    }

    public String getNomPigiste() {
        return nomPigiste;
    }

    public double getPrixPage() {
        return prixPage;
    }
}
