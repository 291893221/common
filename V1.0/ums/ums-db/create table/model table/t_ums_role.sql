-- 删表
DROP TABLE
IF EXISTS `t_ums_role`;
-- 建表
CREATE TABLE `t_ums_role` (
  -- 业务字段 start
  `rolecode` VARCHAR (32) NOT NULL UNIQUE COMMENT '角色编码',
  `rolename` VARCHAR (32) NOT NULL UNIQUE COMMENT '角色名称',
  -- 业务字段 end
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
  COMMENT = '角色表';
-- 初始化数据
INSERT INTO `t_ums_role`
(`rolecode`, `rolename`)
VALUES
  ('ROLE_ROOT', '超级管理员角色'),
  ('ROLE_ADMIN', '管理员角色'),
  ('ROLE_USER', '用户帐号角色');
