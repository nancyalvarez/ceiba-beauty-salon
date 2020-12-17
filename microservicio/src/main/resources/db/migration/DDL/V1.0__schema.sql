create table servicio_estetico(
    id int(11) not null auto_increment,
    id_servicio varchar(12) not null,
    nombre varchar(100) not null,
    tipo_servicio_estetico varchar(50) not null,
    costo int(10) not null,
    estado boolean not null,
    primary key (id)
);

