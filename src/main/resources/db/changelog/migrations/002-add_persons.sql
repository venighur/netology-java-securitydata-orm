--liquibase formatted sql

--changeset aprokopenko:2
insert into persons values(1, 'John', 'Dow', 34, '001', 'Boston');
insert into persons values(2, 'Jane', 'Dow', 32, '002', 'Boston');
insert into persons values(3, 'Mark', 'Smith', 28, '003', 'London');
insert into persons values(4, 'Lisa', 'Markova', 45, '004', 'Moscow');

--rollback delete from persons where id='1';
--rollback delete from persons where id='2';
--rollback delete from persons where id='3';
--rollback delete from persons where id='4';