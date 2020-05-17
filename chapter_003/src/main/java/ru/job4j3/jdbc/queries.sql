--1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product as p inner join type as t on p.type_id=t.id where t.name='СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product as p where p.name like '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product as p where p.expired_date >= date_trunc('month', now() + interval '1 month') and p.expired_date < date_trunc('month', now() + interval '2 month');

--4. Написать запрос, который выводит самый дорогой продукт.
select * from product where price=(select max(price) from product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select t.name, sum(p.quantity) from product as p inner join type as t on p.type_id=t.id group by t.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product as p inner join type as t on p.type_id=t.id where t.name='СЫР' or t.name='МОЛОКО';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name, sum(p.quantity) as total from product as p inner join type as t on p.type_id=t.id group by t.name having sum(p.quantity) < 10;

--8. Вывести все продукты и их тип.
select * from product as p inner join type as t on p.type_id=t.id;