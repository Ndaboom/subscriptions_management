-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : sam. 08 juil. 2023 à 08:16
-- Version du serveur : 5.7.39
-- Version de PHP : 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `subscriptions_management`
--

-- --------------------------------------------------------

--
-- Structure de la table `login_table`
--

CREATE TABLE `login_table` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `login_table`
--

INSERT INTO `login_table` (`username`, `password`) VALUES
('admin', '012345');

-- --------------------------------------------------------

--
-- Structure de la table `membres`
--

CREATE TABLE `membres` (
  `id` int(11) NOT NULL,
  `nom` varchar(500) NOT NULL,
  `prenom` varchar(500) NOT NULL,
  `sexe` varchar(150) NOT NULL,
  `date_naissance` date DEFAULT NULL,
  `lieu_naissance` varchar(500) NOT NULL,
  `profession` varchar(500) NOT NULL,
  `statut_membre` varchar(200) NOT NULL DEFAULT 'Active',
  `telephone` varchar(70) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `partenaire_avec` int(11) DEFAULT NULL,
  `date_enregistrement` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `membres`
--

INSERT INTO `membres` (`id`, `nom`, `prenom`, `sexe`, `date_naissance`, `lieu_naissance`, `profession`, `statut_membre`, `telephone`, `email`, `partenaire_avec`, `date_enregistrement`) VALUES
(1, 'NDABO', 'Sammy', 'Masculin', '1999-11-06', 'Goma', 'Informaticien', 'Actif', '(243)973-886-132', 'ndabosam084@gmail.com', NULL, '2023-06-23'),
(2, 'BERNARD', 'Mali', 'Masculin', '2023-06-23', 'Goma', 'Professeur', 'Actif', '(243)   -   -   ', 'bernardmali@gmail.com', NULL, '2023-06-24'),
(3, 'GALIEN', 'Makutano', 'Masculin', '2023-06-24', 'Bukavu', 'Commercant', 'Actif', '(243)   -   -   ', 'ndabosam084@gmail.com', NULL, '2023-06-25'),
(4, 'JEAN BAPTISTE', 'Mugisha', 'Masculin', '2023-07-08', 'Goma', 'Docteur', 'Actif', '(243)   -   -   ', 'ndabosam084@gmail.com', NULL, '2023-07-15'),
(5, 'MARIE', 'Magdaleine', 'Feminin', '2023-07-08', 'Goma', '-', 'Actif', '(243)   -   -   ', 'ndabosam084@gmail.com', 4, '2023-07-15');

-- --------------------------------------------------------

--
-- Structure de la table `settings`
--

CREATE TABLE `settings` (
  `id` int(11) NOT NULL,
  `current_initial_capital` float NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `settings`
--

INSERT INTO `settings` (`id`, `current_initial_capital`, `created_at`) VALUES
(1, 20000, '2023-06-26 14:27:57');

-- --------------------------------------------------------

--
-- Structure de la table `transactions_table`
--

CREATE TABLE `transactions_table` (
  `id` int(11) NOT NULL,
  `libelle` varchar(100) NOT NULL,
  `montant` float NOT NULL DEFAULT '0',
  `personne` varchar(250) NOT NULL,
  `personne_id` int(11) NOT NULL,
  `type_pret` varchar(100) DEFAULT NULL,
  `gain_percentage` float DEFAULT NULL,
  `interet` float DEFAULT '0',
  `cumul_interet` float DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `transactions_table`
--

INSERT INTO `transactions_table` (`id`, `libelle`, `montant`, `personne`, `personne_id`, `type_pret`, `gain_percentage`, `interet`, `cumul_interet`, `date`) VALUES
(1, 'Crédit', 500, '1 NDABO Sammy', 1, '-- --', NULL, 0, NULL, '2023-06-24 01:22:49'),
(2, 'Débit', 100, '1 NDABO Sammy', 1, 'Ordinaire', NULL, 0, NULL, '2023-06-24 01:23:18'),
(3, 'Crédit', 300, '3 GALIEN Makutano', 3, '-- --', NULL, 0, NULL, '2023-06-24 01:24:16'),
(5, 'Débit', 400, '2 BERNARD Mali', 2, 'Ordinaire', NULL, 8, 8, '2023-06-26 08:48:50'),
(6, 'Débit', 400, '1 NDABO Sammy', 1, 'Express', NULL, 16, 16, '2023-06-26 08:51:21'),
(7, 'Débit', 300, '3 GALIEN Makutano', 3, 'Express', NULL, 12, 12, '2023-06-26 08:54:40'),
(8, 'Débit', 100, '2 BERNARD Mali', 2, 'Ordinaire', NULL, 2, 2, '2023-06-26 09:15:46'),
(9, 'Débit', 100, '1 NDABO Sammy', 1, 'Ordinaire', NULL, 2, 2, '2023-06-26 09:20:06'),
(10, 'Débit', 300, '2 BERNARD Mali', 2, 'Ordinaire', NULL, 6, 6, '2023-06-26 16:09:35'),
(11, 'Crédit', 200, '1 NDABO Sammy', 1, '-- --', NULL, 0, 0, '2023-06-26 16:10:04'),
(12, 'Débit', 400, '3 GALIEN Makutano', 3, 'Ordinaire', NULL, 8, 8, '2023-07-03 12:02:18'),
(13, 'Débit', 300, '2 BERNARD Mali', 2, 'Ordinaire', NULL, 6, 6, '2023-07-03 17:37:25'),
(14, 'Crédit', 300, '2 BERNARD Mali', 2, '-- --', NULL, 0, 0, '2023-07-03 17:38:13');

--
-- Déclencheurs `transactions_table`
--
DELIMITER $$
CREATE TRIGGER `update_interet_trigger` BEFORE INSERT ON `transactions_table` FOR EACH ROW BEGIN
    -- Declare and initialize variables for previous cumulative interet and current cumulative value
    DECLARE prev_cumul_interet DECIMAL(10,2) DEFAULT 0;
    DECLARE current_cumul DECIMAL(10,2) DEFAULT 0;

    -- Get the previous cumulative interet value
    SELECT COALESCE(SUM(cumul_interet), 0) INTO prev_cumul_interet
    FROM transactions_table
    WHERE id < NEW.id;

    -- Calculate the current cumulative interet value based on type_pret
    IF NEW.type_pret = 'Express' THEN
        SET current_cumul = prev_cumul_interet + NEW.montant * 0.04;
        SET NEW.interet = NEW.montant * 0.04;
    ELSEIF NEW.type_pret = 'Ordinaire' THEN
        SET current_cumul = prev_cumul_interet + NEW.montant * 0.02;
        SET NEW.interet = NEW.montant * 0.02;
    END IF;

    -- Set the cumulative interet value for the inserted row
    SET NEW.cumul_interet = current_cumul;
END
$$
DELIMITER ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `membres`
--
ALTER TABLE `membres`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `settings`
--
ALTER TABLE `settings`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `transactions_table`
--
ALTER TABLE `transactions_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `membres`
--
ALTER TABLE `membres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `settings`
--
ALTER TABLE `settings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `transactions_table`
--
ALTER TABLE `transactions_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
