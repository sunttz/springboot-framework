create table if not exists demo_item
(
  id varchar(20) not null
  primary key,
  name varchar(255) not null,
  amount int not null
  )
  engine=InnoDB;

create table if not exists t_user
(
  userId int auto_increment
  primary key,
  userName varchar(255) not null,
  password varchar(255) not null,
  phone varchar(255) not null
  )
  engine=InnoDB;