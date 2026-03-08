package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DataRetriever repo = new DataRetriever();

        // TEST a)
        System.out.println("=== a) Ventes par marque et modèle ===");
        List<VenteParMarqueModele> ventesParMarqueModele = repo.findVentesParMarqueEtModele();
        ventesParMarqueModele.forEach(System.out::println);

        // TEST b)
        System.out.println("\n=== b) Ventes totales par marque (une ligne) ===");
        VenteTotaleParMarque venteTotale = repo.findVentesTotalesParMarque();
        System.out.println(venteTotale);

        // TEST c)
        System.out.println("\n=== c) Pourcentage de ventes par marque avant le 01/01/2026 ===");
        List<PourcentageVenteParMarque> pourcentages = repo.findPourcentageVentesAvant2026();
        pourcentages.forEach(System.out::println);


    }
}