CREATE TABLE `xy_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userpassword` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `userData` varchar(50) DEFAULT NULL,
  `userphone` varchar(20) DEFAULT NULL,
  `userAddress` varchar(50) DEFAULT NULL,
  `userlei` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

