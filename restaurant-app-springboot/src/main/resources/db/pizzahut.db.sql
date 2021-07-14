drop DATABASE pizzahutdb;
drop USER admin;

create user admin with password 'password';
create database pizzahutdb OWNER='admin';
connect pizzahutdb;
alter default privileges grant all on tables to admin;
alter default privileges grant all on sequences to admin;

create table phdbdish (
    dishid INTEGER PRIMARY KEY not null,
    dishname varchar(30) not null,
    dishimg varchar(100) not null,
    dishdesc varchar(50) not null,
    dishprice INTEGER not NULL,
    dishunitssold INTEGER
);

create TABLE phdbrestaurant (
    restaurantid INTEGER PRIMARY KEY not NULL,
    restaurantname VARCHAR(30) not NULL,
    restaurantimg VARCHAR(100) not NULL,
    restaurantdesc VARCHAR(100) not NULL
);

create TABLE phdbpromotion (
    promoid INTEGER PRIMARY KEY not NULL,
    promoname VARCHAR(30) not NULL,
    promodesc VARCHAR(100) not NULL,
    promoimg VARCHAR(100) not NULL,
    promoprice VARCHAR(100) not NULL
);

create TABLE phdbsales (
     saleid SERIAL PRIMARY KEY not NULL,
     purchasedcart VARCHAR(500) not NULL,
     purchasedaddress VARCHAR(100) not NULL,
     purchaseddate VARCHAR(25) not NULL
);
-- create sequnces for generating primary keys

create SEQUENCE phdbdishseq increment 1 start 1;
create SEQUENCE phdbrestaurantseq increment 1 start 1;
create SEQUENCE phdbpromoseq increment 1 start 1;
create SEQUENCE phdbsaleseq increment 2 start 1;