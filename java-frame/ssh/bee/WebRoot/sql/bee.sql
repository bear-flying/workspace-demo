/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : newspace

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-04-01 23:33:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_kindofbee`
-- ----------------------------
DROP TABLE IF EXISTS `t_kindofbee`;
CREATE TABLE `t_kindofbee` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `kind` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kindofbee
-- ----------------------------
INSERT INTO t_kindofbee VALUES ('1', '普通蜜蜂');
INSERT INTO t_kindofbee VALUES ('2', '超级蜜蜂');
INSERT INTO t_kindofbee VALUES ('3', '食人蜜蜂');
INSERT INTO t_kindofbee VALUES ('4', '火腿蜜蜂');

-- ----------------------------
-- Table structure for `t_bee`
-- ----------------------------
DROP TABLE IF EXISTS `t_bee`;
CREATE TABLE `t_bee` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `hobby` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `filepath` varchar(150) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK68F52379CACBAE5` (`did`),
  CONSTRAINT `FK68F52379CACBAE5` FOREIGN KEY (`did`) REFERENCES `t_kindofbee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bee
-- ----------------------------
INSERT INTO t_bee VALUES ('1', '123', '男', '吃饭', '2015-09-26', '0860c6b49a4f4feb929ece7c138fa503.tmp', '3');
INSERT INTO t_bee VALUES ('2', '4rf', '女', '睡觉, 打豆豆', '2015-09-11', 'b8dc9a80e07347afa09ff2786bd97072.tmp', '3');
INSERT INTO t_bee VALUES ('6', '234', '不祥', '睡觉, 打豆豆, 沐浴', '2015-09-17', '28924d33917640bfad818d810644aa94.tmp', '2');
INSERT INTO t_bee VALUES ('7', '3453', '不祥', '睡觉, 沐浴', '2015-09-10', '8a970ea956f54af7846724b2178f5f90.tmp', '3');
INSERT INTO t_bee VALUES ('8', 'e32', '女', '打豆豆', '2015-09-09', '576f27ddbfed4f43809d5be2d171bfdf.tmp', '4');
INSERT INTO t_bee VALUES ('12', '6t34', '女', '睡觉, 打豆豆', '1970-01-01', '465f09a765204faca6e8f7ddf4c1cdb3.tmp', '2');
INSERT INTO t_bee VALUES ('13', '345d', '女', '睡觉, 打豆豆', '2015-09-18', 'fa2575ca8e44447da31a5f4645e1d363.tmp', '2');
