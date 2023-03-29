/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MariaDB
 Source Server Version : 100703
 Source Host           : localhost:3306
 Source Schema         : java

 Target Server Type    : MariaDB
 Target Server Version : 100703
 File Encoding         : 65001

 Date: 08/06/2022 13:00:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for historia
-- ----------------------------
DROP TABLE IF EXISTS `historia`;
CREATE TABLE `historia`  (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `h_rozmiar` double NOT NULL,
  `h_rozmiar_jednostka` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `h_predkosc` double NOT NULL,
  `h_predkosc_jednostka` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `h_czas` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `h_data` datetime NOT NULL,
  PRIMARY KEY (`h_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of historia
-- ----------------------------
INSERT INTO `historia` VALUES (4, 720, 'MB', 360, 'MB/s', '2.0', '2022-06-04 23:57:12');
INSERT INTO `historia` VALUES (18, 1, 'B', 1, 'b/s', '8.0', '2022-06-08 00:30:14');
INSERT INTO `historia` VALUES (19, 1, 'B', 0.1, 'b/s', '80.0', '2022-06-08 01:43:52');
INSERT INTO `historia` VALUES (20, 12, 'B', 1, 'b/s', '96.0', '2022-06-08 01:45:13');
INSERT INTO `historia` VALUES (21, 1, 'B', 1, 'b/s', '8.0', '2022-06-08 01:45:55');
INSERT INTO `historia` VALUES (26, 123232, 'B', 1, 'b/s', '273.8488888888889', '2022-06-08 01:47:02');
INSERT INTO `historia` VALUES (31, 60, 'B', 1, 'B/s', '59.99999999999999s', '2022-06-08 02:14:34');
INSERT INTO `historia` VALUES (32, 61, 'B', 1, 'B/s', '1.0166666666666666min', '2022-06-08 02:14:45');
INSERT INTO `historia` VALUES (33, 720, 'GB', 13, 'Gb/s', '7.384666666666666min', '2022-06-08 02:27:40');
INSERT INTO `historia` VALUES (34, 720, 'B', 13, 'Gb/s', '0.0s', '2022-06-08 02:27:50');
INSERT INTO `historia` VALUES (35, 720, 'B', 13, 'GB/s', '0.0s', '2022-06-08 02:27:55');
INSERT INTO `historia` VALUES (36, 720, 'KB', 13, 'GB/s', '0.0s', '2022-06-08 02:27:59');
INSERT INTO `historia` VALUES (37, 720, 'MB', 13, 'GB/s', '0.06s', '2022-06-08 02:28:02');
INSERT INTO `historia` VALUES (38, 1, 'B', 1, 'b/s', '8.0s', '2022-06-08 10:50:35');
INSERT INTO `historia` VALUES (40, 12, 'B', 2, 'MB/s', '0.0s', '2022-06-08 12:18:46');
INSERT INTO `historia` VALUES (41, 12, 'KB', 2, 'MB/s', '0.01s', '2022-06-08 12:18:54');
INSERT INTO `historia` VALUES (42, 12, 'GB', 2, 'MB/s', '1.67h', '2022-06-08 12:19:02');
INSERT INTO `historia` VALUES (43, 12, 'GB', 2, 'MB/s', '1.67h', '2022-06-08 12:51:44');
INSERT INTO `historia` VALUES (44, 12, 'GB', 2, 'MB/s', '1.67h', '2022-06-08 12:57:04');

-- ----------------------------
-- Table structure for predkosci
-- ----------------------------
DROP TABLE IF EXISTS `predkosci`;
CREATE TABLE `predkosci`  (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_nazwa` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of predkosci
-- ----------------------------
INSERT INTO `predkosci` VALUES (1, 'b/s');
INSERT INTO `predkosci` VALUES (2, 'B/s');
INSERT INTO `predkosci` VALUES (3, 'Kb/s');
INSERT INTO `predkosci` VALUES (4, 'KB/s');
INSERT INTO `predkosci` VALUES (5, 'Mb/s');
INSERT INTO `predkosci` VALUES (6, 'MB/s');
INSERT INTO `predkosci` VALUES (7, 'Gb/s');
INSERT INTO `predkosci` VALUES (8, 'GB/s');
INSERT INTO `predkosci` VALUES (9, 'Tb/s');
INSERT INTO `predkosci` VALUES (10, 'TB/s');

-- ----------------------------
-- Table structure for rozmiar
-- ----------------------------
DROP TABLE IF EXISTS `rozmiar`;
CREATE TABLE `rozmiar`  (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_nazwa` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rozmiar
-- ----------------------------
INSERT INTO `rozmiar` VALUES (1, 'B');
INSERT INTO `rozmiar` VALUES (2, 'KB');
INSERT INTO `rozmiar` VALUES (3, 'MB');
INSERT INTO `rozmiar` VALUES (4, 'GB');
INSERT INTO `rozmiar` VALUES (5, 'TB');

SET FOREIGN_KEY_CHECKS = 1;
