/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : pro-health

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-07-07 15:01:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_setmeal
-- ----------------------------
DROP TABLE IF EXISTS `t_setmeal`;
CREATE TABLE `t_setmeal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `code` varchar(8) DEFAULT NULL,
  `helpCode` varchar(16) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `age` varchar(32) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `attention` varchar(128) DEFAULT NULL,
  `img` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_setmeal
-- ----------------------------
INSERT INTO `t_setmeal` VALUES ('5', '入职无忧体检套餐（男女通用）', '0001', 'RZTJ', '0', '18-60', '300', '入职体检套餐', null, '03a36073-a140-4942-9b9b-712cecb144901.jpg');
INSERT INTO `t_setmeal` VALUES ('6', '粉红珍爱(女)升级TM12项筛查体检套餐', '0002', 'FHZA', '2', '18-60', '1200', '本套餐针对宫颈(TCT检查、HPV乳头瘤病毒筛查）、乳腺（彩超，癌抗125），甲状腺（彩超，甲功验血）以及胸片，血常规肝功等有全面检查，非常适合女性全面疾病筛查使用。', null, '3bd90d2c-4e82-42a1-a401-882c88b06a1a2.jpg');
INSERT INTO `t_setmeal` VALUES ('7', '阳光爸妈升级肿瘤12项筛查（男女单人）体检套餐', '0003', 'YGBM', '0', '55-100', '1400', '本套餐主要针对常见肿瘤筛查，肝肾、颈动脉、脑血栓、颅内血流筛查，以及风湿、颈椎、骨密度检查。', null, 'ee7dcf84-8a3a-4ab9-b981-9c5d272fd58d3.jpg');
INSERT INTO `t_setmeal` VALUES ('9', '孕前检查套餐（女）-精英版', '0005', 'YQJCNV', '2', '18-50', '1500', '孕前检查套餐（女）-精英版', null, 'ac3b5a4d-33a5-4f37-bd49-99e06ce17d202.jpg');
INSERT INTO `t_setmeal` VALUES ('11', '珍爱高端升级肿瘤12项筛查（男女单人）', '0006', 'ZAGD', '0', '14-20', '2400', '本套餐是一款针对生化五项检查，心，肝，胆，胃，甲状腺，颈椎，肺功能，脑部检查（经颅多普勒）以及癌症筛查，适合大众人群体检的套餐。', null, 'e373b2eb-0e50-4e95-a09b-03f2c1ee1d351.jpg');
