--
-- Contenu de la table `ACTION`
--
INSERT INTO `ACTION` (`NUMACTION`, `ACT_NUMACTION`, `LIBACTION`, `SCOREMIN`) VALUES
  (1, NULL, 'Se mettre en tenue', 7),
  (2, 1, 'Préparation véhicule', 7),
  (3, NULL, 'Respect sécurité', 11),
  (4, 3, 'Effectuer manoeuvre', 7),
  (5, NULL, 'Emettre hypothèse', 12),
  (6, 5, 'Proposer solution', 7),
  (7, 6, 'Evaluation solution', 11),
  (8, 7, 'Effectuer solution', 10),
  (9, NULL, 'Accéder mécanique', 7),
  (10, 9, 'Vérifications mécanique', 9),
  (11, 10, 'Analyser panne(s)', 11),
  (12, 10, 'Effectuer niveaux', 10),
  (13, NULL, 'Réaction', 7),
  (14, 13, 'Action face au danger', 13),
  (15, NULL, 'Prise d''informations', 7),
  (16, 15, 'Placement', 12),
  (17, 15, 'Utilisation outils comm', 9),
  (18, NULL, 'Respect protocole comm', 15),
  (19, NULL, 'Travail rendu à temps', 13);

--
-- Contenu de la table `USERS`
--
INSERT INTO `USERS` (`IDUSERS`, `USERNAME`, `NOMUSERS`, `PRENOMUSERS`, `PASSWORD`, `ENABLED`) VALUES
  (1, 'valentin', 'andre', 'valentin', 'valentin', 1),
  (2, 'nathan', 'francois', 'nathan', 'nathan', 1),
  (3, 'hakan', 'sener', 'hakan', 'hakan', 1),
  (4, 'franck', 'lacastaigneratte', 'franck', 'franck', 1),
  (5, 'sylvain', 'begou', 'sylvain', 'sylvain', 1),
  (6, 'admin', 'admin', 'admin', 'admin', 1);
  
  
--
-- Contenu de la table `USER_ROLES`
--
INSERT INTO `USER_ROLES` (`USER_ROLE_ID`, `USER_ID`, `ROLE`) VALUES
  (1, 1, 'ROLE_USER'),
  (2, 2, 'ROLE_USER'),
  (3, 3, 'ROLE_USER'),
  (4, 4, 'ROLE_USER'),
  (5, 5, 'ROLE_USER'),
  (6, 6, 'ROLE_ADMIN');

--
-- Contenu de la table `JEU`
--
INSERT INTO `JEU` (`NUMJEU`, `LIBELLEJEU`) VALUES
  (1, 'Jeu n°1'),
  (2, 'Jeu n°2');

--
-- Contenu de la table `MISSION`
--
INSERT INTO `MISSION` (`NUMMISSION`, `LIBMISSION`) VALUES
  (1, 'Mission A'),
  (2, 'Mission B'),
  (3, 'Mission C'),
  (4, 'Mission 3'),
  (5, 'Mission A2'),
  (6, 'Mission B2'),
  (7, 'Mission C2'),
  (8, 'Mission D2');

--
-- Contenu de la table `COMPREND`
--
INSERT INTO `COMPREND` (`NUMJEU`, `NUMMISSION`) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 5),
  (2, 6),
  (2, 7),
  (2, 8);

--
-- Contenu de la table `OBJECTIF`
--
INSERT INTO `OBJECTIF` (`NUMOBJECTIF`, `LIBOBECTIF`) VALUES
  (1, 'Réussir manoeuvre'),
  (2, 'Analyse des problèmes'),
  (3, 'Vérifier mécanique'),
  (4, 'Réagir au danger'),
  (5, 'Prise de poste correcte'),
  (6, 'Placement sur la voie'),
  (7, 'Interaction avec pilote'),
  (8, 'Respect délai');


--
-- Contenu de la table `CALENDRIER`
--
INSERT INTO `CALENDRIER` (`DATEJOUR`) VALUES
  ('2016-06-18 10:34:09'),
  ('2016-06-19 10:34:09'),
  ('2016-06-20 10:34:09'),
  ('2016-06-21 10:34:09');
  
--
-- Contenu de la table `OBTIENT`
--
INSERT INTO `OBTIENT` (`IDUSERS`, `DATEJOUR`, `NUMACTION`, `VALEURDEBUT`, `VALEURFIN`) VALUES
  (2, '2016-06-18 10:34:09', 3, 12, 15),
  (2, '2016-06-19 10:34:09', 4, 8, 11),
  (2, '2016-06-20 10:34:09', 5, 12, 15),
  (2, '2016-06-21 10:34:09', 6, 18, 20);
  
--
-- Contenu de la table `EST_ASSOCIE`
--
INSERT INTO `EST_ASSOCIE` (`NUMACTION`, `NUMOBJECTIF`) VALUES
  (1, 5),
  (2, 5),
  (3, 1),
  (3, 5),
  (3, 6),
  (4, 1),
  (6, 2),
  (7, 2),
  (8, 2),
  (10, 3),
  (11, 3),
  (12, 3),
  (13, 4),
  (14, 4),
  (15, 6),
  (15, 7),
  (16, 6),
  (17, 7),
  (18, 7),
  (19, 8);

--
-- Contenu de la table `FIXE`
--
INSERT INTO `FIXE` (`NUMMISSION`, `NUMOBJECTIF`) VALUES
  (1, 1),
  (1, 4),
  (1, 5),
  (1, 6),
  (2, 2),
  (2, 3),
  (2, 5),
  (3, 5),
  (3, 7),
  (3, 8),
  (4, 3),
  (4, 4),
  (5, 1),
  (5, 5),
  (5, 7),
  (5, 8),
  (6, 2),
  (7, 7),
  (8, 5);

--
-- Contenu de la table `INDICATEUR`
--
INSERT INTO `INDICATEUR` (`NUMINDIC`, `NUMACTION`, `LIBINDIC`, `POIDS`) VALUES
  (1, 1, '1', 1),
  (2, 2, '2', 2),
  (3, 3, '3', 5),
  (4, 4, '4', 4),
  (5, 5, '5', 1),
  (6, 6, '6', 2),
  (7, 7, '7', 3),
  (8, 8, '8', 2),
  (9, 9, '9', 1),
  (10, 10, '10', 2),
  (11, 11, '11', 3),
  (12, 12, '12', 1),
  (13, 13, '13', 1),
  (14, 14, '14', 3),
  (15, 15, '15', 1),
  (16, 16, '16', 2),
  (17, 17, '17', 1),
  (18, 18, '18', 5),
  (19, 19, '19', 1);

--
-- Contenu de la table `INSCRIPTION`
--
INSERT INTO `INSCRIPTION` (`NUMAPPRENANT`, `NUMJEU`, `DATEINSCRIPTION`) VALUES
  (1, 2, '2016-03-18 10:34:09'),
  (3, 1, '2015-05-18 10:34:09'),
  (3, 2, '2014-07-02 10:34:09'),
  (2, 1, '2013-06-16 10:34:09'),
  (2, 2, '2012-09-14 10:34:09'),
  (4, 1, '2012-08-25 10:34:09');
  
--
-- Contenu de la table `REGLE`
--
INSERT INTO `REGLE` (`NUMREGLE`, `LIBREGLE`, `SCOREMIN`) VALUES
  (1, 'regle 1', 10),
  (2, 'regle 2', 12),
  (3, 'regle 3', 10),
  (4, 'regle 4', 15);
  
--
-- Contenu de la table `POSSEDE`
--
INSERT INTO `POSSEDE` (`NUMACTION`, `NUMREGLE`) VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (3, 4);
