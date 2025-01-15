-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: eventmanagement
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `eventId` int NOT NULL AUTO_INCREMENT,
  `eventName` varchar(250) NOT NULL,
  `name` varchar(250) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `duration` varchar(250) NOT NULL,
  `status` varchar(250) NOT NULL,
  PRIMARY KEY (`eventId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Wedding','MAII','2025-01-01','23:33:00','2 hours','Event Confirmed'),(2,'Christening','Giana','2025-01-01','24:00:00','2 hours','Event Confirmed'),(3,'Birthday','Miara','2025-01-01','23:44:00','2 hours','Event Confirmed'),(4,'Birthday','Mae','2025-01-01','23:45:00','2 hours','Event Confirmed'),(6,'Christening','Matti','2025-01-02','11:06:00','2 hours','Event Confirmed'),(7,'Christening','Matti','2025-01-02','11:07:00','2 hours','Event Confirmed'),(8,'Christening','Matti','2025-01-02','11:08:00','2 hours','Event Confirmed'),(9,'Christening','Matti','2025-01-02','23:08:00','2 hours','Event Confirmed'),(10,'Christening','Matti','2025-01-02','23:35:00','2 hours','Event Confirmed'),(11,'Christening','Matti','2025-01-02','23:36:00','2 hours','Event Confirmed'),(12,'Christening','HARUKI','2025-01-01','23:49:00','2 hours','Event Confirmed'),(13,'Christening','HARUKI','2025-01-01','23:49:00','2 hours','Event Confirmed'),(14,'Christening','HARUKI','2025-01-02','23:49:00','2 hours','Event Confirmed');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-12 16:43:00
