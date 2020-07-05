create table productos (
	id_producto serial not null,
	descripcion text,
	precio money

);

create table clientes(
	id_cliente serial not null,
	nombre text not null,
	apellido text not null,
	empresa text not null

);

create table cotizacion(
	id_cotizacion serial not null,
	id_cliente integer, 
	fecha_creacion text not null,
	descuento numeric(4,2)

);

create table cot_productos(
	id_cotizacion integer,
	id_producto integer,
	id_cot_producto serial not null,
	cantidad integer not null,
	comentario text

);


alter table productos add primary key(id_producto);
alter table clientes add primary key(id_cliente);
alter table cotizacion add primary key(id_cotizacion);
alter table cot_productos add primary key(id_cot_producto);

alter table cotizacion add foreign key (id_cliente) references clientes(id_cliente);
alter table cot_productos add foreign key(id_cotizacion) references cotizacion(id_cotizacion);
alter table cot_productos add foreign key(id_producto) references productos(id_producto);


insert into productos(descripcion,precio) values ('Libro de Probabilidad Y Estadistica', 300);
insert into productos(descripcion,precio) values ('Libro Analisis Matematico', 400);
insert into productos(descripcion,precio) values ('Libro de Matematicas Discretas', 500);

insert into clientes(nombre,apellido,empresa) values ('Jorge Luis', 'Borges', 'RBA');


