/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : newspace

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-02-15 22:16:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_street`
-- ----------------------------
DROP TABLE IF EXISTS `t_street`;
CREATE TABLE `t_street` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_abtbq7dp57vamniqvy6yggy1f` (`cid`),
  CONSTRAINT `FK_abtbq7dp57vamniqvy6yggy1f` FOREIGN KEY (`cid`) REFERENCES `t_city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_street
-- ----------------------------
INSERT INTO t_street VALUES ('1', '果戈里大街', '3');
INSERT INTO t_street VALUES ('2', '长江路', '3');
INSERT INTO t_street VALUES ('3', '下夹树街', '3');
INSERT INTO t_street VALUES ('4', '海淀区东北旺', '1');
INSERT INTO t_street VALUES ('5', '上地七街八维研修学院', '1');
INSERT INTO t_street VALUES ('6', '五道口购物中心', '1');
INSERT INTO t_street VALUES ('7', '天津火车站', '2');
INSERT INTO t_street VALUES ('8', '北安路', '2');
INSERT INTO t_street VALUES ('9', '果戈里二街', '3');

-- ----------------------------
-- Table structure for `t_kindofbee`
-- ----------------------------
DROP TABLE IF EXISTS `t_kindofbee`;
CREATE TABLE `t_kindofbee` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `kind` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kindofbee
-- ----------------------------
INSERT INTO t_kindofbee VALUES ('1', '普通蜜蜂');
INSERT INTO t_kindofbee VALUES ('2', '超级蜜蜂');
INSERT INTO t_kindofbee VALUES ('3', '食人蜜蜂');
INSERT INTO t_kindofbee VALUES ('4', '火腿蜜蜂');

-- ----------------------------
-- Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `price` double(8,0) NOT NULL,
  `datea` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `brand_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `t_goods_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `t_brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO t_goods VALUES ('1', '333', '111', '2015-11-12 00:00:00', '1');
INSERT INTO t_goods VALUES ('2', '222', '222', '2015-11-03 00:00:00', '3');
INSERT INTO t_goods VALUES ('3', '333', '333', '2015-11-17 00:00:00', '2');
INSERT INTO t_goods VALUES ('4', '444', '444', '2015-11-24 00:00:00', '1');
INSERT INTO t_goods VALUES ('5', '555', '555', '2015-11-25 00:00:00', '1');
INSERT INTO t_goods VALUES ('6', '3434', '34444', '2015-11-03 00:00:00', '3');
INSERT INTO t_goods VALUES ('7', '4545', '2222', '2015-11-16 19:41:24', '3');

-- ----------------------------
-- Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO t_city VALUES ('1', '北京');
INSERT INTO t_city VALUES ('2', '天津');
INSERT INTO t_city VALUES ('3', '哈尔滨');

-- ----------------------------
-- Table structure for `t_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `dname` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_brand
-- ----------------------------
INSERT INTO t_brand VALUES ('1', '伊利');
INSERT INTO t_brand VALUES ('2', '娃哈哈');
INSERT INTO t_brand VALUES ('3', '小白侠');

-- ----------------------------
-- Table structure for `t_bee`
-- ----------------------------
DROP TABLE IF EXISTS `t_bee`;
CREATE TABLE `t_bee` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `hobby` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `filepath` varchar(150) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK68F52379CACBAE5` (`did`),
  CONSTRAINT `FK68F52379CACBAE5` FOREIGN KEY (`did`) REFERENCES `t_kindofbee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bee
-- ----------------------------
INSERT INTO t_bee VALUES ('1', '123', '男', '吃饭', '2015-09-26', '0860c6b49a4f4feb929ece7c138fa503.tmp', '3');
INSERT INTO t_bee VALUES ('2', '4rf', '女', '睡觉, 打豆豆', '2015-09-11', 'b8dc9a80e07347afa09ff2786bd97072.tmp', '3');
INSERT INTO t_bee VALUES ('6', '234', '不祥', '睡觉, 打豆豆, 沐浴', '2015-09-17', '28924d33917640bfad818d810644aa94.tmp', '2');
INSERT INTO t_bee VALUES ('7', '3453', '不祥', '睡觉, 沐浴', '2015-09-10', '8a970ea956f54af7846724b2178f5f90.tmp', '3');
INSERT INTO t_bee VALUES ('8', 'e32', '女', '打豆豆', '2015-09-09', '576f27ddbfed4f43809d5be2d171bfdf.tmp', '4');
INSERT INTO t_bee VALUES ('12', '6t34', '女', '睡觉, 打豆豆', '1970-01-01', '465f09a765204faca6e8f7ddf4c1cdb3.tmp', '2');
INSERT INTO t_bee VALUES ('13', '345d', '女', '睡觉, 打豆豆', '2015-09-18', 'fa2575ca8e44447da31a5f4645e1d363.tmp', '2');

-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_555jq55vm2w95bf5gq67nmlqp` (`cid`),
  KEY `FK_qoi0dyyjbhrpr7ck35og9v41` (`sid`),
  CONSTRAINT `FK_555jq55vm2w95bf5gq67nmlqp` FOREIGN KEY (`cid`) REFERENCES `t_city` (`id`),
  CONSTRAINT `FK_qoi0dyyjbhrpr7ck35og9v41` FOREIGN KEY (`sid`) REFERENCES `t_street` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO t_address VALUES ('1', '天津北安路68号', '2', '8');
INSERT INTO t_address VALUES ('2', null, '3', '1');

-- ----------------------------
-- Table structure for `stauts`
-- ----------------------------
DROP TABLE IF EXISTS `stauts`;
CREATE TABLE `stauts` (
  `id` int(11) NOT NULL,
  `datea` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stauts
-- ----------------------------
INSERT INTO stauts VALUES ('1', '7:10');
INSERT INTO stauts VALUES ('2', '12:10');
INSERT INTO stauts VALUES ('3', '17.50');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(20) NOT NULL,
  `date_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `date_id` (`date_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`date_id`) REFERENCES `stauts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO order VALUES ('1', '111', '12233433', '3435dfddf', '2');
INSERT INTO order VALUES ('2', '111', '12233433', '3435dfddf', '2');
INSERT INTO order VALUES ('3', '3434', '3434', '343324', '1');
INSERT INTO order VALUES ('4', '4545', '45334', '45345345', '1');
INSERT INTO order VALUES ('5', '34345', '122345', '3245434', '3');

-- ----------------------------
-- Table structure for `kindofcat`
-- ----------------------------
DROP TABLE IF EXISTS `kindofcat`;
CREATE TABLE `kindofcat` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kindofcat
-- ----------------------------
INSERT INTO kindofcat VALUES ('4', '天蓝猫');
INSERT INTO kindofcat VALUES ('5', '波斯猫');
INSERT INTO kindofcat VALUES ('9', '蜜蜂猫');

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `fname` varchar(12) NOT NULL,
  `price` double(8,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO food VALUES ('1', '西红柿1', '6');
INSERT INTO food VALUES ('2', '西红柿1', '5');
INSERT INTO food VALUES ('3', '西红柿1', '23');
INSERT INTO food VALUES ('4', '西红柿1', '21');
INSERT INTO food VALUES ('5', '西红柿1', '34');
INSERT INTO food VALUES ('6', '西红柿1', '21');
INSERT INTO food VALUES ('7', '西红柿1', '21');
INSERT INTO food VALUES ('8', '西红柿1', '7');
INSERT INTO food VALUES ('9', '西红柿1', '65');
INSERT INTO food VALUES ('10', '西红柿1', '65');
INSERT INTO food VALUES ('11', '西红柿1', '65');
INSERT INTO food VALUES ('12', '西红柿1', '65');
INSERT INTO food VALUES ('13', '西红柿1', '65');
INSERT INTO food VALUES ('14', '西红柿1', '32');
INSERT INTO food VALUES ('15', '西红柿1', '21');
INSERT INTO food VALUES ('16', '西红柿1', '68');
INSERT INTO food VALUES ('17', '西红柿1', '9');
INSERT INTO food VALUES ('18', '西红柿1', '65');
INSERT INTO food VALUES ('19', '西红柿1', '32');
INSERT INTO food VALUES ('20', '西红柿1', '43');
INSERT INTO food VALUES ('21', '西红柿1', '79');

-- ----------------------------
-- Table structure for `erp_user`
-- ----------------------------
DROP TABLE IF EXISTS `erp_user`;
CREATE TABLE `erp_user` (
  `id` varchar(255) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of erp_user
-- ----------------------------
INSERT INTO erp_user VALUES ('1', '赵海龙', '2015-10-21 10:57:51', '我很二', '癫疯');

-- ----------------------------
-- Table structure for `erp_product`
-- ----------------------------
DROP TABLE IF EXISTS `erp_product`;
CREATE TABLE `erp_product` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `productor` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `typeid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8e6ve11iu0h8pxcbu9s9psut8` (`typeid`),
  CONSTRAINT `FK_8e6ve11iu0h8pxcbu9s9psut8` FOREIGN KEY (`typeid`) REFERENCES `erp_prodtype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of erp_product
-- ----------------------------
INSERT INTO erp_product VALUES ('2ca5a2dd50885f1f0150885f23770000', null, null, '赵海龙', null, '2', null, null, '2ca5a2dd50885f1f0150885f23870001');
INSERT INTO erp_product VALUES ('2ca5a2dd50885f1f0150885f23960002', null, null, '赵河龙', null, '1', null, null, '2ca5a2dd50885f1f0150885f23870001');

-- ----------------------------
-- Table structure for `erp_prodtype`
-- ----------------------------
DROP TABLE IF EXISTS `erp_prodtype`;
CREATE TABLE `erp_prodtype` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of erp_prodtype
-- ----------------------------
INSERT INTO erp_prodtype VALUES ('2ca5a2dd50885f1f0150885f23870001', '人偶系列', '报废');

-- ----------------------------
-- Table structure for `erp_customer`
-- ----------------------------
DROP TABLE IF EXISTS `erp_customer`;
CREATE TABLE `erp_customer` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of erp_customer
-- ----------------------------
INSERT INTO erp_customer VALUES ('2ca5a2dd50888c8a0150888c8bc60000', null, null, '海龙之家', '1', '1', null);

-- ----------------------------
-- Table structure for `erp_contact`
-- ----------------------------
DROP TABLE IF EXISTS `erp_contact`;
CREATE TABLE `erp_contact` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duties` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `telPhone` varchar(255) DEFAULT NULL,
  `customer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bik6mg1kpsojeto2gddletqpm` (`customer`),
  CONSTRAINT `FK_bik6mg1kpsojeto2gddletqpm` FOREIGN KEY (`customer`) REFERENCES `erp_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of erp_contact
-- ----------------------------
INSERT INTO erp_contact VALUES ('2ca5a2dd50888c8a0150888c8be50001', null, null, null, null, null, null, null, '赵子龙', null, null, null, '2ca5a2dd50888c8a0150888c8bc60000');
INSERT INTO erp_contact VALUES ('2ca5a2dd50888c8a0150888c8be50002', null, null, null, null, null, null, null, '赵海龙', null, null, null, '2ca5a2dd50888c8a0150888c8bc60000');

-- ----------------------------
-- Table structure for `c_study`
-- ----------------------------
DROP TABLE IF EXISTS `c_study`;
CREATE TABLE `c_study` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `sid` int(3) NOT NULL COMMENT '学生编号',
  `cid` int(3) NOT NULL COMMENT '课程编号',
  `scount` int(3) NOT NULL COMMENT '学习次数',
  `studying` int(1) NOT NULL DEFAULT '0' COMMENT '正在学习课程',
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`),
  KEY `cid` (`cid`),
  CONSTRAINT `c_study_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `c_student` (`id`),
  CONSTRAINT `c_study_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `c_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_study
-- ----------------------------
INSERT INTO c_study VALUES ('1', '1', '1', '2', '0');
INSERT INTO c_study VALUES ('2', '1', '2', '1', '0');
INSERT INTO c_study VALUES ('3', '1', '3', '2', '1');
INSERT INTO c_study VALUES ('4', '2', '1', '1', '0');
INSERT INTO c_study VALUES ('5', '2', '2', '1', '1');
INSERT INTO c_study VALUES ('6', '3', '1', '1', '0');
INSERT INTO c_study VALUES ('7', '3', '2', '2', '1');

-- ----------------------------
-- Table structure for `c_student`
-- ----------------------------
DROP TABLE IF EXISTS `c_student`;
CREATE TABLE `c_student` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL COMMENT '学生名',
  `cometime` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_student
-- ----------------------------
INSERT INTO c_student VALUES ('1', '张三', '2016-02-10');
INSERT INTO c_student VALUES ('2', '李四', '2016-02-01');
INSERT INTO c_student VALUES ('3', '王五', '2016-02-04');

-- ----------------------------
-- Table structure for `c_course`
-- ----------------------------
DROP TABLE IF EXISTS `c_course`;
CREATE TABLE `c_course` (
  `id` int(3) NOT NULL,
  `name` varchar(15) NOT NULL COMMENT '课程名',
  `prev_cid` int(3) DEFAULT NULL COMMENT '上门课程编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_course
-- ----------------------------
INSERT INTO c_course VALUES ('1', 'CoreJava', null);
INSERT INTO c_course VALUES ('2', 'JavaWeb', '1');
INSERT INTO c_course VALUES ('3', 'RIA', '2');
INSERT INTO c_course VALUES ('4', 'CMS', '3');
INSERT INTO c_course VALUES ('5', 'Struts', '4');

-- ----------------------------
-- Table structure for `cat`
-- ----------------------------
DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(18) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `hobby` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `kid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK107B640F4E8` (`kid`),
  CONSTRAINT `FK107B640F4E8` FOREIGN KEY (`kid`) REFERENCES `kindofcat` (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cat
-- ----------------------------
INSERT INTO cat VALUES ('2', '小白侠', '男', '睡觉,沐浴', '1990-08-25', '4');
INSERT INTO cat VALUES ('3', '556', '不祥', '打豆豆', '2015-09-00', '4');
INSERT INTO cat VALUES ('5', '4643', '男', '睡觉, 打豆豆', '2015-09-02', '4');
INSERT INTO cat VALUES ('6', '56555', '女', '打豆豆', '2015-09-16', '5');
INSERT INTO cat VALUES ('8', '蜜蜂侠1', '女', '睡觉,沐浴', '1990-08-25', '9');

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

-- ----------------------------
-- Table structure for `a_type`
-- ----------------------------
DROP TABLE IF EXISTS `a_type`;
CREATE TABLE `a_type` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `kind` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_type
-- ----------------------------
INSERT INTO a_type VALUES ('2', '蜜蜂类');
INSERT INTO a_type VALUES ('3', '猫猫类');
INSERT INTO a_type VALUES ('4', '蚂蚁类');

-- ----------------------------
-- Table structure for `a_dept`
-- ----------------------------
DROP TABLE IF EXISTS `a_dept`;
CREATE TABLE `a_dept` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `deptn` varchar(15) DEFAULT NULL,
  `kid` int(11) DEFAULT NULL,
  `kind` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_dept
-- ----------------------------

-- ----------------------------
-- Table structure for `a_book`
-- ----------------------------
DROP TABLE IF EXISTS `a_book`;
CREATE TABLE `a_book` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(20) NOT NULL,
  `price` double(12,0) NOT NULL,
  `datea` date NOT NULL,
  `kid` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `kid` (`kid`),
  CONSTRAINT `a_book_ibfk_1` FOREIGN KEY (`kid`) REFERENCES `a_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_book
-- ----------------------------

-- ----------------------------
-- Table structure for `aa_team`
-- ----------------------------
DROP TABLE IF EXISTS `aa_team`;
CREATE TABLE `aa_team` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  `address` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aa_team
-- ----------------------------
INSERT INTO aa_team VALUES ('1', '一队', '111111');
INSERT INTO aa_team VALUES ('2', '二队', '222222');
INSERT INTO aa_team VALUES ('3', '三队', '333333');

-- ----------------------------
-- Table structure for `aa_player`
-- ----------------------------
DROP TABLE IF EXISTS `aa_player`;
CREATE TABLE `aa_player` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  `age` int(3) NOT NULL,
  `datea` date NOT NULL,
  `sex` varchar(4) NOT NULL,
  `team_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `team_id` (`team_id`),
  CONSTRAINT `aa_player_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `aa_team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aa_player
-- ----------------------------
INSERT INTO aa_player VALUES ('5', '232', '334', '2015-10-13', '女', '1');
INSERT INTO aa_player VALUES ('10', '434', '32', '2015-10-06', '女', '3');
INSERT INTO aa_player VALUES ('11', '233', '33', '2015-09-29', '男', '3');
INSERT INTO aa_player VALUES ('12', '233', '33', '2015-09-29', '男', '3');
INSERT INTO aa_player VALUES ('13', '34', '33', '2015-10-13', '女', '1');
INSERT INTO aa_player VALUES ('14', '34', '33', '2015-10-13', '女', '1');
