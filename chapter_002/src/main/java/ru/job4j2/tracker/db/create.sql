drop table if exists items;
create table items (
    id serial primary key,
    name character varying(200),
    description text,
    created timestamp
);