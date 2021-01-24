/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : xiaobai

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-08-01 07:55:20
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO student VALUES ('1', '111', '12', '2015-07-14');
INSERT INTO student VALUES ('2', '222', '22', '2015-07-06');
INSERT INTO student VALUES ('3', '222', '2', '2015-07-06');
INSERT INTO student VALUES ('6', '蜜蜂112', '23', '2015-07-09');
INSERT INTO student VALUES ('7', '究级蜜蜂', '21', '2015-07-01');
INSERT INTO student VALUES ('8', '猫猫', '54', '2015-07-07');
INSERT INTO student VALUES ('10', '457', '34', '2015-07-09');
INSERT INTO student VALUES ('11', '457', '34', '2015-07-09');
INSERT INTO student VALUES ('12', '457', '34', '2015-07-09');
