-- MySQL dump 10.13  Distrib 5.7.28, for Win64 (x86_64)
--
-- Host: localhost    Database: estacionamiento
-- ------------------------------------------------------
-- Server version	5.7.28-log

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
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `monto_inicial` double DEFAULT NULL,
  `monto_final` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES (4,'2022-02-05','21:52:16',5000,0),(5,'2022-02-06','09:36:23',5000,0);
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientos` (
  `id_movimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora_entrada` time DEFAULT NULL,
  `hora_salida` time DEFAULT NULL,
  `tiempo` varchar(255) DEFAULT NULL,
  `id_tarifa` int(11) DEFAULT NULL,
  `dinero_generado` double DEFAULT NULL,
  `placas` varchar(60) DEFAULT NULL,
  `correo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_movimiento`),
  KEY `id_tarifa` (`id_tarifa`),
  KEY `correo` (`correo`),
  CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`id_tarifa`) REFERENCES `tarifas` (`id_tarifa`),
  CONSTRAINT `movimientos_ibfk_2` FOREIGN KEY (`correo`) REFERENCES `usuarios` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (10,'2022-02-05','08:00:00','10:04:12','dia: 0 hora: 0 minuto: 0',3,0,'TUE4058','miguelemmanuel_montiel@hotmail.com'),(11,'2022-02-05','10:03:34','10:04:12','dia: 0 hora: 0 minuto: 0',2,0,'TUE4058','miguelemmanuel_montiel@hotmail.com'),(12,'2022-02-05','10:04:01',NULL,NULL,2,NULL,'','miguelemmanuel_montiel@hotmail.com'),(13,'2022-02-05','08:00:00','10:24:15','dia: 0 hora: 0 minuto: 0',3,0,'TTY2062','miguelemmanuel_montiel@hotmail.com'),(14,'2022-02-05','08:00:00','10:28:20','dia: 0 hora: 2 minuto: 28',1,30,'TTY2063','miguelemmanuel_montiel@hotmail.com'),(15,'2022-02-05','08:00:00','10:30:30','dia: 0 hora: 2 minuto: 30',2,45,'UAT4098','miguelemmanuel_montiel@hotmail.com'),(16,'2022-02-05','08:00:00','11:11:36','dia: 0 hora: 3 minuto: 11',1,40,'GNP4051','miguelemmanuel_montiel@hotmail.com'),(17,'2022-02-05','18:20:40','21:30:26','dia: 0 hora: 2 minuto: 23',2,45,'UAT2062','miguelemmanuel_montiel@hotmail.com'),(18,'2022-02-05','19:06:54','21:30:26','dia: 0 hora: 2 minuto: 23',2,45,'UAT2062','popo@popo.com'),(19,'2022-02-05','21:31:16',NULL,NULL,2,NULL,'GNV5022','miguelemmanuel_montiel@hotmail.com'),(20,'2022-02-05','21:31:40',NULL,NULL,3,NULL,'TUE4085','miguelemmanuel_montiel@hotmail.com'),(21,'2022-02-06','09:37:48',NULL,NULL,2,NULL,'UAT2062','miguelemmanuel_montiel@hotmail.com'),(22,'2022-02-06','13:48:21','13:57:09','dia: 0 hora: 0 minuto: 8',2,15,'UAT2065','miguelemmanuel_montiel@hotmail.com'),(23,'2022-02-06','13:58:54',NULL,NULL,2,NULL,'UAT2065','miguelemmanuel_montiel@hotmail.com');
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos_caja`
--

DROP TABLE IF EXISTS `movimientos_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientos_caja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `motivo` text,
  `monto` double DEFAULT NULL,
  `tipo` varchar(7) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `movimientos_caja_ibfk_2` (`correo`),
  CONSTRAINT `movimientos_caja_ibfk_2` FOREIGN KEY (`correo`) REFERENCES `usuarios` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos_caja`
--

LOCK TABLES `movimientos_caja` WRITE;
/*!40000 ALTER TABLE `movimientos_caja` DISABLE KEYS */;
INSERT INTO `movimientos_caja` VALUES (4,'2022-02-05','15:52:24','Propina para uber eats',15.5,'Egreso','miguelemmanuel_montiel@hotmail.com'),(6,'2022-02-05','21:29:40','Pago taxis hijo de don chano',235.5,'Egreso','miguelemmanuel_montiel@hotmail.com'),(7,'2022-02-05','21:32:30','Propina uber eáts',12,'Egreso','miguelemmanuel_montiel@hotmail.com'),(8,'2022-02-06','09:37:34','Pago de pedido don chano no dejo dinero',800,'Egreso','miguelemmanuel_montiel@hotmail.com'),(9,'2022-02-06','13:49:28','Propina para uber eats',10.5,'Egreso','miguelemmanuel_montiel@hotmail.com');
/*!40000 ALTER TABLE `movimientos_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos_pension`
--

DROP TABLE IF EXISTS `movimientos_pension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientos_pension` (
  `id_movimiento` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos_pension`
--

LOCK TABLES `movimientos_pension` WRITE;
/*!40000 ALTER TABLE `movimientos_pension` DISABLE KEYS */;
INSERT INTO `movimientos_pension` VALUES (1,'2022-02-06','14:40:00',NULL,'11:59:00','dia: 0 hora: 12 minuto 0','2225790336','miguelemmanuel_montiel@hotmail.com'),(3,'2022-02-05','14:00:00',NULL,'00:00:00','sc','2225790337','miguelemmanuel_montiel@hotmail.com'),(4,'2022-02-09','14:15:15',NULL,'00:00:00','sc','2225790258','miguelemmanuel_montiel@hotmail.com');
/*!40000 ALTER TABLE `movimientos_pension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pension`
--

DROP TABLE IF EXISTS `pension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pension` (
  `telefono` varchar(10) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apellidop` varchar(60) DEFAULT NULL,
  `apellidom` varchar(60) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `identificacion` varchar(255) DEFAULT NULL,
  `id_plan` int(11) DEFAULT NULL,
  `dia_inicio` date DEFAULT NULL,
  `hora_inicio` time DEFAULT NULL,
  `dia_vencimiento` date DEFAULT NULL,
  `hora_vencimiento` time DEFAULT NULL,
  `cantidad_plan` int(11) DEFAULT NULL,
  `pagado` tinyint(4) DEFAULT NULL,
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
INSERT INTO `pension` VALUES ('','','','','','no selecciono',1,'2022-02-02','08:20:21','2022-02-13','08:20:21',1,0,505.5),('2225095663','Mi','sad','asd','asd','31115613.jpg',1,'2022-02-09','08:20:21','2022-02-23','08:20:21',2,1,505.5),('2225790258','Mike Antony','Johnson','Rieves','AV JUAN ESCUTIA 1703, GLORIA, 31130,Chihuahua,Chihuahua,31130,México','17314631.jpg',1,'2022-02-09','13:41:45','2022-02-23','13:41:45',2,1,501),('2225790336','Miguel Emmanuel','Montiel','Martinez','Ejido de la 42 norte #93-4, colonia 10 de mayo','9dd07e40ff3430e0eed9d5d65d39eb12.png',1,'2022-02-02','08:20:21','2022-02-12','08:20:21',2,1,505.5),('2225790337','Es','El','Pepe','Calle jacarandas, numero 10, colonia el provenir.','727027.png',1,'2022-02-02','08:20:21','2022-02-20','08:20:21',2,1,505.5),('2225790338','popo','popo','oppo','popo','no selecciono',1,'2022-02-02','08:20:21','2022-02-28','08:20:21',3,1,505.5),('2225790341','Miguel Angel','Zepeda','Ruiz','Privada del nacozari #43, colonia el porvenir.','152517.png',2,'2022-02-02','08:20:21','2022-03-08','08:20:21',1,1,505.5);
/*!40000 ALTER TABLE `pension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan` (
  `id_plan` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_plan` varchar(8) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `super_user` (
  `id` int(11) NOT NULL,
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarifas` (
  `id_tarifa` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_vehiculo` varchar(60) DEFAULT NULL,
  `tipo_tarifa` varchar(60) DEFAULT NULL,
  `tarifa` double DEFAULT NULL,
  PRIMARY KEY (`id_tarifa`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifas`
--

LOCK TABLES `tarifas` WRITE;
/*!40000 ALTER TABLE `tarifas` DISABLE KEYS */;
INSERT INTO `tarifas` VALUES (1,'Motocicleta','Hora',10),(2,'Automovil','Hora',15),(3,'Camioneta','Hora',20),(4,'Motocicleta','D?¡a',100),(5,'AUtomovil','D?¡a',150),(6,'Camioneta','D?¡a',200);
/*!40000 ALTER TABLE `tarifas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `usuarios` VALUES ('miguel@elangel.com','Miguel','Macias','Caballero',_binary '1000:a8a500ccbbc1f5d6e92be21aaccc76fc:63ea491d836d587d0f011d5163639cfc19213ee81f538e2b85049aae17509ad4be2302c996f7f174844844faa6c9fb9f2c2c1b92e731e9bec073a556be553f29','Administrador','2022-01-28 20:28:14','2022-01-28 20:28:14'),('miguelemmanuel_montiel@hotmail.com','Miguel Emmanuel','Montiel','Martinez',_binary '1000:cedf4ae1b2ae988805eadc9ad1c9494f:6391ad947cf23fd3d64be6e82a05f14ffb24239b4f7af9526f14588fbbd5b00b5a74951a6701e53f68ffe5d8423ca9f59814074c93ed7ebdc810f2072481daf7','Administrador','2022-02-06 00:56:44','2021-10-06 07:37:03'),('popo@popo.com','pepe','Es ','El ',_binary '1000:a35467684deb8536fe50fecf35e701fa:9b84d3440de6befe9f0e588fdb30a54965c0201bec2bb05f69aa28757fd257f533261f4e1d6983fbd2d4547b4d1f5196cce56cb6a91922ce5ceb8eb9242f8682','Empleado','2022-02-06 01:06:08','2022-01-28 20:26:31');
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

-- Dump completed on 2022-02-09 16:20:35
