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


## Script DB
CREATE SEQUENCE ejemplo.estudiantes_seq
start with 1
increment by 1;

CREATE TABLE ejemplo.estudiantes(
id_estudiante          numeric  NOT null default nextval('ejemplo.estudiantes_seq'),
nombre                 varchar  NOT null,
identificacion       varchar  NOT null,
CONSTRAINT estudiante_pk PRIMARY KEY (id_estudiante)
);