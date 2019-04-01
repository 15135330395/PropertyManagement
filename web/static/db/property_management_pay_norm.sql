create table pay_norm
(
  norm_id        int auto_increment
    primary key,
  pay_id         int          null,
  norm_name      varchar(50)  null,
  compute_mode   varchar(50)  null,
  price          double       null,
  filling_type   varchar(50)  null,
  close_end      int          null,
  custom_formula varchar(100) null,
  charge_cycle   int          null,
  constraint pay_norm_pay_items_pay_id_fk
  foreign key (pay_id) references pay_items (pay_id)
);

INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, price, filling_type, close_end, custom_formula, charge_cycle) VALUES (1, 4, '单价（1.2）*房屋建筑面积   每3月', '单价*数量', 1.2, '房屋建筑面积', 0, '', 4);
INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, price, filling_type, close_end, custom_formula, charge_cycle) VALUES (2, 3, '每户单独录入 每1月', '每户单独录入', null, null, null, null, 1);
INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, price, filling_type, close_end, custom_formula, charge_cycle) VALUES (3, 2, '固定金额（50）每1月', '固定金额', null, null, 50, null, 1);
INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, price, filling_type, close_end, custom_formula, charge_cycle) VALUES (4, 1, '固定金额（150）每1月', '固定金额', null, '', 150, '', 1);
INSERT INTO property_management.pay_norm (norm_id, pay_name, norm_name, compute_mode, price, filling_type, close_end, custom_formula, charge_cycle) VALUES (5, 3, '自定义公式名称', '自定义公式', 0, '', 0, '', 6);