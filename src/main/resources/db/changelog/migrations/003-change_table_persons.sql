--liquibase formatted sql

--changeset aprokopenko:3
alter table persons drop column id;
alter table persons add constraint pr_persons primary key (name, surname, age);

--rollback drop table persons;
