-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: mysql-mercat.alwaysdata.net
-- Generation Time: Jan 11, 2021 at 10:05 AM
-- Server version: 10.5.5-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mercat_db`
--
CREATE DATABASE IF NOT EXISTS `mercat_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `mercat_db`;

-- --------------------------------------------------------

--
-- Table structure for table `basket`
--

DROP TABLE IF EXISTS `basket`;
CREATE TABLE `basket` (
  `quantity` int(11) NOT NULL DEFAULT 1,
  `idProduct` int(11) NOT NULL,
  `pseudoConsumer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `basket`
--

INSERT INTO `basket` (`quantity`, `idProduct`, `pseudoConsumer`) VALUES
(3, 5, 'Admin'),
(2, 5, 'c'),
(1, 5, 's');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `LibelleCategorie` varchar(100) NOT NULL,
  `idCategorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`LibelleCategorie`, `idCategorie`) VALUES
('Informatique', 2),
('Maison', 3),
('Electroménager', 4),
('Livres', 5);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `ContentComment` varchar(100) NOT NULL,
  `idProduct` int(11) NOT NULL,
  `pseudoConsumer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`ContentComment`, `idProduct`, `pseudoConsumer`) VALUES
('Meilleur jupe !', 5, 'c');

-- --------------------------------------------------------

--
-- Table structure for table `orderdb`
--

DROP TABLE IF EXISTS `orderdb`;
CREATE TABLE `orderdb` (
  `dateOrder` timestamp NOT NULL DEFAULT current_timestamp(),
  `deliveryDate` timestamp NULL DEFAULT NULL,
  `deliveryAddress` varchar(100) NOT NULL,
  `stateOrder` varchar(100) NOT NULL,
  `pseudoConsumer` varchar(100) NOT NULL,
  `idOrder` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `orderdb`
--

INSERT INTO `orderdb` (`dateOrder`, `deliveryDate`, `deliveryAddress`, `stateOrder`, `pseudoConsumer`, `idOrder`) VALUES
('2021-01-08 11:44:03', '2021-01-07 23:00:00', 'seller ou consumer address', 'ORDER_CREATED', 'c', 14),
('2021-01-09 12:31:41', '2021-01-08 23:00:00', 'seller ou consumer address', 'ORDER_CREATED', 'c', 16),
('2021-01-10 12:32:18', '2021-01-09 23:00:00', 'Shop', 'start', 'c', 22),
('2021-01-10 12:33:46', '2021-01-09 23:00:00', 'Home', 'start', 'c', 23),
('2021-01-07 13:35:43', '2021-01-07 13:35:43', 'seller ou consumer address', 'ORDER_CREATED', 's', 13),
('2021-01-10 09:52:27', '2021-01-09 23:00:00', 'Shop', 'start', 's', 21),
('2021-01-07 13:35:43', '2026-01-03 23:00:00', '5 rue', 'end', 'sellerOrder', 15),
('2021-01-10 19:24:08', '2021-01-09 23:00:00', 'Home', 'start', 'stephanie', 28),
('2021-01-10 22:44:09', '2021-01-09 23:00:00', 'Home', 'start', 'stephanie', 29);

-- --------------------------------------------------------

--
-- Table structure for table `orderlistproduct`
--

DROP TABLE IF EXISTS `orderlistproduct`;
CREATE TABLE `orderlistproduct` (
  `idOrder` int(11) NOT NULL,
  `idProduct` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `orderlistproduct`
--

INSERT INTO `orderlistproduct` (`idOrder`, `idProduct`, `quantity`) VALUES
(14, 5, 3),
(15, 5, 2),
(15, 6, 10),
(28, 16, 10),
(29, 5, 1),
(29, 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `nameProduct` varchar(100) NOT NULL,
  `priceProduct` float NOT NULL,
  `pictureProduct` varchar(100) NOT NULL,
  `pseudoSeller` varchar(100) NOT NULL,
  `idProduct` int(11) NOT NULL,
  `idCategorie` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`nameProduct`, `priceProduct`, `pictureProduct`, `pseudoSeller`, `idProduct`, `idCategorie`, `description`) VALUES
('_*NePasSupprimer*_', 1, '', 'a', 0, 2, NULL),
('jupe', 25, 'none', 'ulisses', 5, 3, 'dezfd'),
('macbook pro', 2000, 'none', 'ulisses', 6, 2, 'zferg'),
('gourde', 12.12, '', 'Anna', 16, 2, 'Bks'),
('Gourde', 10, '', 'TheBoss', 17, 3, 'Une super gourde');

-- --------------------------------------------------------

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate` (
  `rate` int(11) NOT NULL,
  `pseudoConsumer` varchar(100) NOT NULL,
  `pseudoSeller` varchar(100) NOT NULL,
  `idProduct` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `rate`
--

INSERT INTO `rate` (`rate`, `pseudoConsumer`, `pseudoSeller`, `idProduct`) VALUES
(5, 'c', 'a', 5),
(3, 'c', 'ulisses', 0),
(2, 'stephanie', 'Admin', 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
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
  `phoneNumber` varchar(20) NOT NULL,
  `companyName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`pseudo`, `firstName`, `lastName`, `password`, `emailAddress`, `streetAddress`, `city`, `postalCode`, `pictureUser`, `role`, `phoneNumber`, `companyName`) VALUES
('123', '1', '1', 'El1tA7MshNSSdH95zwv24XnSh/NBOE611tMZdSWta+jm3wEWAyk1aY+ZoJ4mUHPR1sMsJ0WRvx0KIK1ny6khvA==', 'ac.co@gm.fr', '1', '1', '1', '', 'consumer', '0202020202', NULL),
('123456789', 'a', 'a', '+lhdichR3TOKcNz1Naoqkv7ng23Wr/EiZYPojgmWKT8WvACcZSgm4PxccGaVoDzdzjcvE57/TROVnabx9dPqvg==', 'azertyu@gmail.com', '3', 'R', '44450', '', 'consumer', '0202020202', NULL),
('12345678seller', 'bb', 'b', '9KoZqBB+Q/UNdeEdlZmRdUbY5gF9QyGuDenQ+uOcQxQcmwauLTFNBzQKc6EDER4a65ds8kWFQwy5Y+G0qsJreQ==', 'a@gmail.com', '4', '4', '44450', '', 'seller', '0808080808', 'test'),
('a', 'F', 'a', 'LF0YzUbdAEt7Vwie594EZsba8dI1Cka1hINh1vg3g3+9Yhpiqb/v8d5hIUjvuHzrjd7witR43kLarIgsRBn3ug==', '@', 'Street', 'City', '12', '', 'admin', '1212121212', NULL),
('Admin', 'Anna', 'Masante', 'DfD810qtzIWW2knNOQ4mHbPA/Ka24tTbOVfZ/gT8Z1nGM86xOsBIPerCgV2a+9DhMF3lkYM1cN5uSFt3tyrS/Q==', 'anna@gmail.com', '35 rue de machin', 'Libourne', '33100', '', 'consumer', '0909090909', NULL),
('Anna', 'sdfsfs', 'sfsfsfsf', '3QepyV8q/37WpdlXat8mNZDsenxo3vRRafzAmkKGmOWmQVH5VOpNDQ0F2kanYuXRVhsKIUZLwOn1IwSmzSo3DA==', 'anna@gmail.com', 'skdhskdh', 'sdsds', '34555', '', 'seller', '0909090909', NULL),
('Annatest', 'Anna', 'Masante', 'DfD810qtzIWW2knNOQ4mHbPA/Ka24tTbOVfZ/gT8Z1nGM86xOsBIPerCgV2a+9DhMF3lkYM1cN5uSFt3tyrS/Q==', 'anna@gmail.com', '45 rue de machni', 'Geni', '34500', '', 'consumer', '0909090909', NULL),
('Annn', 'llllljljljlj', 'mkfkdlfk', 'EIMcdXMJFhBP1m2vFO9NrEZLV1sYvw8BPugpGRvsV6H2AHBQ82QNN1e+eRPoDVGXqfCDmcCgFPHKNHGaiS/qXQ==', 'anna.masante@gmail.com', '34jkdfk', 'kkkk', '23456', '', 'consumer', '0909090909', NULL),
('AymericTest', 'a', 'a', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'a@gmail.com', 'r', 'rezr', '44450', '', 'consumer', '0202020202', NULL),
('bb', 'a', 'a', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'a', 'zare', 'zare', 'er', '', 'consumer', '0345678897', NULL),
('Bonjour', 'Anna', 'Masante', 'DfD810qtzIWW2knNOQ4mHbPA/Ka24tTbOVfZ/gT8Z1nGM86xOsBIPerCgV2a+9DhMF3lkYM1cN5uSFt3tyrS/Q==', 'anna@gmail.com', '34r iiiekjdf', 'dfsfsfs', 'dffdfdf', '', 'consumer', '0909090909', NULL),
('c', 'Vree', 'A', 'LF0YzUbdAEt7Vwie594EZsba8dI1Cka1hINh1vg3g3+9Yhpiqb/v8d5hIUjvuHzrjd7witR43kLarIgsRBn3ug==', '@', 'ez', 'dsd', '21', '', 'consumer', '1212121212', NULL),
('Chekjkjk', 'Anna', 'Masa', 'YY4gTU0JSs3mo9eTPrVNXl4uXsirZC4BxgKTYDaKq39qGNxAjYBiqsbeifM1MH/KqkIdZhNNDPcHcZuJRRK7pQ==', 'anna@gmail.com', 'rue de lll', 'Genn', '34567', '', 'consumer', '0909090909', NULL),
('Consom', 'Ann', 'Masa', 'DfD810qtzIWW2knNOQ4mHbPA/Ka24tTbOVfZ/gT8Z1nGM86xOsBIPerCgV2a+9DhMF3lkYM1cN5uSFt3tyrS/Q==', 'fdfdfd@gmail.com', '34rksf', 'Gnd', '23444', '', 'consumer', '0909090909', NULL),
('consumerTest', 'a', 'a', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'a.c@gmail.com', '5', 'nantes', '44450', '', 'consumer', '0808080808', NULL),
('eee', 'a', 'a', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'a@gmail.com', 'ztgdfr', 'zreztgz', 'etretgr', '', 'consumer', '0932145567', NULL),
('Keven', 'Akjd', 'dfsfsf', 'RXbxMtaibyszVBV8EqCkhNUhWGClG1lZNZET4FHiScpo7Ffpwqs8g7puWFrtSmeoIj6kjqH2saZyZVjJ4toZ3Q==', 'lsjfs@gmail.com', '45 rye de ksfh', 'genn', '34555', '', 'consumer', '0909909090', NULL),
('s', 'Florian', 'B', 'LF0YzUbdAEt7Vwie594EZsba8dI1Cka1hINh1vg3g3+9Yhpiqb/v8d5hIUjvuHzrjd7witR43kLarIgsRBn3ug==', 'ae@ez.com', 'rye', 'Ville', '20000', '', 'seller', '0609098987', 'Oui'),
('sellerOrder', 'seller', 'seller', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'seller@gmail.com', 'a', 'a', '11111', '', 'seller', '0202020202', NULL),
('stephanie', 'azert', 'azerty', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'a@free.fr', '3 rue cactus', 'Mexique', '34090', '', 'consumer', '0321225534', 'ezr'),
('test', 'a', 'a', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'a@gmail.com', '4 rue tutu', 'lile', '4345', '', 'admin', '0765432213', NULL),
('TheBoss', 'Anna', 'Masante', 'DfD810qtzIWW2knNOQ4mHbPA/Ka24tTbOVfZ/gT8Z1nGM86xOsBIPerCgV2a+9DhMF3lkYM1cN5uSFt3tyrS/Q==', 'anna@gmail.com', 'dfjfkd', 'Gkd', '34567', '', 'seller', '0909090909', 'Bobob'),
('ulisses', 'ulisses', 'mexican', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'mexicanboy@gmail.com', '342 rue ldez', 'Mexico', '22234', '', 'seller', '0732184432', 'E'),
('za', 'a', 'a', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'a', 'aaze', 'zert', 'ert', '', 'consumer', '0234567787', NULL),
('zaeaze', 'zea', 'azeaze', 'rTpT62rQtFIfqgV3ONic4wkkaiHEXm8kt6dyGI0lR8DRV3WfIq41TzAkWg8wiZaABteyKF3s2pEaLh8yMGgWFA==', 'ezaeaz@eaz.com', 'aze', 'aze', '12', '', 'consumer', '0909090909', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `basket`
--
ALTER TABLE `basket`
  ADD PRIMARY KEY (`idProduct`,`pseudoConsumer`) USING BTREE,
  ADD KEY `consumerBasket_property` (`pseudoConsumer`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`pseudoConsumer`,`idProduct`),
  ADD KEY `productComment_property` (`idProduct`);

--
-- Indexes for table `orderdb`
--
ALTER TABLE `orderdb`
  ADD PRIMARY KEY (`pseudoConsumer`,`dateOrder`) USING BTREE,
  ADD UNIQUE KEY `idOrder` (`idOrder`),
  ADD KEY `consumerOder_property` (`pseudoConsumer`);

--
-- Indexes for table `orderlistproduct`
--
ALTER TABLE `orderlistproduct`
  ADD PRIMARY KEY (`idOrder`,`idProduct`),
  ADD KEY `FK_idProduct` (`idProduct`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`idProduct`),
  ADD KEY `category_property` (`idCategorie`),
  ADD KEY `seller_property` (`pseudoSeller`);

--
-- Indexes for table `rate`
--
ALTER TABLE `rate`
  ADD PRIMARY KEY (`pseudoConsumer`,`pseudoSeller`,`idProduct`),
  ADD KEY `pseudoSellerRate_property` (`pseudoSeller`),
  ADD KEY `productRate_property` (`idProduct`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`pseudo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `orderdb`
--
ALTER TABLE `orderdb`
  MODIFY `idOrder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `idProduct` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `basket`
--
ALTER TABLE `basket`
  ADD CONSTRAINT `consumerBasket_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productBasket_property` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `consumerComment_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productComment_property` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderdb`
--
ALTER TABLE `orderdb`
  ADD CONSTRAINT `consumerOder_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderlistproduct`
--
ALTER TABLE `orderlistproduct`
  ADD CONSTRAINT `FK_idOrder` FOREIGN KEY (`idOrder`) REFERENCES `orderdb` (`idOrder`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_idProduct` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `category_property` FOREIGN KEY (`idCategorie`) REFERENCES `category` (`idCategorie`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seller_property` FOREIGN KEY (`pseudoSeller`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rate`
--
ALTER TABLE `rate`
  ADD CONSTRAINT `productRate_property` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pseudoConsumerRate_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pseudoSellerRate_property` FOREIGN KEY (`pseudoSeller`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
