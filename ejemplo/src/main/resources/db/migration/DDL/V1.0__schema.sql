create table usuario (
 id NUMERIC not null IDENTITY,
 nombre varchar(100) not null,
 edad NUMERIC not null,
 direccion VARCHAR(100) null,
 primary key (id)
);