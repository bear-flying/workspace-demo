/*
Navicat MySQL Data Transfer

Source Server         : xiaobaixia
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : xiaobai

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-02-15 22:15:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `x_kindofbee`
-- ----------------------------
DROP TABLE IF EXISTS `x_kindofbee`;
CREATE TABLE `x_kindofbee` (
  `Kid` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Kid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of x_kindofbee
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(3) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(12) NOT NULL,
  `user_age` int(3) NOT NULL,
  `user_sex` varchar(4) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO user_info VALUES ('1', '11111', '12', '男');
INSERT INTO user_info VALUES ('2', '11111', '12', '男');

-- ----------------------------
-- Table structure for `t_shop`
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addresses` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_s1upmkxxbu4nj1y4pl3mf9o0l` (`aid`),
  CONSTRAINT `FK_s1upmkxxbu4nj1y4pl3mf9o0l` FOREIGN KEY (`aid`) REFERENCES `t_area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop
-- ----------------------------
INSERT INTO t_shop VALUES ('1', '240号', '小白侠快餐', '小白侠快餐', '13803642693', '2');
INSERT INTO t_shop VALUES ('2', '390号', '蟋蟀面点', '蟋蟀面点', '13453879078', '1');
INSERT INTO t_shop VALUES ('3', '21号', '蜜蜂便当', '蜜蜂便当', '190876390', '3');

-- ----------------------------
-- Table structure for `t_food`
-- ----------------------------
DROP TABLE IF EXISTS `t_food`;
CREATE TABLE `t_food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `cid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_82s1rcc9x7gpeyfjbyiyrcylt` (`cid`),
  KEY `FK_hy6dpvfppu6auct7bqe6rt5hd` (`sid`),
  CONSTRAINT `FK_82s1rcc9x7gpeyfjbyiyrcylt` FOREIGN KEY (`cid`) REFERENCES `t_category` (`id`),
  CONSTRAINT `FK_hy6dpvfppu6auct7bqe6rt5hd` FOREIGN KEY (`sid`) REFERENCES `t_shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_food
-- ----------------------------
INSERT INTO t_food VALUES ('4', '蟋蟀牛粪汤', '32', '3', '2');
INSERT INTO t_food VALUES ('5', '蜜蜂麻辣烫', '45', '4', '3');
INSERT INTO t_food VALUES ('6', '小白侠寿元果', '9000', '4', '1');
INSERT INTO t_food VALUES ('7', '蔬菜沙拉', '21', '2', '1');
INSERT INTO t_food VALUES ('8', null, '0', null, null);

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO t_category VALUES ('1', '肉类');
INSERT INTO t_category VALUES ('2', '凉菜');
INSERT INTO t_category VALUES ('3', '牛粪');
INSERT INTO t_category VALUES ('4', '蜜蜂');

-- ----------------------------
-- Table structure for `t_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_area
-- ----------------------------
INSERT INTO t_area VALUES ('1', '一区');
INSERT INTO t_area VALUES ('2', '二区');
INSERT INTO t_area VALUES ('3', '三区');

-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gc8cvyjj0ddtcee3x06uo557r` (`aid`),
  CONSTRAINT `FK_gc8cvyjj0ddtcee3x06uo557r` FOREIGN KEY (`aid`) REFERENCES `t_area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO t_address VALUES ('1', '小白圣地', '2');
INSERT INTO t_address VALUES ('2', '添香教总部', '3');
INSERT INTO t_address VALUES ('3', '帝国边境', '1');

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

-- ----------------------------
-- Table structure for `ssh_user`
-- ----------------------------
DROP TABLE IF EXISTS `ssh_user`;
CREATE TABLE `ssh_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(18) NOT NULL,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssh_user
-- ----------------------------
INSERT INTO ssh_user VALUES ('297e23ab50d26b6d0150d2731ba60004', 'xiaobai', '111', '234565@qq.com', '13056753467');
INSERT INTO ssh_user VALUES ('297e23ab50d284740150d28ac4050001', 'w8251tl', '111', '374829473@qq.con', '13956753467');
INSERT INTO ssh_user VALUES ('297e23ab50d284740150d28afe890003', '876yhh', '111', '374829473@qq.con', '13956753467');
INSERT INTO ssh_user VALUES ('fdrdsefd45fgvcgfrtyhjhgfertfgh5r', 'zh3', '123', '2880766@qq.com', '13012345454');

-- ----------------------------
-- Table structure for `shop_user`
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(18) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `datea` datetime NOT NULL,
  `sex` varchar(4) NOT NULL,
  `qq` varchar(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO shop_user VALUES ('234edvcdwe898tkfmghruko9876yhfed', 'zh3', '123', '23456@qq.com', '13908909090', '2015-11-03 16:42:50', '男', '345678', '1');
INSERT INTO shop_user VALUES ('8a81872150d732cf0150d73415dd0001', 'li4', '123', '290755380@qq.com', '13609790678', '2015-11-18 00:00:00', '保密', '454343111', '0');
INSERT INTO shop_user VALUES ('8a81872150d7560f0150d756a0430001', 'wang5', '123', '374829473@qq.con', '13909790678', '2015-11-25 00:00:00', '女', '23423435', '0');

-- ----------------------------
-- Table structure for `shop_product`
-- ----------------------------
DROP TABLE IF EXISTS `shop_product`;
CREATE TABLE `shop_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `pname` varchar(15) NOT NULL,
  `description` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `stock` int(11) NOT NULL,
  `childid` int(11) DEFAULT NULL,
  `filename` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `shop_product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `shop_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_product
-- ----------------------------
INSERT INTO shop_product VALUES ('1', '5', '三国', '三国演义', '100', '10', '1', 'ad14.jpg');
INSERT INTO shop_product VALUES ('2', '10', '小白侠', '之飞天猫熊', '7000', '21', '2', 'ad14.jpg');
INSERT INTO shop_product VALUES ('3', '21', '猫猫', '加菲猫', '3200', '32', '3', 'ad14.jpg');
INSERT INTO shop_product VALUES ('4', '49', '蜜蜂', '超级蜜蜂', '2900', '46', '4', 'ad14.jpg');
INSERT INTO shop_product VALUES ('5', '61', '火腿蜜蜂', '食人蜜蜂', '1290', '33', '5', 'ad14.jpg');
INSERT INTO shop_product VALUES ('6', '22', '牛粪', '你爱牛粪', '10', '1000', '6', 'ad14.jpg');

-- ----------------------------
-- Table structure for `shop_newstype`
-- ----------------------------
DROP TABLE IF EXISTS `shop_newstype`;
CREATE TABLE `shop_newstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_newstype
-- ----------------------------
INSERT INTO shop_newstype VALUES ('1', '娱乐');
INSERT INTO shop_newstype VALUES ('2', '军事');
INSERT INTO shop_newstype VALUES ('3', '其他');

-- ----------------------------
-- Table structure for `shop_news`
-- ----------------------------
DROP TABLE IF EXISTS `shop_news`;
CREATE TABLE `shop_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newstype_id` int(11) NOT NULL,
  `title` varchar(60) NOT NULL,
  `content` varchar(200) NOT NULL,
  `create_data` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8298D27C786B3840` (`newstype_id`),
  CONSTRAINT `FK8298D27C786B3840` FOREIGN KEY (`newstype_id`) REFERENCES `shop_newstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_news
-- ----------------------------
INSERT INTO shop_news VALUES ('1', '2', '夏日流行e站，让你抢购到手软', '夏日流行e站，让你抢购到手软', '2015-11-11 16:38:25');
INSERT INTO shop_news VALUES ('2', '3', '你们必须吃牛粪', '你们必须吃牛粪 否则扫厕所', '2015-11-11 16:39:01');
INSERT INTO shop_news VALUES ('3', '1', '花花世界', '花花世界 鸳鸯蝴蝶', '2015-11-11 16:39:33');
INSERT INTO shop_news VALUES ('4', '2', '爱本是泡沫', '如果能够看破 又何必难过', '2015-11-05 16:40:23');
INSERT INTO shop_news VALUES ('5', '2', '八维云计算', '云计算', '2015-11-11 16:40:51');
INSERT INTO shop_news VALUES ('6', '3', '飞天猫熊', '之小白侠光芒万丈', '2015-10-27 16:41:23');

-- ----------------------------
-- Table structure for `shop_category`
-- ----------------------------
DROP TABLE IF EXISTS `shop_category`;
CREATE TABLE `shop_category` (
  `id` int(5) NOT NULL,
  `cname` varchar(20) NOT NULL,
  `parentId` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_category
-- ----------------------------
INSERT INTO shop_category VALUES ('5', '冰箱', '0');
INSERT INTO shop_category VALUES ('10', '家用电器', '0');
INSERT INTO shop_category VALUES ('21', '运动鞋包', '0');
INSERT INTO shop_category VALUES ('22', '动漫周边', '0');
INSERT INTO shop_category VALUES ('23', '汽车用品', '0');
INSERT INTO shop_category VALUES ('24', '运动服饰', '0');
INSERT INTO shop_category VALUES ('43', '灯具', '22');
INSERT INTO shop_category VALUES ('44', '海尔', '5');
INSERT INTO shop_category VALUES ('46', '空调', '10');
INSERT INTO shop_category VALUES ('49', '背包', '21');
INSERT INTO shop_category VALUES ('50', '上衣', '24');
INSERT INTO shop_category VALUES ('51', '车载电器', '23');
INSERT INTO shop_category VALUES ('52', '五金家装', '10');
INSERT INTO shop_category VALUES ('53', '格力', '46');
INSERT INTO shop_category VALUES ('54', '台灯', '43');
INSERT INTO shop_category VALUES ('55', '沙发', '52');
INSERT INTO shop_category VALUES ('56', '连衣裙', '24');
INSERT INTO shop_category VALUES ('57', '锥子', '52');
INSERT INTO shop_category VALUES ('58', '导航', '51');
INSERT INTO shop_category VALUES ('59', '吸顶灯', '43');
INSERT INTO shop_category VALUES ('60', '单肩包', '49');
INSERT INTO shop_category VALUES ('61', 'nike', '49');
INSERT INTO shop_category VALUES ('62', '行车记录仪', '51');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `rname` varchar(12) NOT NULL,
  `description` varchar(25) NOT NULL,
  `state` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('2', 'li4', '1111', '正常');
INSERT INTO role VALUES ('3', '222', '222', '停用');

-- ----------------------------
-- Table structure for `priovince`
-- ----------------------------
DROP TABLE IF EXISTS `priovince`;
CREATE TABLE `priovince` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of priovince
-- ----------------------------
INSERT INTO priovince VALUES ('1', '江苏');
INSERT INTO priovince VALUES ('2', '北京');

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

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(15) DEFAULT NULL,
  `pass` varchar(15) DEFAULT NULL,
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `rank` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO login VALUES ('zh3', '1234', '1', '1');
INSERT INTO login VALUES ('li4', '1234', '2', '0');
INSERT INTO login VALUES ('wang5', '1234', '3', '1');
INSERT INTO login VALUES ('12', '1', '6', '0');

-- ----------------------------
-- Table structure for `d_newstype`
-- ----------------------------
DROP TABLE IF EXISTS `d_newstype`;
CREATE TABLE `d_newstype` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_newstype
-- ----------------------------
INSERT INTO d_newstype VALUES ('1', '政治');
INSERT INTO d_newstype VALUES ('2', '军事');
INSERT INTO d_newstype VALUES ('3', '文艺');
INSERT INTO d_newstype VALUES ('4', '校园');
INSERT INTO d_newstype VALUES ('5', '小白');

-- ----------------------------
-- Table structure for `d_news`
-- ----------------------------
DROP TABLE IF EXISTS `d_news`;
CREATE TABLE `d_news` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `content` varchar(80) NOT NULL,
  `author` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  `datea` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `d_news_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `d_newstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_news
-- ----------------------------
INSERT INTO d_news VALUES ('3', '蟋蟀9980', '斗蟋蟀', '飞天猫熊', '290755380@qq.com', '2015-11-18 00:00:00', '5');
INSERT INTO d_news VALUES ('13', '12223ee', '分隔符', '333898', '234565@qq.com', '2015-11-19 00:00:00', '2');
INSERT INTO d_news VALUES ('15', '344', '3433', '23343', '234565@qq.com', '2015-11-18 23:53:03', '4');
INSERT INTO d_news VALUES ('16', '5656', '4656', '4656', '234565@qq.com', '2015-11-19 00:00:00', '2');
INSERT INTO d_news VALUES ('19', '35656', 'e445', '454', '234565@qq.com', '2015-11-19 00:00:00', '1');

-- ----------------------------
-- Table structure for `d_beeofkind`
-- ----------------------------
DROP TABLE IF EXISTS `d_beeofkind`;
CREATE TABLE `d_beeofkind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bkind` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_beeofkind
-- ----------------------------
INSERT INTO d_beeofkind VALUES ('1', '普通蜜蜂');
INSERT INTO d_beeofkind VALUES ('2', '超级蜜蜂');
INSERT INTO d_beeofkind VALUES ('3', '食人蜜蜂');
INSERT INTO d_beeofkind VALUES ('4', '火腿蜜蜂');
INSERT INTO d_beeofkind VALUES ('5', '巨炮蜜蜂');

-- ----------------------------
-- Table structure for `d_bee`
-- ----------------------------
DROP TABLE IF EXISTS `d_bee`;
CREATE TABLE `d_bee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datea` timestamp NULL DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `kind_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q7cro5r2u6xkfx8xohp2sj5b7` (`kind_id`),
  CONSTRAINT `FK_q7cro5r2u6xkfx8xohp2sj5b7` FOREIGN KEY (`kind_id`) REFERENCES `d_beeofkind` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_bee
-- ----------------------------
INSERT INTO d_bee VALUES ('1', '2015-11-05 12:01:12', '男', '火腿', '猫猫', '3');
INSERT INTO d_bee VALUES ('4', '2015-11-20 15:16:20', '男', '食人,超级', '454', '5');
INSERT INTO d_bee VALUES ('5', '2015-11-20 19:18:18', '女', '火腿,超级', '454', '3');
INSERT INTO d_bee VALUES ('6', '2015-11-25 14:53:44', '女', '食人', '333333', '3');
INSERT INTO d_bee VALUES ('7', '2015-11-25 19:20:32', '男', '火腿,食人', '5555', '3');
INSERT INTO d_bee VALUES ('8', '2015-11-25 19:20:45', '男', '火腿,超级', '56655', '5');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `dname` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `empnum` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO department VALUES ('2', '天屎', '20');

-- ----------------------------
-- Table structure for `c_role`
-- ----------------------------
DROP TABLE IF EXISTS `c_role`;
CREATE TABLE `c_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `remark` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_role
-- ----------------------------
INSERT INTO c_role VALUES ('1', '超级蜜蜂', '超级');
INSERT INTO c_role VALUES ('2', '普通蜜蜂', '普通');
INSERT INTO c_role VALUES ('3', '食人蜜蜂', '食人');
INSERT INTO c_role VALUES ('4', '火腿蜜蜂', '火腿');

-- ----------------------------
-- Table structure for `c_kindofbee`
-- ----------------------------
DROP TABLE IF EXISTS `c_kindofbee`;
CREATE TABLE `c_kindofbee` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_kindofbee
-- ----------------------------

-- ----------------------------
-- Table structure for `c_emp_role`
-- ----------------------------
DROP TABLE IF EXISTS `c_emp_role`;
CREATE TABLE `c_emp_role` (
  `eid` int(11) NOT NULL,
  `rid` int(11) DEFAULT NULL,
  KEY `emp_fk` (`eid`),
  KEY `role_fk` (`rid`),
  CONSTRAINT `emp_fk` FOREIGN KEY (`eid`) REFERENCES `c_emp` (`id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`rid`) REFERENCES `c_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_emp_role
-- ----------------------------
INSERT INTO c_emp_role VALUES ('2', '1');
INSERT INTO c_emp_role VALUES ('3', '4');
INSERT INTO c_emp_role VALUES ('1', '2');
INSERT INTO c_emp_role VALUES ('1', '3');
INSERT INTO c_emp_role VALUES ('1', '1');

-- ----------------------------
-- Table structure for `c_emp`
-- ----------------------------
DROP TABLE IF EXISTS `c_emp`;
CREATE TABLE `c_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_emp
-- ----------------------------
INSERT INTO c_emp VALUES ('1', 'zh3');
INSERT INTO c_emp VALUES ('2', 'li4');
INSERT INTO c_emp VALUES ('3', 'wang5');
INSERT INTO c_emp VALUES ('4', 'zhao6');
INSERT INTO c_emp VALUES ('5', 'liu7');

-- ----------------------------
-- Table structure for `c_bee`
-- ----------------------------
DROP TABLE IF EXISTS `c_bee`;
CREATE TABLE `c_bee` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK3DC5666748DFFB0` (`did`),
  CONSTRAINT `FK3DC5666748DFFB0` FOREIGN KEY (`did`) REFERENCES `c_kindofbee` (`kid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_bee
-- ----------------------------

-- ----------------------------
-- Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `xid` int(11) NOT NULL AUTO_INCREMENT,
  `xname` varchar(30) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`xid`),
  KEY `cid` (`cid`),
  CONSTRAINT `country_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `city` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO country VALUES ('1', '下关', '1');
INSERT INTO country VALUES ('2', '中山', '1');
INSERT INTO country VALUES ('3', '太仓', '2');
INSERT INTO country VALUES ('4', '昆山', '2');
INSERT INTO country VALUES ('5', '上地', '3');
INSERT INTO country VALUES ('6', '中关村', '3');
INSERT INTO country VALUES ('7', '南口', '4');
INSERT INTO country VALUES ('8', '沙河', '4');

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `pid` (`pid`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `priovince` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO city VALUES ('1', '南京', '1');
INSERT INTO city VALUES ('2', '苏州', '1');
INSERT INTO city VALUES ('3', '海淀', '2');
INSERT INTO city VALUES ('4', '昌平', '2');

-- ----------------------------
-- Table structure for `b_kindofbee`
-- ----------------------------
DROP TABLE IF EXISTS `b_kindofbee`;
CREATE TABLE `b_kindofbee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_kindofbee
-- ----------------------------
INSERT INTO b_kindofbee VALUES ('1', '食人蜜蜂');
INSERT INTO b_kindofbee VALUES ('2', '超级蜜蜂');
INSERT INTO b_kindofbee VALUES ('3', '普通蜜蜂');
INSERT INTO b_kindofbee VALUES ('4', '火腿蜜蜂');

-- ----------------------------
-- Table structure for `b_bee`
-- ----------------------------
DROP TABLE IF EXISTS `b_bee`;
CREATE TABLE `b_bee` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `hobby` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK591AB25748DFFB0` (`did`),
  CONSTRAINT `FK591AB25748DFFB0` FOREIGN KEY (`did`) REFERENCES `b_kindofbee` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_bee
-- ----------------------------
INSERT INTO b_bee VALUES ('10', '4353', '女', '食人, 普通', '2015-10-07', '4');
INSERT INTO b_bee VALUES ('13', '6677', '不祥', '食人, 超级, 火腿', '2015-10-01', '2');

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
