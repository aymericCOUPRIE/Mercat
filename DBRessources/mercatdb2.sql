-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  mar. 22 déc. 2020 à 23:12
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
  `idCategory` int NOT NULL,
  `categoryName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `seller` int NOT NULL,
  `category` int NOT NULL,
  `idProduct` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  `companyName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`pseudo`, `firstName`, `lastName`, `password`, `emailAddress`, `streetAddress`, `city`, `postalCode`, `pictureUser`, `role`, `companyName`) VALUES
('Anna', 'sdsds', 'fdfdf', 'DfD810qtzIWW2knNOQ4mHbPA/Ka24tTbOVfZ/gT8Z1nGM86xOsBIPerCgV2a+9DhMF3lkYM1cN5uSFt3tyrS/Q==', 'anna@gmail.com', 'kdkjjf', 'sfsf', 'kkk', '', '', 'null'),
('Ayemr', 'Akokok', 'Mkjfkdjf', '345FFFFFFF', 'anan@g', '34 rue jelsjflj', 'JUJUJJ', '34567', '', '', 'null'),
('Ayemrd', 'ddddddddddd', 'ffffffffff', 'dffffffffff', 'dfffffffff', 'dfffd', 'dff', '23456', '', '', 'null'),
('juuuu', 'mmmsdsd', 'lsflsjfljfsljf', 'Annnakdfdkj', 'kdjflkjfldfj', 'ksjlsd', 'ksfjksfjfjsf', '34567', '', '', 'null'),
('momo', 'Moll', 'SDdd', 'DfD810qtzIWW2knNOQ4mHbPA/Ka24tTbOVfZ/gT8Z1nGM86xOsBIPerCgV2a+9DhMF3lkYM1cN5uSFt3tyrS/Q==', 'dkjdksjdksj@gmail.com', '56 ru ejdhd', 'Génissac', '22334', '', '', 'null'),
('spatchoun', 'aaal', 'lkjlkj', 'Anna2204', 'lksjflsjLK', 'LKJLKJKL', 'JKLJKLJ', 'llkj', 'kjkjkl', 'lkjlkj', 'lkjlj'),
('test', 'dfsfsffs', 'Mammam', '+lhdichR3TOKcNz1Naoqkv7ng23Wr/EiZYPojgmWKT8WvACcZSgm4PxccGaVoDzdzjcvE57/TROVnabx9dPqvg==', 'skskjfjfjfj@gmail.com', 'kjfjff', 'GGG', '23456', '', '', 'null'),
('Tibi', 'Stdfd', 'kljljlj', 'DfD810qtzIWW2knNOQ4mHbPA/Ka24tTbOVfZ/gT8Z1nGM86xOsBIPerCgV2a+9DhMF3lkYM1cN5uSFt3tyrS/Q==', 'anna@gmal.com', 'khkhsf', 'jjjjj', '33454', '', '', 'null');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`idCategory`);

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
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `idCategory` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `product`
--
ALTER TABLE `product`
  MODIFY `idProduct` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
