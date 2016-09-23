-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: multiplex_system_lict
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking_information`
--

DROP TABLE IF EXISTS `booking_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_information` (
  `customer_id` int(11) NOT NULL,
  `show_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_information`
--

LOCK TABLES `booking_information` WRITE;
/*!40000 ALTER TABLE `booking_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hall` (
  `hall_id` int(15) NOT NULL,
  `hall_name` varchar(255) NOT NULL,
  `seat_no` varchar(3) NOT NULL,
  `seat_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`hall_id`),
  UNIQUE KEY `hall_name` (`hall_name`),
  KEY `hall_id` (`hall_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall`
--

LOCK TABLES `hall` WRITE;
/*!40000 ALTER TABLE `hall` DISABLE KEYS */;
/*!40000 ALTER TABLE `hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hall_contains_info`
--

DROP TABLE IF EXISTS `hall_contains_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hall_contains_info` (
  `hall_id` int(15) NOT NULL,
  `movie_id` int(15) NOT NULL,
  `show_id` int(11) NOT NULL,
  `ticket_id` int(15) NOT NULL,
  KEY `movie_id` (`movie_id`,`show_id`),
  KEY `ticket_id` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall_contains_info`
--

LOCK TABLES `hall_contains_info` WRITE;
/*!40000 ALTER TABLE `hall_contains_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `hall_contains_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_information`
--

DROP TABLE IF EXISTS `movie_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie_information` (
  `movie_id` int(15) NOT NULL AUTO_INCREMENT,
  `movie_name` text NOT NULL,
  `genre` text,
  `cbfc_rating` varchar(20) DEFAULT NULL,
  `rating` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`movie_id`),
  KEY `movie_id` (`movie_id`),
  KEY `movie_id_2` (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_information`
--

LOCK TABLES `movie_information` WRITE;
/*!40000 ALTER TABLE `movie_information` DISABLE KEYS */;
INSERT INTO `movie_information` VALUES (1,'DemoMovie','Action',NULL,NULL),(2,'Demo2','Comedy','3.8','6.5');
/*!40000 ALTER TABLE `movie_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `show_information`
--

DROP TABLE IF EXISTS `show_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `show_information` (
  `show_id` int(15) NOT NULL AUTO_INCREMENT,
  `show_date` date NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  PRIMARY KEY (`show_id`),
  KEY `show_id` (`show_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `show_information`
--

LOCK TABLES `show_information` WRITE;
/*!40000 ALTER TABLE `show_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `show_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_information`
--

DROP TABLE IF EXISTS `ticket_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_information` (
  `ticket_id` int(15) NOT NULL AUTO_INCREMENT,
  `price` int(15) NOT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `ticket_id` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_information`
--

LOCK TABLES `ticket_information` WRITE;
/*!40000 ALTER TABLE `ticket_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `customer_id` int(15) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_No` int(13) NOT NULL,
  `isAdmin` int(1) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_email` (`customer_email`,`phone_No`),
  KEY `customer_id` (`customer_id`),
  KEY `customer_id_2` (`customer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'tahmid.choyon','tahmid.choyon@gmail.com','tahmid123',1741778025,0),(2,'brutal.efaz','brutal.efaz@gmail.com','efaz123',1791694599,0),(3,'tahnvir.ovy','tanvirovy92093@gmail.com','ovy123',1748987173,0),(4,'tanvir.zahin','tanvir.zahin@gmail.com','zahin123',1754121201,0),(5,'admin','tahmid.choyon@gmail.com','administrator246',0,1),(6,'lalala','lalala@gmail.com','lalala',123456,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-23 10:31:46
