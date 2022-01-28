-- MariaDB dump 10.19  Distrib 10.4.22-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: curso_spring
-- ------------------------------------------------------
-- Server version	10.4.22-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addresss`
--

DROP TABLE IF EXISTS `addresss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresss` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `complement` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `city_id` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FKpry12epdy8db5j0o9dotg4ki6` (`city_id`),
  KEY `FKqhxoeg1f2j6u1fha33srvvqqk` (`client_id`),
  CONSTRAINT `FKpry12epdy8db5j0o9dotg4ki6` FOREIGN KEY (`city_id`) REFERENCES `citys` (`uuid`),
  CONSTRAINT `FKqhxoeg1f2j6u1fha33srvvqqk` FOREIGN KEY (`client_id`) REFERENCES `client` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresss`
--

LOCK TABLES `addresss` WRITE;
/*!40000 ALTER TABLE `addresss` DISABLE KEYS */;
INSERT INTO `addresss` VALUES ('07df0ca6-0abc-4578-98a5-808efd228db9','2022-01-28 16:51:40',NULL,'','Rua Caetano Basso','03584-130',NULL,'Parque Savoi City','252','7357cd91-161e-406f-acd4-b302235364f4','9dc00737-32af-46cf-a68d-c9df55347cbb'),('62f90910-9e60-4bef-8e5d-50b6ebdea7a1','2022-01-28 16:51:40',NULL,'','Rua Bernado','00000-100',NULL,'Sé','100','16f54e8e-7680-4c6b-a1e0-f32bfde5efc8','614abc62-56f6-4b01-96d8-720353e746a4'),('92264a9b-c752-4113-b8b1-b9180cca3d14','2022-01-28 16:51:40',NULL,'','Rua Piquinhu','03657-010',NULL,'Vila Ré','227','7357cd91-161e-406f-acd4-b302235364f4','9dc00737-32af-46cf-a68d-c9df55347cbb');
/*!40000 ALTER TABLE `addresss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('1fe578c4-cb19-4f5b-b2fd-075c6da7c4b7','2022-01-28 16:51:40',NULL,'','Elétrico'),('2cfa3baa-3ae8-4731-be27-9860f654883b','2022-01-28 16:51:40',NULL,'','Informática'),('34497edf-8ca9-43f5-9832-5ed2b5fb5715','2022-01-28 16:51:40',NULL,'','Informática'),('34e54290-40af-400e-b8ab-a4f0e72f6e6c','2022-01-28 16:51:40',NULL,'','Vestuário'),('3a7794df-46f8-4d68-8e65-a5b483638458','2022-01-28 16:51:40',NULL,'','Escritório'),('405364e8-a992-498a-8aff-5ef2fb65b9e4','2022-01-28 16:51:40',NULL,'','Biblioteca'),('5c82b068-d306-42a0-9d39-d663da3dcb5c','2022-01-28 16:51:40',NULL,'','Vestuário'),('5ecc3a48-d96a-4221-8b84-d5db61e96dda','2022-01-28 16:51:40',NULL,'','Biblioteca'),('69adc232-495e-4d8a-b013-3a14fa5e8fc0','2022-01-28 16:51:40',NULL,'','Escritório'),('712cc97a-9175-4804-a215-66e028e7b1dd','2022-01-28 16:51:40',NULL,'','Elétrico'),('7734ef0c-2999-484b-9526-3d6bbb861822','2022-01-28 16:51:40',NULL,'','Escritório'),('9723b531-ff16-4815-b7ef-3b3d48351db1','2022-01-28 16:51:40',NULL,'','Informática'),('a5686455-0737-4f3c-b107-d9f5bb8eb052','2022-01-28 16:51:40',NULL,'','Elétrico'),('c4bd20ef-f031-45c2-8408-982376c7be56','2022-01-28 16:51:40',NULL,'','Vestuário'),('cd59225c-4372-4902-8ba2-5317091445d7','2022-01-28 16:51:40',NULL,'','Biblioteca'),('d41d97d1-1808-4b02-9b4e-24e9f9be629a','2022-01-28 16:51:40',NULL,'','Biblioteca'),('d67df753-3b32-46c0-9c60-95acdac70d4e','2022-01-28 16:51:40',NULL,'','Vestuário'),('dcbad46a-f0b2-4ffe-903e-d438323de8ed','2022-01-28 16:51:40',NULL,'','Escritório'),('e4300d2d-a451-4b91-a380-00c57b187803','2022-01-28 16:51:40',NULL,'','Informática'),('e972bb7b-005a-4c25-b604-18c25f44d5f7','2022-01-28 16:51:40',NULL,'','Elétrico');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citys`
--

DROP TABLE IF EXISTS `citys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citys` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FKdq9li6gi1hbw8urucf9fber2k` (`state_id`),
  CONSTRAINT `FKdq9li6gi1hbw8urucf9fber2k` FOREIGN KEY (`state_id`) REFERENCES `state` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citys`
--

LOCK TABLES `citys` WRITE;
/*!40000 ALTER TABLE `citys` DISABLE KEYS */;
INSERT INTO `citys` VALUES ('104e6248-9848-48e6-a934-8ca766d118e2','2022-01-28 16:51:40',NULL,'','Campinas','f6c4432b-6f1e-4f1d-aa82-75fb7e17ba82'),('16f54e8e-7680-4c6b-a1e0-f32bfde5efc8','2022-01-28 16:51:40',NULL,'','Sorocaba','f6c4432b-6f1e-4f1d-aa82-75fb7e17ba82'),('3a83f5f9-774f-42c4-838c-6a64e96bfd02','2022-01-28 16:51:40',NULL,'','Fortaleza','c2150694-3e31-4508-89d5-79637c3d1fc3'),('47034f19-640b-4f84-9e24-9ff11d6c9cad','2022-01-28 16:51:40',NULL,'','Bragança Paulista','f6c4432b-6f1e-4f1d-aa82-75fb7e17ba82'),('4cd75bfd-919c-4a26-8569-3b8903bc8408','2022-01-28 16:51:40',NULL,'','Fluminense','2e5ac047-8cf6-400c-8abd-f1690b397d4f'),('7357cd91-161e-406f-acd4-b302235364f4','2022-01-28 16:51:40',NULL,'','São Paulo','f6c4432b-6f1e-4f1d-aa82-75fb7e17ba82'),('7f3e3509-2c68-42e5-9e33-46960a177748','2022-01-28 16:51:40',NULL,'','Volta Redonda','2e5ac047-8cf6-400c-8abd-f1690b397d4f'),('b0b492a0-40a9-4a73-ba82-45a86d3aa978','2022-01-28 16:51:40',NULL,'','Sobral','c2150694-3e31-4508-89d5-79637c3d1fc3'),('bd071052-5f78-43b7-8dd7-f443e9cd1e48','2022-01-28 16:51:40',NULL,'','Rio de Janeiro','2e5ac047-8cf6-400c-8abd-f1690b397d4f'),('c56f5916-c398-4b46-bf13-1b4d716a0e3c','2022-01-28 16:51:40',NULL,'','Santos','f6c4432b-6f1e-4f1d-aa82-75fb7e17ba82');
/*!40000 ALTER TABLE `citys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nature` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('614abc62-56f6-4b01-96d8-720353e746a4','2022-01-28 16:51:40',NULL,'','46130373368',NULL,'antonio@gmail.com',1,'Antonio Lima'),('9dc00737-32af-46cf-a68d-c9df55347cbb','2022-01-28 16:51:40',NULL,'',NULL,'467518998-90','viniciusmls@outlook.com',0,'Marcus Vinicius');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_items` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `discount` decimal(19,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_price` decimal(19,2) DEFAULT NULL,
  `unity_price` decimal(19,2) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FK1263i88q602gig7fxad3pmfuo` (`order_id`),
  KEY `FKlf6f9q956mt144wiv6p1yko16` (`product_id`),
  CONSTRAINT `FK1263i88q602gig7fxad3pmfuo` FOREIGN KEY (`order_id`) REFERENCES `pedido` (`uuid`),
  CONSTRAINT `FKlf6f9q956mt144wiv6p1yko16` FOREIGN KEY (`product_id`) REFERENCES `product` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES ('5e59fa89-3e30-4f69-b4d7-4bf2f25f04ef','2022-01-28 16:51:40',NULL,'',100.00,3,1500.00,500.00,'4b731c1b-4c8b-4898-a588-b9b5166cc4e6','bc117b32-86d4-4654-ad93-a18ae5c882c2'),('9c0ecf30-8fb6-4ead-b41e-86ce1ca96dbe','2022-01-28 16:51:40',NULL,'',0.00,1,500.00,500.00,'4b731c1b-4c8b-4898-a588-b9b5166cc4e6','0ea84ec5-95a9-4e83-8908-3d21efc8ccb4');
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `state_payment` int(11) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FKffjmb2f9luqfak4lnk1rceb2b` (`order_id`),
  CONSTRAINT `FKffjmb2f9luqfak4lnk1rceb2b` FOREIGN KEY (`order_id`) REFERENCES `pedido` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_credit`
--

DROP TABLE IF EXISTS `payment_credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_credit` (
  `installments` int(11) DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FKphiosu6svaaksit62of9n9iu` FOREIGN KEY (`uuid`) REFERENCES `payment` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_credit`
--

LOCK TABLES `payment_credit` WRITE;
/*!40000 ALTER TABLE `payment_credit` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_credit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_ticket`
--

DROP TABLE IF EXISTS `payment_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_ticket` (
  `due_date` date DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK7r6pg62da6ea05mwsnj7b1lr` FOREIGN KEY (`uuid`) REFERENCES `payment` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_ticket`
--

LOCK TABLES `payment_ticket` WRITE;
/*!40000 ALTER TABLE `payment_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `date` date DEFAULT NULL,
  `address_id` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FK322wo1hgta9rxfrhgbjexsyvh` (`address_id`),
  KEY `FKk5facti0es38cfg0sed66dxpv` (`client_id`),
  CONSTRAINT `FK322wo1hgta9rxfrhgbjexsyvh` FOREIGN KEY (`address_id`) REFERENCES `addresss` (`uuid`),
  CONSTRAINT `FKk5facti0es38cfg0sed66dxpv` FOREIGN KEY (`client_id`) REFERENCES `client` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES ('4b731c1b-4c8b-4898-a588-b9b5166cc4e6','2022-01-28 16:51:40',NULL,'','2022-01-28','07df0ca6-0abc-4578-98a5-808efd228db9','9dc00737-32af-46cf-a68d-c9df55347cbb');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('0ea84ec5-95a9-4e83-8908-3d21efc8ccb4','2022-01-28 16:51:40',NULL,'','Harry Potter e o Prisioneiro de Aszaban',100.00,'405364e8-a992-498a-8aff-5ef2fb65b9e4'),('b0fbdd23-5b12-45af-97f5-b4dd983a42fe','2022-01-28 16:51:40',NULL,'','Sapato',0.00,'5c82b068-d306-42a0-9d39-d663da3dcb5c'),('bc117b32-86d4-4654-ad93-a18ae5c882c2','2022-01-28 16:51:40',NULL,'','Harry Potter e a Pedra FIlosofal',50.99,'405364e8-a992-498a-8aff-5ef2fb65b9e4'),('d9b3d91d-a434-42ad-81fa-811192e9b6ea','2022-01-28 16:51:40',NULL,'','Canetas',0.00,'5c82b068-d306-42a0-9d39-d663da3dcb5c'),('e21389f9-3c38-4be4-9cb8-14483bf3f2fd','2022-01-28 16:51:40',NULL,'','Cabos',100.00,'712cc97a-9175-4804-a215-66e028e7b1dd');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `code` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES ('01ab14ee-849c-4b2b-9315-24fc8c790b41','2022-01-28 16:51:40',NULL,'',21,'Maranhão','MA'),('034c3cc8-1adb-4d8b-b887-7b0cb529cb13','2022-01-28 16:51:40',NULL,'',29,'Bahia','BA'),('08a4cbf9-210c-493f-a6dc-784bed2af230','2022-01-28 16:51:40',NULL,'',51,'Mato Grosso','MT'),('25c8fb66-e6b7-4f56-987b-43631751a837','2022-01-28 16:51:40',NULL,'',42,'Santa Catarina','SC'),('2e5ac047-8cf6-400c-8abd-f1690b397d4f','2022-01-28 16:51:40',NULL,'',33,'Rio de Janeiro','RJ'),('33e06d8d-f43a-455c-ae5e-dfbc72ec1fc3','2022-01-28 16:51:40',NULL,'',41,'Paraná','PR'),('419563a4-476a-420a-ad11-b074d621db71','2022-01-28 16:51:40',NULL,'',23,'Ceará','CE'),('45599741-e62d-4725-94e2-a39794b73502','2022-01-28 16:51:40',NULL,'',32,'Espirito Santo','ES'),('46fb0d5d-3ce8-49a7-9a5c-926d09deaa6f','2022-01-28 16:51:40',NULL,'',17,'Tocatins','TO'),('634b349e-c955-4494-884e-2b42d427ee1e','2022-01-28 16:51:40',NULL,'',14,'Roraima','RR'),('80f7f6f3-cadc-4991-8ce7-607605de179d','2022-01-28 16:51:40',NULL,'',26,'Pernanbuco','PE'),('89f3c893-6935-4165-87ef-f9ed62efbfbb','2022-01-28 16:51:40',NULL,'',27,'Alagoas','AL'),('928844e6-75c6-496f-ae9d-3f809d8d65b1','2022-01-28 16:51:40',NULL,'',22,'Piauí','PI'),('93cbb4c5-c5eb-4006-b8d6-d9a935c64908','2022-01-28 16:51:40',NULL,'',52,'Goías','GO'),('9b3fc7bb-8780-4c0f-8e1c-faac3010b798','2022-01-28 16:51:40',NULL,'',28,'Sergipe','SE'),('a57c70e4-f48b-48b9-b696-4f848a20dc4a','2022-01-28 16:51:40',NULL,'',15,'Pará','PA'),('bbddc679-d8a1-496d-ab08-3c81f1eaf648','2022-01-28 16:51:40',NULL,'',13,'Amazonas','AM'),('bececc1d-9737-4a68-ab0c-0b7898bb1166','2022-01-28 16:51:40',NULL,'',12,'Acre','AC'),('c2150694-3e31-4508-89d5-79637c3d1fc3','2022-01-28 16:51:40',NULL,'',11,'Rondônia','RO'),('cce71567-cb5a-49f3-9c37-140b9e9f475e','2022-01-28 16:51:40',NULL,'',50,'Mato Grosso do Sul','MS'),('ccff22d2-8410-489d-a89a-9af6854857fc','2022-01-28 16:51:40',NULL,'',53,'Distrito Federal','DF'),('d92f8b53-61d1-4387-8336-412d678e4ecc','2022-01-28 16:51:40',NULL,'',24,'Rio Grande do Norte','RN'),('dd86187e-7d7e-407d-b489-d92a6d50f2fb','2022-01-28 16:51:40',NULL,'',43,'Rio Grande do Sul','RS'),('e4f1c09c-9884-4ff8-9a6a-52ad084ac1b2','2022-01-28 16:51:40',NULL,'',31,'Minas Gerais','MG'),('f2dd6fb3-ac56-444e-bd52-6dc992e021ca','2022-01-28 16:51:40',NULL,'',16,'Amapá','AP'),('f3cc1e47-8ce6-4213-9c9a-13c1677bd3c1','2022-01-28 16:51:40',NULL,'',25,'Paraíba','PB'),('f6c4432b-6f1e-4f1d-aa82-75fb7e17ba82','2022-01-28 16:51:40',NULL,'',25,'São Paulo','SP');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telephones`
--

DROP TABLE IF EXISTS `telephones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telephones` (
  `uuid` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `ddd` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FKqwph5onbc9ewpfqoghe1s7gw0` (`client_id`),
  CONSTRAINT `FKqwph5onbc9ewpfqoghe1s7gw0` FOREIGN KEY (`client_id`) REFERENCES `client` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telephones`
--

LOCK TABLES `telephones` WRITE;
/*!40000 ALTER TABLE `telephones` DISABLE KEYS */;
INSERT INTO `telephones` VALUES ('31e48751-17b1-4a82-ae78-72f980f55923','2022-01-28 16:51:40',NULL,'','11','98934-7080','9dc00737-32af-46cf-a68d-c9df55347cbb'),('97a9c2ed-3092-46af-9a70-c011492392e4','2022-01-28 16:51:40',NULL,'','11','99352-7709','9dc00737-32af-46cf-a68d-c9df55347cbb'),('a9f9466f-e676-4e6c-b051-519da88a724f','2022-01-28 16:51:40',NULL,'','21','3569-0873','614abc62-56f6-4b01-96d8-720353e746a4');
/*!40000 ALTER TABLE `telephones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-28 16:52:02
