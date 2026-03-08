package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

  public List<VenteParMarqueModele> findVentesParMarqueEtModele() {
        List<VenteParMarqueModele> list = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    """
                    SELECT mv.marque, mv.modele, COALESCE(SUM(v.quantite), 0) AS nbre_pieces_vendus
                    FROM Modele_voiture mv
                    LEFT JOIN Piece_auto pa ON pa.id_modele_voiture = mv.id
                    LEFT JOIN Vente v ON v.id_piece_auto = pa.id
                    GROUP BY mv.marque, mv.modele
                    ORDER BY mv.marque, mv.modele
                    """
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VenteParMarqueModele vente = new VenteParMarqueModele();
                // setters
                vente.setMarque(resultSet.getString("marque"));
                vente.setModele(resultSet.getString("modele"));
                vente.setNbrePiecesVendus(resultSet.getInt("nbre_pieces_vendus"));
                list.add(vente);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

  public VenteTotaleParMarque findVentesTotalesParMarque() {
      try (Connection connection = DBConnection.getConnection()) {
          PreparedStatement preparedStatement = connection.prepareStatement(
                  """
                  SELECT
                      SUM(CASE WHEN mv.marque = 'KIA'    THEN v.quantite ELSE 0 END) AS nbre_piece_kia,
                      SUM(CASE WHEN mv.marque = 'DAEWOO' THEN v.quantite ELSE 0 END) AS nbre_piece_daewoo
                  FROM Vente v
                  JOIN Piece_auto pa ON pa.id = v.id_piece_auto
                  JOIN Modele_voiture mv ON mv.id = pa.id_modele_voiture
                  """
          );
          ResultSet resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
              VenteTotaleParMarque vente = new VenteTotaleParMarque();
              // setters
              vente.setNbrePieceKia(resultSet.getInt("nbre_piece_kia"));
              vente.setNbrePieceDaewoo(resultSet.getInt("nbre_piece_daewoo"));
              return vente;
          }
          return null;
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }


  public List<PourcentageVenteParMarque> findPourcentageVentesAvant2026() {
      List<PourcentageVenteParMarque> list = new ArrayList<>();
      try (Connection connection = DBConnection.getConnection()) {
          PreparedStatement preparedStatement = connection.prepareStatement(
                  """
                  SELECT mv.marque,
                      ROUND(SUM(v.quantite) * 100.0 / SUM(SUM(v.quantite)) OVER (), 0) || '%' AS pourcentage
                  FROM Vente v
                  JOIN Piece_auto pa ON pa.id = v.id_piece_auto
                  JOIN Modele_voiture mv ON mv.id = pa.id_modele_voiture
                  WHERE v.date < '2026-01-01'
                  GROUP BY mv.marque
                  ORDER BY mv.marque
                  """
          );
          ResultSet resultSet = preparedStatement.executeQuery();
          while (resultSet.next()) {
              PourcentageVenteParMarque pourcentage = new PourcentageVenteParMarque();
              // setters
              pourcentage.setMarque(resultSet.getString("marque"));
              pourcentage.setPourcentage(resultSet.getString("pourcentage"));
              list.add(pourcentage);
          }
          return list;
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }




}
