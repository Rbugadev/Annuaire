package fr.afcepf.ai104.entidades;

public class Stagiaire {
    private String nomStagiaire;
    private String prenomStagiaire;
    private String departementStagiare;
    private String promoStagiaire;
    private int anneePromoStagiaire;

    public Stagiaire() {
    }


    public Stagiaire(String nomStagiaire, String prenomStagiaire, String departementStagiare, String promoStagiaire,
                     int anneePromoStagiaire) {
        super();
        this.nomStagiaire = nomStagiaire;
        this.prenomStagiaire = prenomStagiaire;
        this.departementStagiare = departementStagiare;
        this.promoStagiaire = promoStagiaire;
        this.anneePromoStagiaire = anneePromoStagiaire;
    }


    public String getNomStagiaire() {
        return nomStagiaire;
    }

    public void setNomStagiaire(String nomStagiaire) {
        this.nomStagiaire = nomStagiaire;
    }

    public String getPrenomStagiaire() {
        return prenomStagiaire;
    }

    public void setPrenomStagiaire(String prenomStagiaire) {
        this.prenomStagiaire = prenomStagiaire;
    }

    public String getDepartementStagiare() {
        return departementStagiare;
    }

    public void setDepartementStagiare(String departementStagiare) {
        this.departementStagiare = departementStagiare;
    }

    public String getPromoStagiaire() {
        return promoStagiaire;
    }

    public void setPromoStagiaire(String promoStagiaire) {
        this.promoStagiaire = promoStagiaire;
    }

    public int getAnneePromoStagiaire() {
        return anneePromoStagiaire;
    }

    public void setAnneePromoStagiaire(int anneePromoStagiaire) {
        this.anneePromoStagiaire = anneePromoStagiaire;
    }


    @Override
    public String toString() {
        return "Nom = " + nomStagiaire + "\t Prenom = " + prenomStagiaire
                + "\tDpto = " + departementStagiare + "\tPromo = " + promoStagiaire
                + "\tAnnée = " + anneePromoStagiaire;
    }


}
