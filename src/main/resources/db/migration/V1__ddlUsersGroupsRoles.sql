create table groups
(
    id   int8 generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table roles
(
    id   int8 generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table users
(
    id        int8 generated by default as identity,
    chat_id   varchar(255),
    user_name varchar(255),
    group_id  int8 not null,
    role_id   int8 not null,
    primary key (id)
);
alter table if exists users
    add constraint UK_k8d0f2n7n88w1a16yhua64onx unique (user_name);
alter table if exists users
    add constraint FKemfuglprp85bh5xwhfm898ysc foreign key (group_id) references groups;
alter table if exists users
    add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles;