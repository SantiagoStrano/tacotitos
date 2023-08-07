create database if not exists taquitos;
use taquitos;
#drop database taquitos;


create table if not exists ingrediente_tipo(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    cant_max int not null

)engine innodb;


create table if not exists pedidos(
	id int not null primary key auto_increment,
    fecha date not null,
    precio_total int not null,
    alta tinyint not null default 0
)engine innodb;



create table if not exists taco(
	id int not null primary key auto_increment,
    id_pedido int not null,
    costo int not null,
    foreign key(id_pedido) references pedidos(id)

)engine innodb;


create table if not exists ingrediente(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    precio int not null,
    id_tipo_ingrediente int not null,
    baja boolean default 0,
    foreign key(id_tipo_ingrediente) references ingrediente_tipo(id)

)engine innodb;

create table if not exists ingrediente_taco(
	id_ingrediente int not null,
    id_taco int not null,
    precio_ingrediente int not null,
    foreign key(id_ingrediente) references ingrediente(id),
    foreign key(id_taco) references taco(id)
    
)engine innodb;



insert into ingrediente_tipo (nombre, cant_max) values ('tortilla', '2');
insert into ingrediente_tipo (nombre, cant_max) values ('salsa', '1');
insert into ingrediente_tipo (nombre, cant_max) values ('alimento', '5');

insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Cheddar',60,2);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Picante',30,2);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Pico de gallo',80,2);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Queso Crema',50,2);

insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Trigo',200,1);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Maiz',170,1);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Integral',100,1);

insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Carne',150,3);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('lechuga',50,3);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Pollo',100,3);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Arroz',80,3);


