create database orders_items;

-- create table category
drop table if exists category cascade;
create table category (
    id serial primary key,
    name character varying(200)
);

-- create table state
drop table if exists state cascade;
create table state (
    id serial primary key,
    name character varying(200)
);

-- create table role
drop table if exists role cascade;
create table role (
    id serial primary key,
    name character varying(100),
    description text
);

-- create table users
drop table if exists users cascade;
create table users (
    id serial primary key,
    name character varying(100),
    role_id int references role(id)
);

-- create table rules
drop table if exists rules cascade ;
create table rules(
    id serial primary key,
    name character varying(100),
    description text
);

-- create table role_rules
drop table if exists role_rules;
create table role_rules(
    id serial primary key,
    role_id int references role(id),
    rule_id int references rules(id)
);

-- create table item
drop table if exists item cascade;
create table item (
    id serial primary key,
    date timestamp not null,
    user_id int references users(id) not null,
    description text,
    category_id int references category(id),
    state_id int references state(id)
);

-- create table comments
drop table if exists comments;
create table comments (
    id serial primary key,
    comment text not null,
    date timestamp not null,
    item_id int references item(id)
);

-- create table attaches
drop table if exists attaches;
create table attaches (
    id serial primary key,
    url character varying(500) not null,
    item_id int references item(id)
);

-- table state filling in
insert into state(name) values('New');
insert into state(name) values('In Progress');
insert into state(name) values('Done');

-- table category filling in
insert into category(name) values('Wholesale');
insert into category(name) values('Retail');
insert into category(name) values('VIP');

-- table role filling in
insert into role(name, description) values('Administrator', 'Has access to everywhere. Read, write and execute.');
insert into role(name, description) values('Author', 'Can read and write.');
insert into role(name, description) values('User', 'Can only read.');

-- table rules filling in
insert into rules(name, description) values('Read', 'Allow read rule.');
insert into rules(name, description) values('Write', 'Allow write rule.');
insert into rules(name, description) values('Execute', 'Allow execute rule');

-- table role_rules filling in
insert into role_rules(role_id, rule_id) values(1, 1);
insert into role_rules(role_id, rule_id) values(1, 2);
insert into role_rules(role_id, rule_id) values(1, 3);
insert into role_rules(role_id, rule_id) values(2, 1);
insert into role_rules(role_id, rule_id) values(2, 2);
insert into role_rules(role_id, rule_id) values(3, 1);

-- table users filling in
insert into users(name, role_id) values('Admin Ivanych', 1);
insert into users(name, role_id) values('Writer Petrovich', 2);
insert into users(name, role_id) values('User Sidorovich', 3);
insert into users(name, role_id) values('Writer Smirnovich', 2);
insert into users(name, role_id) values('User Kozlovich', 3);
insert into users(name, role_id) values('User Bykovich', 3);

-- table item filling in
insert into item(date, user_id, description, category_id, state_id) values(now(), 3, 'Order: 00001', 2, 1);
insert into item(date, user_id, description, category_id, state_id) values(now(), 5, 'Order: 00002', 1, 1);
insert into item(date, user_id, description, category_id, state_id) values(now(), 6, 'Order: 00003', 2, 1);
insert into item(date, user_id, description, category_id, state_id) values(now(), 5, 'Order: 00004', 3, 1);

-- table comments filling in
insert into comments(comment, date, item_id) values('I forget to fill my address.', now(), 2);
insert into comments(comment, date, item_id) values('Please contact me before sending', now(), 2);
insert into comments(comment, date, item_id) values('I don''t need delivery', now(), 3);
insert into comments(comment, date, item_id) values('Make me discount please.', now(), 3);
insert into comments(comment, date, item_id) values('Thank you.', now(), 3);

-- table attaches filling in
insert into attaches(url, item_id) values('https://www.google.com/maps', 2);
insert into attaches(url, item_id) values('http://mail.ru', 2);
insert into attaches(url, item_id) values('null', 3);
insert into attaches(url, item_id) values('URL doesn''t provided', 3);
insert into attaches(url, item_id) values('google.com', 4);