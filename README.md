# iridio crm
El software iridio crm es un pequeño proyecto desarrollado en Java EE con Spring Boot, Spring Data JPA, Thymeleaf e Hibernate, que permite registrar las llamadas emitidas y recibidas, por parte de y hacia,los clientes. No trata de ser una solución comercial sino más bien código para ensayar habilidades (opino que se aprende a programar... programando).

# Base de datos MySql
Los datos necesarios para que la aplicación pueda acceder a la base de datos, pueden conocerse y modificarse en el fichero: application.yml que se encuentra en la ruta: /src/main/resources

Los datos de acceso por defecto son:

    + url: jdbc:mysql://localhost:3306/iridiodb?useSSL=false
    + username: admin
    + password: pass
    
La base de datos puede estar completamente vacía ya que la aplicación se encargará de generar las distintas tablas necesarias para su funcionamiento.

# Deployment
Esta versión del crm genera un archivo de extensión JAR con Tomcat embebido propio de Spring Boot. En otro repositorio publicaré la versión WAR para despliegue en cualquier contenedor de servlets externo (como Tomcat o GlassFish) que sea compatible con esta tecnología.


