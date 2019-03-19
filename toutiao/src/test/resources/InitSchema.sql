DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`(
  `id` int(11) unsigned not null auto_increment,
  `title` varchar(128) not null default '',
  `link` varchar(256) not null default '',
  `image` varchar(256)not null default '',
  `like_count` int(11) not null,
  `comment_count` int(11) not null,
  `created_date` datetime not null,
  `user_id` int(11) not null,
  primary key(`id`)
)ENGINE = InnoDB,auto_increment = 1,charset=UTF8;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `salt` varchar(16) DEFAULT NULL,
  `head_url` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `login_ticket`;
CREATE TABLE `login_ticket`(
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `ticket` VARCHAR(45) NOT NULL,
  `expired` DATETIME NOT NULL,
  `status` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;