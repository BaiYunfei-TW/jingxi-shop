/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : jingxishop

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-24 11:40:29
*/

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES ('1', '10', '21');
INSERT INTO `inventory` VALUES ('2', '100', '7');
INSERT INTO `inventory` VALUES ('3', '100', '35');
INSERT INTO `inventory` VALUES ('9', '0', '0');
INSERT INTO `inventory` VALUES ('10', '0', '0');
INSERT INTO `inventory` VALUES ('11', '0', '0');
INSERT INTO `inventory` VALUES ('12', '0', '0');
INSERT INTO `inventory` VALUES ('13', '0', '0');
INSERT INTO `inventory` VALUES ('14', '0', '0');
INSERT INTO `inventory` VALUES ('15', '0', '0');
INSERT INTO `inventory` VALUES ('16', '0', '0');

-- ----------------------------
-- Records of logistics_record
-- ----------------------------
INSERT INTO `logistics_record` VALUES ('1', '李师傅', '2018-05-17 16:05:40', '2018-05-17 16:05:40', 'signed');

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2018-05-17 11:38:25', null, '2018-05-17 16:05:40', null, '1', 'paid', null);
INSERT INTO `orders` VALUES ('5', '2018-05-17 14:04:47', null, null, '3300', '1', 'withdrawn', '2018-05-17 16:05:40');
INSERT INTO `orders` VALUES ('6', '2018-05-17 14:08:58', null, null, '3300', '1', null, null);
INSERT INTO `orders` VALUES ('7', '2018-05-17 14:09:20', null, null, '3300', '1', null, null);
INSERT INTO `orders` VALUES ('8', '2018-05-17 14:44:42', null, null, '3300', null, null, null);
INSERT INTO `orders` VALUES ('9', '2018-05-17 14:45:00', null, null, '3300', null, null, null);
INSERT INTO `orders` VALUES ('10', '2018-05-17 14:59:53', null, null, '3300', null, null, null);
INSERT INTO `orders` VALUES ('11', '2018-05-17 15:03:42', null, null, '3300', null, null, null);
INSERT INTO `orders` VALUES ('12', '2018-05-17 15:04:25', null, null, '3300', null, null, null);
INSERT INTO `orders` VALUES ('13', '2018-05-17 15:04:48', null, null, '3300', null, null, null);
INSERT INTO `orders` VALUES ('14', '2018-05-17 15:06:22', null, null, '3300', null, null, null);
INSERT INTO `orders` VALUES ('15', '2018-05-17 15:10:50', null, null, '3300', null, null, null);
INSERT INTO `orders` VALUES ('16', '2018-05-17 16:05:24', null, null, '3300', null, null, null);
INSERT INTO `orders` VALUES ('17', '2018-05-17 16:05:40', null, null, '3300', null, null, null);

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'test666', 'test', '1000', '2018-05-17 10:38:47');
INSERT INTO `product` VALUES ('2', '方便面', '师牌方便面的描述', '200', '2018-05-17 10:46:39');
INSERT INTO `product` VALUES ('3', 'test1', 'test', '20', '2018-05-17 12:12:49');
INSERT INTO `product` VALUES ('9', 'test1', 'test', '20', '2018-05-17 14:59:52');
INSERT INTO `product` VALUES ('10', 'test1', 'test', '20', '2018-05-17 15:03:42');
INSERT INTO `product` VALUES ('11', 'test1', 'test', '20', '2018-05-17 15:04:25');
INSERT INTO `product` VALUES ('12', 'test1', 'test', '20', '2018-05-17 15:04:48');
INSERT INTO `product` VALUES ('13', 'test1', 'test', '20', '2018-05-17 15:06:21');
INSERT INTO `product` VALUES ('14', 'test1', 'test', '20', '2018-05-17 15:10:50');
INSERT INTO `product` VALUES ('15', 'test1', 'test', '20', '2018-05-17 16:05:20');
INSERT INTO `product` VALUES ('16', 'test1', 'test', '20', '2018-05-17 16:05:39');

-- ----------------------------
-- Records of purchase_item
-- ----------------------------
INSERT INTO `purchase_item` VALUES ('1', '1', '3000', '3', '5', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('2', '2', '200', '1', '5', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('3', '3', '100', '5', '5', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('4', '1', '3000', '3', '6', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('5', '2', '200', '1', '6', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('6', '3', '100', '5', '6', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('7', '1', '3000', '3', '7', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('8', '2', '200', '1', '7', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('9', '3', '100', '5', '7', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('10', '1', '3000', '3', '8', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('11', '2', '200', '1', '8', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('12', '3', '100', '5', '8', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('13', '1', '3000', '3', '9', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('14', '2', '200', '1', '9', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('15', '3', '100', '5', '9', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('16', '1', '3000', '3', '10', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('17', '2', '200', '1', '10', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('18', '3', '100', '5', '10', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('19', '1', '3000', '3', '11', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('20', '2', '200', '1', '11', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('21', '3', '100', '5', '11', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('22', '1', '3000', '3', '12', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('23', '2', '200', '1', '12', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('24', '3', '100', '5', '12', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('25', '1', '3000', '3', '13', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('26', '2', '200', '1', '13', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('27', '3', '100', '5', '13', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('28', '1', '3000', '3', '14', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('29', '2', '200', '1', '14', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('30', '3', '100', '5', '14', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('31', '1', '3000', '3', '15', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('32', '2', '200', '1', '15', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('33', '3', '100', '5', '15', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('34', '1', '3000', '3', '16', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('35', '2', '200', '1', '16', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('36', '3', '100', '5', '16', 'test1', 'test');
INSERT INTO `purchase_item` VALUES ('37', '1', '3000', '3', '17', 'test666', 'test');
INSERT INTO `purchase_item` VALUES ('38', '2', '200', '1', '17', '方便面', '师牌方便面的描述');
INSERT INTO `purchase_item` VALUES ('39', '3', '100', '5', '17', 'test1', 'test');
