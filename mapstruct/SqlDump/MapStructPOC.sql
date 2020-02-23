-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 23, 2020 at 09:34 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `MapStructPOC`
--

-- --------------------------------------------------------

--
-- Table structure for table `Interfaces`
--

CREATE TABLE `Interfaces` (
  `interface_pk` int(10) UNSIGNED NOT NULL,
  `interface_name` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Interfaces`
--

INSERT INTO `Interfaces` (`interface_pk`, `interface_name`) VALUES
(1, 'bean0'),
(2, 'bean1'),
(6, 'bean2'),
(4, 'bean3'),
(5, 'bean4');

-- --------------------------------------------------------

--
-- Table structure for table `mapping`
--

CREATE TABLE `mapping` (
  `source_interface` int(10) UNSIGNED NOT NULL,
  `target_interface` int(10) UNSIGNED NOT NULL,
  `mapper_id` varchar(20) NOT NULL,
  `mapping_pk` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mapping`
--

INSERT INTO `mapping` (`source_interface`, `target_interface`, `mapper_id`, `mapping_pk`) VALUES
(1, 4, 'Bean0ToBean3Mapper', 1),
(1, 5, 'Bean0ToBean4Mapper', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Interfaces`
--
ALTER TABLE `Interfaces`
  ADD PRIMARY KEY (`interface_pk`),
  ADD UNIQUE KEY `Unique_interface_name` (`interface_name`);

--
-- Indexes for table `mapping`
--
ALTER TABLE `mapping`
  ADD PRIMARY KEY (`mapping_pk`),
  ADD UNIQUE KEY `Unique_mapper_id` (`mapper_id`),
  ADD KEY `fk_target_interface` (`target_interface`),
  ADD KEY `fk_source_interface` (`source_interface`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Interfaces`
--
ALTER TABLE `Interfaces`
  MODIFY `interface_pk` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `mapping`
--
ALTER TABLE `mapping`
  MODIFY `mapping_pk` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mapping`
--
ALTER TABLE `mapping`
  ADD CONSTRAINT `fk_source_interface` FOREIGN KEY (`source_interface`) REFERENCES `Interfaces` (`interface_pk`),
  ADD CONSTRAINT `fk_target_interface` FOREIGN KEY (`target_interface`) REFERENCES `Interfaces` (`interface_pk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
