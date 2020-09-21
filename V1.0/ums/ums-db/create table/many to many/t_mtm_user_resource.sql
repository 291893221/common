-- 删多对多关联表
DROP TABLE
IF EXISTS `t_mtm_user_resource`;
-- 建表
CREATE TABLE `t_mtm_user_resource` (
  -- 业务字段 start
  `user_id`     BIGINT NOT NULL
  COMMENT '用户表主键，外键关联 t_ums_user.id',
  `resource_id` BIGINT NOT NULL
  COMMENT '角色表主键，外键关联 t_ums_resource.id',
  PRIMARY KEY (`user_id`, `resource_id`),
  KEY `t_mtm_user_resource_fk_u` (`user_id`),
  KEY `t_mtm_user_resource_fk_r` (`resource_id`),
  CONSTRAINT `t_mtm_user_resource_fk_u` FOREIGN KEY (`user_id`) REFERENCES `t_ums_user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `t_mtm_user_resource_fk_r` FOREIGN KEY (`resource_id`) REFERENCES `t_ums_resource` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
  -- 业务字段 end
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '用户资源关联表';
-- 初始化数据
INSERT INTO `t_mtm_user_resource` (`user_id`, `resource_id`)
VALUES (1, 1);