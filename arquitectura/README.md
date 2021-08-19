Plantilla backend arquitectura proyecto empresarial alta disponibilidad y transaccionalidad
Expone servicios rest

## Running the Application

1. java 1.8
2. proyecto web spring
3. Despliegue war sobre wildfly 19 min

## Build

mvn clean
mvn install


## documentacion api swagger
http://localhost:8080/arquitectura/swagger-ui.html#/


## Script DB postgresql
CREATE SEQUENCE ejemplo.estudiantes_seq
start with 1
increment by 1;

CREATE TABLE ejemplo.estudiantes(
id_estudiante          numeric  NOT null default nextval('ejemplo.estudiantes_seq'),
nombre                 varchar  NOT null,
identificacion       varchar  NOT null,
CONSTRAINT estudiante_pk PRIMARY KEY (id_estudiante)
);


CREATE SEQUENCE ejemplo.producto_seq
start with 1
increment by 1;

CREATE TABLE ejemplo.producto (
    id_producto      numeric  NOT null default nextval('ejemplo.producto_seq'),
    nombre  varchar(60) NOT NULL
    CONSTRAINT pk_producto PRIMARY KEY (id)
);

CREATE SEQUENCE ejemplo.detalle_producto_seq
start with 1
increment by 1;

CREATE TABLE ejemplo.detalle_producto (
    id_detalle      numeric  NOT null default nextval('ejemplo.detalle_producto_seq'),
	id_producto     numeric  null,
	caracteristica  varchar(60) NOT null,
	CONSTRAINT pk_detalle_producto PRIMARY KEY (id_detalle),
	CONSTRAINT detalle_producto_fk FOREIGN KEY (id_producto) REFERENCES ejemplo.producto (id_producto)
);