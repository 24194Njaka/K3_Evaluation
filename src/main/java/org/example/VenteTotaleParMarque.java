package org.example;

public class VenteTotaleParMarque {
    private int nbrePieceKia;
    private int nbrePieceDaewoo;

    public int getNbrePieceKia() { return nbrePieceKia; }
    public void setNbrePieceKia(int nbrePieceKia) {
        this.nbrePieceKia = nbrePieceKia;
    }

    public int getNbrePieceDaewoo() { return nbrePieceDaewoo; }
    public void setNbrePieceDaewoo(int nbrePieceDaewoo) {
        this.nbrePieceDaewoo = nbrePieceDaewoo;
    }

    @Override
    public String toString() {
        return nbrePieceKia + " | " + nbrePieceDaewoo;
    }
}
