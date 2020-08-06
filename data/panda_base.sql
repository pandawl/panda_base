/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : panda_base

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 06/08/2020 17:16:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `browser_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `log_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `request_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `request_params` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `request_time` datetime(0) NULL DEFAULT NULL,
  `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_agent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8776 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (8776, 'Chrome', '0:0:0:0:0:0:0:1', '用户列表', 'SYS', 'GET', '', '2020-08-06 17:14:26', '/sysUser/list', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36', NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号名称',
  `user_rel_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `user_pwd` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码 操作员用户密码为空',
  `acc_tel` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `acc_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `acc_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `acc_birthday` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `acc_sex` smallint(6) NULL DEFAULT NULL COMMENT '性别（1男 2女）',
  `acc_err_log_num` smallint(6) NULL DEFAULT NULL COMMENT '登录错误次数 最多尝试5次',
  `acc_err_log_time` bigint(20) NULL DEFAULT NULL COMMENT '登录错误时间',
  `user_type` smallint(6) NULL DEFAULT NULL COMMENT '用户类型',
  `user_source` smallint(6) NULL DEFAULT NULL COMMENT '用户来源 1.内部自建用户 2.外部用户',
  `ou_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织机构编码',
  `ou_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织机构名称',
  `user_status` smallint(6) NULL DEFAULT 0 COMMENT '用户状态 0.未冻结 1.冻结',
  `remarks` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del` smallint(6) NULL DEFAULT NULL COMMENT '删除标记 0.未删除 1.删除',
  `created_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `i_sys_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 369 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考核账户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (24, 'Admin', '超级管理员', 'bfc62b3f67a4c3e57df84dad8cc48a3b', '', '', '', '66666666', 0, 10, 1587806005904, 20, 1, '3000000', 'panda服务有限公司', 0, '1', 0, 'wl', '2020-05-07 10:32:09', 'realm', '2020-07-21 14:53:57', '2020-08-05 21:15:23');
INSERT INTO `sys_user` VALUES (359, 'GW_WL', NULL, '', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, NULL, '2020-07-07 15:48:46', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (360, 'GW_MD', NULL, 'b183261d3893d366507255a454e164e6', NULL, '18209298930@qq.com', '18209298930', NULL, 1, NULL, NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, NULL, '2020-07-07 15:50:14', NULL, '2020-07-24 16:00:36', NULL);
INSERT INTO `sys_user` VALUES (365, 'mert_func_manage', '测试专用', NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 2, '3', 'panda商户', 0, NULL, 0, NULL, '2020-07-17 15:59:18', NULL, '2020-08-05 16:09:54', '2020-08-06 16:39:34');
INSERT INTO `sys_user` VALUES (368, 'ZB_WL1', '王磊', '', '', '', '', '', 0, NULL, NULL, NULL, 2, '3', 'panda商户', 0, '', 0, '', '2020-08-05 18:16:33', '', '2020-08-05 18:20:52', '2020-08-05 20:51:54');

SET FOREIGN_KEY_CHECKS = 1;
