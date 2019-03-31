-- auto-generated definition
create table pay
(
  pid        int auto_increment
    primary key,
  department varchar(20)  null,
  staff_id   int          null,
  staff_name varchar(20)  null,
  money      double       null,
  reason     varchar(100) null,
  transactor varchar(20)  null,
  time       date         null
);

