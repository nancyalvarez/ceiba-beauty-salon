create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table servicio_estetico(
    id int(11) not null auto_increment,
    ise varchar(12) not null,
    nombre varchar(100) not null,
    tipo varchar(50) not null,
    costo int(10) not null,
    estado boolean not null,
    primary key (id)
);

