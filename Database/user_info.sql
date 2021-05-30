-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2019 at 09:10 PM
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
-- Table structure for table `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `full_name` varchar(30) DEFAULT NULL,
  `city` varchar(30) NOT NULL,
  `locality` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `pincode` varchar(10) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `otp` int(7) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`id`, `username`, `password`, `full_name`, `city`, `locality`, `state`, `pincode`, `email`, `mobile`, `otp`) VALUES
(1, 'vaibhavlagad', 'lagad1111', 'Vaibhav Mohan Lagad', 'Ahmednagar', 'Kolgaon', 'Maharashtra', '413728', 'vaibhav.lagad11@gmail.com', '9823273648', NULL),
(2, 'sidgote', 'sid2007', 'Siddharth Nandkumar Gote', 'Pune', 'Vadgaonsheri', 'Maharashtra', '411007', 'siddharthgote2007@gmail.com', '9028142007', NULL),
(3, 'rutikbhandwalkar', 'rutik03', 'Rutik Bhandwalkar', 'Usmanabad', NULL, 'Maharashtra', '411225', 'rutikbhandwalkar777@gmail.com', '9656892345', NULL),
(4, 'omkarshirase', '123456789', 'Omkar Sanjay Shirase', 'Pune', 'Keshavnagar', 'Maharashtra', '411036', 'omkarshirase2000@gmail.com', '9112363782', 680983),
(5, 'surajlagad', 'suraj@123', 'Suraj Rajendra Lagad', 'Kolgaon', 'Manmodiwadi', 'Maharashtra', '413728', 'surajlagad99@gmail.com', '9309744295', NULL),
(7, 'roshanlagad', 'lagad1111', NULL, 'Kolgaon', NULL, NULL, NULL, 'roshan.lagad11@gmail.com', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Username` (`username`),
  ADD UNIQUE KEY `Email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
