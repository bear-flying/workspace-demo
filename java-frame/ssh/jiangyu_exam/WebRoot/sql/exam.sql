/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-04-01 23:38:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_student_hobby`
-- ----------------------------
DROP TABLE IF EXISTS `t_student_hobby`;
CREATE TABLE `t_student_hobby` (
  `sid` int(11) NOT NULL,
  `hid` int(11) NOT NULL,
  PRIMARY KEY (`hid`,`sid`),
  KEY `FK_gcfncsb4m6xj5pfech4eq435v` (`hid`),
  KEY `FK_am598cjlxpxqlkrjiav9otxu9` (`sid`),
  CONSTRAINT `FK_am598cjlxpxqlkrjiav9otxu9` FOREIGN KEY (`sid`) REFERENCES `t_student` (`id`),
  CONSTRAINT `FK_gcfncsb4m6xj5pfech4eq435v` FOREIGN KEY (`hid`) REFERENCES `t_hobby` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_hobby
-- ----------------------------
INSERT INTO t_student_hobby VALUES ('1', '1');
INSERT INTO t_student_hobby VALUES ('3', '1');
INSERT INTO t_student_hobby VALUES ('4', '1');
INSERT INTO t_student_hobby VALUES ('5', '1');
INSERT INTO t_student_hobby VALUES ('7', '1');
INSERT INTO t_student_hobby VALUES ('8', '1');
INSERT INTO t_student_hobby VALUES ('1', '2');
INSERT INTO t_student_hobby VALUES ('2', '2');
INSERT INTO t_student_hobby VALUES ('3', '2');
INSERT INTO t_student_hobby VALUES ('5', '2');
INSERT INTO t_student_hobby VALUES ('6', '2');
INSERT INTO t_student_hobby VALUES ('7', '2');
INSERT INTO t_student_hobby VALUES ('2', '3');
INSERT INTO t_student_hobby VALUES ('4', '3');
INSERT INTO t_student_hobby VALUES ('6', '3');
INSERT INTO t_student_hobby VALUES ('7', '3');
INSERT INTO t_student_hobby VALUES ('9', '3');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adddate` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `academy_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_e06exmw5pg7i5vg7m05xrwkiy` (`academy_id`),
  KEY `FK_vo41o8vp5s7poxf47mfe8kf8` (`class_id`),
  CONSTRAINT `FK_e06exmw5pg7i5vg7m05xrwkiy` FOREIGN KEY (`academy_id`) REFERENCES `t_academy` (`id`),
  CONSTRAINT `FK_vo41o8vp5s7poxf47mfe8kf8` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO t_student VALUES ('1', null, '233,23,2015-11-27', '1', null, null);
INSERT INTO t_student VALUES ('2', '2015-11-05', '34343', '1', null, '34');
INSERT INTO t_student VALUES ('3', '2015-11-05', '4545', '1', null, '21');
INSERT INTO t_student VALUES ('4', '2015-11-05', '4445', '1', null, '34');
INSERT INTO t_student VALUES ('5', '2015-11-12', '3434', '1', null, '34');
INSERT INTO t_student VALUES ('6', '2015-11-27', 's', '2', '2', '12');
INSERT INTO t_student VALUES ('7', '2015-11-19', '545', '2', '2', '44');
INSERT INTO t_student VALUES ('8', '2015-11-19', '454', '1', '1', '44');
INSERT INTO t_student VALUES ('9', '2015-11-19', '454', '2', '2', '44');

-- ----------------------------
-- Table structure for `t_hobby`
-- ----------------------------
DROP TABLE IF EXISTS `t_hobby`;
CREATE TABLE `t_hobby` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hobby
-- ----------------------------
INSERT INTO t_hobby VALUES ('1', '爱好1');
INSERT INTO t_hobby VALUES ('2', '爱好2');
INSERT INTO t_hobby VALUES ('3', '爱好3');

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_okbujxrxogc2343ketc9dnxiy` (`aid`),
  CONSTRAINT `FK_okbujxrxogc2343ketc9dnxiy` FOREIGN KEY (`aid`) REFERENCES `t_academy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO t_class VALUES ('1', '1507javad', '1');
INSERT INTO t_class VALUES ('2', '1509phpD', '2');

-- ----------------------------
-- Table structure for `t_academy`
-- ----------------------------
DROP TABLE IF EXISTS `t_academy`;
CREATE TABLE `t_academy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_academy
-- ----------------------------
INSERT INTO t_academy VALUES ('1', '云计算学院');
INSERT INTO t_academy VALUES ('2', '软工学院');
INSERT INTO t_academy VALUES ('3', '传媒学院');
