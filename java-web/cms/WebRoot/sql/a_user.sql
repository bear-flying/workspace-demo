/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2015-08-28 20:55:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `a_user`
-- ----------------------------
DROP TABLE IF EXISTS `a_user`;
CREATE TABLE `a_user` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `real_name` varchar(15) NOT NULL,
  `sex` varchar(4) NOT NULL,
  `age` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_user
-- ----------------------------
INSERT INTO a_user VALUES ('1', 'liurui', '123', '刘瑞', '不详', '23');
INSERT INTO a_user VALUES ('2', 'jiangyu', '123', '姜宇', '男', '24');
INSERT INTO a_user VALUES ('3', 'liyuanyuan', '123', '李园园', '女', '22');
INSERT INTO a_user VALUES ('6', 'bee', '321', '蜜蜂', '男', '3');
INSERT INTO a_user VALUES ('7', 'liupeng', '123', '刘鹏', '男', '25');
INSERT INTO a_user VALUES ('10', 'fuqian', '123', '付倩', '女', '22');
INSERT INTO a_user VALUES ('11', 'caizilu', '123', '蔡子鲁', '男', '22');
INSERT INTO a_user VALUES ('12', 'zhangyufan', '123', '张宇帆', '男', '24');
INSERT INTO a_user VALUES ('13', 'niufenggui', '123', '牛逢贵', '不详', '21');
INSERT INTO a_user VALUES ('14', 'huluwa', '123', '葫芦娃', '不详', '11');
INSERT INTO a_user VALUES ('15', 'baimingxing', '123', '白明星', '女', '21');
INSERT INTO a_user VALUES ('16', 'caofengjiao', '123', '曹凤娇', '女', '22');
