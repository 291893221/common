-- 删表
DROP TABLE
IF EXISTS `t_common_base_entity`;
-- 建表
CREATE TABLE `t_common_base_entity` (
  -- 公共字段 start
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL COMMENT '创建时间',
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL COMMENT '更新时间',
  `is_delete` INT NOT NULL DEFAULT '0' COMMENT '是否删除（0:未删除,1:已删除）',
  `status` INT NOT NULL DEFAULT '1' COMMENT '状态(0:禁用,1:正常)',
  `describe` VARCHAR(32) DEFAULT '' COMMENT '描述信息',
  `sort` BIGINT DEFAULT 1 COMMENT '排序编号',
  PRIMARY KEY (`id`)
  -- 公共字段 end
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '基础表';