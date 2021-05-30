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
-- Table structure for table `sensor_alerts`
--

CREATE TABLE IF NOT EXISTS `sensor_alerts` (
  `id` int(10) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `parameter` varchar(30) NOT NULL,
  `value` varchar(10) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'Not Specified'
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sensor_alerts`
--

INSERT INTO `sensor_alerts` (`id`, `date`, `time`, `parameter`, `value`, `status`) VALUES
(18, '07-05-2019', '12:03 AM', 'Moisture', '6', 'Low'),
(19, '07-05-2019', '12:03 AM', 'Moisture', '5', 'Low'),
(20, '07-05-2019', '12:03 AM', 'Temperature', '42', 'High'),
(21, '07-05-2019', '12:03 AM', 'Moisture', '7', 'Low'),
(22, '07-05-2019', '12:03 AM', 'Moisture', '6', 'Low'),
(23, '07-05-2019', '12:03 AM', 'Moisture', '2', 'Low'),
(24, '07-05-2019', '12:03 AM', 'Moisture', '7', 'Low'),
(25, '07-05-2019', '12:03 AM', 'Temperature', '42', 'High'),
(26, '07-05-2019', '12:03 AM', 'Moisture', '3', 'Low'),
(27, '07-05-2019', '12:04 AM', 'Temperature', '42', 'High'),
(28, '07-05-2019', '12:04 AM', 'Moisture', '7', 'Low'),
(29, '07-05-2019', '12:04 AM', 'Moisture', '3', 'Low');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sensor_alerts`
--
ALTER TABLE `sensor_alerts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sensor_alerts`
--
ALTER TABLE `sensor_alerts`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
