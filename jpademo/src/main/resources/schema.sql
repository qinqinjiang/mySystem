drop table users if exists;
create table users(id bigint auto_increment,name varchar(20),age int,gender TINYINT,primary key (id));