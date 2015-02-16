-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Feb 16, 2015 at 02:11 PM
-- Server version: 5.5.38
-- PHP Version: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `FacilityProblems`
--

-- --------------------------------------------------------

--
-- Table structure for table `FacilityProblems`
--

CREATE TABLE `FacilityProblems` (
  `Id` int(11) NOT NULL,
  `FacilityId` int(11) NOT NULL,
  `Current` tinyint(1) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `FacilityTable`
--

CREATE TABLE `FacilityTable` (
  `Id` int(11) NOT NULL,
  `Vacant` tinyint(1) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Cost` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Maintenance`
--

CREATE TABLE `Maintenance` (
  `MaintReqId` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `Completed` tinyint(1) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `MaintenanceRequest`
--

CREATE TABLE `MaintenanceRequest` (
  `FacilityId` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `Current` tinyint(1) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `EstimatedCost` double NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Person`
--

CREATE TABLE `Person` (
  `RenterId` int(11) NOT NULL,
  `OwnerId` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Person`
--

INSERT INTO `Person` (`RenterId`, `OwnerId`, `Id`, `FirstName`, `LastName`, `Age`) VALUES
(1, 1, 1, 'Jeel', 'Patel', 23),
(2, 2, 2, 'Ethan ', 'Le', 20);

-- --------------------------------------------------------

--
-- Table structure for table `Use`
--

CREATE TABLE `Use` (
  `FacilityId` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `Description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Use`
--

INSERT INTO `Use` (`FacilityId`, `Id`, `StartDate`, `EndDate`, `Description`) VALUES
(1, 1, '2015-02-15', '2015-02-17', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
