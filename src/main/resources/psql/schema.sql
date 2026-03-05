-- Table Modele_voiture
CREATE TYPE marque_enum AS ENUM ('KIA', 'HYUNDAI', 'DAEWOO');
CREATE TYPE modele_enum AS ENUM ('SPORTAGE', 'SORENTO', 'WINDSTORM');

CREATE TABLE Modele_voiture (
                                id SERIAL PRIMARY KEY,
                                marque marque_enum NOT NULL,
                                modele modele_enum NOT NULL
);

-- Table Piece_auto
CREATE TABLE Piece_auto (
                            id SERIAL PRIMARY KEY,
                            id_modele_voiture INT NOT NULL,
                            numero_serie VARCHAR(50) NOT NULL,
                            FOREIGN KEY (id_modele_voiture) REFERENCES Modele_voiture(id)
);

-- Table Vente
CREATE TABLE Vente (
                       id SERIAL PRIMARY KEY,
                       id_piece_auto INT NOT NULL,
                       quantite INT NOT NULL,
                       date DATE NOT NULL,
                       FOREIGN KEY (id_piece_auto) REFERENCES Piece_auto(id)
);