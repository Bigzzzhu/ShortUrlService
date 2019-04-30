create database shorturl;
use shorturl;

create table urlmap
(
	shortUrl varchar(10) primary key,
	realUrl varchar(250) not null unique,
	createDate timestamp,
	count int(11) default 0
);ENGINE=InnoDB DEFAULT CHARSET=utf8;