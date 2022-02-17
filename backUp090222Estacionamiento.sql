-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: estacionamiento
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caja` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `monto_inicial` double DEFAULT NULL,
  `monto_final` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES (4,'2022-02-05','21:52:16',5000,0),(5,'2022-02-06','09:36:23',5000,0),(6,'2022-02-09','18:19:26',3000,0),(7,'2022-02-11','08:01:05',5000,0);
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `id_movimiento` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora_entrada` time DEFAULT NULL,
  `hora_salida` time DEFAULT NULL,
  `tiempo` varchar(255) DEFAULT NULL,
  `id_tarifa` int DEFAULT NULL,
  `dinero_generado` double DEFAULT NULL,
  `placas` varchar(60) DEFAULT NULL,
  `correo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_movimiento`),
  KEY `id_tarifa` (`id_tarifa`),
  KEY `correo` (`correo`),
  CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`id_tarifa`) REFERENCES `tarifas` (`id_tarifa`),
  CONSTRAINT `movimientos_ibfk_2` FOREIGN KEY (`correo`) REFERENCES `usuarios` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (10,'2022-02-05','08:00:00','10:04:12','dia: 0 hora: 0 minuto: 0',3,0,'TUE4058','miguelemmanuel_montiel@hotmail.com'),(11,'2022-02-05','10:03:34','10:04:12','dia: 0 hora: 0 minuto: 0',2,0,'TUE4058','miguelemmanuel_montiel@hotmail.com'),(12,'2022-02-05','10:04:01','16:40:27','dia: 10 hora: 6 minuto: 36',2,1070,'','miguelemmanuel_montiel@hotmail.com'),(13,'2022-02-05','08:00:00','10:24:15','dia: 0 hora: 0 minuto: 0',3,0,'TTY2062','miguelemmanuel_montiel@hotmail.com'),(14,'2022-02-05','08:00:00','10:28:20','dia: 0 hora: 2 minuto: 28',1,30,'TTY2063','miguelemmanuel_montiel@hotmail.com'),(15,'2022-02-05','08:00:00','10:30:30','dia: 0 hora: 2 minuto: 30',2,45,'UAT4098','miguelemmanuel_montiel@hotmail.com'),(16,'2022-02-05','08:00:00','11:11:36','dia: 0 hora: 3 minuto: 11',1,40,'GNP4051','miguelemmanuel_montiel@hotmail.com'),(17,'2022-02-05','18:20:40','21:30:26','dia: 0 hora: 2 minuto: 23',2,45,'UAT2062','miguelemmanuel_montiel@hotmail.com'),(18,'2022-02-05','19:06:54','21:30:26','dia: 0 hora: 2 minuto: 23',2,45,'UAT2062','popo@popo.com'),(19,'2022-02-05','21:31:16','11:01:17','dia: 4 hora: 13 minuto: 30',2,810,'GNV5022','miguelemmanuel_montiel@hotmail.com'),(20,'2022-02-05','21:31:40','11:00:46','dia: 4 hora: 13 minuto: 29',3,1080,'TUE4085','miguelemmanuel_montiel@hotmail.com'),(21,'2022-02-06','09:37:48','11:00:02','dia: 4 hora: 1 minuto: 22',2,630,'UAT2062','miguelemmanuel_montiel@hotmail.com'),(22,'2022-02-06','13:48:21','13:57:09','dia: 0 hora: 0 minuto: 8',2,15,'UAT2065','miguelemmanuel_montiel@hotmail.com'),(23,'2022-02-06','13:58:54','10:52:22','dia: 3 hora: 20 minuto: 53',2,765,'UAT2065','miguelemmanuel_montiel@hotmail.com'),(24,'2022-02-09','18:06:05','18:07:53','dia: 0 hora: 0 minuto: 1',2,0,'UAT3456','miguelemmanuel_montiel@hotmail.com'),(26,'2022-02-10','10:12:06','10:12:16','dia: 0 hora: 0 minuto: 0',1,0,'POPO98','miguelemmanuel_montiel@hotmail.com'),(27,'2022-02-10','06:00:00','10:18:14','dia: 0 hora: 4 minuto: 18',2,75,'TTY9876','miguelemmanuel_montiel@hotmail.com'),(29,'2022-02-10','11:04:08','22:59:00','dia: 2 hora: 11 minuto: 54',2,480,'UAT2062','miguelemmanuel_montiel@hotmail.com'),(30,'2022-02-12','22:50:30',NULL,NULL,2,NULL,'UAT3456','miguelemmanuel_montiel@hotmail.com'),(31,'2022-02-13','12:19:29','20:22:55','dia: 0 hora: 8 minuto: 3',1,40,'BENOTTO ROJA','miguelemmanuel_montiel@hotmail.com'),(32,'2022-02-13','18:12:26','19:20:39','dia: 0 hora: 1 minuto: 8',3,30,'TTY9870','miguelemmanuel_montiel@hotmail.com'),(33,'2022-02-13','20:35:04','20:38:21','dia: 0 hora: 0 minuto: 3',3,0,'UAT2020','miguelemmanuel_montiel@hotmail.com'),(34,'2022-02-13','20:40:44','20:45:10','dia: 0 hora: 0 minuto: 4',1,0,'BMX AZUL','miguelemmanuel_montiel@hotmail.com'),(35,'2022-02-13','20:45:48','20:56:17','dia: 0 hora: 0 minuto: 10',1,5,'POPO3456','miguelemmanuel_montiel@hotmail.com'),(36,'2022-02-13','20:59:34','21:14:35','dia: 0 hora: 0 minuto: 15',1,5,'BICICLETA AZUL','miguelemmanuel_montiel@hotmail.com'),(37,'2022-02-13','21:18:54','21:19:19','dia: 0 hora: 0 minuto: 0',3,15,'L64AFA','miguelemmanuel_montiel@hotmail.com'),(38,'2022-02-13','21:26:04','21:27:05','dia: 0 hora: 0 minuto: 1',3,15,'MUG7809','miguelemmanuel_montiel@hotmail.com'),(39,'2022-02-15','11:09:49',NULL,NULL,3,NULL,'UAT2067','miguelemmanuel_montiel@hotmail.com'),(40,'2022-02-15','16:41:32','16:42:50','dia: 0 hora: 0 minuto: 1',1,5,'BENOTO ROJA 2','miguelemmanuel_montiel@hotmail.com');
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos_caja`
--

DROP TABLE IF EXISTS `movimientos_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos_caja` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `motivo` text,
  `monto` double DEFAULT NULL,
  `tipo` varchar(7) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `movimientos_caja_ibfk_2` (`correo`),
  CONSTRAINT `movimientos_caja_ibfk_2` FOREIGN KEY (`correo`) REFERENCES `usuarios` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos_caja`
--

LOCK TABLES `movimientos_caja` WRITE;
/*!40000 ALTER TABLE `movimientos_caja` DISABLE KEYS */;
INSERT INTO `movimientos_caja` VALUES (4,'2022-02-05','15:52:24','Propina para uber eats',15.5,'Egreso','miguelemmanuel_montiel@hotmail.com'),(6,'2022-02-05','21:29:40','Pago taxis hijo de don chano',235.5,'Egreso','miguelemmanuel_montiel@hotmail.com'),(7,'2022-02-05','21:32:30','Propina uber eáts',12,'Egreso','miguelemmanuel_montiel@hotmail.com'),(8,'2022-02-06','09:37:34','Pago de pedido don chano no dejo dinero',800,'Egreso','miguelemmanuel_montiel@hotmail.com'),(9,'2022-02-06','13:49:28','Propina para uber eats',10.5,'Egreso','miguelemmanuel_montiel@hotmail.com'),(10,'2022-02-09','18:19:41','camaras',50,'Egreso','miguelemmanuel_montiel@hotmail.com');
/*!40000 ALTER TABLE `movimientos_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos_pension`
--

DROP TABLE IF EXISTS `movimientos_pension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos_pension` (
  `id_movimiento` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora_entrada` time DEFAULT NULL,
  `fecha_salida` date DEFAULT NULL,
  `hora_salida` time DEFAULT NULL,
  `tiempo` varchar(255) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_movimiento`),
  KEY `telefono` (`telefono`),
  KEY `movimientos_pension_ibfk_2` (`correo`),
  CONSTRAINT `movimientos_pension_ibfk_1` FOREIGN KEY (`telefono`) REFERENCES `pension` (`telefono`),
  CONSTRAINT `movimientos_pension_ibfk_2` FOREIGN KEY (`correo`) REFERENCES `usuarios` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos_pension`
--

LOCK TABLES `movimientos_pension` WRITE;
/*!40000 ALTER TABLE `movimientos_pension` DISABLE KEYS */;
INSERT INTO `movimientos_pension` VALUES (1,'2022-02-06','14:40:00',NULL,'11:59:00','dia: 0 hora: 12 minuto 0','2225790336','miguelemmanuel_montiel@hotmail.com'),(3,'2022-02-05','14:00:00','2022-02-12','23:19:42','7 día 9 hora 19 minuto 42 segundo ','2225790337','miguelemmanuel_montiel@hotmail.com'),(4,'2022-02-09','14:15:15','2022-02-12','23:18:59','3 día 9 hora 3 minuto 44 segundo ','2225790258','miguelemmanuel_montiel@hotmail.com'),(5,'2022-02-09','17:57:17','2022-02-09','17:57:23','0 día 0 hora 0 minuto 6 segundo ','2225790341','miguelemmanuel_montiel@hotmail.com'),(6,'2022-02-09','18:25:25','2022-02-09','18:26:16','0 día 0 hora 0 minuto 51 segundo ','2223434334','miguelemmanuel_montiel@hotmail.com'),(7,'2022-02-10','07:38:22','0000-00-00','00:00:00','sc','2225790341','miguelemmanuel_montiel@hotmail.com'),(8,'2022-02-13','22:30:32','2022-02-13','22:49:35','0 día 0 hora 19 minuto 3 segundo ','2225790336','miguelemmanuel_montiel@hotmail.com'),(9,'2022-02-13','22:59:43','2022-02-13','23:04:33','0 día 0 hora 4 minuto 50 segundo ','2225790258','miguelemmanuel_montiel@hotmail.com'),(10,'2022-02-13','23:04:41','2022-02-13','23:05:35','0 día 0 hora 0 minuto 54 segundo ','2225790258','miguelemmanuel_montiel@hotmail.com'),(11,'2022-02-14','15:16:23','0000-00-00','00:00:00','sc','2223434334','miguelemmanuel_montiel@hotmail.com'),(12,'2022-02-15','11:06:29','2022-02-15','13:00:09','0 día 1 hora 53 minuto 40 segundo ','2225790336','miguelemmanuel_montiel@hotmail.com'),(13,'2022-02-15','11:09:03','0000-00-00','00:00:00','sc','2225095663','miguelemmanuel_montiel@hotmail.com'),(14,'2022-02-15','16:54:03','2022-02-15','16:54:16','0 día 0 hora 0 minuto 13 segundo ','2221754003','miguelemmanuel_montiel@hotmail.com'),(15,'2022-02-16','19:17:07','2022-02-16','19:19:21','0 día 0 hora 2 minuto 14 segundo ','2225790336','miguelemmanuel_montiel@hotmail.com'),(16,'2022-02-16','19:39:25','2022-02-16','19:52:19','0 día 0 hora 12 minuto 54 segundo ','2225790336','miguelemmanuel_montiel@hotmail.com');
/*!40000 ALTER TABLE `movimientos_pension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pension`
--

DROP TABLE IF EXISTS `pension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pension` (
  `telefono` varchar(10) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apellidop` varchar(60) DEFAULT NULL,
  `apellidom` varchar(60) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `identificacion` varchar(255) DEFAULT NULL,
  `id_plan` int DEFAULT NULL,
  `dia_inicio` date DEFAULT NULL,
  `hora_inicio` time DEFAULT NULL,
  `dia_vencimiento` date DEFAULT NULL,
  `hora_vencimiento` time DEFAULT NULL,
  `cantidad_plan` int DEFAULT NULL,
  `activo` tinyint DEFAULT NULL,
  `importe_pagado` double DEFAULT NULL,
  PRIMARY KEY (`telefono`),
  KEY `id_plan` (`id_plan`),
  CONSTRAINT `pension_ibfk_1` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id_plan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pension`
--

LOCK TABLES `pension` WRITE;
/*!40000 ALTER TABLE `pension` DISABLE KEYS */;
INSERT INTO `pension` VALUES ('2220909990','Big','mike','ohr','djadnoawdnownodnaod','no selecciono',1,'2022-02-14','23:04:04','2022-02-21','23:04:04',1,1,250.5),('2221754003','dalila','mendoza','tellez','calle pino #24 colonia maravillas','no selecciono',1,'2022-02-15','16:51:26','2022-02-22','16:51:26',1,1,250.5),('2223434334','miguel','montirel','martinez','calle 6 ote colonia centro','no selecciono',1,'2022-02-09','18:14:53','2022-02-23','18:14:53',2,1,501),('2225095663','Mi','sad','asd','asd','31115613.jpg',1,'2022-02-09','08:20:21','2022-02-23','08:20:21',2,1,505.5),('2225790258','Mike Antony','Johnson','Rieves','AV JUAN ESCUTIA 1703, GLORIA, 31130,Chihuahua,Chihuahua,31130,México','17314631.jpg',1,'2022-02-09','13:41:45','2022-02-23','13:41:45',2,1,501),('2225790336','mike','salazar','montero','utytf ytfytfytf ytfytfy tfyt fytfy','no selecciono',2,'2022-02-16','19:16:43','2022-05-17','19:16:43',3,1,3006),('2225790337','Es','El','Pepe','Calle jacarandas, numero 10, colonia el provenir.','727027.png',1,'2022-02-02','08:20:21','2022-02-20','08:20:21',2,1,505.5),('2225790338','popo','popo','oppo','popo','no selecciono',1,'2022-02-02','08:20:21','2022-02-28','08:20:21',3,1,505.5),('2225790339','MIGUEL ANGEL','ZEPEDA','RUIZ','CALLE 42 NORTE #93 COLONIA 10 DE MAYO PUEBLA, PUEBLA','no selecciono',1,'2022-02-16','19:58:06','2022-02-23','19:58:06',1,1,250.5),('2225790341','Miguel Angel','Zepeda','Ruiz','Privada del nacozari #43, colonia el porvenir.','152517.png',2,'2022-02-02','08:20:21','2022-03-08','08:20:21',1,1,505.5);
/*!40000 ALTER TABLE `pension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `id_plan` int NOT NULL AUTO_INCREMENT,
  `tipo_plan` varchar(8) DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,'Semanal',7,250.5),(2,'Mensual',30,1002);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `super_user`
--

DROP TABLE IF EXISTS `super_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `super_user` (
  `id` int NOT NULL,
  `pass` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `super_user`
--

LOCK TABLES `super_user` WRITE;
/*!40000 ALTER TABLE `super_user` DISABLE KEYS */;
INSERT INTO `super_user` VALUES (0,_binary '1000:8c5746e31a3dfa8047dd4c26e07745e4:8fdc780151e330f348aeb31a8e608cae120eaa2a7aba1792df335735514b84bcee8efb0431d0e423e97cc1863adc9d522083f9bb975933fba88e608fd6eef8ae');
/*!40000 ALTER TABLE `super_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarifas`
--

DROP TABLE IF EXISTS `tarifas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarifas` (
  `id_tarifa` int NOT NULL AUTO_INCREMENT,
  `tipo_vehiculo` varchar(60) DEFAULT NULL,
  `tipo_tarifa` varchar(60) DEFAULT NULL,
  `tarifa` double DEFAULT NULL,
  PRIMARY KEY (`id_tarifa`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifas`
--

LOCK TABLES `tarifas` WRITE;
/*!40000 ALTER TABLE `tarifas` DISABLE KEYS */;
INSERT INTO `tarifas` VALUES (1,'Bicicleta','Hora',5),(2,'Motocicleta','Hora',10),(3,'Automovil','Hora',15),(4,'Camioneta','Hora',20),(5,'Bicicleta','Dia',50),(6,'Motocicleta','Dia',100),(7,'Automovil','Dia',150),(8,'Camioneta','Dia',200);
/*!40000 ALTER TABLE `tarifas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `correo` varchar(255) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidop` varchar(100) DEFAULT NULL,
  `apellidom` varchar(100) DEFAULT NULL,
  `password` blob,
  `area` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('1@1.com','Pepe','Es ','El',_binary '1000:d6056d0b1e895cdc9399abfd57ae810b:525dd30bc8128fcf73bf02f6163b803036f8f47d884b6c3842beb010d3e8e6ad049cd4134b4554d3029aece6610d9a85c09d6ab7b5b6de578e61de67a431c89a','Empleado','2022-02-14 16:02:27','2022-02-14 16:02:27'),('miguel@elangel.com','Miguel','Macias','Caballero',_binary '1000:a8a500ccbbc1f5d6e92be21aaccc76fc:63ea491d836d587d0f011d5163639cfc19213ee81f538e2b85049aae17509ad4be2302c996f7f174844844faa6c9fb9f2c2c1b92e731e9bec073a556be553f29','Administrador','2022-01-28 20:28:14','2022-01-28 20:28:14'),('miguelemmanuel_montiel@hotmail.com','Miguel Emmanuel','Montiel','Martinez',_binary '1000:cedf4ae1b2ae988805eadc9ad1c9494f:6391ad947cf23fd3d64be6e82a05f14ffb24239b4f7af9526f14588fbbd5b00b5a74951a6701e53f68ffe5d8423ca9f59814074c93ed7ebdc810f2072481daf7','Administrador','2022-02-06 00:56:44','2021-10-06 07:37:03'),('mike@gmail.com','Es ','El ','mIke',_binary '1000:f631b47c79e8497b2e7a2dc56d5c0d22:daf9009cb16121c5b9611aa143f2473bb196222a0f8328db67b3b8264ef30c45d5d9608cefa6e19494a50ad0e0137b871678fe1a0dc3a840efe7f246008458e7','Empleado','2022-02-11 14:48:51','2022-02-11 14:48:51'),('popo@popo.com','pepe','Es ','El ',_binary '1000:a35467684deb8536fe50fecf35e701fa:9b84d3440de6befe9f0e588fdb30a54965c0201bec2bb05f69aa28757fd257f533261f4e1d6983fbd2d4547b4d1f5196cce56cb6a91922ce5ceb8eb9242f8682','Empleado','2022-02-06 01:06:08','2022-01-28 20:26:31'),('sombrass46@gmail.com','sombra','4','6',_binary '1000:b3bd197338162547c5fbe50927499890:c0af6a9889c7cf0d9a30370cd4ec6cbf07be18abada9ee5666a85fe8e6ba9e4464b7bb76c175db2e4536dbf51d77adf9a2ece10933c09817d502352f9764b9e2','Administrador','2022-02-11 00:26:07','2022-02-11 00:26:07');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-16 20:08:57
