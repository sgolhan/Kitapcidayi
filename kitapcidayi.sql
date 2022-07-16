-- MySQL dump 10.13  Distrib 8.0.24, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: kitapcidayi
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `BID` bigint NOT NULL AUTO_INCREMENT,
  `bookname` varchar(255) NOT NULL,
  `category` varchar(45) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  PRIMARY KEY (`BID`),
  UNIQUE KEY `BID_UNIQUE` (`BID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (3,'Yüzüklerin Efendisi','Roman','24234234234234'),(9,'Sefiller','Roman','13123123123123'),(18,'Fareler ve İnsanlar','Biyografi','2423424'),(24,'Kelebek Etkisi','Deneme','12313131312'),(25,'Frankestein','Masal','131313'),(26,'Görünmez Adam','Polisiye','141414124141'),(27,'Uzaktan Kumandalı Kız','Polisiye','342414141'),(28,'Liste','Biyografi','342423424'),(29,'Haycan Çiftliği','Hikaye','242424');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issues`
--

DROP TABLE IF EXISTS `issues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issues` (
  `issueid` bigint NOT NULL AUTO_INCREMENT,
  `issuedate` varchar(255) DEFAULT NULL,
  `pickedup` varchar(255) DEFAULT NULL,
  `returndate` varchar(255) DEFAULT NULL,
  `books_id` bigint DEFAULT NULL,
  `users_id` bigint DEFAULT NULL,
  `expectedpickup` datetime DEFAULT NULL,
  PRIMARY KEY (`issueid`),
  KEY `fk_issues_books1_idx` (`books_id`),
  KEY `fk_issues_user1_idx` (`users_id`),
  CONSTRAINT `books_id` FOREIGN KEY (`books_id`) REFERENCES `books` (`BID`),
  CONSTRAINT `users_id` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issues`
--

LOCK TABLES `issues` WRITE;
/*!40000 ALTER TABLE `issues` DISABLE KEYS */;
INSERT INTO `issues` VALUES (98,'2022-07-16 01:36:58.008','1','2022-07-31 01:36:58.008',3,14,'2022-07-23 01:36:58'),(99,'2022-07-16 01:37:27.542','0','2022-07-31 01:37:27.542',18,16,'2022-07-23 01:37:28'),(100,'2022-07-16 02:08:23.187','0','2022-07-31 02:08:23.187',25,14,'2022-07-23 02:08:23'),(102,'2022-07-16 02:24:42.3','1','2022-07-31 02:24:42.3',28,10,'2022-07-23 02:24:42'),(103,'2022-07-16 02:24:45.836','0','2022-07-31 02:24:45.836',29,10,'2022-07-23 02:24:46');
/*!40000 ALTER TABLE `issues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_USER'),(5,'ROLE_USER'),(10,'ROLE_USER'),(14,'ROLE_ADMIN'),(16,'ROLE_USER'),(17,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`),
  KEY `FK388j0vyq4hnj72xl53tdls2u4` (`user_id`),
  CONSTRAINT `FK388j0vyq4hnj72xl53tdls2u4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,'sgolhan@gmail.com','Serkan','GÖLHAN','$2a$10$rY.212cBUrEsYNrpi4vHxOWVQTAP4TdrHc2.EG/eNo78MIbk7rrMe',NULL),(14,'admin','Admin','User','$2a$10$5StZ1GfV1OLArb4SQXCsmeVMba7Q9/nK9zsGn/HAhLcbFHi1aauFW',NULL),(16,'umit_soylu@yahoo.com','Ümit','SOYLU','$2a$10$Ouv6tsInVsRxa4PGx.XqteoEROF9A5uuYU/k3vbs3x9Ds.bcJOfva',NULL),(17,'user@user.com','Test','User','$2a$10$G3Km9dmJeWjnFElbtJ4JK.RCntQ/7WJmKdGfknGuLS0mHAe9migcq',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`),
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (10,10),(14,14),(16,16),(17,17);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-16  4:03:50
