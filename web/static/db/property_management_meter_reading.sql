create table meter_reading
(
  meter_reading_id int auto_increment
    primary key,
  plot_name        varchar(50) null,
  room_number      varchar(50) null,
  riqi             date        null,
  price            double      null,
  start            double      null,
  stop             double      null,
  pooled           double      null,
  moneysum         double      null
);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, riqi, price, start, stop, pooled, moneysum) VALUES (1, '宏盛花园', '502', '2019-01-01', 0, 0, 0, 0, null);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, riqi, price, start, stop, pooled, moneysum) VALUES (3, '邮政小区', '1001', '2019-01-12', 0.8, 100, 180, 20, null);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, riqi, price, start, stop, pooled, moneysum) VALUES (4, '金黄即可', '1002', '2019-03-31', 0, 0, 0, 0, null);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, riqi, price, start, stop, pooled, moneysum) VALUES (5, '广汇股份', '电话规划', '2019-03-29', 5, 0, 4, 2, null);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, riqi, price, start, stop, pooled, moneysum) VALUES (8, '几乎都是看', '333', '2019-03-31', 6, 56, 60, 0, null);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, riqi, price, start, stop, pooled, moneysum) VALUES (9, '很少看电视看', '22', '2019-04-03', 5, 33, 66, 3, null);
INSERT INTO property_management.meter_reading (meter_reading_id, plot_name, room_number, riqi, price, start, stop, pooled, moneysum) VALUES (10, '对方的', '221', '2019-04-17', 5, 22, 66, 2, null);