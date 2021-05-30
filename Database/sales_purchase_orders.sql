-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2019 at 09:09 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `modagrospark`
--

-- --------------------------------------------------------

--
-- Table structure for table `sales_purchase_orders`
--

CREATE TABLE IF NOT EXISTS `sales_purchase_orders` (
  `id` int(10) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(10) NOT NULL,
  `order_type` varchar(20) NOT NULL DEFAULT 'Not Specified',
  `product_type` varchar(20) NOT NULL,
  `product_name` varchar(20) NOT NULL,
  `quantity` varchar(20) NOT NULL,
  `merchant` varchar(30) NOT NULL,
  `description` varchar(500) NOT NULL DEFAULT 'No Description for order'
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_purchase_orders`
--

INSERT INTO `sales_purchase_orders` (`id`, `date`, `time`, `order_type`, `product_type`, `product_name`, `quantity`, `merchant`, `description`) VALUES
(2, '2019-05-01', '11:36 AM', 'Sales Order', 'Leafy vegetables', 'Barley', '2145kg', 'vaibhav.lagad10@gmail.com', 'asfryhrhh\nhet\nhth\ndgth\ng\njy\njryj'),
(3, '2019-04-29', '12:40 PM', 'Purchase Order', 'Pesticides', 'Compound fertilizers', '3 bottels', 'vaibhav.lagad10@gmail.com', 'sfsdhdfff\nnfnentjrjn\nfdnethj\nerhdf\nngm'),
(5, '2019-05-06', '03:11 PM', 'Purchase Order', 'Seeds', 'Herbicides - plants', '6 bags', 'roshan.lagad11@gmail.com', 'adghsfd\nggsbdjger\njhyk\nj,bv\ncx\ntrdi\ngykhm'),
(6, '2019-05-03', '03:12 PM', 'Purchase Order', 'Pesticides', 'Compound fertilizers', '1 bottle', 'vaibhav.lagad12@gmail.com', 'asfsgasf\ngqwtgehb\ndsbhe3wy\nr.'),
(7, '2019-05-07', '04:15 PM', 'Purchase Order', 'Seeds', 'Organic fertilizers', '45', 'vaibhav.lagad10@gmail.com', 'Xdc');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sales_purchase_orders`
--
ALTER TABLE `sales_purchase_orders`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sales_purchase_orders`
--
ALTER TABLE `sales_purchase_orders`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
