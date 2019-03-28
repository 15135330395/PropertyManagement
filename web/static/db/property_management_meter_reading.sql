create table meter_reading
(
  meter_reading_id int auto_increment
    primary key,
  plot_name        varchar(50)  null,
  room_number      varchar(50)  null,
  pay_name         varchar(50)  null,
  norm_name        varchar(50)  null,
  month            date         null,
  price            double       null,
  start            double       null,
  stop             double       null,
  pooled           double       null,
  note             varchar(200) null
);