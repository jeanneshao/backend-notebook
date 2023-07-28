 show global variables like "%default%";
 show global variables like "%max%";
 show global variables like "%transaction%";
 show global variables like "%size%";
 show global variables like "%row%";
SHOW VARIABLES LIKE 'datadir';
SHOW SESSION VARIABLES ;
SHOW SESSION VARIABLES like '%transaction%';
SHOW SESSION VARIABLES like '%insert%';
SHOW SESSION VARIABLES like '%increment%';
# SHOW [GLOBAL|SESSION] STATUS [LIKE 匹配的模式];
SHOW global STATUS;
SHOW SESSION STATUS;
SHOW global STATUS LIKE 'thread%';
SHOW STATUS LIKE 'thread%';
SHOW CHARACTER SET; #|CHARSET)
SHOW COLLATION;
SHOW COLLATION LIKE '%utf8%';
SHOW VARIABLES LIKE 'character_set_server';
SHOW VARIABLES LIKE 'collation_server';

show table status like "full_example";

SELECT *
FROM INFORMATION_SCHEMA.COLUMNS
where TABLE_SCHEMA like 'low_code_demo'
and TABLE_NAME like '%full_example%';

SELECT COLUMN_NAME, TABLE_NAME
FROM INFORMATION_SCHEMA.COLUMNS
WHERE   COLUMN_COMMENT LIKE '%hidden%';



#  CREATE TABLE varchar_size_demo(
# #  c VARCHAR(65533) not null
#  c VARCHAR(65532)
#  ) CHARSET=ascii ROW_FORMAT=Compact;

# CREATE TABLE varchar_size_demo(
#  c VARCHAR(32766) not null
# #  c VARCHAR(32766)
#  ) CHARSET=gbk ROW_FORMAT=Compact;

CREATE TABLE varchar_size_demo(
 c VARCHAR(21844)
 ) CHARSET=utf8 ROW_FORMAT=Compact;
show create table full_example;
drop table if exists  varchar_size_demo;

CREATE TABLE index_demo(
 c1 INT,
 c2 INT,
 c3 CHAR(1),
 PRIMARY KEY(c1),
 INDEX idx_c2_c3 (c2, c3)
);
ALTER TABLE index_demo DROP INDEX idx_c2_c3;
ALTER TABLE index_demo add INDEX idx_c2_c3 (c2, c3);


use low_code_demo;
SHOW VARIABLES LIKE 'character_set_database';
SHOW VARIABLES LIKE 'collation_database';

select * from full_example;

explain select * from base.asset where id = 0x323B43D0122811EDB892ADB562C6F2EF;

show engines ;

SHOW DATABASES;