-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 18, 2020 at 12:45 AM
-- Server version: 5.7.29-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `PracticeSecurityDB`
--
CREATE DATABASE IF NOT EXISTS `PracticeSecurityDB` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `PracticeSecurityDB`;

-- --------------------------------------------------------

--
-- Table structure for table `GroupTB`
--

CREATE TABLE `GroupTB` (
  `UserId` varchar(50) NOT NULL,
  `GroupName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `GroupTB`
--

INSERT INTO `GroupTB` (`UserId`, `GroupName`) VALUES
('Admin', 'Admin'),
('AdminAdmin', 'AdminAdmin'),
('Supervisor', 'Supervisor'),
('SupervisorSupervisor', 'SupervisorSupervisor');

-- --------------------------------------------------------

--
-- Table structure for table `UserTB`
--

CREATE TABLE `UserTB` (
  `UserId` varchar(50) NOT NULL,
  `Password` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `UserTB`
--

INSERT INTO `UserTB` (`UserId`, `Password`) VALUES
('Admin', 'adminadmin'),
('AdminAdmin', 'PBKDF2WithHmacSHA256:2048:A8QskdRao2pgim5iEkb1yv47Dx1g+iKz5d9upCWKonw=:8zB9AcSsd03QwYsceIOBpvIlscEOCN5mFp96B+Ywlhg='),
('Common', 'common'),
('Supervisor', 'supervisor'),
('SupervisorSupervisor', 'PBKDF2WithHmacSHA256:2048:uchUAV6c0DVgA0VodVx7poAGtpf1xz7fmcVB0tfriq0=:naw/AuuIH41YNfrkwCq1PTy6fucohJ5kKQGnBNUonDY=');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `GroupTB`
--
ALTER TABLE `GroupTB`
  ADD PRIMARY KEY (`UserId`,`GroupName`);

--
-- Indexes for table `UserTB`
--
ALTER TABLE `UserTB`
  ADD PRIMARY KEY (`UserId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `GroupTB`
--
ALTER TABLE `GroupTB`
  ADD CONSTRAINT `FK_UserId` FOREIGN KEY (`UserId`) REFERENCES `UserTB` (`UserId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
