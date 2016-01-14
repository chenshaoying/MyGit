insert into sys_dict (dictcd, fildcd, fildvl, desctx, seq)
      select 'common',  'gender',      'M',         '男',            1 from dual
union select 'common',  'gender',      'F',         '女',            2 from dual
union select 'common',  'gender',      'U',         '未知',          3 from dual
;