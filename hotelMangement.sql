-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hotelms
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `admint`
--

DROP TABLE IF EXISTS admint;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE admint (
  user_name varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admint`
--

LOCK TABLES admint WRITE;
/*!40000 ALTER TABLE admint DISABLE KEYS */;
INSERT INTO admint VALUES ('Kuntal','123456789'),('Kunal','12345');
/*!40000 ALTER TABLE admint ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS customer;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE customer (
  document varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  gender varchar(30) DEFAULT NULL,
  country varchar(30) DEFAULT NULL,
  room varchar(30) DEFAULT NULL,
  checkintime varchar(80) DEFAULT NULL,
  deposit varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES customer WRITE;
/*!40000 ALTER TABLE customer DISABLE KEYS */;
/*!40000 ALTER TABLE customer ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS department;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE department (
  department varchar(20) DEFAULT NULL,
  budget varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES department WRITE;
/*!40000 ALTER TABLE department DISABLE KEYS */;
INSERT INTO department VALUES ('office','50000'),('house keeping','40000'),('food','80000'),('kitchen','20000'),('security','60000');
/*!40000 ALTER TABLE department ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS driver;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE driver (
  `name` varchar(20) DEFAULT NULL,
  age varchar(20) DEFAULT NULL,
  gender varchar(20) DEFAULT NULL,
  company varchar(20) DEFAULT NULL,
  carname varchar(20) DEFAULT NULL,
  available varchar(20) DEFAULT NULL,
  location varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES driver WRITE;
/*!40000 ALTER TABLE driver DISABLE KEYS */;
INSERT INTO driver VALUES ('Kuntal','12','Male','VOLVO','lion200','Yes','Station'),('Rahul','23','Male','TATA','Punch','Yes','Hospital');
/*!40000 ALTER TABLE driver ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS employee;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE employee (
  `name` varchar(20) DEFAULT NULL,
  age varchar(20) DEFAULT NULL,
  gender varchar(20) DEFAULT NULL,
  job varchar(20) DEFAULT NULL,
  salary varchar(20) DEFAULT NULL,
  phone varchar(20) DEFAULT NULL,
  email varchar(20) DEFAULT NULL,
  aadhar varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES employee WRITE;
/*!40000 ALTER TABLE employee DISABLE KEYS */;
INSERT INTO employee VALUES ('Kuntal','12','MAlE','Kitchen Staff','100000','9476451443','kb@gmail.com','210002107845'),('Kunal','37','MAlE','Front Desk','40000','9475847652','kunal@gamil.com','211457809550'),('Priyansu','23','MAlE','Accountant','45000','8745789514','priyansu@gmail.com','214563789456142'),('Tanmoy','22','MAlE','Housekeeping','21540','6247884598','saha@gamil.com','245789456124578'),('Yash','23','MAlE','Manager','50000','9847581546','yash@gmail.com','213457894561245'),('Safi','23','MAlE','Manager','40000','8748587956','safi@email','257846154789564');
/*!40000 ALTER TABLE employee ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS login;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE login (
  username varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES login WRITE;
/*!40000 ALTER TABLE login DISABLE KEYS */;
INSERT INTO login VALUES ('kuntal','12345678');
/*!40000 ALTER TABLE login ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS room;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE room (
  roomNumber varchar(20) NOT NULL,
  availability varchar(20) DEFAULT NULL,
  price varchar(20) NOT NULL,
  cleaningStatus varchar(20) DEFAULT NULL,
  bedType varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES room WRITE;
/*!40000 ALTER TABLE room DISABLE KEYS */;
INSERT INTO room VALUES ('101','Available','2000','Dirty','Single Bed'),('102','Available','3000','Cleaned','Single Bed'),('103','Available','5000','Cleaned','Double Bed'),('104','Available','8000','Dirty','Double Bed');
/*!40000 ALTER TABLE room ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-08 13:33:24
