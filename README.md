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
4. Optimización del punto 3
   - Los nombres de los inputs del formulario **form** tienen que ser iguales a los nombres de los atributos del Objeto **Usuario**
5. Validaciones y Manejo de Errores
   - **@NotEmpty**: No permite enviar datos vacíos de Usuario
     - Le ponemos a todos los atributos de Usuario
     - Adicional al atributo email le agregamos **@Email**
   - **@Valid**: Con esta anotación le estamos diciendo que le estamos validando al Usuario
   - **Manejo de Errores**
     - **BindingResult**: Mapea todos los errores
     - Enviamos todos los errores encontrados a form.html
     - Validamos los errores en form.html
     - Para evitar que se pierdan los datos al actualizar la página form.html usamos th:value="${usuario.username}"
     - Adicional agregamos en el FormControl en el método form <code> Usuario usuario = new Usuario();</code>
6. Optimizar los errores
   - Hacer un código más pequeño usando etiquetas adicionales en Thymeleaf
   - Para ello **Thymeleaf** mapea el form.html, los **inputs** deben de ser iguales a los nombres de los atributos de **Usuario**.
   - Modificamos el **FormController**
   - También modificamos el **form.html** añadiendo etiquetas
7. Optimizar los errores II
8. Pasar un Id
   - Agregamos un atributo a la clase Usuario
   - Agregamos un campo más en form.html
   - En resultado le decimos que lea el campo id
   - Manteniendo un valor en memoria **@SessionAttributes("usuario")**
   - Finalizando la session en memoria de id con **SessionStatus**
   - También agregamos un Select de forma Explicita
9. Mejorando el SELECT
   - Generamos una lista de forma general
   - Para ello hacemos un método general @ModelAttribute
   - Luego modificamos la vista form.html
10. Optimizando el punto 9
    - Agregamos un Arrays con la lista de países
11. Utilizando un Map
    - Hacemos una lista de Países, pero con Map en el FormController
    - Modificamos el form.html
12. Desacoplando los mensajes
    - Creamos messages.properties
