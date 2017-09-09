/*
Navicat MariaDB Data Transfer

Source Server         : MariaDB
Source Server Version : 100206
Source Host           : localhost:3306
Source Database       : sboot

Target Server Type    : MariaDB
Target Server Version : 100206
File Encoding         : 65001

Date: 2017-08-22 20:40:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL,
  `username` varchar(9) NOT NULL,
  `password` varchar(10) NOT NULL,
  `uri` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '冀永光', 'jyg0723', 'http://www.jiyongguang.xin/');
INSERT INTO `user` VALUES ('2', '李亚男', 'lyn0723', 'http://www.jiyongguang.xin/');
