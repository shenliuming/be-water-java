SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_short_links
-- ----------------------------
DROP TABLE IF EXISTS `m_short_links`;
CREATE TABLE `m_short_links`
(
    `id`                  bigint UNSIGNED NOT NULL AUTO_INCREMENT,
    `short_url`           varchar(255) NOT NULL COMMENT '短链URL',
    `original_url`        varchar(2048) NOT NULL COMMENT '原始URL',
    `short_type`          tinyint UNSIGNED DEFAULT 1 COMMENT '短链类型(1-课程,2-其他)',
    `page_views`          int UNSIGNED NOT NULL DEFAULT 0 COMMENT '今日访问次数',
    `unique_visitors`     int UNSIGNED NOT NULL DEFAULT 0 COMMENT '今日独立访客数',
    `acquired_customers`  int UNSIGNED NOT NULL DEFAULT 0 COMMENT '今日获客次数',
    `pv_total`            int UNSIGNED NOT NULL DEFAULT 0 COMMENT '累计访问次数',
    `uv_total`            int UNSIGNED NOT NULL DEFAULT 0 COMMENT '累计独立访客次数',
    `ac_total`            int UNSIGNED NOT NULL DEFAULT 0 COMMENT '累计获客次数',
    `status`              tinyint UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态 (0=禁用, 1=启用)',
    `channel_id`          bigint UNSIGNED DEFAULT NULL COMMENT '渠道ID',
    `channel_name`        varchar(125) DEFAULT NULL COMMENT '渠道名称',
    `domain_id`           bigint UNSIGNED NOT NULL COMMENT '网站域名ID',
    `domain_name`         varchar(125) DEFAULT NULL COMMENT '网站域名名称',
    `creator_id`          varchar(64) DEFAULT NULL COMMENT '创建人ID',
    `creator_name`        varchar(64) DEFAULT NULL COMMENT '创建人名称',
    `create_time`         datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='营销短链表' ROW_FORMAT=Dynamic;

CREATE TABLE IF NOT EXISTS `m_wx_account_config` (
     `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `app_id` VARCHAR(64) NOT NULL COMMENT '公众号appId',
    `app_name` VARCHAR(128) NOT NULL COMMENT '公众号appName',
    `type` tinyint NOT NULL COMMENT '账号类型',
    `secret` VARCHAR(32) NOT NULL COMMENT 'appsecret',
    `token` VARCHAR(32)  NULL COMMENT 'token',
    `aes_key` VARCHAR(43)  NULL COMMENT 'aes_key',
    `is_flow_dist` tinyint NOT NULL DEFAULT 1 COMMENT '是否流量分发: 1启用 0禁用',
    `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态: 1启用 0禁用',
    `welcome_message` JSON COMMENT '默认欢迎语',
    `remark` VARCHAR(255) COMMENT '备注信息',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='存储微信公众号的基础配置信息';


CREATE TABLE `m_wx_user` (
     `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
     `open_id` varchar(50) NOT NULL COMMENT '微信openid',
     `app_id` varchar(20) NOT NULL COMMENT 'appId',
     `app_name` varchar(50) NULL COMMENT 'appName',
     `phone` varchar(20) NULL DEFAULT NULL COMMENT '手机号',
     `nickname` varchar(50) NULL DEFAULT NULL COMMENT '昵称',
     `sex` tinyint(4) NULL DEFAULT NULL COMMENT '性别(0-未知、1-男、2-女)',
     `city` varchar(20) NULL DEFAULT NULL COMMENT '城市',
     `province` varchar(20) NULL DEFAULT NULL COMMENT '省份',
     `avatar` varchar(255) NULL DEFAULT NULL COMMENT '头像',
     `subscribe_time` datetime NULL DEFAULT NULL COMMENT '订阅时间',
     `subscribe` tinyint(3) UNSIGNED NULL DEFAULT 1 COMMENT '是否关注',
     `union_id` varchar(50) NULL DEFAULT NULL COMMENT 'unionid',
     `language` varchar(50) NULL DEFAULT NULL COMMENT '语言',
     `remark` varchar(255) NULL DEFAULT NULL COMMENT '备注',
     `tagid_list` json NULL COMMENT '标签ID列表',
     `subscribe_scene` varchar(50) NULL DEFAULT NULL COMMENT '关注场景',
     `qr_scene_str` varchar(64) NULL DEFAULT NULL COMMENT '扫码场景值',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微信用户表' ROW_FORMAT=Dynamic;