-- 删多对多关联表
DROP TABLE
IF EXISTS `t_mtm_user_organization`;
-- 建表
CREATE TABLE `t_mtm_user_organization` (
  -- 业务字段 start
  `user_id`         BIGINT NOT NULL
  COMMENT '用户表主键，外键关联 t_ums_user.id',
  `organization_id` BIGINT NOT NULL
  COMMENT '组织树结构表主键，外键关联 t_ums_organization.id',
  PRIMARY KEY (`user_id`, `organization_id`),
  KEY `t_mtm_user_organization_fk_u` (`user_id`),
  KEY `t_mtm_user_organization_fk_o` (`organization_id`),
  CONSTRAINT `t_mtm_user_organization_fk_u` FOREIGN KEY (`user_id`) REFERENCES `t_ums_user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `t_mtm_user_organization_fk_o` FOREIGN KEY (`organization_id`) REFERENCES `t_ums_organization` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
  -- 业务字段 end
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '用户组织关联表';
-- 初始化数据
INSERT INTO `t_mtm_user_organization` (`user_id`, `organization_id`)
VALUES (1, 1);