-- ----------------------------
-- Table structure for orders
-- ----------------------------
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `finishTime` datetime DEFAULT NULL,
  `paidTime` datetime DEFAULT NULL,
  `totalPrice` int(11) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `withdrawnTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;