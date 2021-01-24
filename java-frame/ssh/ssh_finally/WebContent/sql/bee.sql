/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : xiaobai

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-03-27 23:10:57
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `d_beeofkind`
-- ----------------------------
DROP TABLE IF EXISTS `d_beeofkind`;
CREATE TABLE `d_beeofkind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bkind` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_beeofkind
-- ----------------------------
INSERT INTO d_beeofkind VALUES ('1', '普通蜜蜂');
INSERT INTO d_beeofkind VALUES ('2', '超级蜜蜂');
INSERT INTO d_beeofkind VALUES ('3', '食人蜜蜂');
INSERT INTO d_beeofkind VALUES ('4', '火腿蜜蜂');
INSERT INTO d_beeofkind VALUES ('5', '巨炮蜜蜂');

-- ----------------------------
-- Table structure for `d_bee`
-- ----------------------------
DROP TABLE IF EXISTS `d_bee`;
CREATE TABLE `d_bee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datea` timestamp NULL DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `kind_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q7cro5r2u6xkfx8xohp2sj5b7` (`kind_id`),
  CONSTRAINT `FK_q7cro5r2u6xkfx8xohp2sj5b7` FOREIGN KEY (`kind_id`) REFERENCES `d_beeofkind` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_bee
-- ----------------------------
INSERT INTO d_bee VALUES ('1', '2015-11-05 12:01:12', '男', '火腿', '猫猫', '3');
INSERT INTO d_bee VALUES ('4', '2015-11-20 15:16:20', '男', '食人,超级', '454', '5');
INSERT INTO d_bee VALUES ('5', '2015-11-20 19:18:18', '女', '火腿,超级', '454', '3');
INSERT INTO d_bee VALUES ('6', '2015-11-25 14:53:44', '女', '食人', '333333', '3');
INSERT INTO d_bee VALUES ('7', '2015-11-25 19:20:32', '男', '火腿,食人', '5555', '3');
INSERT INTO d_bee VALUES ('8', '2015-11-25 19:20:45', '男', '火腿,超级', '56655', '5');
