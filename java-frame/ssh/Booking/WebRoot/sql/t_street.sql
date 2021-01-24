/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : newspace

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-11-21 11:52:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_street`
-- ----------------------------
DROP TABLE IF EXISTS `t_street`;
CREATE TABLE `t_street` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_abtbq7dp57vamniqvy6yggy1f` (`cid`),
  CONSTRAINT `FK_abtbq7dp57vamniqvy6yggy1f` FOREIGN KEY (`cid`) REFERENCES `t_city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_street
-- ----------------------------
INSERT INTO t_street VALUES ('1', '果戈里大街', '3');
INSERT INTO t_street VALUES ('2', '长江路', '3');
INSERT INTO t_street VALUES ('3', '下夹树街', '3');
INSERT INTO t_street VALUES ('4', '海淀区东北旺', '1');
INSERT INTO t_street VALUES ('5', '上地七街八维研修学院', '1');
INSERT INTO t_street VALUES ('6', '五道口购物中心', '1');
INSERT INTO t_street VALUES ('7', '天津火车站', '2');
INSERT INTO t_street VALUES ('8', '北安路', '2');
INSERT INTO t_street VALUES ('9', '果戈里二街', '3');
