/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : xiaobai

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-03-27 23:21:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `oa_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `oa_user_role`;
CREATE TABLE `oa_user_role` (
  `ROLE_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `FK913B5A3D203ABD23` (`ROLE_ID`),
  KEY `FK913B5A3DC5658103` (`USER_ID`),
  CONSTRAINT `FK913B5A3D203ABD23` FOREIGN KEY (`ROLE_ID`) REFERENCES `oa_role` (`ID`),
  CONSTRAINT `FK913B5A3DC5658103` FOREIGN KEY (`USER_ID`) REFERENCES `oa_user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `oa_user`
-- ----------------------------
DROP TABLE IF EXISTS `oa_user`;
CREATE TABLE `oa_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LOGINNAME` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKC759E6186115BCE3` (`department_id`),
  CONSTRAINT `FKC759E6186115BCE3` FOREIGN KEY (`department_id`) REFERENCES `oa_department` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_user
-- ----------------------------

-- ----------------------------
-- Table structure for `oa_role`
-- ----------------------------
DROP TABLE IF EXISTS `oa_role`;
CREATE TABLE `oa_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_role
-- ----------------------------
INSERT INTO oa_role VALUES ('1', '1岗位', '11111111111');
INSERT INTO oa_role VALUES ('2', '2岗位', '2222222222');

-- ----------------------------
-- Table structure for `oa_department`
-- ----------------------------
DROP TABLE IF EXISTS `oa_department`;
CREATE TABLE `oa_department` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK1EE083DFA32ED88B` (`parent_id`),
  CONSTRAINT `FK1EE083DFA32ED88B` FOREIGN KEY (`parent_id`) REFERENCES `oa_department` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_department
-- ----------------------------
INSERT INTO oa_department VALUES ('1', '生活部', '233', null);
INSERT INTO oa_department VALUES ('2', '宿管部', '35343432', '1');
INSERT INTO oa_department VALUES ('3', '卫生部', '3242324', '1');
INSERT INTO oa_department VALUES ('4', '学习部', '3453234', null);
INSERT INTO oa_department VALUES ('5', '222', '222', null);
