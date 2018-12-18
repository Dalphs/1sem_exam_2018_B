-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Vært: 127.0.0.1
-- Genereringstid: 18. 12 2018 kl. 11:19:25
-- Serverversion: 10.1.36-MariaDB
-- PHP-version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `TV2DK`
--

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `mediadata`
--

DROP TABLE IF EXISTS `mediadata`;
CREATE TABLE `mediadata` (
  `assetid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `filename` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Data dump for tabellen `mediadata`
--

INSERT INTO `mediadata` (`assetid`, `name`, `date`, `filename`) VALUES
(464, 'null', 'Tue Dec 18 11:09:32 CET 2018', 'null'),
(474, 'Julemanden & co', 'Tue Dec 18 11:16:01 CET 2018', 'J&C'),
(484, 'Basket i USA', 'Tue Dec 18 11:16:39 CET 2018', 'Basket'),
(494, 'Jordskælv i Indonesien', 'Tue Dec 18 11:17:03 CET 2018', 'Katastrofe');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
