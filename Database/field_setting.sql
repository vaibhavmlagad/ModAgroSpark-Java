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
-- Table structure for table `field_setting`
--

CREATE TABLE IF NOT EXISTS `field_setting` (
  `id` int(10) NOT NULL,
  `field_size` varchar(20) NOT NULL DEFAULT 'Not Set',
  `soil_type` varchar(20) NOT NULL,
  `irrigation` varchar(30) NOT NULL,
  `crop_type` varchar(30) NOT NULL,
  `crop_name` varchar(20) NOT NULL DEFAULT 'Not Set',
  `crop_variety` varchar(30) NOT NULL DEFAULT 'Not Set',
  `date_of_cultivation` varchar(20) NOT NULL DEFAULT 'Not Set'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `field_setting`
--

INSERT INTO `field_setting` (`id`, `field_size`, `soil_type`, `irrigation`, `crop_type`, `crop_name`, `crop_variety`, `date_of_cultivation`) VALUES
(1, '3 Hects', 'Clay Soil', 'Sprinkler Irrigation', 'Grains', 'Wheat', 'SAMBA-565', '2 April, 2019');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `field_setting`
--
ALTER TABLE `field_setting`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `field_setting`
--
ALTER TABLE `field_setting`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
