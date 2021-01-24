/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : week

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-04-01 23:30:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `c_user`
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO c_user VALUES ('1', '21', 'zh3');
INSERT INTO c_user VALUES ('2', '22', 'li4');
INSERT INTO c_user VALUES ('3', '23', 'wang5');
INSERT INTO c_user VALUES ('4', '24', 'zhao6');
