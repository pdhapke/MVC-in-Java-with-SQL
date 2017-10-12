create database classes1718; 
use classes1718; 
create table students
(ID  int NOT NULL auto_increment, 
firstname varchar(20) NOT NULL, 
lastname varchar(20) NOT NULL, 
classperiod int NOT NULL, 
primary key (id)); 

select * 
from students; 


TRUNCATE TABLE students;

