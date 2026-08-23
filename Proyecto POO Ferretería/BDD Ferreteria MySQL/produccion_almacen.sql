-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: produccion
-- ------------------------------------------------------
-- Server version	9.7.1

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '111e15c9-79ad-11f1-aa44-5ecef0499927:1-109';

--
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacen` (
  `id_movimiento` int NOT NULL AUTO_INCREMENT,
  `id_producto` int DEFAULT NULL,
  `tipo_movimiento` enum('Entrada','Salida') NOT NULL,
  `cantidad` int NOT NULL,
  `fecha_movimiento` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_movimiento`),
  KEY `fk_producto_almacen` (`id_producto`),
  CONSTRAINT `fk_producto_almacen` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` VALUES (1,1,'Entrada',10,'2026-07-10 15:36:03'),(2,2,'Salida',5,'2026-07-10 15:36:03'),(3,3,'Entrada',15,'2026-07-10 15:36:03'),(4,4,'Salida',2,'2026-07-10 15:36:03'),(5,5,'Entrada',20,'2026-07-10 15:36:03'),(6,6,'Salida',8,'2026-07-10 15:36:03'),(7,7,'Entrada',12,'2026-07-10 15:36:03'),(8,8,'Salida',4,'2026-07-10 15:36:03'),(9,9,'Entrada',30,'2026-07-10 15:36:03'),(10,10,'Salida',1,'2026-07-10 15:36:03'),(11,11,'Entrada',25,'2026-07-10 15:36:03'),(12,12,'Salida',3,'2026-07-10 15:36:03'),(13,13,'Entrada',5,'2026-07-10 15:36:03'),(14,14,'Salida',10,'2026-07-10 15:36:03'),(15,15,'Entrada',50,'2026-07-10 15:36:03');
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-07-27 10:02:35
