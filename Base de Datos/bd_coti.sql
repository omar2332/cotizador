create table productos (
	id_producto serial not null,
	descripcion text,
	precio numeric(10,2),
	urlImg text

);

create table clientes(
	id_cliente serial not null,
	nombre text not null,
	apellido text not null,
	empresa text not null,
	email text,
	contacto text,
	telefono varchar(20),
	rfc varchar(13),
	domicilio text,
	embarcar text

);

create table cotizacion(
	id_cotizacion serial not null,
	id_cliente integer, 
	fecha_creacion date not null,
	fecha_modificacion date,
	descuento numeric(10,2),
	total numeric(10,2),
	subtotal numeric(10,2),
	iva numeric(10,2),
	vigencia integer,
	num_letras text

);

create table cot_productos(
	id_cotizacion integer,
	id_producto integer,
	id_cot_producto serial not null,
	cantidad integer not null,
	cantidadXProducto numeric(10,2),
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

INSERT INTO clientes(
	 nombre, apellido, empresa, email, contacto, telefono, rfc, domicilio, embarcar)
	VALUES ('Omar Sebastian', 'Programador', 'SISA', 'omar_23_99@hotmail.com', 'Sebastian', '5551843061', '123456789', 'Direccion NA', 'Direccion NA');
insert into cotizacion(id_cliente,fecha_creacion,fecha_modificacion,subtotal,iva,descuento,total,vigencia) values (1,'10-05-2020','10-05-2020',1400,0,0,1400,8);

insert into cot_productos(id_cotizacion,id_producto,cantidad,cantidadXProducto,comentario) values (1,1,2,600,'Sin comentarios');
insert into cot_productos(id_cotizacion,id_producto,cantidad,cantidadXProducto,comentario) values (1,2,2,800,'Sin comentarios');



