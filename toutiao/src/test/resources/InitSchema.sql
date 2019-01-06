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
CREATE TABLE `user`(
  `id` int(11) primary key auto_increment,
  `username` varchar(64),
  `password` varchar(64),
  `salt` varchar(16),
  `head_url` varchar(64)
)ENGINE = InnoDB,auto_increment = 1,charset=UTF8;