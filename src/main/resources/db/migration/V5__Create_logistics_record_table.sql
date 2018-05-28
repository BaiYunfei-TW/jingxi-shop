-- ----------------------------
-- Table structure for logistics_record
-- ----------------------------
CREATE TABLE `logistics_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deliveryMan` varchar(255) DEFAULT NULL,
  `outboundTime` datetime DEFAULT NULL,
  `signedTime` datetime DEFAULT NULL,
  `logisticsStatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;