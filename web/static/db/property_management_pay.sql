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
  shijian    date         null
);
INSERT INTO property_management.pay (pid, department, staff_id, staff_name, money, reason, transactor, shijian) VALUES (1, '后勤部', 1, '苏肃', 2000, '购买办公用品', '苏素1', '2019-03-30');
INSERT INTO property_management.pay (pid, department, staff_id, staff_name, money, reason, transactor, shijian) VALUES (2, '采购部', 2, '法规', 200, '采购A4纸和墨盒', '苏苏', '2019-03-31');
INSERT INTO property_management.pay (pid, department, staff_id, staff_name, money, reason, transactor, shijian) VALUES (3, '的方式', 3, '对方的', 333, '大师傅但是', '反倒是', '2019-03-31');