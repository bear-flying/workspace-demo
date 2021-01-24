/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : newspace

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-11-21 11:53:06
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_555jq55vm2w95bf5gq67nmlqp` (`cid`),
  KEY `FK_qoi0dyyjbhrpr7ck35og9v41` (`sid`),
  CONSTRAINT `FK_qoi0dyyjbhrpr7ck35og9v41` FOREIGN KEY (`sid`) REFERENCES `t_street` (`id`),
  CONSTRAINT `FK_555jq55vm2w95bf5gq67nmlqp` FOREIGN KEY (`cid`) REFERENCES `t_city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO t_address VALUES ('1', '天津北安路68号', '2', '8');
INSERT INTO t_address VALUES ('2', null, '3', '1');
