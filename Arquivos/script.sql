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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresss`
--

LOCK TABLES `addresss` WRITE;
/*!40000 ALTER TABLE `addresss` DISABLE KEYS */;
INSERT INTO `addresss` VALUES ('5f93fbb4-d801-4566-8598-8fc97e223164','2022-01-28 16:01:52',NULL,'','Rua Caetano Basso','03584-130',NULL,'Parque Savoi City','252','e857db35-7711-4907-808c-93aacd505d08','7adbda13-6b23-4145-8e6e-da72ce46083f'),('7ec35b8d-c257-4d22-b72a-06961eee8589','2022-01-28 16:01:52',NULL,'','Rua Bernado','00000-100',NULL,'Sé','100','f007dcc1-acca-41bc-9409-ca7cb9921a8e','a0fcdcfd-a75a-4d62-b939-f5f661c20002'),('ae4e6833-ca2e-4af0-8877-b1573cebdbc2','2022-01-28 16:01:52',NULL,'','Rua Piquinhu','03657-010',NULL,'Vila Ré','227','e857db35-7711-4907-808c-93aacd505d08','7adbda13-6b23-4145-8e6e-da72ce46083f');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('0984b3b2-61e1-431d-9e44-d79c80793b84','2022-01-28 16:01:52',NULL,'','Escritório'),('15a76f22-d1f6-447c-a16c-7b7f60fd8155','2022-01-28 16:01:52',NULL,'','Vestuário'),('1f36bd2a-800a-45a4-b0e0-39c5f432b044','2022-01-28 16:01:52',NULL,'','Informática'),('1f384331-8318-4029-8de2-6a8de0f45fc3','2022-01-28 16:01:52',NULL,'','Biblioteca'),('3493981a-9813-4133-85e7-39d6bd3434c4','2022-01-28 16:01:52',NULL,'','Informática'),('3935a0f5-30a1-43b7-8438-2c65997705d3','2022-01-28 16:01:52',NULL,'','Elétrico'),('46875348-e837-41eb-9907-57cf9d59d248','2022-01-28 16:01:52',NULL,'','Informática'),('61f8ed8e-5c70-4e56-b062-ce7f0afeafc8','2022-01-28 16:01:52',NULL,'','Informática'),('6441cce8-ef53-4e97-b226-92a38a40e3a3','2022-01-28 16:01:52',NULL,'','Biblioteca'),('69b7d613-a6db-49a1-bf7a-4e4323369009','2022-01-28 16:01:52',NULL,'','Elétrico'),('72b57b73-d2e7-4c5c-9c44-9b278c3b051f','2022-01-28 16:01:52',NULL,'','Biblioteca'),('754e1258-a9a9-4fe9-b895-de581407bc64','2022-01-28 16:01:52',NULL,'','Elétrico'),('82b46fd0-9149-4930-abba-e4da2df9cf9c','2022-01-28 16:01:52',NULL,'','Escritório'),('8b75c144-1ccf-437d-97da-941777f014c4','2022-01-28 16:01:52',NULL,'','Escritório'),('9a27615a-f6a1-4720-8137-3ce77fc296f7','2022-01-28 16:01:52',NULL,'','Vestuário'),('a17fd31c-728d-4dac-ac6c-ae8c25dfce87','2022-01-28 16:01:52',NULL,'','Escritório'),('be3b73a4-aadb-4ef5-9236-327b5e471549','2022-01-28 16:01:52',NULL,'','Vestuário'),('c10f82fe-bbbe-4555-a4f4-86bb19ecb60b','2022-01-28 16:01:52',NULL,'','Biblioteca'),('fd5f1f2b-9b3f-4612-a00e-775df4c63d89','2022-01-28 16:01:52',NULL,'','Elétrico'),('ff229fb2-618e-4063-9b2d-3f4b0838fa2a','2022-01-28 16:01:52',NULL,'','Vestuário');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citys`
--

LOCK TABLES `citys` WRITE;
/*!40000 ALTER TABLE `citys` DISABLE KEYS */;
INSERT INTO `citys` VALUES ('36a18231-369f-4c2b-953f-4457f005b18c','2022-01-28 16:01:52',NULL,'','Santos','41d53444-fc27-4c2e-aee6-c5f948f1ec87'),('3cfa2049-8261-4869-93b3-956a280e2c8f','2022-01-28 16:01:52',NULL,'','Sobral','37098001-da6e-4b4c-896c-d586f1e6f513'),('4cd1eef0-638f-4449-a3c4-03d61ab461a8','2022-01-28 16:01:52',NULL,'','Volta Redonda','7f8faeac-dd71-419b-ae96-b570dcc453f9'),('6a8c27a5-5ac7-4024-a3c9-d25bb2ad3831','2022-01-28 16:01:52',NULL,'','Bragança Paulista','41d53444-fc27-4c2e-aee6-c5f948f1ec87'),('77e55ab9-181c-42d8-aa6e-da5c5f72a35f','2022-01-28 16:01:52',NULL,'','Campinas','41d53444-fc27-4c2e-aee6-c5f948f1ec87'),('792677c6-32fe-4b2b-8304-d01bf3938195','2022-01-28 16:01:52',NULL,'','Fluminense','7f8faeac-dd71-419b-ae96-b570dcc453f9'),('8d49d02b-c46b-45f8-988c-49242220ca91','2022-01-28 16:01:52',NULL,'','Fortaleza','37098001-da6e-4b4c-896c-d586f1e6f513'),('e60ace20-4c7c-480b-8652-c0ab69e99b2d','2022-01-28 16:01:52',NULL,'','Rio de Janeiro','7f8faeac-dd71-419b-ae96-b570dcc453f9'),('e857db35-7711-4907-808c-93aacd505d08','2022-01-28 16:01:52',NULL,'','São Paulo','41d53444-fc27-4c2e-aee6-c5f948f1ec87'),('f007dcc1-acca-41bc-9409-ca7cb9921a8e','2022-01-28 16:01:52',NULL,'','Sorocaba','41d53444-fc27-4c2e-aee6-c5f948f1ec87');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('7adbda13-6b23-4145-8e6e-da72ce46083f','2022-01-28 16:01:52',NULL,'',NULL,'467518998-90','viniciusmls@outlook.com',0,'Marcus Vinicius'),('a0fcdcfd-a75a-4d62-b939-f5f661c20002','2022-01-28 16:01:52',NULL,'','46130373368',NULL,'antonio@gmail.com',1,'Antonio Lima');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES ('95c2fb15-8f2a-41c1-b382-8809d33512f8','2022-01-28 16:01:52',NULL,'',100.00,3,1500.00,500.00,'b2625e24-1669-4c20-908f-22047479b7c7','5b65f329-a836-4bde-9485-3f298969fd8e'),('bd1535e2-fbc8-403f-b21d-a4bf970b06d4','2022-01-28 16:01:52',NULL,'',0.00,1,500.00,500.00,'b2625e24-1669-4c20-908f-22047479b7c7','598438da-142f-45b7-ba38-9e9b2c9d4efb');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES ('b2625e24-1669-4c20-908f-22047479b7c7','2022-01-28 16:01:52',NULL,'','2022-01-28','5f93fbb4-d801-4566-8598-8fc97e223164','7adbda13-6b23-4145-8e6e-da72ce46083f');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('506f5a28-09e0-44a6-939d-9d67e19f9506','2022-01-28 16:01:52',NULL,'','Canetas',0.00,'ff229fb2-618e-4063-9b2d-3f4b0838fa2a'),('598438da-142f-45b7-ba38-9e9b2c9d4efb','2022-01-28 16:01:52',NULL,'','Harry Potter e o Prisioneiro de Aszaban',100.00,'72b57b73-d2e7-4c5c-9c44-9b278c3b051f'),('5b65f329-a836-4bde-9485-3f298969fd8e','2022-01-28 16:01:52',NULL,'','Harry Potter e a Pedra FIlosofal',50.99,'72b57b73-d2e7-4c5c-9c44-9b278c3b051f'),('5bda7cd1-92db-4d53-8b30-e190fab0279b','2022-01-28 16:01:52',NULL,'','Sapato',0.00,'ff229fb2-618e-4063-9b2d-3f4b0838fa2a'),('bfbee962-4c76-45c7-a4f8-82fea1b92dda','2022-01-28 16:01:52',NULL,'','Cabos',100.00,'69b7d613-a6db-49a1-bf7a-4e4323369009');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES ('2e77e7a9-e968-4728-bf6f-091381248ac0','2022-01-28 16:01:52',NULL,'',32,'Espirito Santo','ES'),('37098001-da6e-4b4c-896c-d586f1e6f513','2022-01-28 16:01:52',NULL,'',11,'Rondônia','RO'),('41d53444-fc27-4c2e-aee6-c5f948f1ec87','2022-01-28 16:01:52',NULL,'',25,'São Paulo','SP'),('4de6eb82-7718-46db-961d-06a4aea29cff','2022-01-28 16:01:52',NULL,'',12,'Acre','AC'),('55ddec2b-9298-4640-b742-0d664efb861f','2022-01-28 16:01:52',NULL,'',25,'Paraíba','PB'),('57bec80c-172c-4eb2-8fd4-d613a4436f14','2022-01-28 16:01:52',NULL,'',16,'Amapá','AP'),('5dbb7e0c-7621-4b8b-9197-e72608c1243c','2022-01-28 16:01:52',NULL,'',24,'Rio Grande do Norte','RN'),('6abb5f3d-11f8-4366-a8a9-3c35812557c9','2022-01-28 16:01:52',NULL,'',41,'Paraná','PR'),('6c9c375e-a01d-41be-a8c1-e026e5c45d6e','2022-01-28 16:01:52',NULL,'',23,'Ceará','CE'),('79112b1f-9a86-48a3-a27f-f43ff31d5bf5','2022-01-28 16:01:52',NULL,'',13,'Amazonas','AM'),('7c970d30-d2cf-40db-a0b4-c7196b2e94a6','2022-01-28 16:01:52',NULL,'',42,'Santa Catarina','SC'),('7f8faeac-dd71-419b-ae96-b570dcc453f9','2022-01-28 16:01:52',NULL,'',33,'Rio de Janeiro','RJ'),('8528c9e5-5443-40a1-8611-70cdcaf61cc7','2022-01-28 16:01:52',NULL,'',50,'Mato Grosso do Sul','MS'),('856742c1-2b89-481b-8b94-a80929826413','2022-01-28 16:01:52',NULL,'',53,'Distrito Federal','DF'),('866bdef6-a309-4d2c-b4bd-5cc5b60bb456','2022-01-28 16:01:52',NULL,'',29,'Bahia','BA'),('87b3f397-8b34-4097-889e-31ef19cb8601','2022-01-28 16:01:52',NULL,'',27,'Alagoas','AL'),('88f5d5c5-2d9f-4946-8a01-72c6f10c14bd','2022-01-28 16:01:52',NULL,'',26,'Pernanbuco','PE'),('a4900ce8-6581-4cd0-a96e-24b62f435c96','2022-01-28 16:01:52',NULL,'',43,'Rio Grande do Sul','RS'),('abfb5caf-89ba-42a3-9588-bf792c6c2f42','2022-01-28 16:01:52',NULL,'',21,'Maranhão','MA'),('ac2929e6-57e0-4543-90a1-d693233014d1','2022-01-28 16:01:52',NULL,'',17,'Tocatins','TO'),('b4848bea-d91b-4034-af40-444b7850208e','2022-01-28 16:01:52',NULL,'',14,'Roraima','RR'),('c415632a-6ce7-4d04-9cc1-c644c9c7d478','2022-01-28 16:01:52',NULL,'',15,'Pará','PA'),('d5ba0f13-3608-472c-8cfe-d6ef0d359e55','2022-01-28 16:01:52',NULL,'',22,'Piauí','PI'),('e0810b61-d75d-4a1f-b6f6-16d5ea8a52de','2022-01-28 16:01:52',NULL,'',52,'Goías','GO'),('e32e168c-53a6-4d37-ab1e-a27d723bce6d','2022-01-28 16:01:52',NULL,'',28,'Sergipe','SE'),('ed1fb7e9-bd08-40ac-b2e2-a306a3dd93ae','2022-01-28 16:01:52',NULL,'',51,'Mato Grosso','MT'),('ee2a4939-a66d-4b8d-b5b8-1b2704d21e5e','2022-01-28 16:01:52',NULL,'',31,'Minas Gerais','MG');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telephones`
--

LOCK TABLES `telephones` WRITE;
/*!40000 ALTER TABLE `telephones` DISABLE KEYS */;
INSERT INTO `telephones` VALUES ('3bfd7073-2e86-4b09-b379-1c289d6438fa','2022-01-28 16:01:52',NULL,'','11','99352-7709','7adbda13-6b23-4145-8e6e-da72ce46083f'),('893bd7e6-5312-4af7-a988-d9dfc7889ade','2022-01-28 16:01:52',NULL,'','11','98934-7080','7adbda13-6b23-4145-8e6e-da72ce46083f'),('949a8bdb-7bf9-41c7-8303-5f9aaeee3804','2022-01-28 16:01:52',NULL,'','21','3569-0873','a0fcdcfd-a75a-4d62-b939-f5f661c20002');
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

-- Dump completed on 2022-01-28 16:18:08
