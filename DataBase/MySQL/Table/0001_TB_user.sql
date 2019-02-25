
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- 用户基础信息表
-- by Tommy
-- ----------------------------
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL COMMENT '用户id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `mobile` varchar(20) NOT NULL COMMENT '手机号码',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET ascii COLLATE ascii_general_ci DEFAULT NULL COMMENT '用户密码MD5',
  `user_state` smallint(6) NOT NULL DEFAULT '0' COMMENT '用户状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_mobile` (`mobile`) COMMENT '手机号索引',
  UNIQUE KEY `uk_user_name` (`user_name`) COMMENT '用户名索引',
  KEY `idx_user_password` (`user_password`(20)) COMMENT '用户密码索引',
  KEY `idx_user_state` (`user_state`) COMMENT '用户状态索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户基础信息表';