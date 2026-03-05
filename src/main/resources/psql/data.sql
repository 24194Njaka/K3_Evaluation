-- Modeles de voiture (KIA + DAEWOO, pas HYUNDAI selon le contexte)
INSERT INTO Modele_voiture (marque, modele) VALUES
                                                ('KIA',    'SPORTAGE'),   -- id = 1
                                                ('KIA',    'SORENTO'),    -- id = 2
                                                ('KIA',    'WINDSTORM'),  -- id = 3
                                                ('DAEWOO', 'SPORTAGE'),   -- id = 4
                                                ('DAEWOO', 'SORENTO'),    -- id = 5
                                                ('DAEWOO', 'WINDSTORM');  -- id = 6

-- Pièces automobiles
INSERT INTO Piece_auto (id_modele_voiture, numero_serie) VALUES
                                                             (1, 'KIA-SP-001'),   -- id = 1 → KIA SPORTAGE
                                                             (1, 'KIA-SP-002'),   -- id = 2 → KIA SPORTAGE
                                                             (2, 'KIA-SO-001'),   -- id = 3 → KIA SORENTO
                                                             (2, 'KIA-SO-002'),   -- id = 4 → KIA SORENTO
                                                             (3, 'KIA-WS-001'),   -- id = 5 → KIA WINDSTORM
                                                             (4, 'DAE-SP-001'),   -- id = 6 → DAEWOO SPORTAGE
                                                             (5, 'DAE-SO-001'),   -- id = 7 → DAEWOO SORENTO
                                                             (6, 'DAE-WS-001');   -- id = 8 → DAEWOO WINDSTORM

-- Ventes (avant et après le 1er janvier 2026 pour la question c)
INSERT INTO Vente (id_piece_auto, quantite, date) VALUES
                                                      -- Avant 2026 (pour question c)
                                                      (1, 5,  '2025-03-10'),   -- KIA SPORTAGE
                                                      (1, 3,  '2025-06-15'),   -- KIA SPORTAGE
                                                      (2, 2,  '2025-07-20'),   -- KIA SPORTAGE
                                                      (3, 8,  '2025-04-05'),   -- KIA SORENTO
                                                      (3, 7,  '2025-09-18'),   -- KIA SORENTO
                                                      (4, 5,  '2025-11-22'),   -- KIA SORENTO
                                                      (6, 4,  '2025-05-30'),   -- DAEWOO SPORTAGE
                                                      (7, 6,  '2025-08-14'),   -- DAEWOO SORENTO

                                                      -- Après 2026 (pour différencier question c)
                                                      (1, 4,  '2026-01-10'),   -- KIA SPORTAGE
                                                      (3, 6,  '2026-02-05'),   -- KIA SORENTO
                                                      (5, 2,  '2026-01-25'),   -- KIA WINDSTORM
                                                      (8, 3,  '2026-02-18');   -- DAEWOO WINDSTORM