/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : xiaobai

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-04-01 23:43:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `c_role`
-- ----------------------------
DROP TABLE IF EXISTS `c_role`;
CREATE TABLE `c_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `remark` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_role
-- ----------------------------
INSERT INTO c_role VALUES ('1', '超级蜜蜂', '超级');
INSERT INTO c_role VALUES ('2', '普通蜜蜂', '普通');
INSERT INTO c_role VALUES ('3', '食人蜜蜂', '食人');
INSERT INTO c_role VALUES ('4', '火腿蜜蜂', '火腿');

-- ----------------------------
-- Table structure for `c_emp`
-- ----------------------------
DROP TABLE IF EXISTS `c_emp`;
CREATE TABLE `c_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_emp
-- ----------------------------
INSERT INTO c_emp VALUES ('1', 'zh3');
INSERT INTO c_emp VALUES ('2', 'li4');
INSERT INTO c_emp VALUES ('3', 'wang5');
INSERT INTO c_emp VALUES ('4', 'zhao6');
INSERT INTO c_emp VALUES ('5', 'liu7');
