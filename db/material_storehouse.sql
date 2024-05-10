DROP TABLE IF EXISTS `m_configs`;
CREATE TABLE `m_configs`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `advertise_id` int(11) NULL DEFAULT NULL COMMENT '广告id',
  `old_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '历史数据兼容',
  `content` json NULL COMMENT '配制信息',
  `rule` tinyint(4) NULL DEFAULT 0 COMMENT '分发: 1:公众号的销售(公共池), 2:流量绑定的销售',
  `scene` int(11) NULL DEFAULT NULL COMMENT '场景',
  `scene_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '场景值（实际业务数据）',
  `wx_flow_qrcode_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信关注二维码地址',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '1: 领取资料, 2:活码, 3:公众号默认回复, 4:流量分发, 5:支付成功',
  `bind` int(11) NULL DEFAULT 0 COMMENT '绑定数量',
  `unbind` int(11) NULL DEFAULT 0 COMMENT '解绑数量',
  `sale_ucode` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '销售',
  `flow_ucode` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流量',
  `creator` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '操作时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '删除标识  0：正常   1：已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31177 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '配置' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `m_enter_video`;
CREATE TABLE `m_enter_video`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '视频标题',
  `intro` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频简介',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '视频图片',
  `config_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '配置ID',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '视频code(用于搜索)',
  `last_update_time` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `link` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '视频链接',
  `channel` int(11) NOT NULL COMMENT '渠道 1: B站  2: 知乎',
  `is_label` tinyint(1) NULL DEFAULT 0 COMMENT '是否打标签 0：否  1：是',
  `creator` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_config_id`(`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20630 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '录入视频' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `m_enter_video_label`;
CREATE TABLE `m_enter_video_label`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `enter_video_id` bigint(20) NOT NULL COMMENT '视频ID',
  `label_id` bigint(20) NOT NULL COMMENT '标签ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38069 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频标签关系表' ROW_FORMAT = Dynamic;
