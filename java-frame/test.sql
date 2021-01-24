/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-02-15 22:16:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(3) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `regtime` date NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES ('1', 'zhang3', '123', '2015-09-10');
INSERT INTO t_user VALUES ('3', '111', '111', '2015-08-03');
INSERT INTO t_user VALUES ('5', '333', '222', '2015-08-03');

-- ----------------------------
-- Table structure for `t_thing`
-- ----------------------------
DROP TABLE IF EXISTS `t_thing`;
CREATE TABLE `t_thing` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `hobby` varchar(30) NOT NULL,
  `sex` char(2) NOT NULL,
  `birthday` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_thing
-- ----------------------------
INSERT INTO t_thing VALUES ('2', 'li4', '扫地', '男', '2015-09-10');
INSERT INTO t_thing VALUES ('3', 'zhang3', '树胶', '女', '2015-08-05');
INSERT INTO t_thing VALUES ('4', 'wang5', '扫地', '男', '2015-08-05');

-- ----------------------------
-- Table structure for `t_kind`
-- ----------------------------
DROP TABLE IF EXISTS `t_kind`;
CREATE TABLE `t_kind` (
  `id` int(4) NOT NULL,
  `kname` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kind
-- ----------------------------
INSERT INTO t_kind VALUES ('1', '小学');
INSERT INTO t_kind VALUES ('2', '中学');
INSERT INTO t_kind VALUES ('3', '大学');

-- ----------------------------
-- Table structure for `t_emp`
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `rname` varchar(15) NOT NULL,
  `age` int(3) NOT NULL,
  `address` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO t_emp VALUES ('1', '1', '1', '1');
INSERT INTO t_emp VALUES ('2', '2', '44', '2');

-- ----------------------------
-- Table structure for `t_country`
-- ----------------------------
DROP TABLE IF EXISTS `t_country`;
CREATE TABLE `t_country` (
  `id` int(3) NOT NULL,
  `name` varchar(15) NOT NULL,
  `hiredate` date NOT NULL,
  `discription` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_country
-- ----------------------------
INSERT INTO t_country VALUES ('1', '肯尼亚', '2015-09-10', '这是一个优秀的国家！');
INSERT INTO t_country VALUES ('2', '比利时', '2015-09-01', '这是一个牛粪的国家！');
INSERT INTO t_country VALUES ('3', '菲律宾', '2015-09-09', '这是一个劣等的国家！');

-- ----------------------------
-- Table structure for `t_college`
-- ----------------------------
DROP TABLE IF EXISTS `t_college`;
CREATE TABLE `t_college` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `collegename` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `tel` varchar(11) NOT NULL,
  `email` varchar(20) NOT NULL,
  `content` varchar(200) NOT NULL,
  `cid` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `t_college_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `t_category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_college
-- ----------------------------
INSERT INTO t_college VALUES ('1', '111', '11', '13809780945', '234@qq.com', '11111', '1');
INSERT INTO t_college VALUES ('6', '345', '33445', '13456754321', '290755380@qq.com', '1124', '2');
INSERT INTO t_college VALUES ('7', '4567', '2334', '13456754321', '234565@qq.com', '34564dgf', '1');
INSERT INTO t_college VALUES ('8', '4576', '1234', '13456754321', '234565@qq.com', '456rgff', '3');

-- ----------------------------
-- Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `description` varchar(80) NOT NULL,
  `cid` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO t_city VALUES ('1', '土城', '111111111', '1');
INSERT INTO t_city VALUES ('3', '火城', '32222', '3');
INSERT INTO t_city VALUES ('6', 'fdgd', '4545', '1');
INSERT INTO t_city VALUES ('7', '3333', '44444', '1');
INSERT INTO t_city VALUES ('8', '55565', '34524346', '3');
INSERT INTO t_city VALUES ('9', '457463', '34235464', '2');
INSERT INTO t_city VALUES ('10', '5644635', '35364743', '1');
INSERT INTO t_city VALUES ('11', '97958', '6478574', '1');
INSERT INTO t_city VALUES ('12', '086757', '535466', '3');
INSERT INTO t_city VALUES ('13', '7846353', '8574646', '2');
INSERT INTO t_city VALUES ('14', '795746474', '35364745', '2');
INSERT INTO t_city VALUES ('15', '0877975', '4678343', '3');
INSERT INTO t_city VALUES ('16', '75746', '3583535', '1');
INSERT INTO t_city VALUES ('17', '85746', '242647', '2');
INSERT INTO t_city VALUES ('18', '9746484', '353745', '2');
INSERT INTO t_city VALUES ('19', '07857', '3522464', '1');
INSERT INTO t_city VALUES ('20', '68353', '583536', '2');
INSERT INTO t_city VALUES ('21', '0746', '141526', '1');

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `cid` int(4) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO t_category VALUES ('1', 'IT类');
INSERT INTO t_category VALUES ('2', '语言类');
INSERT INTO t_category VALUES ('3', '基础类');

-- ----------------------------
-- Table structure for `t_book`
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `content` varchar(40) NOT NULL,
  `author` varchar(15) NOT NULL,
  `datea` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO t_book VALUES ('1', 'xiaobai', 'xiaobaixia', 'jy', '2015-09-01');
INSERT INTO t_book VALUES ('2', '343', '3332', '4334', '2015-09-04');
INSERT INTO t_book VALUES ('3', '456', '3435', '234', '2015-09-21');
INSERT INTO t_book VALUES ('4', '454', '34224', '5464', '2015-09-11');
INSERT INTO t_book VALUES ('5', '33', '333', '333', '2015-09-17');
INSERT INTO t_book VALUES ('6', '7667', '565', '454', '2015-09-04');

-- ----------------------------
-- Table structure for `t_bee`
-- ----------------------------
DROP TABLE IF EXISTS `t_bee`;
CREATE TABLE `t_bee` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `content` varchar(16) NOT NULL,
  `cid` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `t_bee_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `t_kind` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bee
-- ----------------------------
INSERT INTO t_bee VALUES ('1', '111', '666', '2');
INSERT INTO t_bee VALUES ('4', '1111', '1111', '1');
INSERT INTO t_bee VALUES ('5', '1111', '2222', '1');
INSERT INTO t_bee VALUES ('6', '333', '333', '1');
INSERT INTO t_bee VALUES ('7', '555', '555', '3');
INSERT INTO t_bee VALUES ('8', '888', '888', '1');
INSERT INTO t_bee VALUES ('9', '44', '44', '1');
INSERT INTO t_bee VALUES ('10', '333', '333', '1');
INSERT INTO t_bee VALUES ('11', '444', '444', '2');

-- ----------------------------
-- Table structure for `q_time`
-- ----------------------------
DROP TABLE IF EXISTS `q_time`;
CREATE TABLE `q_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of q_time
-- ----------------------------
INSERT INTO q_time VALUES ('1', '5:30');
INSERT INTO q_time VALUES ('2', '10:30');
INSERT INTO q_time VALUES ('3', '12:10');

-- ----------------------------
-- Table structure for `q_order_food`
-- ----------------------------
DROP TABLE IF EXISTS `q_order_food`;
CREATE TABLE `q_order_food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `food_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `q_order_food_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `q_order` (`id`),
  CONSTRAINT `q_order_food_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `q_food` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of q_order_food
-- ----------------------------
INSERT INTO q_order_food VALUES ('1', '1', '2');
INSERT INTO q_order_food VALUES ('2', '1', '3');
INSERT INTO q_order_food VALUES ('7', '1', '1');
INSERT INTO q_order_food VALUES ('8', '2', '3');
INSERT INTO q_order_food VALUES ('9', '2', '2');
INSERT INTO q_order_food VALUES ('10', '3', '1');
INSERT INTO q_order_food VALUES ('13', '5', '1');
INSERT INTO q_order_food VALUES ('14', '5', '2');
INSERT INTO q_order_food VALUES ('15', '6', '1');
INSERT INTO q_order_food VALUES ('16', '6', '3');
INSERT INTO q_order_food VALUES ('17', '7', '1');
INSERT INTO q_order_food VALUES ('18', '7', '2');
INSERT INTO q_order_food VALUES ('19', '7', '3');
INSERT INTO q_order_food VALUES ('22', '4', '1');
INSERT INTO q_order_food VALUES ('23', '4', '3');

-- ----------------------------
-- Table structure for `q_order`
-- ----------------------------
DROP TABLE IF EXISTS `q_order`;
CREATE TABLE `q_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `datea` varchar(255) DEFAULT NULL,
  `time_id` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `time_id` (`time_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `q_order_ibfk_1` FOREIGN KEY (`time_id`) REFERENCES `q_time` (`id`),
  CONSTRAINT `q_order_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `q_address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of q_order
-- ----------------------------
INSERT INTO q_order VALUES ('1', '孤王', '12345678902', '2012-02-29', '2', '3');
INSERT INTO q_order VALUES ('2', '天眼', '12345678902', '2012-3-3', '2', '2');
INSERT INTO q_order VALUES ('3', '默默', '12345678902', '2012-3-3', '2', '1');
INSERT INTO q_order VALUES ('4', '莫邪', '233', '2015-11-04', '2', '3');
INSERT INTO q_order VALUES ('5', 'xx', '23', '2015-11-11', '2', '1');
INSERT INTO q_order VALUES ('6', 'qwe', '2', '2015-11-27', '3', '3');
INSERT INTO q_order VALUES ('7', '好彩妹', '22222', '2015-11-25', '3', '3');

-- ----------------------------
-- Table structure for `q_food`
-- ----------------------------
DROP TABLE IF EXISTS `q_food`;
CREATE TABLE `q_food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of q_food
-- ----------------------------
INSERT INTO q_food VALUES ('1', '月饼');
INSERT INTO q_food VALUES ('2', '冰山雪莲');
INSERT INTO q_food VALUES ('3', '灵芝');

-- ----------------------------
-- Table structure for `q_address`
-- ----------------------------
DROP TABLE IF EXISTS `q_address`;
CREATE TABLE `q_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of q_address
-- ----------------------------
INSERT INTO q_address VALUES ('1', '中国');
INSERT INTO q_address VALUES ('2', '美国');
INSERT INTO q_address VALUES ('3', '日本');

-- ----------------------------
-- Table structure for `d_time`
-- ----------------------------
DROP TABLE IF EXISTS `d_time`;
CREATE TABLE `d_time` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_time
-- ----------------------------
INSERT INTO d_time VALUES ('1', '7:10');
INSERT INTO d_time VALUES ('2', '10:40');
INSERT INTO d_time VALUES ('3', '16:00');

-- ----------------------------
-- Table structure for `d_order_food`
-- ----------------------------
DROP TABLE IF EXISTS `d_order_food`;
CREATE TABLE `d_order_food` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `oid` int(3) DEFAULT NULL,
  `fid` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oid` (`oid`),
  KEY `fid` (`fid`),
  CONSTRAINT `d_order_food_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `d_order` (`id`),
  CONSTRAINT `d_order_food_ibfk_2` FOREIGN KEY (`fid`) REFERENCES `d_food` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_order_food
-- ----------------------------
INSERT INTO d_order_food VALUES ('1', '1', '2');
INSERT INTO d_order_food VALUES ('2', '1', '3');

-- ----------------------------
-- Table structure for `d_order`
-- ----------------------------
DROP TABLE IF EXISTS `d_order`;
CREATE TABLE `d_order` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `datea` varchar(15) DEFAULT NULL,
  `time_id` int(3) NOT NULL,
  `address_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `time_id` (`time_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `d_order_ibfk_1` FOREIGN KEY (`time_id`) REFERENCES `d_time` (`id`),
  CONSTRAINT `d_order_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `d_address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_order
-- ----------------------------
INSERT INTO d_order VALUES ('1', 'zh3', '123456', '112233', '2', '2');

-- ----------------------------
-- Table structure for `d_food`
-- ----------------------------
DROP TABLE IF EXISTS `d_food`;
CREATE TABLE `d_food` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_food
-- ----------------------------
INSERT INTO d_food VALUES ('1', '清蒸鱼');
INSERT INTO d_food VALUES ('2', '玉子汤');
INSERT INTO d_food VALUES ('3', '西红柿');

-- ----------------------------
-- Table structure for `d_address`
-- ----------------------------
DROP TABLE IF EXISTS `d_address`;
CREATE TABLE `d_address` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_address
-- ----------------------------
INSERT INTO d_address VALUES ('1', '八维1');
INSERT INTO d_address VALUES ('2', '八维2');
INSERT INTO d_address VALUES ('3', '八维3');

-- ----------------------------
-- Table structure for `c_time`
-- ----------------------------
DROP TABLE IF EXISTS `c_time`;
CREATE TABLE `c_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_time
-- ----------------------------
INSERT INTO c_time VALUES ('1', '7:30');
INSERT INTO c_time VALUES ('2', '10:00');
INSERT INTO c_time VALUES ('3', '16:40');

-- ----------------------------
-- Table structure for `c_order_food`
-- ----------------------------
DROP TABLE IF EXISTS `c_order_food`;
CREATE TABLE `c_order_food` (
  `order_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`food_id`),
  KEY `FK_h4ujr1sxg5sendqga9h53t1r5` (`food_id`),
  KEY `FK_qhfnob3ahuh2xirpfegmrb5a2` (`order_id`),
  CONSTRAINT `FK_h4ujr1sxg5sendqga9h53t1r5` FOREIGN KEY (`food_id`) REFERENCES `c_food` (`id`),
  CONSTRAINT `FK_qhfnob3ahuh2xirpfegmrb5a2` FOREIGN KEY (`order_id`) REFERENCES `c_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_order_food
-- ----------------------------
INSERT INTO c_order_food VALUES ('2', '1');
INSERT INTO c_order_food VALUES ('2', '2');
INSERT INTO c_order_food VALUES ('2', '3');
INSERT INTO c_order_food VALUES ('3', '3');
INSERT INTO c_order_food VALUES ('3', '4');

-- ----------------------------
-- Table structure for `c_order`
-- ----------------------------
DROP TABLE IF EXISTS `c_order`;
CREATE TABLE `c_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datea` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `time_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kr7m3su6104sm1v6l5a65ymb6` (`address_id`),
  KEY `FK_nt3r9l7ekq6mpgqlrnt1066q9` (`time_id`),
  CONSTRAINT `FK_kr7m3su6104sm1v6l5a65ymb6` FOREIGN KEY (`address_id`) REFERENCES `c_address` (`id`),
  CONSTRAINT `FK_nt3r9l7ekq6mpgqlrnt1066q9` FOREIGN KEY (`time_id`) REFERENCES `c_time` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_order
-- ----------------------------
INSERT INTO c_order VALUES ('2', null, 'zh3', '13456754321', '3', '2');
INSERT INTO c_order VALUES ('3', null, 'li4', '12478906537', '1', '1');

-- ----------------------------
-- Table structure for `c_food`
-- ----------------------------
DROP TABLE IF EXISTS `c_food`;
CREATE TABLE `c_food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_food
-- ----------------------------
INSERT INTO c_food VALUES ('1', '五香驴肉');
INSERT INTO c_food VALUES ('2', '麻花鸡胗');
INSERT INTO c_food VALUES ('3', '酸菜鱼');
INSERT INTO c_food VALUES ('4', '兰花炖');

-- ----------------------------
-- Table structure for `c_address`
-- ----------------------------
DROP TABLE IF EXISTS `c_address`;
CREATE TABLE `c_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_address
-- ----------------------------
INSERT INTO c_address VALUES ('1', '海淀区八维');
INSERT INTO c_address VALUES ('2', '小白区猫猫');
INSERT INTO c_address VALUES ('3', '南岗区人和');

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
INSERT INTO b_type VALUES ('1', '娱乐');
INSERT INTO b_type VALUES ('2', '财经');
INSERT INTO b_type VALUES ('3', '其他');
INSERT INTO b_type VALUES ('4', '教育');

-- ----------------------------
-- Table structure for `b_role`
-- ----------------------------
DROP TABLE IF EXISTS `b_role`;
CREATE TABLE `b_role` (
  `id` int(3) NOT NULL,
  `rname` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_role
-- ----------------------------
INSERT INTO b_role VALUES ('1', '火腿蜜蜂');
INSERT INTO b_role VALUES ('2', '食人蜜蜂');
INSERT INTO b_role VALUES ('3', '普通蜜蜂');
INSERT INTO b_role VALUES ('4', '超级蜜蜂');

-- ----------------------------
-- Table structure for `b_news`
-- ----------------------------
DROP TABLE IF EXISTS `b_news`;
CREATE TABLE `b_news` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `content` varchar(200) DEFAULT NULL,
  `datea` date NOT NULL,
  `author_id` int(3) NOT NULL,
  `company_id` int(3) NOT NULL,
  `type_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  KEY `company_id` (`company_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `b_news_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `b_type` (`id`),
  CONSTRAINT `b_news_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `b_company` (`id`),
  CONSTRAINT `b_news_ibfk_3` FOREIGN KEY (`author_id`) REFERENCES `b_author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_news
-- ----------------------------
INSERT INTO b_news VALUES ('1', '111', '111', '2015-11-02', '2', '2', '1');
INSERT INTO b_news VALUES ('2', '222', '222', '2015-11-11', '3', '2', '3');
INSERT INTO b_news VALUES ('3', '333', '333', '2015-11-11', '1', '3', '2');
INSERT INTO b_news VALUES ('4', '444', '444', '2015-11-18', '4', '2', '1');

-- ----------------------------
-- Table structure for `b_emp`
-- ----------------------------
DROP TABLE IF EXISTS `b_emp`;
CREATE TABLE `b_emp` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  `sex` char(2) NOT NULL,
  `hobby` varchar(20) NOT NULL,
  `rid` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of b_emp
-- ----------------------------
INSERT INTO b_emp VALUES ('1', 'zh3', '男', '火腿', '1');
INSERT INTO b_emp VALUES ('2', '1111', '女', '食人, 普通', '2');
INSERT INTO b_emp VALUES ('3', '333', '女', '火腿, 食人', '3');
INSERT INTO b_emp VALUES ('4', '444', '女', '食人', '1');
INSERT INTO b_emp VALUES ('5', '555', '男', '食人', '2');
INSERT INTO b_emp VALUES ('6', '777', '男', '高级', '2');
INSERT INTO b_emp VALUES ('9', '12345', '男', '火腿, 食人, 普通, 高级', '2');
INSERT INTO b_emp VALUES ('10', '7665', '女', '普通', '3');
INSERT INTO b_emp VALUES ('11', '65丰田好烦', '女', '火腿, 普通', '2');
INSERT INTO b_emp VALUES ('12', '就可以', '女', '食人', '4');
INSERT INTO b_emp VALUES ('13', '999', '女', '火腿, 普通', '4');
INSERT INTO b_emp VALUES ('14', '5665', '女', '食人', '3');
INSERT INTO b_emp VALUES ('15', '9999', '女', '食人', '2');
INSERT INTO b_emp VALUES ('16', '8888', '女', '火腿', '4');
INSERT INTO b_emp VALUES ('17', '544455', '男', '火腿, 食人', '1');
INSERT INTO b_emp VALUES ('18', '67766', '女', '普通, 高级', '1');
INSERT INTO b_emp VALUES ('19', '44444', '男', '火腿', '1');

-- ----------------------------
-- Table structure for `b_company`
-- ----------------------------
DROP TABLE IF EXISTS `b_company`;
CREATE TABLE `b_company` (
  `id` int(3) NOT NULL,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of b_company
-- ----------------------------
INSERT INTO b_company VALUES ('1', '新浪');
INSERT INTO b_company VALUES ('2', '搜狐');
INSERT INTO b_company VALUES ('3', '腾讯');

-- ----------------------------
-- Table structure for `b_author`
-- ----------------------------
DROP TABLE IF EXISTS `b_author`;
CREATE TABLE `b_author` (
  `id` int(3) NOT NULL,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of b_author
-- ----------------------------
INSERT INTO b_author VALUES ('1', '小白侠');
INSERT INTO b_author VALUES ('2', '飞天猫熊');
INSERT INTO b_author VALUES ('3', '考拉');
INSERT INTO b_author VALUES ('4', '山寨');
INSERT INTO b_author VALUES ('5', '超级蜜蜂');
INSERT INTO b_author VALUES ('6', '火腿蜜蜂');

-- ----------------------------
-- Table structure for `a_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `a_user_role`;
CREATE TABLE `a_user_role` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `user_id` int(3) NOT NULL,
  `role_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `a_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `a_user` (`id`),
  CONSTRAINT `a_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `a_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_user_role
-- ----------------------------
INSERT INTO a_user_role VALUES ('4', '1', '3');
INSERT INTO a_user_role VALUES ('5', '1', '4');
INSERT INTO a_user_role VALUES ('7', '1', '4');
INSERT INTO a_user_role VALUES ('29', '2', '2');
INSERT INTO a_user_role VALUES ('30', '2', '3');
INSERT INTO a_user_role VALUES ('31', '2', '5');
INSERT INTO a_user_role VALUES ('36', '10', '1');
INSERT INTO a_user_role VALUES ('37', '10', '2');
INSERT INTO a_user_role VALUES ('40', '11', '2');
INSERT INTO a_user_role VALUES ('41', '11', '4');
INSERT INTO a_user_role VALUES ('42', '12', '2');
INSERT INTO a_user_role VALUES ('43', '13', '4');
INSERT INTO a_user_role VALUES ('45', '15', '1');
INSERT INTO a_user_role VALUES ('46', '16', '1');
INSERT INTO a_user_role VALUES ('47', '6', '4');
INSERT INTO a_user_role VALUES ('48', '6', '5');
INSERT INTO a_user_role VALUES ('49', '7', '1');
INSERT INTO a_user_role VALUES ('50', '7', '5');
INSERT INTO a_user_role VALUES ('51', '3', '3');
INSERT INTO a_user_role VALUES ('52', '3', '4');
INSERT INTO a_user_role VALUES ('53', '3', '5');

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

-- ----------------------------
-- Table structure for `a_role`
-- ----------------------------
DROP TABLE IF EXISTS `a_role`;
CREATE TABLE `a_role` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(15) NOT NULL,
  `role_desc` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_role
-- ----------------------------
INSERT INTO a_role VALUES ('1', '学生', '读书的');
INSERT INTO a_role VALUES ('2', '图书管理员', '看屋的');
INSERT INTO a_role VALUES ('3', '蜜蜂', '采蜜的');
INSERT INTO a_role VALUES ('4', '清洁工', '打扫厕所的');
INSERT INTO a_role VALUES ('5', '高级讲师', '教书的');

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

-- ----------------------------
-- Table structure for `auto_user`
-- ----------------------------
DROP TABLE IF EXISTS `auto_user`;
CREATE TABLE `auto_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auto_user
-- ----------------------------
INSERT INTO auto_user VALUES ('1', 'zh3', '1234');
