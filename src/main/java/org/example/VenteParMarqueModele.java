package org.example;

public class VenteParMarqueModele {
    private Marque marque;
    private ModeleVoiture modele;
    private int nbrePiecesVendus;

    public Marque getMarque() { return marque; }
    public void setMarque(String marque) {
        this.marque = Marque.valueOf(marque);
    }

    public ModeleVoiture getModele() { return modele; }
    public void setModele(String modele) {
        this.modele = ModeleVoiture.valueOf(modele);
    }

    public int getNbrePiecesVendus() { return nbrePiecesVendus; }
    public void setNbrePiecesVendus(int nbrePiecesVendus) {
        this.nbrePiecesVendus = nbrePiecesVendus;
    }
}
