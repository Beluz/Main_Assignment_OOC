-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2019 at 12:23 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ultra_vision`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_Id` char(10) NOT NULL,
  `c_Name` char(100) DEFAULT NULL,
  `c_Address` char(100) DEFAULT NULL,
  `c_Membership` char(20) DEFAULT NULL,
  `c_Phone` char(10) DEFAULT NULL,
  `c_Points` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_Id`, `c_Name`, `c_Address`, `c_Membership`, `c_Phone`, `c_Points`) VALUES
('2222222222', 'Leopardstown Dublin 18 Ireland', 'Gregor Grabowsky', 'VL', '0834222222', 0),
('3333333333', 'Ken Connors', 'Leopardstown Dublin18', 'TV', '0834567890', 0),
('9999999999', 'Dublin 3 Ire', 'Beluz Suarez', 'ML', '0834665210', 90);

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `r_Id` int(11) NOT NULL,
  `r_Date_Rent` date DEFAULT NULL,
  `r_Date_Return` date DEFAULT NULL,
  `r_Status` tinyint(1) DEFAULT NULL,
  `Title_t_Id` int(11) NOT NULL,
  `Customer_c_Id` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `title`
--

CREATE TABLE `title` (
  `t_Id` int(11) NOT NULL,
  `t_Type` char(20) DEFAULT NULL,
  `t_Name` char(100) DEFAULT NULL,
  `t_Genre` varchar(45) DEFAULT NULL,
  `t_ArtOrDir` char(100) DEFAULT NULL,
  `t_Year_Release` int(11) DEFAULT NULL,
  `t_Format` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`c_Id`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`r_Id`),
  ADD KEY `fk_Rent_Title1_idx` (`Title_t_Id`),
  ADD KEY `fk_Rent_Customer1_idx` (`Customer_c_Id`);

--
-- Indexes for table `title`
--
ALTER TABLE `title`
  ADD PRIMARY KEY (`t_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `r_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `title`
--
ALTER TABLE `title`
  MODIFY `t_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rent`
--
ALTER TABLE `rent`
  ADD CONSTRAINT `fk_Rent_Customer1` FOREIGN KEY (`Customer_c_Id`) REFERENCES `customer` (`c_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Rent_Title1` FOREIGN KEY (`Title_t_Id`) REFERENCES `title` (`t_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
