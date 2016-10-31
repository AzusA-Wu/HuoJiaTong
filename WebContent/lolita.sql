/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : lolita

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-10-31 15:19:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `brand_id` int(6) unsigned NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `brand_name` varchar(255) NOT NULL COMMENT '品牌名',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态：0有效；1无效',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------

-- ----------------------------
-- Table structure for `color`
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `color_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '颜色id',
  `color_name` varchar(64) NOT NULL COMMENT '颜色名',
  `status` int(1) NOT NULL COMMENT '状态：0有效；1无效',
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of color
-- ----------------------------

-- ----------------------------
-- Table structure for `export`
-- ----------------------------
DROP TABLE IF EXISTS `export`;
CREATE TABLE `export` (
  `export_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `amount` int(11) NOT NULL COMMENT '数量',
  `export_price` float NOT NULL COMMENT '售价',
  `user_id` int(11) NOT NULL COMMENT '经手人',
  `export_time` datetime NOT NULL COMMENT '出货时间',
  `vip_id` int(11) DEFAULT NULL COMMENT '会员卡自增id',
  `pay_id` int(2) NOT NULL COMMENT '支付方式',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`export_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of export
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_name` varchar(255) NOT NULL COMMENT '商品名',
  `brand_id` int(6) NOT NULL COMMENT '品牌id',
  `color_id` int(11) NOT NULL COMMENT '颜色id',
  `size_id` int(2) NOT NULL COMMENT '尺码id',
  `stock` int(6) NOT NULL COMMENT '库存',
  `type_id` int(6) NOT NULL COMMENT '种类',
  `import_price` float NOT NULL COMMENT '进货价',
  `standard_price` float NOT NULL COMMENT '普通售价',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `goods_source`
-- ----------------------------
DROP TABLE IF EXISTS `goods_source`;
CREATE TABLE `goods_source` (
  `source_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '货源id',
  `source_name` varchar(255) NOT NULL COMMENT '货源名',
  PRIMARY KEY (`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_source
-- ----------------------------

-- ----------------------------
-- Table structure for `goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `type_id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `type_name` varchar(64) NOT NULL COMMENT '类型名',
  `status` int(1) NOT NULL COMMENT '状态：0有效；1无效',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_type
-- ----------------------------

-- ----------------------------
-- Table structure for `import`
-- ----------------------------
DROP TABLE IF EXISTS `import`;
CREATE TABLE `import` (
  `import_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `import_price` float NOT NULL COMMENT '进货价',
  `amount` int(11) NOT NULL COMMENT '数量',
  `source_id` int(11) NOT NULL COMMENT '货源',
  `user_id` int(11) NOT NULL COMMENT '经手人',
  `import_time` datetime NOT NULL COMMENT '入货时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`import_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of import
-- ----------------------------

-- ----------------------------
-- Table structure for `other`
-- ----------------------------
DROP TABLE IF EXISTS `other`;
CREATE TABLE `other` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `content` varchar(255) NOT NULL COMMENT '支出内容',
  `money` float NOT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of other
-- ----------------------------

-- ----------------------------
-- Table structure for `pay`
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `pay_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `pay_name` varchar(255) NOT NULL COMMENT '支付方式',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay
-- ----------------------------

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) NOT NULL COMMENT '权限功能',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_group`
-- ----------------------------
DROP TABLE IF EXISTS `permission_group`;
CREATE TABLE `permission_group` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限组id',
  `group_name` varchar(32) NOT NULL COMMENT '权限组名',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_group
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_relation`
-- ----------------------------
DROP TABLE IF EXISTS `permission_relation`;
CREATE TABLE `permission_relation` (
  `relation_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL COMMENT '权限组id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_relation
-- ----------------------------

-- ----------------------------
-- Table structure for `shift`
-- ----------------------------
DROP TABLE IF EXISTS `shift`;
CREATE TABLE `shift` (
  `shift_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `staff_id` int(11) NOT NULL COMMENT '员工id',
  `starttime` datetime NOT NULL COMMENT '起始时间',
  `endtime` datetime NOT NULL COMMENT '结束时间',
  `user_id` int(11) NOT NULL COMMENT '经手人id',
  `time` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`shift_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shift
-- ----------------------------

-- ----------------------------
-- Table structure for `size`
-- ----------------------------
DROP TABLE IF EXISTS `size`;
CREATE TABLE `size` (
  `size_id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '尺码id',
  `size_name` varchar(16) NOT NULL COMMENT '尺码',
  PRIMARY KEY (`size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of size
-- ----------------------------
INSERT INTO `size` VALUES ('1', '均码');
INSERT INTO `size` VALUES ('2', 'XS');
INSERT INTO `size` VALUES ('3', 'S');
INSERT INTO `size` VALUES ('4', 'M');
INSERT INTO `size` VALUES ('5', 'L');
INSERT INTO `size` VALUES ('6', 'XL');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staff_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `staff_name` varchar(16) NOT NULL COMMENT '员工名',
  `staff_nickname` varchar(16) DEFAULT NULL COMMENT '员工昵称',
  `status` int(2) NOT NULL COMMENT '状态',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(4) NOT NULL COMMENT '用户id',
  `account` varchar(16) NOT NULL COMMENT '账号',
  `password` varchar(16) NOT NULL COMMENT '密码',
  `name` varchar(16) NOT NULL,
  `permission_group` int(4) NOT NULL COMMENT '权限组',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `vip`
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `id` int(11) NOT NULL COMMENT '自增id',
  `vip_id` varchar(255) NOT NULL COMMENT '会员卡编号',
  `vip_name` varchar(255) NOT NULL COMMENT '会员名',
  `birthday` date NOT NULL COMMENT '生日',
  `phone` varchar(20) NOT NULL COMMENT '手机号码',
  `other_contact` varchar(64) DEFAULT NULL COMMENT '其他联系方式',
  `location` int(11) DEFAULT NULL COMMENT '归属',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------

-- ----------------------------
-- Table structure for `vip_location`
-- ----------------------------
DROP TABLE IF EXISTS `vip_location`;
CREATE TABLE `vip_location` (
  `location_id` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `location_name` varchar(255) NOT NULL COMMENT '归属',
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip_location
-- ----------------------------
