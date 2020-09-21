-- 删表
DROP TABLE
IF EXISTS `t_ums_resource`;
-- 建表
CREATE TABLE `t_ums_resource` (
  -- 业务字段 start
  `resource_url` VARCHAR(255) COMMENT '资源相对路径',
  `resource_name` VARCHAR(32) COMMENT '资源名称',
  `resource_permission` VARCHAR(32) COMMENT '资源权限(c:create创建,r:read查询,u:update修改,d:delete删除)',
  `resource_icon` VARCHAR(32) COMMENT '图标',
  `resource_type` INT COMMENT '资源类型(1:模块目录,2:功能菜单,3:操作按钮)',
  `pid` BIGINT COMMENT '上级id',
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
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '资源树结构表';
-- 初始化数据
INSERT INTO `t_ums_resource`
(`resource_url`, `resource_name`, `resource_permission`)
VALUES
  ('/ums/user', '用户管理模块', 'c,r,u,d'),
  ('/ums/user', '用户管理模块', 'c,r'),
  ('/ums/user', '用户管理模块', 'r');
