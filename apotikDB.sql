/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 10.4.27-MariaDB : Database - apotik
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`apotik` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `apotik`;

/*Table structure for table `agents` */

DROP TABLE IF EXISTS `agents`;

CREATE TABLE `agents` (
  `ID` INT(255) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(255) DEFAULT NULL,
  `AGE` INT(255) DEFAULT NULL,
  `PHONE` INT(255) DEFAULT NULL,
  `PASSWORD` VARCHAR(255) DEFAULT NULL,
  `GENDER` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `agents` */

INSERT  INTO `agents`(`ID`,`NAME`,`AGE`,`PHONE`,`PASSWORD`,`GENDER`) VALUES 
(1,'nayla',20,8774777,'asdf','Perempuan'),
(2,'Marom',34,86,'asdf','Male'),
(3,'aufal',18,877,'asdf','Male'),
(4,'aufal',18,877,'asdf','Male');

/*Table structure for table `companies` */

DROP TABLE IF EXISTS `companies`;

CREATE TABLE `companies` (
  `ID` INT(255) NOT NULL,
  `NAME` CHAR(255) DEFAULT NULL,
  `ADDRESS` CHAR(255) DEFAULT NULL,
  `COMPANYEXP` INT(255) DEFAULT NULL,
  `PHONE` INT(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `companies` */

INSERT  INTO `companies`(`ID`,`NAME`,`ADDRESS`,`COMPANYEXP`,`PHONE`) VALUES 
(1,'pramita','malang',3,98),
(2,'saga','jakarta',2,85),
(3,'angger','surabaya',3,8),
(4,'waras','surabaya',3,8);

/*Table structure for table `medicines` */

DROP TABLE IF EXISTS `medicines`;

CREATE TABLE `medicines` (
  `ID` INT(255) NOT NULL,
  `MEDNAME` VARCHAR(255) DEFAULT NULL,
  `QUANTITY` INT(255) DEFAULT NULL,
  `FABDATE` DATE DEFAULT NULL,
  `EXPDATE` DATE DEFAULT NULL,
  `MEDCOMP` VARCHAR(255) DEFAULT NULL,
  `PRICE` INT(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `medicines` */

INSERT  INTO `medicines`(`ID`,`MEDNAME`,`QUANTITY`,`FABDATE`,`EXPDATE`,`MEDCOMP`,`PRICE`) VALUES 
(1,'bodrex',20,'2024-05-01','2024-05-02','pramita',2),
(2,'paracetamol',18,'2024-05-01','2024-05-31','saga',5),
(3,'komik',50,'2024-05-01','2024-05-02','pramita',2),
(4,'bodrex',50,'2024-05-01','2024-05-02','pramita',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
