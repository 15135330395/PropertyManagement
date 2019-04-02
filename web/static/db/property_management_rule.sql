create table rule
(
  rule_id     int auto_increment
    primary key,
  plot_name   varchar(50) null,
  room_number varchar(50) null,
  pay_name    varchar(50) null,
  norm_name   varchar(50) null,
  price       double      null,
  area        double      null,
  close_end   int         null,
  riqi        date        null,
  money       double      null,
  money1      double      null,
  money2      double      null,
  moneysum    double      null
);
INSERT INTO property_management.rule (rule_id, plot_name, room_number, pay_name, norm_name, price, area, close_end, riqi, money, money1, money2, moneysum) VALUES (2, '的法国队', '444', 'vzdf', '的发射点', 5, 20, 20, '2019-03-30', null, null, 10, null);