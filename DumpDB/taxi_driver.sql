-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: taxi
-- ------------------------------------------------------
-- Server version	6.0.6-alpha-community

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
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(60) DEFAULT NULL,
  `first_name` varchar(60) NOT NULL,
  `phone_number` varchar(25) CHARACTER SET latin1 NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `rating` int(11) NOT NULL,
  `id_auto` int(11) DEFAULT NULL,
  `id_status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`id_auto`),
  KEY `id_status_idx` (`id_status`),
  CONSTRAINT `id_auto` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_status` FOREIGN KEY (`id_status`) REFERENCES `status_driver` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'Иванов','Иванчик','8923546789','ivanchik','1234',8,1,1),(2,'Иванов','Иван','8923546789','ivan','1234',10,2,2),(3,'Петров','Петр','87564567412','petr','1234',5,3,1),(4,'Конев','Александр','89456475613','aleksandr','1234',7,5,3);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-22  3:58:42
