package org.example;

public class PourcentageVenteParMarque {
    private Marque marque;
    private String pourcentage;

    public Marque getMarque() { return marque; }
    public void setMarque(String marque) {
        this.marque = Marque.valueOf(marque);
    }

    public String getPourcentage() { return pourcentage; }
    public void setPourcentage(String pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return marque + " | " + pourcentage;
    }
}
