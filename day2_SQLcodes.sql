/*
insert into tv_shows(title,lang,rating,user_rating,release_date) 
           values('Jap test 1','Japanese','PG','7.7','2025-05-11');
           
insert into tv_shows(title,lang,rating,user_rating,release_date) 
           values('Jap test 2','Japanese','PG','7.7','2025-05-15');
           
insert into tv_shows(title,lang,rating,user_rating,release_date) 
           values('Jap test 3','Japanese','PG','7.7','2025-05-17');
*/
           
#select distinct lang from tv_shows;

#select distinct lang,rating from tv_shows

#select * from tv_shows;

/*
select count(*) from tv_shows
where lang like 'English';
*/
#select count(distinct title) from tv_shows where lang like '%Japanese%';
#select count(distinct title) from tv_shows where lang in('Chinese','Japanese');
#select avg(user_rating) from tv_shows where lang like 'English';
#select sum(user_rating) from tv_shows where lang like 'English';
#select sum(user_rating) / count(*) from tv_shows where lang like 'English';
/*
select rating, count(rating) as cnt
from tv_shows
where lang in('Chinese','Japanese')
group by rating
order by cnt asc;
*/

/*
select rating,count(rating)
from tv_shows
where lang in (select distinct lang from tv_shows where lang like 'English')
group by rating 
order by count(rating) desc;
*/
/*
select * from
(select rating, count(rating) as cnt
from tv_shows 
group by rating) as tableA
where tableA.cnt > 5;
*/
/*
select rating, count(rating)
from tv_shows 
group by rating
having count(rating) > 2;
*/

/*
SELECT title, rating , lang
,max(rating) over (partition by rating) as max_rating
from tv_shows;
*/

/*
create table car(
	id int not null auto_increment,
    make varchar(50),
    model varchar(50),
    cartype varchar(50),
    price float default '1000.00',
    constraint pk_carid primary key (id)
)
*/
/*
insert into car(make,model,cartype,price) values('Hyundai','Avante','Sedan',80000.0);
insert into car(make,model,cartype,price)  values('Toyota','Altis','Sedan',82050.0);
insert into car(make,model,cartype,price)  values('Ford','Falcom','Low Cost',50000.0);
insert into car(make,model,cartype,price)  values('Renault','Megane','Standard',90000.0);
insert into car(make,model,cartype,price)  values('Hyundai','Box','Premium',120000.0);
insert into car(make,model,cartype,price)  values('Honda','Civic','Sports',180000.0);
insert into car(make,model,cartype,price)  values('Toyota','Two','Sports',155000.0);
insert into car(make,model,cartype,price)  values('Honda','Fit','Sports',152600.0);
insert into car(make,model,cartype,price)  values('Ford','Galaxy','Standard',79000.0);
insert into car(make,model,cartype,price)  values('Toyota','Penguin','Sedan',69000.0);
insert into car(make,model,cartype,price)  values('Renault','Fuego','Sports',65000.0);

select * from car;
*/

select make,model,cartype,price, max(price) over (partition by cartype) as max_cartype
from car;


select make,model,cartype,price, sum(price) over (partition by make) as sum_make
from car;

select make,model,cartype,price, 
avg(price) over() as overall_avg_price,
avg(price) over (partition by make) as sum_make
from car;




