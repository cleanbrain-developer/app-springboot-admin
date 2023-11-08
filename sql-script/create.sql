create database adminapp character set utf8;

create user cleanbrain identified by 'cleanbrain!1234';

grant all privileges on adminapp.* to cleanbrain@'%';

flush privileges;

use adminapp;

create table user (
    id              varchar(20) primary key,
    name            varchar(64) not null,
    create_date     datetime,
    update_date     datetime
);