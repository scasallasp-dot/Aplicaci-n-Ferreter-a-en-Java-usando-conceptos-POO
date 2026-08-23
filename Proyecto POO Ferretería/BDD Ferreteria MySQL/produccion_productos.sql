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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text,
  `precio` decimal(10,2) NOT NULL,
  `existencia` int NOT NULL,
  `id_categoria` int DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `fk_categoria` (`id_categoria`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Smartphone X','Teléfono inteligente de última generación',850.00,1000,1,'2026-01-10'),(2,'Camiseta de Algodón','Camiseta cómoda talla M',19.99,150,2,'2026-02-15'),(3,'Cafetera Express','Cafetera automática de acero inoxidable',120.00,20,3,'2026-03-01'),(4,'Novela de Ficción','Libro de tapa dura, 400 páginas',15.50,100,4,'2026-01-20'),(5,'Balón de Fútbol','Balón reglamentario tamaño 5',25.00,80,5,'2026-02-10'),(6,'Bloques de Construcción','Juguete didáctico de 100 piezas',30.00,45,6,'2026-03-12'),(7,'Aceite para Motor','Aceite sintético 5W-30',45.00,35,7,'2026-04-05'),(8,'Crema Hidratante','Para todo tipo de piel 200ml',12.99,80,8,'2026-04-18'),(9,'Alimento para Perro','Sabor carne y vegetales 10kg',35.00,40,9,'2026-05-02'),(10,'Juego de Destornilladores','Kit de 12 piezas imantadas',18.50,85,10,'2026-05-10'),(11,'Tenis Deportivos','Zapatillas para correr talla 40',85.00,30,11,'2026-05-25'),(12,'Manguera de Jardín','Manguera expandible de 15 metros',22.00,15,12,'2026-06-01'),(13,'Silla de Oficina','Silla ergonómica con soporte lumbar',140.00,12,13,'2026-06-14'),(14,'Vitaminas C 1000mg','Suplemento en tabletas x100',9.99,200,14,'2026-06-20'),(15,'Café Gourmet en Grano','Bolsa de café de origen 1kg',14.50,70,15,'2026-07-01'),(17,'adwad','1',88.00,855,2,'2026-07-27');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
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

-- Dump completed on 2026-07-27 10:02:34
