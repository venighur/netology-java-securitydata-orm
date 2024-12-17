--liquibase formatted sql

--changeset aprokopenko:1
create table persons (
  id serial primary key,
  name varchar(255) not null,
  surname varchar(255) not null,
  age int not null,
  phone_number varchar(20),
  city_of_living varchar(100) not null
);

--rollback drop table persons;