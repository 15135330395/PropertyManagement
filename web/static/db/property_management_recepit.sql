-- auto-generated definition
create table recepit
(
  rid        int auto_increment
    primary key,
  department varchar(20) null,
  staff_id   int         null,
  staff_name varchar(20) null,
  money      double      null,
  pay_name   varchar(20) null,
  transactor varchar(20) null,
  shijian    date        null
);

