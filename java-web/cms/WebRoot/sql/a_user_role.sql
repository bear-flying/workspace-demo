/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-08-28 20:55:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `a_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `a_user_role`;
CREATE TABLE `a_user_role` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `user_id` int(3) NOT NULL,
  `role_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `a_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `a_user` (`id`),
  CONSTRAINT `a_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `a_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_user_role
-- ----------------------------
INSERT INTO a_user_role VALUES ('4', '1', '3');
INSERT INTO a_user_role VALUES ('5', '1', '4');
INSERT INTO a_user_role VALUES ('7', '1', '4');
INSERT INTO a_user_role VALUES ('11', '3', '3');
INSERT INTO a_user_role VALUES ('12', '3', '5');
INSERT INTO a_user_role VALUES ('13', '6', '4');
INSERT INTO a_user_role VALUES ('29', '2', '2');
INSERT INTO a_user_role VALUES ('30', '2', '3');
INSERT INTO a_user_role VALUES ('31', '2', '5');
INSERT INTO a_user_role VALUES ('36', '10', '1');
INSERT INTO a_user_role VALUES ('37', '10', '2');
INSERT INTO a_user_role VALUES ('38', '7', '1');
INSERT INTO a_user_role VALUES ('39', '7', '4');
INSERT INTO a_user_role VALUES ('40', '11', '2');
INSERT INTO a_user_role VALUES ('41', '11', '4');
INSERT INTO a_user_role VALUES ('42', '12', '2');
INSERT INTO a_user_role VALUES ('43', '13', '4');
INSERT INTO a_user_role VALUES ('44', '14', '4');
INSERT INTO a_user_role VALUES ('45', '15', '1');
INSERT INTO a_user_role VALUES ('46', '16', '1');
