create table pay_items
(
  pay_id           int auto_increment
    primary key,
  pay_name         varchar(50)  null,
  pay_type         varchar(50)  null,
  billing_accuracy varchar(10)  null,
  note             varchar(200) null
);
INSERT INTO property_management.pay_items (pay_id, pay_name, pay_type, billing_accuracy, note) VALUES (1, '物业费', '周期性', '元', null);
INSERT INTO property_management.pay_items (pay_id, pay_name, pay_type, billing_accuracy, note) VALUES (2, '水费', '押金性', '分', '');
INSERT INTO property_management.pay_items (pay_id, pay_name, pay_type, billing_accuracy, note) VALUES (3, '停车费', '临时性', '角', '111');
INSERT INTO property_management.pay_items (pay_id, pay_name, pay_type, billing_accuracy, note) VALUES (5, '反倒是', '淀粉', null, '');
INSERT INTO property_management.pay_items (pay_id, pay_name, pay_type, billing_accuracy, note) VALUES (6, '56', 'erer', null, '');
INSERT INTO property_management.pay_items (pay_id, pay_name, pay_type, billing_accuracy, note) VALUES (7, 'nbvn', 'cvbcv', null, '');
INSERT INTO property_management.pay_items (pay_id, pay_name, pay_type, billing_accuracy, note) VALUES (8, 'dfd', 'gdfgdg', null, 'sdgadg');