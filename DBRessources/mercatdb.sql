-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  lun. 28 déc. 2020 à 15:34
-- Version du serveur :  8.0.22-0ubuntu0.20.04.3
-- Version de PHP :  7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `mercatdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `nameCategory` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`nameCategory`) VALUES
('Informatique');

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` varchar(100) NOT NULL,
  `seller` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `idProduct` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`name`, `description`, `price`, `seller`, `category`, `idProduct`) VALUES
('', 'ddsdsds', '0.0', '', 'Informatique', 1),
('', 'ddsdsds', '0.0', '', 'Informatique', 2),
('', 'ddsdsds', '0.0', '', 'Informatique', 3),
('', 'ddsdsds', '0.0', '', 'Informatique', 4),
('', 'Momo', '0.0', '', 'Informatique', 5),
('Table', 'Momkdkdk', '12.12', 'Anna', 'Informatique', 6),
('Mouton', 'Mommmdd', '12.0', 'Anna', 'Informatique', 7);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `pseudo` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `emailAddress` varchar(100) NOT NULL,
  `streetAddress` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `postalCode` varchar(100) NOT NULL,
  `pictureUser` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  `companyName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`pseudo`, `firstName`, `lastName`, `password`, `emailAddress`, `streetAddress`, `city`, `postalCode`, `pictureUser`, `role`, `phoneNumber`, `companyName`) VALUES
('Admin', 'fsfsf', 'sfsfsfsf', 'DfD810qtzIWW2knNOQ4mHbPA/Ka24tTbOVfZ/gT8Z1nGM86xOsBIPerCgV2a+9DhMF3lkYM1cN5uSFt3tyrS/Q==', 'ksjkfjf@gmail.com', 'ksjfksfjs', 'fdfdfdfdf', '43555', '', '', '0909090909', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`nameCategory`);

--
-- Index pour la table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`idProduct`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`pseudo`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `product`
--
ALTER TABLE `product`
  MODIFY `idProduct` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
