create table receipt
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
INSERT INTO property_management.receipt (rid, department, staff_id, staff_name, money, pay_name, transactor, shijian) VALUES (1, '后勤部', 4, '广寒1', 300, '水电费', '计科', '2019-03-30');