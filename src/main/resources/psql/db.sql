CREATE USER hie_vente_voiture WITH PASSWORD 'voiture1234';
CREATE DATABASE vente_voiture;
\c vente_voiture;



GRANT CONNECT ON DATABASE postgres TO hie_vente_voiture;
GRANT USAGE ON SCHEMA public TO  hie_vente_voiture;

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE Modele_voiture TO hie_vente_voiture;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE Piece_auto TO hie_vente_voiture;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE Vente TO hie_vente_voiture;


GRANT USAGE, SELECT ON SEQUENCE Modele_voiture_id_seq TO hie_vente_voiture;
GRANT USAGE, SELECT ON SEQUENCE Piece_auto_id_seq TO hie_vente_voiture;
GRANT USAGE, SELECT ON SEQUENCE Vente_id_seq TO hie_vente_voiture;


ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO hie_vente_voiture;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO hie_vente_voiture;