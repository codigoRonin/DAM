# Ejercicio 1

Crea una carpeta llamada Excercice_HelloUser. Añade un fichero llamado greeting.js y échale un ojo a la API a un módulo de node llamado os -> https://nodejs.org/dist/latest-v14.x/docs/api/os.html

Para ser más precisos, presta atención al método userInfo. Úsalo para saludar al inicio de sesión al usuario que ingresó al sistema. Por ejemplo, si el inicio de sesión del usuario es "michel", el programa debería decir "Hola michel".

    AYUDA: el método userInfo devuelve un objeto con algunas propiedades. Para obtener el nombre de usuario, debe obtener la propiedad username.

    AYUDA: el método console.log permite especificar un número variable de parámetros que son unidos automáticamente por espacios en blanco, por lo que puede unir texto estático y variable de diferentes maneras, como:

`
console.log("Hello " + name);     console.log("Hello", name);
`
# Ejercicio 2

Crea una carpeta llamada Exercise_JoinList en tu espacio de trabajo. Define un archivo package.json ejecutando el comando npm init, con valores por defecto para todos los atributos. Entonces, instala el módulo lodash como hemos explicado anteriormente, y utilízalo para crear un programa en el archivo index.js para unir una colección de nombres separados por comas.

Por ejemplo, si tenemos este array: [“Michel“, “Ana”,“Paco”], la salida debería ser:

    Michel, Ana, Paco

Puedes consultar la documentación del módulo lodash en -> https://lodash.com/docs. Échale un vistazo a cómo se usa el método join para obtener la salida deseada.

# Ejercicio 3

Crea un proyecto llamado Exercise_ContactsMongo en tu espacio de trabajo. Usa npm init y npm install para instalar mongoose en este proyecto y crear un archivo fuente llamado contacts.js. Agrega el código explicado anteriormente para conectarse a una base de datos llamada contacts y define el esquema que se muestra arriba para el model de contact. Luego, debes implementar varias acciones dependiendo de un parámetro adicional que utilices al iniciar la aplicación:

• Si llamas a la aplicación de esta manera: node contactos.js i, entonces debe agregar 3 contactos válidos a la colección de contactos. Estos contactos están predefinidos en el código, no se le preguntan al usuario.

• Si llamas a la aplicación de esta otra manera contactos.js l, mostrará dos listas:

    o   Listar todos los contactos de la colección
    o	Listar un contacto filtrando por su nombre y teléfono

• Si llamas a la aplicación de esta otra manera contactos.js u, debe actualizar el nombre de un contacto, dado su id (o cualquier otro atributo, si quieres)

• Finalmente, si llamas a la aplicación de esta manera contactos.js d, debe eliminar un contacto por su id.

Ten en cuenta que ninguna de estas opciones debe preguntar nada al usuario. Simplemente agregarán, eliminarán o actualizarán documentos predefinidos. Entonces debes cambiar el código para especificar el id para eliminar o actualizar, por ejemplo.

Para obtener este parámetro adicional (i, l, u o d), puedes usar el vector process.argv, que obtiene toda la lista de argumentos. El primer argumento (process.argv[0]) es el comando node, y el segundo (process.argv[1]) es el archivo fuente para ejecutar (contacts.js , en nuestro caso). Así que debes acceder a process.argv[2] para determinar qué operación debe realizarse.

# Ejercicio 4

Crea un proyecto llamado Exercise_BasicExpress en tu Workspace. Instala Express en él y utilízalo para definir un servidor Web que responda a través de un comando GET a estas URIs:

•	URI /date: el servidor enviará al cliente la fecha y hora actual, en el formato que quieras. Puedes utilizar las funciones estándar de fechas que trae JavaScript.

•	URI /user:  el servidor responderá al cliente con el usuario que se haya logueado en el sistema operativo. Puedes utilizar la librería “os” para completar esta tarea.

# Ejercicio 5

Crea el proyecto Exercise_ContactsExpress con las bibliotecas Express y Mongoose como hemos explicado anteriormente. Conéctate con Mongoose a la base de datos de contactos y define el esquema y el modelo de contacto.

Inicializa el servidor Express y agrega estos dos métodos para procesar ambas peticiones GET. Pruébalos desde un navegador web. Con respecto al segundo método, usa una identificación válida de tu base de datos de contactos para obtener toda la información al respecto. Con respecto a la petición POST, agrega el código explicado y averigua como podrías probarlo.

# Ejercicio 6

Crea una nueva colección de Postman llamada Contacts (si aún no la ha creado) y agrega las peticiones pertinentes para: obtener todos los contactos, obtener un contacto por su id añadir un nuevo contacto. Para la entrega de este ejercicio exporta la colección creada en Postman (si lo deseas puedes adjuntar un documento PDF con las capturas que creas oportunas).

# Ejercicio 7

Agrega estos dos nuevos métodos (PUT y DELETE) a nuestra aplicación Exercise_ContactsExpress y sus correspondientes peticiones de Postman para probarlos.

# Ejercicio 8 (Opcional)

Crea una aplicación Java de consola llamada LinkSearch que le pedirá una dirección e imprimirá todos los enlaces ( <a> ) detectados en la respuesta. Si quieres, es una buena idea crear una clase auxiliar que extiende de BufferedReader.

# Ejercicio 9

Crea un proyecto Java llamado JsonParsing. Agregua la librería GSON y luego implementa un programa (una aplicación de consola, no una JavaFX) que use el código anterior (ServiceUtils , Person , Address y GetPersonResponse, aparte de la aplicación principal) para conectarse a un servidor y recuperar la información de una persona.

El servidor constará de un único end-point  localhost/services/example para recuperar los datos JSON, y escuchará en el puerto 3000.

# Ejercicio 10

Crea un proyecto JavaFX llamado FXWebServiceExample y crea una aplicación JavaFX similar a la que se muestra en los apuntes. Usa la clase GetSumService para acceder al servicio de la suma y recuperar la suma de los dos dígitos enviados como parámetros.

Como en el ejercicio anterior, puedes utilizar los servicios de Node que se te proporcionan en los apuntes. En este caso, deberás acceder a localhost/services/sum con los dos parámetros necesarios (por ejemplo, localhost/services/sum/5/2 debería devolver 7 como resultado). 



