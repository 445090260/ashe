/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : vitality

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-12-15 18:52:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_base
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_base
-- ----------------------------

-- ----------------------------
-- Table structure for user_certificate
-- ----------------------------
DROP TABLE IF EXISTS `user_certificate`;
CREATE TABLE `user_certificate` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `cert_type` varchar(255) DEFAULT NULL,
  `cert_no` int(11) DEFAULT NULL,
  `cert_status` varchar(255) DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  `audit_time` datetime DEFAULT NULL,
  `submit_remark` varchar(255) DEFAULT NULL,
  `audit_remark` varchar(255) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_certificate
-- ----------------------------

-- ----------------------------
-- Table structure for user_certified
-- ----------------------------
DROP TABLE IF EXISTS `user_certified`;
CREATE TABLE `user_certified` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `cert_type` varchar(255) DEFAULT NULL,
  `cert_no` int(11) DEFAULT NULL,
  `cert_exp` varchar(255) DEFAULT NULL,
  `creat_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_certified
-- ----------------------------

-- ----------------------------
-- Table structure for user_login_log
-- ----------------------------
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE `user_login_log` (
  `id` int(11) NOT NULL,
  `login_id` int(11) DEFAULT NULL,
  `is_login` varchar(255) DEFAULT NULL,
  `result_status` varchar(255) DEFAULT NULL,
  `login_ip` varchar(255) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `login_params` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for user_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `user_operate_log`;
CREATE TABLE `user_operate_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `operate_desc` varchar(255) DEFAULT NULL,
  `operate_ip` varchar(255) DEFAULT NULL,
  `operate_time` datetime DEFAULT NULL,
  `result_status` varchar(255) DEFAULT NULL,
  `operate_params` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_operate_log
-- ----------------------------

-- ----------------------------
-- Table structure for user_profile
-- ----------------------------
DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE `user_profile` (
  `user_id` int(11) NOT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `personal_sign` varchar(255) DEFAULT NULL,
  `personal_title` varchar(255) DEFAULT NULL,
  `face_url` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `regist_ip` varchar(255) DEFAULT NULL,
  `regist_time` datetime DEFAULT NULL,
  `regist_count` varchar(255) DEFAULT NULL,
  `regist_status` varchar(255) DEFAULT NULL,
  `unreadmsg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_profile
-- ----------------------------

-- ----------------------------
-- Table structure for user_security_conf
-- ----------------------------
DROP TABLE IF EXISTS `user_security_conf`;
CREATE TABLE `user_security_conf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `question1` varchar(255) DEFAULT NULL,
  `answer1` varchar(255) DEFAULT NULL,
  `question2` varchar(255) DEFAULT NULL,
  `answer2` varchar(255) DEFAULT NULL,
  `question3` varchar(255) DEFAULT NULL,
  `answer3` varchar(255) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_security_conf
-- ----------------------------

-- ----------------------------
-- Table structure for user_system_conf
-- ----------------------------
DROP TABLE IF EXISTS `user_system_conf`;
CREATE TABLE `user_system_conf` (
  `user_id` int(11) NOT NULL,
  `payset` varchar(255) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `lang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_system_conf
-- ----------------------------

-- ----------------------------
-- Table structure for user_trade_conf
-- ----------------------------
DROP TABLE IF EXISTS `user_trade_conf`;
CREATE TABLE `user_trade_conf` (
  `user_id` int(11) DEFAULT NULL,
  `trade_password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_trade_conf
-- ----------------------------
