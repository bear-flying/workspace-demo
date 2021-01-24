/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-08-28 20:56:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `a_news_type`
-- ----------------------------
DROP TABLE IF EXISTS `a_news_type`;
CREATE TABLE `a_news_type` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_news_type
-- ----------------------------
INSERT INTO a_news_type VALUES ('1', '娱乐新闻');
INSERT INTO a_news_type VALUES ('2', '军事新闻');
INSERT INTO a_news_type VALUES ('3', '蜜蜂新闻');
INSERT INTO a_news_type VALUES ('4', '八卦新闻');
INSERT INTO a_news_type VALUES ('5', '另类新闻');
INSERT INTO a_news_type VALUES ('7', '内地新闻');
INSERT INTO a_news_type VALUES ('10', '外地新闻');
INSERT INTO a_news_type VALUES ('11', '校园新闻');
INSERT INTO a_news_type VALUES ('12', '牛粪新闻');
INSERT INTO a_news_type VALUES ('13', '科技新闻');
INSERT INTO a_news_type VALUES ('14', '竞技新闻');
INSERT INTO a_news_type VALUES ('15', '游戏新闻');
