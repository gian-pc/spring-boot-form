                                                         Proyecto 3
                                                        (Formularios)

1. Creamos el proyecto **spring-boot-form**
   - Maven
   - Jar
   - Java 17
   - Dependencias
     - Spring Web
     - Spring Boot Actuator
     - Thymeleaf
     - Validation
     - Spring Boot Dev Tools
2. Creamos un formulario
   - Creamos un package controllers
     - Dentro creamos FormController: Este controller tienes 2 métodos
   - Creamos 2 vistas html
     - form: envía los valores de form a la vista resultado
     - resultado: recibe los valores enviados por form
3. Creamos una clase para enviar un objeto
   - Ahora ya no enviaremos **datos** de forma individual
   - Ahora crearemos una **clase** que nos permita construir un objeto y enviar el objeto por completo
   - Creamos el package **model.domain**
   - Realizamos cierta modificación en el **FormController**
   - Realizamos cambios en **resultado.html**
