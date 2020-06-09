-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2020 at 09:33 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pelanggan`
--

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `Nama Pelanggan` varchar(20) NOT NULL,
  `Tanggal Masuk` varchar(15) NOT NULL,
  `Jenis Pakaian` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Berat Pakaian / kg` varchar(20) CHARACTER SET latin1 NOT NULL,
  `Jenis Laundry` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Tanggal Selesai` varchar(30) CHARACTER SET latin1 NOT NULL,
  `No. Telepon` varchar(50) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`Nama Pelanggan`, `Tanggal Masuk`, `Jenis Pakaian`, `Berat Pakaian / kg`, `Jenis Laundry`, `Tanggal Selesai`, `No. Telepon`) VALUES
('Angelia ', '01 Juni 2020', 'Celana ', '2 kg', 'Cuci Setrika', '04 Juni 2020', '083847714532'),
('Auden', '02 Juni 2020', 'Kemeja, Celana, dan Kaos', '4 kg', 'Cuci Kering', '06 Juni 2020', '089765944522'),
('Freya', '30 Mei 2020', 'Baju', '2 kg', 'Cuci Setrika', '02 Juni 2020', '082134525752');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
