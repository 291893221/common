-- 删多对多关联表
DROP TABLE
IF EXISTS `t_mtm_user_role`;
-- 建表
CREATE TABLE `t_mtm_user_role` (
  -- 业务字段 start
  `user_id` BIGINT NOT NULL
  COMMENT '用户表主键，外键关联 t_ums_user.id',
  `role_id` BIGINT NOT NULL
  COMMENT '角色表主键，外键关联 t_ums_role.id',
  PRIMARY KEY (`user_id`, `role_id`),
  KEY `t_mtm_user_role_fk_u` (`user_id`),
  KEY `t_mtm_user_role_fk_r` (`role_id`),
  CONSTRAINT `t_mtm_user_role_fk_u` FOREIGN KEY (`user_id`) REFERENCES `t_ums_user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `t_mtm_user_role_fk_r` FOREIGN KEY (`role_id`) REFERENCES `t_ums_role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
  -- 业务字段 end
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '用户角色关联表';
-- 初始化数据
INSERT INTO `t_mtm_user_role` (`user_id`, `role_id`)
VALUES (1, 1);