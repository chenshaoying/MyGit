insert into sys_user(userid,userna,passwd,gender,mobile,email,status,reg_date,last_login_time) 
	select 'admina', '����ԱA', '123456','U','135101123456','123456@chensy.com','N',now(),now() from dual
;
