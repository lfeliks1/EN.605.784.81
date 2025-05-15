create table STUDENT (
id serial not null primary key,
first_name varchar(20) not null,
last_name varchar(20) not null,
email varchar(64) not null
);

insert into STUDENT (id, first_name, last_name, email) values
(1, 'John1', 'Doe1', 'jdoe1@email.com'),
(2, 'John2', 'Doe2', 'jdoe2@email.com'),
(3, 'John3', 'Doe3', 'jdoe3@email.com');