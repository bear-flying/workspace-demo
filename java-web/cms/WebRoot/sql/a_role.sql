/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-08-28 20:56:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `a_role`
-- ----------------------------
DROP TABLE IF EXISTS `a_role`;
CREATE TABLE `a_role` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(15) NOT NULL,
  `role_desc` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_role
-- ----------------------------
INSERT INTO a_role VALUES ('1', '学生', '读书的');
INSERT INTO a_role VALUES ('2', '图书管理员', '看屋的');
INSERT INTO a_role VALUES ('3', '蜜蜂', '采蜜的');
INSERT INTO a_role VALUES ('4', '清洁工', '打扫厕所的');
INSERT INTO a_role VALUES ('5', '高级讲师', '教书的');
