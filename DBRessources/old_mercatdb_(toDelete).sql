-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Dec 28, 2020 at 05:06 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

/*
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `mercatdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Basket`
--

CREATE TABLE `Basket` (
    <<<<<<< HEAD
      `quantity` int(11) NOT NULL DEFAULT '1',
    `idProduct` int(11) NOT NULL,
    `pseudoConsumer` varchar(100) NOT NULL
        =======
        `quantity` int(11) NOT NULL DEFAULT '1',
    `idProduct` int(11) NOT NULL,
    `pseudoConsumer` varchar(100) NOT NULL
        >>>>>>> comment_rate
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
    <<<<<<< HEAD
      `LibelleCategorie` varchar(100) NOT NULL,
    `idCategorie` int(11) NOT NULL
        =======
        `LibelleCategorie` varchar(100) NOT NULL,
    `idCategorie` int(11) NOT NULL
        >>>>>>> comment_rate
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Comment`
--

CREATE TABLE `Comment` (
    <<<<<<< HEAD
      `ContentComment` varchar(100) NOT NULL,
    `idProduct` int(11) NOT NULL,
    `pseudoConsumer` varchar(100) NOT NULL
        =======
        `ContentComment` varchar(100) NOT NULL,
    `idProduct` int(11) NOT NULL,
    `pseudoConsumer` varchar(100) NOT NULL
        >>>>>>> comment_rate
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Order`
--

CREATE TABLE `Order` (
    <<<<<<< HEAD
      `quantity` int(11) NOT NULL,
    `dateOrder` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `deliveryDate` timestamp NULL DEFAULT NULL,
    `deliveryAdress` varchar(100) NOT NULL,
    `stateOrder` varchar(100) NOT NULL,
    `pseudoSeller` varchar(100) NOT NULL,
    `pseudoConsumer` varchar(100) NOT NULL,
    `idProduct` int(11) NOT NULL
        =======
        `quantity` int(11) NOT NULL,
    `dateOrder` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `deliveryDate` timestamp NULL DEFAULT NULL,
    `deliveryAdress` varchar(100) NOT NULL,
    `stateOrder` varchar(100) NOT NULL,
    `pseudoSeller` varchar(100) NOT NULL,
    `pseudoConsumer` varchar(100) NOT NULL,
    `idProduct` int(11) NOT NULL
        >>>>>>> comment_rate
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Product`
--

CREATE TABLE `Product` (
    <<<<<<< HEAD
      `nameProduct` varchar(100) NOT NULL,
    `priceProduct` float NOT NULL,
    `pictureProduct` varchar(100) NOT NULL,
    `pseudoSeller` varchar(100) NOT NULL,
    `idProduct` int(11) NOT NULL,
    `idCategorie` int(11) NOT NULL
        =======
        `nameProduct` varchar(100) NOT NULL,
    `priceProduct` float NOT NULL,
    `pictureProduct` varchar(100) NOT NULL,
    `pseudoSeller` varchar(100) NOT NULL,
    `idProduct` int(11) NOT NULL,
    `idCategorie` int(11) NOT NULL
        >>>>>>> comment_rate
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Rate`
--

CREATE TABLE `Rate` (
    <<<<<<< HEAD
      `rate` int(11) NOT NULL,
    `pseudoConsumer` varchar(100) NOT NULL,
    `pseudoSeller` varchar(100) NOT NULL,
    `idProduct` int(11) NOT NULL
        =======
        `rate` int(11) NOT NULL,
    `pseudoConsumer` varchar(100) NOT NULL,
    `pseudoSeller` varchar(100) NOT NULL,
    `idProduct` int(11) NOT NULL
        >>>>>>> comment_rate
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
    <<<<<<< HEAD
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
        =======
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
                                           >>>>>>> comment_rate
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`pseudo`, `firstName`, `lastName`, `password`, `emailAddress`, `streetAddress`, `city`, `postalCode`, `pictureUser`, `role`, `phoneNumber`, `companyName`) VALUES
('stephanie', 'a', 'a', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'a@a.fr', '3 rue cactus', 'Mexique', '3242', '', 'consumer', '0321225534', NULL),
('test', 'a', 'a', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'a@gmail.com', '4 rue tutu', 'lile', '4345', '', 'admin', '0765432213', NULL),
('ulisses', 'ulisses', 'mexican', '908mA5OaU2VpSEgM5x8c5GZoW2ZU/SLGHB8s5OLJbRzQLRYrVgxL6vGuRfNHHcXLwc4EBwHAtcOEV5iKoA/pfw==', 'mexicanboy@gmail.com', '342 rue ldez', 'Mexico', '22234', '', 'consumer', '0732184432', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Basket`
--
ALTER TABLE `Basket`
    <<<<<<< HEAD
    ADD PRIMARY KEY (`idProduct`,`pseudoConsumer`),
    ADD KEY `consumerBasket_property` (`pseudoConsumer`);
=======
    ADD PRIMARY KEY (`idProduct`,`pseudoConsumer`),
    ADD KEY `consumerBasket_property` (`pseudoConsumer`);
>>>>>>> comment_rate

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
    <<<<<<< HEAD
    ADD PRIMARY KEY (`idCategorie`);
=======
    ADD PRIMARY KEY (`idCategorie`);
>>>>>>> comment_rate

--
-- Indexes for table `Comment`
--
ALTER TABLE `Comment`
    <<<<<<< HEAD
    ADD PRIMARY KEY (`pseudoConsumer`,`idProduct`),
    ADD KEY `productComment_property` (`idProduct`);
=======
    ADD PRIMARY KEY (`pseudoConsumer`,`idProduct`),
    ADD KEY `productComment_property` (`idProduct`);
>>>>>>> comment_rate

--
-- Indexes for table `Order`
--
ALTER TABLE `Order`
    <<<<<<< HEAD
    ADD PRIMARY KEY (`idProduct`,`pseudoConsumer`,`dateOrder`),
    ADD KEY `sellerOder_property` (`pseudoSeller`),
    ADD KEY `consumerOder_property` (`pseudoConsumer`);
=======
    ADD PRIMARY KEY (`idProduct`,`pseudoConsumer`,`dateOrder`),
    ADD KEY `sellerOder_property` (`pseudoSeller`),
    ADD KEY `consumerOder_property` (`pseudoConsumer`);
>>>>>>> comment_rate

--
-- Indexes for table `Product`
--
ALTER TABLE `Product`
    <<<<<<< HEAD
    ADD PRIMARY KEY (`idProduct`),
    ADD KEY `category_property` (`idCategorie`),
    ADD KEY `seller_property` (`pseudoSeller`);
=======
    ADD PRIMARY KEY (`idProduct`),
    ADD KEY `category_property` (`idCategorie`),
    ADD KEY `seller_property` (`pseudoSeller`);
>>>>>>> comment_rate

--
-- Indexes for table `Rate`
--
ALTER TABLE `Rate`
    <<<<<<< HEAD
    ADD PRIMARY KEY (`pseudoConsumer`,`pseudoSeller`,`idProduct`),
    ADD KEY `pseudoSellerRate_property` (`pseudoSeller`),
    ADD KEY `productRate_property` (`idProduct`);
=======
    ADD PRIMARY KEY (`pseudoConsumer`,`pseudoSeller`,`idProduct`),
    ADD KEY `pseudoSellerRate_property` (`pseudoSeller`),
    ADD KEY `productRate_property` (`idProduct`);
>>>>>>> comment_rate

--
-- Indexes for table `user`
--
ALTER TABLE `user`
    <<<<<<< HEAD
    ADD PRIMARY KEY (`pseudo`);
=======
    ADD PRIMARY KEY (`pseudo`);
>>>>>>> comment_rate

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Category`
--
ALTER TABLE `Category`
    <<<<<<< HEAD
    MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT;
=======
    MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT;
>>>>>>> comment_rate

--
-- AUTO_INCREMENT for table `Product`
--
ALTER TABLE `Product`
    <<<<<<< HEAD
    MODIFY `idProduct` int(11) NOT NULL AUTO_INCREMENT;
=======
    MODIFY `idProduct` int(11) NOT NULL AUTO_INCREMENT;
>>>>>>> comment_rate

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Basket`
--
ALTER TABLE `Basket`
    <<<<<<< HEAD
    ADD CONSTRAINT `consumerBasket_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `productBasket_property` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE;
=======
    ADD CONSTRAINT `consumerBasket_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `productBasket_property` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE;
>>>>>>> comment_rate

--
-- Constraints for table `Comment`
--
ALTER TABLE `Comment`
    <<<<<<< HEAD
    ADD CONSTRAINT `consumerComment_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `productComment_property` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE;
=======
    ADD CONSTRAINT `consumerComment_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `productComment_property` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE;
>>>>>>> comment_rate

--
-- Constraints for table `Order`
--
ALTER TABLE `Order`
    <<<<<<< HEAD
    ADD CONSTRAINT `consumerOder_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `productOrder_property` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    ADD CONSTRAINT `sellerOder_property` FOREIGN KEY (`pseudoSeller`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;
=======
    ADD CONSTRAINT `consumerOder_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `productOrder_property` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    ADD CONSTRAINT `sellerOder_property` FOREIGN KEY (`pseudoSeller`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;
>>>>>>> comment_rate

--
-- Constraints for table `Product`
--
ALTER TABLE `Product`
    <<<<<<< HEAD
    ADD CONSTRAINT `category_property` FOREIGN KEY (`idCategorie`) REFERENCES `Category` (`idCategorie`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `seller_property` FOREIGN KEY (`pseudoSeller`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;
=======
    ADD CONSTRAINT `category_property` FOREIGN KEY (`idCategorie`) REFERENCES `Category` (`idCategorie`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `seller_property` FOREIGN KEY (`pseudoSeller`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;
>>>>>>> comment_rate

--
-- Constraints for table `Rate`
--
ALTER TABLE `Rate`
    <<<<<<< HEAD
    ADD CONSTRAINT `productRate_property` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `pseudoConsumerRate_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `pseudoSellerRate_property` FOREIGN KEY (`pseudoSeller`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;
=======
    ADD CONSTRAINT `productRate_property` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `pseudoConsumerRate_property` FOREIGN KEY (`pseudoConsumer`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `pseudoSellerRate_property` FOREIGN KEY (`pseudoSeller`) REFERENCES `user` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;
>>>>>>> comment_rate

*/