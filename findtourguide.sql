-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 29, 2020 at 01:01 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `findtourguide`
--

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
  `guest_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fullname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_of_birth` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `image` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `country` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(2) DEFAULT 1,
  PRIMARY KEY (`guest_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`guest_id`, `username`, `password`, `fullname`, `date_of_birth`, `image`, `country`, `email`, `phone`, `status`) VALUES
(1, 'nghia', '123', 'hoohi', '2018-11-11 18:02:03', 'ad.jpg', 'Viet Nam', 'nfdhf@gmail.com', '0968997331', 123);

-- --------------------------------------------------------

--
-- Table structure for table `guide`
--

DROP TABLE IF EXISTS `guide`;
CREATE TABLE IF NOT EXISTS `guide` (
  `guide_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fullname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `birthday` datetime NOT NULL,
  `idCard_before` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idCard_after` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `experience` int(2) NOT NULL,
  `cost` int(11) NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `country` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `city` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `tour_sum` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`guide_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `guide`
--

INSERT INTO `guide` (`guide_id`, `username`, `password`, `fullname`, `image`, `birthday`, `idCard_before`, `idCard_after`, `gender`, `experience`, `cost`, `description`, `phone`, `email`, `country`, `city`, `status`, `tour_sum`) VALUES
(1, 'nghia', '123456', 'Nguyen Van Nghia', '', '1997-08-16 01:02:03', '', '', 'male', 1, 20, '', '', '', '', '', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `guide_lang`
--

DROP TABLE IF EXISTS `guide_lang`;
CREATE TABLE IF NOT EXISTS `guide_lang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guide_id` int(11) NOT NULL,
  `lang_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `guide_lang`
--

INSERT INTO `guide_lang` (`id`, `guide_id`, `lang_name`) VALUES
(1, 2, 'kaka'),
(2, 1, 'hihi'),
(3, 1, 'hihi'),
(4, 1, 'hihi'),
(5, 1, 'hihi'),
(6, 1, 'hihi'),
(7, 1, 'hihi'),
(8, 1, 'hihi'),
(9, 1, 'hihi'),
(10, 1, 'hihi'),
(11, 1, 'hihi'),
(12, 1, 'hihi'),
(13, 1, 'hihi'),
(14, 1, 'hihi'),
(15, 1, 'hihi'),
(16, 1, 'hihi'),
(17, 1, 'hihi'),
(18, 1, 'hihi'),
(19, 1, 'hihi'),
(20, 1, 'hihi'),
(21, 1, 'hihi'),
(22, 1, 'hihi'),
(23, 1, 'hihi');

-- --------------------------------------------------------

--
-- Table structure for table `guide_order`
--

DROP TABLE IF EXISTS `guide_order`;
CREATE TABLE IF NOT EXISTS `guide_order` (
  `oder_id` int(11) NOT NULL AUTO_INCREMENT,
  `guide_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `from_day` datetime NOT NULL,
  `thro_day` datetime NOT NULL,
  `place` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cost` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`oder_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `guide_time`
--

DROP TABLE IF EXISTS `guide_time`;
CREATE TABLE IF NOT EXISTS `guide_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guide_id` int(11) NOT NULL,
  `from_date` datetime NOT NULL,
  `thro_day` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
CREATE TABLE IF NOT EXISTS `language` (
  `lang_id` int(11) NOT NULL AUTO_INCREMENT,
  `lang_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`lang_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
CREATE TABLE IF NOT EXISTS `place` (
  `place_id` int(11) NOT NULL AUTO_INCREMENT,
  `place_name` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`place_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
CREATE TABLE IF NOT EXISTS `rate` (
  `rate_id` int(11) NOT NULL AUTO_INCREMENT,
  `guide_id` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  PRIMARY KEY (`rate_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `guide_id` int(11) NOT NULL,
  `guest_id` int(11) NOT NULL,
  `review_content` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `username`, `password`) VALUES
(1, 'nghia', '123'),
(2, 'hihi', '1234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
