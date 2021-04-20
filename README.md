![Java CI](../../workflows/Java%20CI/badge.svg)

# Proyecto Java Básico - JDBC 

## Config. Previa

Antes de empezar modifica el par&aacute;metro `prefixUsername` y ponle como valor tu inicial seguida de tu apellido, ejemplo `eserrano` para Eduardo Serrano.

Una vez realizado el cambio guarda el archivo, si lo necesitas refresca la configuraci&oacute;de Gradle en Eclipse. 
Bot&oacute;n derecho sobre el proyecto > Gradle > Refresh Gradle Project.

### Requisitos para crear una base de datos con MySQL y Docker

1. Tener Instalado Docker  
2. Instalar docker-compose  
`sudo apt install docker-compose`

#### Ubuntu  
[Instrucciones Instalación Docker Ubuntu](https://docs.docker.com/engine/install/ubuntu/)  

#### Windows 10  
[Instrucciones para Instalación Docker Windows](https://docs.docker.com/docker-for-windows/install/)

### Crear el contenedor

Situarse en el directorio de proyecto y ejecutar el siguiente comando  
$>`docker-compose-up`


#### CREAR UNA BD BÁSICA CON UNA TABLA

mysql>`CREATE DATABASE biblioteca;`

mysql>`USE biblioteca;`

mysql>`CREATE TABLE libro(
titulo VARCHAR(100),
isbn VARCHAR(10) PRIMARY KEY,
genero VARCHAR(10),
autor VARCHAR(100),
paginas INTEGER
);`

mysql>`
INSERT INTO libro VALUES ('libro1','3214569874','FICCION','autor1',100);  
INSERT INTO libro VALUES ('libro2','7413698525','POESIA','autor2',200);  
INSERT INTO libro VALUES ('libro3','9516234876','NOVELA','autor3',300);
`

Conectar directamenet al esquema de biblioteca  
$>`docker exec -it mysql1 mysql -udeveloper -p biblioteca`
$>`docker-compose exec db mysql -udeveloper -p biblioteca`

Consultar esquema/bd actual  
mysql>`SELECT DATABASE();`

### Comandos útiles  

Ejecutar contenedor  
$>` docker-compose up`

Conectar por consola  
$>`docker-compose exec db bash`

Cargar fichero sql desde consola
docker@container>`mysql -udeveloper -p biblioteca < /home/bd/biblioteca.sql`

Consultar ip contenedor desde consola
`docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' java-bd-basic-template_db_1`

Eliminar todos los contedores  
$>'docker-compose  rm -s'