insert into sys_user(userid,userna,passwd,gender,mobile,email,status,reg_date,last_login_time) 
	select 'admina', '����ԱA', '123456','U','135101123456','123456@chensy.com','N',now(),now() from dual
;


insert into sys_menu(menucd, name, icon, level, pid, action, desctx) 
	select '0', 'ϵͳ����', 'fa-cogs',0, null,'#', null from dual
;