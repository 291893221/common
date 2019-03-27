DROP TABLE
IF EXISTS `t_sys_user_role`;

DROP TABLE
IF EXISTS `t_sys_user`;

DROP TABLE
IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_user` (
	`id` INT (11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR (255) NOT NULL,
	`password` VARCHAR (255) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE `t_sys_role` (
	`id` INT (11) NOT NULL AUTO_INCREMENT,
	`role_name` VARCHAR (255) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE `t_sys_user_role` (
	`user_id` INT (11) NOT NULL,
	`role_id` INT (11) NOT NULL,
	PRIMARY KEY (`user_id`, `role_id`),
	KEY `fk_role_id` (`role_id`),
	CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB DEFAULT CHARSET = utf8;

INSERT INTO `t_sys_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `t_sys_role` VALUES ('2', 'ROLE_USER');

INSERT INTO `t_sys_user` VALUES ('1', 'admin', '123');
INSERT INTO `t_sys_user` VALUES ('2', 'test', '123');

INSERT INTO `t_sys_user_role` VALUES ('1', '1');
INSERT INTO `t_sys_user_role` VALUES ('2', '2');