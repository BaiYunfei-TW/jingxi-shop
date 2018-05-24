/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : jingxishop

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2018-05-24 11:17:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
CREATE TABLE `inventory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `lockedCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

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

-- ----------------------------
-- Table structure for product
-- ----------------------------
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

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
