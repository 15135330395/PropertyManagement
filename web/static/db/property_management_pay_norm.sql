create table pay_norm
(
  norm_id      int auto_increment
    primary key,
  pay_name     varchar(50) null,
  norm_name    varchar(50) null,
  compute_mode varchar(50) null,
  charge_cycle int         null
);
INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, charge_cycle) VALUES (1, '房租', '单价（1.2）*房屋建筑面积 每4月', '单价*数量', 4);
INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, charge_cycle) VALUES (2, '停车费', '每户单独录入 每1月', '每户单独录入', 1);
INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, charge_cycle) VALUES (3, '水电费', '固定金额（50）每1月', '固定金额', 1);
INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, charge_cycle) VALUES (4, '物业费', '固定金额（150）每1月', '固定金额', 1);
INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, charge_cycle) VALUES (6, '水电费', '固定金额（100）每1月', '固定金额', 1);