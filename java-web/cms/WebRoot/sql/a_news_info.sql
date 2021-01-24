/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-08-28 20:56:18
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `a_news_info`
-- ----------------------------
DROP TABLE IF EXISTS `a_news_info`;
CREATE TABLE `a_news_info` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(15) NOT NULL,
  `news_author` varchar(15) NOT NULL,
  `type_id` int(3) NOT NULL,
  `news_content` varchar(255) NOT NULL,
  `create_datetime` date NOT NULL,
  `update_datetime` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `a_news_info_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `a_news_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_news_info
-- ----------------------------
INSERT INTO a_news_info VALUES ('1', '牛粪', '刘瑞', '2', '爱吃牛粪<img src=\"http://127.0.0.1:8080/cms/common/fckeditor//editor/images/smiley/taobao/76.gif\" alt=\"\" />', '2015-08-04', '2015-07-05');
INSERT INTO a_news_info VALUES ('2', '蜜蜂', '李园园', '3', '超级蜜蜂', '2015-08-03', '2015-08-28');
INSERT INTO a_news_info VALUES ('3', '八维', '付倩', '1', '牛粪姐', '2015-08-12', '2015-09-02');
INSERT INTO a_news_info VALUES ('4', '天女散花', '刘鹏', '12', '天女散花 -----那可真是天屎呀！~~', '1990-08-07', '2015-07-05');
INSERT INTO a_news_info VALUES ('11', '魂斗罗', '李运良', '5', '&nbsp;与刘瑞真人版魂斗罗！进行中', '2015-07-05', '2015-07-05');
INSERT INTO a_news_info VALUES ('12', '山西炮男', '刘瑞', '5', '&nbsp;诚信做事！', '2015-07-05', '2015-07-05');
INSERT INTO a_news_info VALUES ('13', '死人', '曹凤娇', '7', '&nbsp;你这个死人！', '2015-07-05', '2015-07-05');
INSERT INTO a_news_info VALUES ('14', '子撸', '蔡子鲁', '5', '&nbsp;大熊！！！', '2015-07-05', '2015-07-05');
INSERT INTO a_news_info VALUES ('15', '葫芦娃', '艾超', '1', '&nbsp;生生不轻舞&nbsp;', '2015-07-05', '2015-07-05');
INSERT INTO a_news_info VALUES ('16', '小吉吉', '孟祥吉', '10', '&nbsp;小吉吉下山去化债', '2015-07-05', '2015-07-05');
INSERT INTO a_news_info VALUES ('17', '天下苍生', '姜宇', '2', '为了天下苍生和大陆未来，所以才游戏人间的！', '2015-07-05', '2015-07-05');
INSERT INTO a_news_info VALUES ('18', '大陆未来', '姜宇', '2', '&nbsp; 为了天下苍生和大陆未来，所以才游戏人间的！', '2015-07-05', '2015-07-05');
