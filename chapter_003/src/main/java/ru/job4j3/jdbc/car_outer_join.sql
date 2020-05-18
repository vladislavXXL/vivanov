--all cars with all parts
select c.id, c.name as car, b.name as body, e.name as engine, t.name as transmission from car as c left outer join body as b on c.id_body=b.id left outer join engine as e on c.id_engine=e.id left outer join transmission as t on c.id_transmission=t.id;

--not used body
select b.name from car as c right outer join body as b on c.id_body=b.id where c.id is null;

--not used engine
select e.name from car as c right outer join engine as e on c.id_engine=e.id where c.id is null;

--not used transmission
select t.name from transmission as t left outer join car as c on t.id=c.id_transmission where c.id is null;
