/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : newspace

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-11-25 13:53:17
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `b_year`
-- ----------------------------
DROP TABLE IF EXISTS `b_year`;
CREATE TABLE `b_year` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `years` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_year
-- ----------------------------
INSERT INTO b_year VALUES ('1', '2015');
INSERT INTO b_year VALUES ('2', '2014');
INSERT INTO b_year VALUES ('3', '2013');

-- ----------------------------
-- Table structure for `b_type`
-- ----------------------------
DROP TABLE IF EXISTS `b_type`;
CREATE TABLE `b_type` (
  `id` int(3) NOT NULL,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_type
-- ----------------------------
INSERT INTO b_type VALUES ('1', '爱情片');
INSERT INTO b_type VALUES ('2', '喜剧片');
INSERT INTO b_type VALUES ('3', '剧情片');

-- ----------------------------
-- Table structure for `b_movie`
-- ----------------------------
DROP TABLE IF EXISTS `b_movie`;
CREATE TABLE `b_movie` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `area_id` int(3) NOT NULL,
  `price` double(6,0) NOT NULL,
  `type_id` int(3) NOT NULL,
  `year_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `area_id` (`area_id`),
  KEY `type_id` (`type_id`),
  KEY `year_id` (`year_id`),
  CONSTRAINT `b_movie_ibfk_1` FOREIGN KEY (`area_id`) REFERENCES `b_area` (`id`),
  CONSTRAINT `b_movie_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `b_type` (`id`),
  CONSTRAINT `b_movie_ibfk_3` FOREIGN KEY (`year_id`) REFERENCES `b_year` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_movie
-- ----------------------------
INSERT INTO b_movie VALUES ('1', '夏洛特烦恼', '2', '23', '2', '1');
INSERT INTO b_movie VALUES ('2', '港囧', '2', '35', '3', '2');
INSERT INTO b_movie VALUES ('3', '我是路人甲', '3', '32', '1', '3');
INSERT INTO b_movie VALUES ('4', '2334', '1', '3423', '1', '1');
INSERT INTO b_movie VALUES ('5', '564', '1', '64545', '1', '1');
INSERT INTO b_movie VALUES ('6', '564', '1', '64545', '1', '1');
INSERT INTO b_movie VALUES ('7', '56565', '1', '45656', '1', '1');

-- ----------------------------
-- Table structure for `b_area`
-- ----------------------------
DROP TABLE IF EXISTS `b_area`;
CREATE TABLE `b_area` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_area
-- ----------------------------
INSERT INTO b_area VALUES ('1', '大陆');
INSERT INTO b_area VALUES ('2', '台湾');
INSERT INTO b_area VALUES ('3', '香港');
