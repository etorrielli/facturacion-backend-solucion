# Bienvenido a la app facturacion-backend 
-----------------------------------
Este repo contiene el backend que provee de servicios Rest al frontend.

### Stack de Tecnologías utilizadas
Aplicacion Web:

* Git
* jdk-8
* MySql
* Maven
* Spring
* Hibernate
* Tomcat

### Build + Deploy + Run application
A continuación se detalla los comandos a ejecutar:

* mvn clean install (genera war)
* mvn tomcat7:run (corre el tomcat embebido)
* mvn -Dmaven.tomcat.port=8686 tomcat7:run (si se requiere cambiar el puerto por defecto)
