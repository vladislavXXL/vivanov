drop table if exists type;
create table type (
	id serial primary key,
	name character varying(200)
);

drop table if exists product;
create table product (
	id serial primary key,
	name character varying(200),
	type_id int refernces type(id),
	expired_date timestamp,
	price int,
	quantity int
);

insert into type(name) values('СЫР');
insert into type(name) values('МОЛОКО');
insert into type(name) values('МЯСО');

insert into product(name, type_id, expired_date, price, quantity) values('Danablu', 1, now(), 1500, 15);
insert into product(name, type_id, expired_date, price, quantity) values('Gonbazolla', 1, now(), 1700, 5);
insert into product(name, type_id, expired_date, price, quantity) values('Зеленое село', 2, now(), 80, 120);
insert into product(name, type_id, expired_date, price, quantity) values('Домик в деревне', 2, now(), 85, 1000);
insert into product(name, type_id, expired_date, price, quantity) values('Говядина', 3, now(), 450, 15);
insert into product(name, type_id, expired_date, price, quantity) values('Баранина', 3, now(), 600, 2);
insert into product(name, type_id, expired_date, price, quantity) values('Веселый молочник', 2, now(), 600, 5000);
insert into product(name, type_id, expired_date, price, quantity) values('Телятина', 3, now(), 850, 130);