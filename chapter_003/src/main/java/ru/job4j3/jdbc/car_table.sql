--create table body
drop table if exists body;
create table body (
	id serial primary key,
	name character varying(200)
);

--create table engine
drop table if exists engine;
create table engine (
	id serial primary key,
	name character varying(200)
);

--create table transmission
drop table if exists transmission;
create table transmission (
	id serial primary key,
	name character varying(200)
);

--create table car
drop table if exists car;
create table car (
	id serial primary key,
	name character varying(200),
	id_body int references body(id),
	id_engine int references engine(id),
	id_transmission int references transmission(id)
);

--fill table body
insert into body(name) values('coupe');
insert into body(name) values('universal');
insert into body(name) values('sedan');
insert into body(name) values('cabriolet');
insert into body(name) values('roadster');

--fill table engine
insert into engine(name) values('N63B44');
insert into engine(name) values('B47D20');
insert into engine(name) values('M 274 DES 20 AL');
insert into engine(name) values('M 256 E 30 DEH LA G');
insert into engine(name) values('OM 642 LS DE 30 LA');

--fill table transmission
insert into transmission(name) values('ZFS 241006');
insert into transmission(name) values('6HP21');
insert into transmission(name) values('4HP24');
insert into transmission(name) values('4L30E');
insert into transmission(name) values('5HP24 (01L)');
insert into transmission(name) values('RE5R01A');

--fill table car
insert into car(name, id_body, id_engine, id_transmission) values('bmw 5', 3, 1, 1);
insert into car(name, id_body, id_engine, id_transmission) values('bmw 5', 2, 2, 3);
insert into car(name, id_body, id_engine, id_transmission) values('mercedes e', 1, 3, 2);
insert into car(name, id_body, id_engine, id_transmission) values('mercedes e', 2, 4, 4);
