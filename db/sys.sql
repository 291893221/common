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

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_roleId` (`role_id`),
  CONSTRAINT `fk_roleId` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DELETE FROM `t_sys_role`;
DELETE FROM `t_sys_user`;
DELETE FROM `t_sys_user_role`;

INSERT INTO `t_sys_role` VALUES ('1', 'ROLE_ROOT');
INSERT INTO `t_sys_role` VALUES ('2', 'ROLE_ADMIN');
INSERT INTO `t_sys_role` VALUES ('3', 'ROLE_USER');

INSERT INTO `t_sys_user` VALUES ('1', 'root', 'root');
INSERT INTO `t_sys_user` VALUES ('2', 'admin', '123');
INSERT INTO `t_sys_user` VALUES ('3', 'test', '123');

INSERT INTO `t_sys_user_role` VALUES ('1', '1');
INSERT INTO `t_sys_user_role` VALUES ('1', '2');
INSERT INTO `t_sys_user_role` VALUES ('1', '3');
INSERT INTO `t_sys_user_role` VALUES ('2', '2');
INSERT INTO `t_sys_user_role` VALUES ('3', '3');