-- 删外键关联表
DROP TABLE
IF EXISTS `t_oto_user_ext`;
-- 建表
CREATE TABLE t_oto_user_ext (
  -- 业务字段 start
  `username` VARCHAR(32) NOT NULL UNIQUE
  COMMENT '登录帐号',
  `phone`    VARCHAR(32) COMMENT '手机号',
  `email`    VARCHAR(32) COMMENT '邮箱',
  `sex`      INT COMMENT '0:女,1:男',
  KEY `t_oto_user_ext_fk` (`username`),
  CONSTRAINT `t_oto_user_ext_fk` FOREIGN KEY (`username`) REFERENCES `t_ums_user` (`username`)
  -- 业务字段 end
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT '用户信息扩展表';