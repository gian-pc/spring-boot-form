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
13. Lista de Países(Objetos)
    - Creamos una nueva clase Pais
    - Enlazamos Pais - Usuario: Cambiamos String por Pais en la clase Usuario
    - @Valid evalúa la clase por separado
    - @NotNull: Evalúa si se creo o no el objeto
    - En el controlador agregamos un método
    - Modificamos el form.html
14. Desacoplar
    - Creamos el package services
      - Creamos una interface Ipais
        - Generamos 2 métodos
      - Creamos 1 clase PaisService
        - Implements Ipais
        - Desarrollamos los 2 métodos implementados
        - Generamos un constructor, de tal manera que al llamar a PaisService se construye los países 1 sola vez para luego ser retornado las veces que sea necesario
        - Desarrollamos el método ObtenerPais
    - Inyectamos la Interface IPais en el FormController @Autowired
      - Para ello PaisService debe convertirse en un componente @Service
      - Creamos un nuevo método que retorne todos los países
    - Hacemos un cambio en form.html con el nuevo método "objectPaisesV2"
    - Probamos y se genera un error de validación, debido a que ahora estamos validando un objeto completo, debemos hacer ciertos cambios
    - Eliminamos la validación @NotEmpty en Pais
    - Cambiamos el atributo pais @NotNull en Usuario
    - Adicional hacemos un cambio a NotNull.usuario.pais en messages.properties
    - Probamos y vuelve a generarse el error
      - Está fallando la conversión de codigo que es un String hacia un Objeto de tipo País
        - Solución: Lo que haremos es tomar el código que es un String mapearlo con el método **obtenerPais** que reciba el codigo por parámetro devuelva un país y la conversión Pais con Pais si se la respete
          - Creamos un package **editors**
          - Creamos 1 clase **PaisEditor**
          - Convertimos en un @Component
          - Extendemos de PropertyEditorSupport(Convertir un texto en algo de otro tipo)
          - Inyectamos la interface IPais
          - En el **FormController** inyectamos PaisEditor
          - Agregamos un nuevo método **@InitBinder**
            - Se inicia en primer lugar y se registra un editor(Lo que contenga paisEditor(Un método que me permite cambiar ese String código a un País))
            - Adicionalmente tenemos que decirle a quien va a afectar **pais** de Usuario
            - También tenemos que decirle de qué tipo es **Pais.class**
            - Funciona así: Al momento de hacer click el boton **enviar** se ejecuta el método **initBinder**
              - Se registra el editor, toma el código, envía ese código, busca un Pais en concreto y retorna un Pais y ese Pais completo le asigna al campo **pais**
              - De tal forma que en los resultados se pueda acceder a todos los atributos de pais y no solamente a uno de ellos
              - En resultado agregamos usuario.pais.nombre
15. Date
    - Agregamos un atributo **fechaNacimiento** de tipo Date
    - Agregamos un nuevo campo en el form.html
    - Agregamos en el resultado.html
    - Le damos formato a fechaNacimiento con @DateTimeFormat(pattern = "yyyy-MM-dd")
    - En form.html se recomienda usar type="date" el cual le agrega un formato
    - En resultado también agregamos un formato
    - Para evitar que se envíe un campo vacío se agrega @NotNull en fechaNacimiento
    - Agregamos messages.properties
    - @Past y @Future validá que las fechas sean del pasado o futuro
16. Roles
    - Creamos un nuevo campo roles y agregamos la anotación @NotEmpty
    - Agregamos los getters y setters
    - En el FormController agregamos un nuevo método @ModelAttribute("listRoles")
    - Agregamos un nuevo campo en el form
    - Agregamos un bucle para las listas de roles
    - En el form agregamos ids para que al hacer clic en las etiquetas de roles se seleccione la casilla del checkbox
    - Agregamos una lista en el Resultado
17. Resultado
    - ![img.png](src%2Fmain%2Fresources%2Fstatic%2Fimg.png)