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
-- Table structure for table `sensor_setting`
--

CREATE TABLE IF NOT EXISTS `sensor_setting` (
  `id` int(10) NOT NULL,
  `temperature` varchar(5) NOT NULL,
  `humidity` varchar(5) NOT NULL,
  `moisture` varchar(5) NOT NULL,
  `air` varchar(5) NOT NULL,
  `sunlight` varchar(5) NOT NULL,
  `heat` varchar(5) NOT NULL,
  `duration` varchar(5) NOT NULL DEFAULT '5'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sensor_setting`
--

INSERT INTO `sensor_setting` (`id`, `temperature`, `humidity`, `moisture`, `air`, `sunlight`, `heat`, `duration`) VALUES
(1, 'OFF', 'ON', 'ON', 'OFF', 'OFF', 'OFF', '5');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sensor_setting`
--
ALTER TABLE `sensor_setting`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sensor_setting`
--
ALTER TABLE `sensor_setting`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
