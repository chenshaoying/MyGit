drop table if exists sys_user;
create table sys_user (
	userid          varchar(20) not null,
	userna          varchar(80) not null,
	passwd          varchar(20) not null,  
	gender          char(1)     not null,     --M 男 F 女 
	mobile          varchar(20) null,
	email           varchar(80) null,
	status          char(1)     not null,     --N正常  L锁定  C注销
	reg_date        date null,
	last_login_time timestamp null,
	primary key(userid)
) engine=innodb default charset=utf8;