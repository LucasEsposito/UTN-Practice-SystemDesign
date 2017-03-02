# Instalación mysql
1. Instalar mysql y mysql-workbench
2. sudo mysql_install_db --user=mysql --basedir=/usr --datadir=/var/lib/mysql
3. Si es necesario, activar el servicio de mysql.
4. Completar con usuario y contraseña en persistence.xml:                                                                                                                     
            property name="hibernate.connection.username" value="root"                                                                                                        
            property name="hibernate.connection.password" value=""
5. En mysql-workbench -> create a new schema in the connected server -> llamarlo 'pois'
6. En el directorio del proyecto correr: mvn clean install && mvn eclipse:clean eclipse:eclipse

# Comandos copados sobre mysql:
## Bash:
mysql -h localhost -u root -p: iniciar mysql

## Mysql:
show databases: muestra las bases de datos

use <database>: cambia a la base de datos seleccionada

insert into <table> (<param1>,…,<paramn>) values (<value1>,…,<valuen>)

# Manejo de archivos
[![Libreria externa para manejar archivos](https://commons.apache.org/proper/commons-io/javadocs/api-2.4/org/apache/commons/io/FileUtils.html)](https://commons.apache.org/proper/commons-io/javadocs/api-2.4/org/apache/commons/io/FileUtils.html)

## Ver paquetes en forma comoda:
En eclipse, estando con Package explore, ir a la flechita hacia abajo que aparece arriba de la lista de proyectos -> Package presentation -> Hieranchical

De esa forma las cosas, segun el orden que les puse, se ven como corresponde y quedan en subcarpetas, en vez de verse en forma rara.
