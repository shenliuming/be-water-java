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
