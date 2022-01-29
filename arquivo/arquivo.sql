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
INSERT INTO `addresss` VALUES ('1ff95e89-ea36-49cb-a50a-c6e0b80fc52e','2022-01-28 17:45:55',NULL,'','Rua Caetano Basso','03584-130',NULL,'Parque Savoi City','252','d6287f9f-43db-47c8-a19e-04dce18e6850','928173b3-c11e-4b32-950b-4baf690ac0a9'),('3528394f-4e38-45f0-b81d-6a735618f685','2022-01-28 17:45:55',NULL,'','Rua Piquinhu','03657-010',NULL,'Vila Ré','227','d6287f9f-43db-47c8-a19e-04dce18e6850','928173b3-c11e-4b32-950b-4baf690ac0a9'),('6cef6f0b-f751-47f2-b76b-6f84c761c1c7','2022-01-28 17:45:55',NULL,'','Rua Bernado','00000-100',NULL,'Sé','100','66375a2e-084a-4ee3-af59-a22d9b50db80','527c1122-7f82-4c06-b676-d27329576c9e');
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
INSERT INTO `category` VALUES ('08cf9a72-8ead-43a4-8637-63ec6a2bba3e','2022-01-28 17:45:54',NULL,'','Vestuário'),('0dd1bc4c-ff7e-42b4-a501-e5d77191f325','2022-01-28 17:45:54',NULL,'','Informática'),('1db195a8-3a68-4861-b817-78359c89b9ae','2022-01-28 17:45:54',NULL,'','Escritório'),('1ec94a39-3fe9-4082-be24-93ab07d30a84','2022-01-28 17:45:54',NULL,'','Escritório'),('3bf51038-a317-4a50-b252-70a0043ee5d6','2022-01-28 17:45:54',NULL,'','Elétrico'),('4dae601c-5d6b-48d9-b896-5ce10b975b78','2022-01-28 17:45:54',NULL,'','Biblioteca'),('635a0298-3dc5-4e63-a823-340ea7f4c159','2022-01-28 17:45:54',NULL,'','Vestuário'),('715483eb-a54a-4cf8-bccb-49150107d466','2022-01-28 17:45:54',NULL,'','Informática'),('76aa140c-d94f-4765-9f48-4a2b877e80d1','2022-01-28 17:45:54',NULL,'','Escritório'),('780fb57b-6158-408b-bfe8-d91e41eb0edf','2022-01-28 17:45:54',NULL,'','Vestuário'),('7fe24e91-ddbc-4e81-90a8-bc5957874047','2022-01-28 17:45:54',NULL,'','Biblioteca'),('85833bbc-18be-4b25-a813-f80cd0bba26e','2022-01-28 17:45:54',NULL,'','Elétrico'),('ab1ae75a-3d47-4546-906b-aa4673c4ada0','2022-01-28 17:45:54',NULL,'','Informática'),('b21bb144-1cd4-4922-a240-7c2395493858','2022-01-28 17:45:54',NULL,'','Escritório'),('cbf7e2c8-7fc2-4c5b-9e3d-1fa79bd9d9eb','2022-01-28 17:45:54',NULL,'','Elétrico'),('dacf8cad-1026-4540-8b4e-91e9e343847e','2022-01-28 17:45:54',NULL,'','Elétrico'),('dbe01713-2a9b-40b6-9ff6-bbcc6dce2970','2022-01-28 17:45:54',NULL,'','Biblioteca'),('e06c3908-4944-4939-806e-4d73d77be0e7','2022-01-28 17:45:54',NULL,'','Biblioteca'),('e1cc0adf-b96e-45a4-af24-23fe23670154','2022-01-28 17:45:54',NULL,'','Informática'),('e30964ea-33cd-4ac8-bf12-1021e2d00ab8','2022-01-28 17:45:54',NULL,'','Vestuário');
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
INSERT INTO `citys` VALUES ('0f03c3da-e057-4919-9101-2934bc593b31','2022-01-28 17:45:55',NULL,'','Fortaleza','8e7c8a09-eb8f-4a4c-9268-16e589a81525'),('58a352a8-5249-4068-9e98-3df8ea576e12','2022-01-28 17:45:55',NULL,'','Rio de Janeiro','52010d30-2ae2-45b7-8c28-4379c7b03775'),('655f284b-2d72-4fce-9c31-6aac6b91e56a','2022-01-28 17:45:55',NULL,'','Fluminense','52010d30-2ae2-45b7-8c28-4379c7b03775'),('66375a2e-084a-4ee3-af59-a22d9b50db80','2022-01-28 17:45:55',NULL,'','Sorocaba','a483f5c7-c722-48ae-bbf7-2ac7b979dd4b'),('8ca44703-73f3-4f94-b47d-4710a1601a43','2022-01-28 17:45:55',NULL,'','Volta Redonda','52010d30-2ae2-45b7-8c28-4379c7b03775'),('992a3a34-fb53-4547-a23d-595798f185a9','2022-01-28 17:45:55',NULL,'','Campinas','a483f5c7-c722-48ae-bbf7-2ac7b979dd4b'),('abe51548-f8fe-4026-801b-f97b5a5032a1','2022-01-28 17:45:55',NULL,'','Sobral','8e7c8a09-eb8f-4a4c-9268-16e589a81525'),('d4013a79-9236-4f22-990f-c898d83db38e','2022-01-28 17:45:55',NULL,'','Santos','a483f5c7-c722-48ae-bbf7-2ac7b979dd4b'),('d6287f9f-43db-47c8-a19e-04dce18e6850','2022-01-28 17:45:55',NULL,'','São Paulo','a483f5c7-c722-48ae-bbf7-2ac7b979dd4b'),('def9512f-85aa-4c96-bee8-35cca5e73d07','2022-01-28 17:45:55',NULL,'','Bragança Paulista','a483f5c7-c722-48ae-bbf7-2ac7b979dd4b');
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
INSERT INTO `client` VALUES ('527c1122-7f82-4c06-b676-d27329576c9e','2022-01-28 17:45:55',NULL,'','46130373368',NULL,'antonio@gmail.com',1,'Antonio Lima'),('928173b3-c11e-4b32-950b-4baf690ac0a9','2022-01-28 17:45:55',NULL,'',NULL,'467518998-90','viniciusmls@outlook.com',0,'Marcus Vinicius');
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
INSERT INTO `order_items` VALUES ('1e05c18e-6c8c-4bdb-a38a-125333dcb8f9','2022-01-28 17:45:55',NULL,'',0.00,1,500.00,500.00,'56051c60-3555-4a15-bc49-a2e3e5565830','2352c111-6027-4c73-ab0d-629a94b274da'),('e14acfea-110b-47eb-9a87-36dce37ef9d8','2022-01-28 17:45:55',NULL,'',100.00,3,1500.00,500.00,'56051c60-3555-4a15-bc49-a2e3e5565830','a53502f6-62b3-4495-b9e8-72a5ed6898f8');
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
INSERT INTO `pedido` VALUES ('56051c60-3555-4a15-bc49-a2e3e5565830','2022-01-28 17:45:55',NULL,'','2022-01-28','1ff95e89-ea36-49cb-a50a-c6e0b80fc52e','928173b3-c11e-4b32-950b-4baf690ac0a9');
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
INSERT INTO `product` VALUES ('2352c111-6027-4c73-ab0d-629a94b274da','2022-01-28 17:45:55',NULL,'','Harry Potter e o Prisioneiro de Aszaban',100.00,'4dae601c-5d6b-48d9-b896-5ce10b975b78'),('a53502f6-62b3-4495-b9e8-72a5ed6898f8','2022-01-28 17:45:55',NULL,'','Harry Potter e a Pedra FIlosofal',50.99,'4dae601c-5d6b-48d9-b896-5ce10b975b78'),('af3d8297-9c4c-4702-ad48-809416bbaa86','2022-01-28 17:45:55',NULL,'','Sapato',0.00,'635a0298-3dc5-4e63-a823-340ea7f4c159'),('c38a5e4d-6b4b-4541-be3e-f07be2f32564','2022-01-28 17:45:55',NULL,'','Canetas',0.00,'635a0298-3dc5-4e63-a823-340ea7f4c159'),('f70e9d58-6466-4de1-b37d-26833b54d40f','2022-01-28 17:45:55',NULL,'','Cabos',100.00,'cbf7e2c8-7fc2-4c5b-9e3d-1fa79bd9d9eb');
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
INSERT INTO `state` VALUES ('097d2357-f63d-4eaf-a992-9d3c30e6c15c','2022-01-28 17:45:55',NULL,'',12,'Acre','AC'),('1f3dac20-d2c9-4629-8eb8-054791ffe3a7','2022-01-28 17:45:55',NULL,'',21,'Maranhão','MA'),('20eda8db-95fb-490a-a369-dd086cb4c28f','2022-01-28 17:45:55',NULL,'',25,'Paraíba','PB'),('2138efba-b1a2-4995-a493-bb95d9cd9e5d','2022-01-28 17:45:55',NULL,'',41,'Paraná','PR'),('23cbdb8f-c9fa-424b-8103-bd624ea3ac76','2022-01-28 17:45:55',NULL,'',51,'Mato Grosso','MT'),('385c3af0-29ed-4cd8-9056-334d22e87e52','2022-01-28 17:45:55',NULL,'',24,'Rio Grande do Norte','RN'),('3f115d44-d94e-40fd-ad97-c8c29bec303a','2022-01-28 17:45:55',NULL,'',17,'Tocatins','TO'),('52010d30-2ae2-45b7-8c28-4379c7b03775','2022-01-28 17:45:55',NULL,'',33,'Rio de Janeiro','RJ'),('5236dee3-f4bb-40aa-a463-c1050325bae5','2022-01-28 17:45:55',NULL,'',15,'Pará','PA'),('53022a61-9089-4935-9f69-97ef11a12f07','2022-01-28 17:45:55',NULL,'',13,'Amazonas','AM'),('5776a0fc-5082-4320-a8de-4f56c1629a95','2022-01-28 17:45:55',NULL,'',29,'Bahia','BA'),('65165ffc-595f-443b-9b21-d64a63cd128d','2022-01-28 17:45:55',NULL,'',27,'Alagoas','AL'),('7e18e3b3-ca4f-4cb6-9797-27709f92cf7f','2022-01-28 17:45:55',NULL,'',53,'Distrito Federal','DF'),('8e7c8a09-eb8f-4a4c-9268-16e589a81525','2022-01-28 17:45:55',NULL,'',11,'Rondônia','RO'),('98abe96d-1d0e-4b64-8b49-5f9597619747','2022-01-28 17:45:55',NULL,'',52,'Goías','GO'),('a483f5c7-c722-48ae-bbf7-2ac7b979dd4b','2022-01-28 17:45:55',NULL,'',25,'São Paulo','SP'),('ac545c44-768d-4f67-8c11-92c1c23dcc19','2022-01-28 17:45:55',NULL,'',16,'Amapá','AP'),('af0dec57-f3da-4043-8765-34fcbd39f28c','2022-01-28 17:45:55',NULL,'',14,'Roraima','RR'),('b4d57baf-ef0d-4908-b7a0-6ab585378dbe','2022-01-28 17:45:55',NULL,'',26,'Pernanbuco','PE'),('d2a543ee-162c-4704-a6e2-1249f5783040','2022-01-28 17:45:55',NULL,'',22,'Piauí','PI'),('dc7b4208-12aa-4b38-9084-c4b1dcfee499','2022-01-28 17:45:55',NULL,'',43,'Rio Grande do Sul','RS'),('e327e300-d3fc-4a2a-85c6-8d0bcf412897','2022-01-28 17:45:55',NULL,'',50,'Mato Grosso do Sul','MS'),('e3a139e9-8f7a-4c47-b9c9-5585b4223ee2','2022-01-28 17:45:55',NULL,'',28,'Sergipe','SE'),('e6e04233-04ca-44cd-a465-d9752182a38a','2022-01-28 17:45:55',NULL,'',31,'Minas Gerais','MG'),('ec254648-6945-4472-befc-d7575b811485','2022-01-28 17:45:55',NULL,'',32,'Espirito Santo','ES'),('faa06725-ea73-44d5-9447-b0b2561a8829','2022-01-28 17:45:55',NULL,'',23,'Ceará','CE'),('fd0f4ab3-58c0-40fe-a44b-f1ee0785e5ee','2022-01-28 17:45:55',NULL,'',42,'Santa Catarina','SC');
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
INSERT INTO `telephones` VALUES ('0d04c154-36a7-4ee4-a00d-ffbc9f3769c3','2022-01-28 17:45:55',NULL,'','11','98934-7080','928173b3-c11e-4b32-950b-4baf690ac0a9'),('37a89e88-07a3-450b-ae89-44e6c7f5e97d','2022-01-28 17:45:55',NULL,'','21','3569-0873','527c1122-7f82-4c06-b676-d27329576c9e'),('9a1d339b-176d-4896-a679-5551559d4937','2022-01-28 17:45:55',NULL,'','11','99352-7709','928173b3-c11e-4b32-950b-4baf690ac0a9');
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

-- Dump completed on 2022-01-29 12:00:42
