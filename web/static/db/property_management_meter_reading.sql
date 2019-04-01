create table meter_reading
(
  meter_reading_id int auto_increment
    primary key,
  plot_name        varchar(50) null,
  room_number      varchar(50) null,
  pay_name         varchar(50) null,
  norm_name        varchar(50) null,
  riqi             date        null,
  price            double      null,
  start            double      null,
  stop             double      null,
  pooled           double      null
);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, pay_name, norm_name, riqi, price, start, stop, pooled) VALUES (1, '宏盛花园', '502', '物业费', '固定金额（150）每1月', '2019-01-01', 0, 0, 0, 0);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, pay_name, norm_name, riqi, price, start, stop, pooled) VALUES (3, '邮政小区', '1001', '水电费', '单价（1.2）*抄表表数', '2019-01-12', 0.8, 100, 180, 20);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, pay_name, norm_name, riqi, price, start, stop, pooled) VALUES (4, '金黄即可', '1002', '停车费', '固定金额（50）每1月', '2019-03-31', 0, 0, 0, 0);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, pay_name, norm_name, riqi, price, start, stop, pooled) VALUES (5, '广汇股份', '电话规划', '电话费很贵', '大概花费很高', '2019-03-29', 5, 0, 4, 2);
