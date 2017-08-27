# iridio crm
El software iridio crm es un pequeño proyecto desarrollado en Java EE con Spring Boot, Spring Data JPA, Thymeleaf e Hibernate, que permite a una empresa registrar las llamadas recibidas y emitidas por los clientes. 

# Base de datos MySql
Los datos necesarios para que la aplicación pueda acceder a la base de datos, pueden conocerse y modificarse en el fichero: application.yml que se encuentra en la ruta: /src/main/resources

Los datos de acceso por defecto son:

    + url:      jdbc:mysql://localhost:3306/iridiodb?useSSL=false
    + username: admin
    + password: pass
    
La base de datos puede estar completamente vacía ya que la aplicación se encargará de generar las distintas tablas necesarias para su funcionamiento.

# Deployment
Esta versión del crm genera un archivo de extensión JAR con Tomcat embebido propio de Spring Boot. La versión WAR para despliegue en cualquier servidor externo (como Tomcat o GlassFish) que sea compatible con esta tecnología, se puede encontrar aquí: https://github.com/ivelaz/iridiocrmwar


