CREATE DATABASE  IF NOT EXISTS `web_customer_tracker`;
USE `web_customer_tracker`;

SET FOREIGN_KEY_CHECKS = 0;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;

INSERT INTO `address` VALUES 
	(1,'81 King E','Hamilton','ON','L8N 1A5','Canada'),
	(2,'195 Peel','Montreal','QC','H3C 0T1','Canada'),
	(3,'81 King E','Hamilton','ON','L8N 1A5','Canada'),
	(4,'195 Peel','Montreal','QC','H3C 0T1','Canada'),
	(5,'81 King E','Hamilton','ON','L8N 1A5','Canada');

UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `active` boolean,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ADDRESS_idx` (`address_id`),
  CONSTRAINT `FK_ADDRESS` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;

INSERT INTO `customer` VALUES 
	(1,'David','Adams','david@luv2code.com',1,1),
	(2,'John','Doe','john@luv2code.com',true,2),
	(3,'Ajay','Rao','ajay@luv2code.com',0,3),
	(4,'Mary','Public','mary@luv2code.com',1,4),
	(5,'Maxwell','Dixon','max@luv2code.com',false,5);

UNLOCK TABLES;
