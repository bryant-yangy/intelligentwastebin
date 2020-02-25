create database wastebin;
use wastebin;
create table user (
    id int primary key auto_increment,
    username varchar(20) unique,
    name varchar(20),
    phone varchar (20),
    password varchar(32),
    points int,
    hasFace varchar(5),
    create_date datetime
);
alter table user auto_increment=1001;
create table admin (
    id int primary key auto_increment,
    adminname varchar(20) unique,
    password varchar(32)
);
alter table admin auto_increment=1001;

create table product(
    id int primary key auto_increment,
    product_name varchar(20),
    infor varchar (50),
    account int,
    points int,
    image varchar (100)

);
alter table product auto_increment=1001;

create table trash(
    id  int  primary key auto_increment,
    trash_name varchar(20),
    points int

);
alter table trash auto_increment=1001;

insert into trash(trash_name,points) value ("塑料瓶",2);
insert into trash(trash_name,points) value ("易拉罐",3);
insert into trash(trash_name,points) value ("电池",5);


create table deliver(
    id int primary key auto_increment,
    user_name varchar (20),
    name varchar (20),
    trash varchar (10),
    points int,
    date  datetime
);
alter table deliver auto_increment=1001;

create table indent(
    id int primary key auto_increment,
    user_name varchar (20),
    name varchar (20),
    product_name varchar (20),
    account int,
    points int,
    date datetime
);
alter table indent auto_increment=1001;