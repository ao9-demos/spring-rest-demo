DROP DATABASE  IF EXISTS `spring_security_demo_bcrypt`;

CREATE DATABASE  IF NOT EXISTS `spring_security_demo_bcrypt`;
USE `spring_security_demo_bcrypt`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('user','{bcrypt}$2y$12$dHBolPVzgn5LKsZxvPk/0OA4CzBpt2XZC48HD2HaXtaEn4N8dDNPa
',1),
('mng','{bcrypt}$2y$12$hlXCORkr/aAd8Nl0h1hrke2EWyQyrlAeMGc2Q/.7kLUm9e4e7Z5Te
',1),
('admin','{bcrypt}$2y$12$AlavQa5QWkJTDsZVN3ygp.SDjR3yHzsSxLaXdYfJ7wuaifbwDGDfi
',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('user','ROLE_USER'),
('mng','ROLE_USER'),
('mng','ROLE_MANAGER'),
('admin','ROLE_USER'),
('admin','ROLE_ADMIN');