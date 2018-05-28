-- ----------------------------
-- Table structure for purchase_item
-- ----------------------------
CREATE TABLE `purchase_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productId` bigint(20) DEFAULT NULL,
  `purchasePrice` int(11) DEFAULT NULL,
  `purchaseCount` int(11) DEFAULT NULL,
  `orderId` bigint(20) DEFAULT NULL,
  `productName` varchar(255) DEFAULT NULL,
  `productDescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;