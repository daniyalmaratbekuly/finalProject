create table permissions(
    id serial primary key,
    role varchar(100)

);
insert into permissions(role) values ('ROLE_ADMIN');
insert into permissions(role) values ('MODERATOR');
insert into permissions(role) values ('ROLE_USER');