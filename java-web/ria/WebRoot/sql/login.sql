/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : xiaobai

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-08-01 07:55:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(15) DEFAULT NULL,
  `pass` varchar(15) DEFAULT NULL,
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `rank` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO login VALUES ('zh3', '1234', '1', '1');
INSERT INTO login VALUES ('li4', '1234', '2', '0');
INSERT INTO login VALUES ('wang5', '1234', '3', '1');
INSERT INTO login VALUES ('12', '1', '6', '0');
