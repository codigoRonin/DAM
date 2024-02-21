# ACTIVIDAD EVALUABLE 3

## Ejercicio 1:

Crea una aplicación cliente-servidor "eco" usando Java sockets, creando para ello dos proyectos separados (uno para el cliente y otro para el servidor):

Crea un proyecto para el lado del servidor llamado Echo_Server. Define un servidor que escuchará el puerto 6000, y cuando obtenga una conexión, leerá constantemente un mensaje del cliente y le enviará el mismo mensaje, convertido en mayúsculas. Por ejemplo, si recibe el mensaje "Hola", devolverá "HOLA" al cliente.

Cree un proyecto para el lado del cliente llamado Echo_Client. Define un socket que se conectará al servidor (usa "localhost" como nombre del servidor, si está ejecutando ambos proyectos en la misma máquina). Cuando se establece la conexión, el cliente solicita constantemente al usuario que ingrese un mensaje, y luego lo enviará al servidor, esperando el eco correspondiente.

El proceso de comunicación terminará cuando el servidor reciba el mensaje “bye”.

## Ejercicio 2:

Crea una aplicación cliente-servidor UDP con los siguientes proyectos:

Un proyecto llamado UDPDictionary_Client que enviará al servidor una palabra escrita por el usuario. Intenta establecer un tiempo de espera en el cliente (por ejemplo, 5 segundos), utilizando el método setSoTimeout del socket. Si este tiempo de espera expira, se lanzará una excepción InterruptedIOException y el cliente deberá imprimir un mensaje en la pantalla con el texto "No translation found".

Un proyecto llamado UDPDictionary_Server que se ejecutará en el puerto 6000. Tendrá una colección (HashMap o similar) con algunas palabras en inglés (keys) y su correspondiente traducción al español (values). El servidor leerá la palabra enviada por el cliente y devolverá la traducción al español de esa palabra. Si la palabra no se encuentra en la colección, el servidor no devolverá nada.

## Ejercicio 3:

Mejora el Ejercicio 1 con estos dos cambios:

Haz que la conexión cliente-servidor sea independiente de las máquinas donde se encuentran. Es decir, no debe usar "localhost" como la dirección del servidor. En lugar de esto, deje que el usuario especifique la dirección del servidor.

Permite que más de un cliente se conecte al servidor. Luego, el servidor deberá hacer eco de los mensajes de diferentes clientes, enviando a cada uno sus respuestas.

Llama a los nuevos proyectos EchoImproved_Server y EchoImproved_Client.

## Ejercicio 4:

Crea una aplicación de serialización con los siguientes proyectos:

Vamos a trabajar con datos de usuario. Por lo tanto, crea un nuevo proyecto llamado UserData_Model y defina una clase User dentro, con los siguientes atributos: el nombre de usuario y la contraseña (Strings), la fecha de registro y los constructores, getters y setters apropiados. El constructor debe dejar el nombre de usuario y la contraseña vacíos (""), y la fecha de registro se completará automáticamente con la fecha actual.

## Ejercicio 5:

En este ejercicio vamos a simular una versión simplificada de una subasta. Para hacer esto, almacenaremos la información del producto que queremos vender en una clase Product (recuerda crear un proyecto separado para manejar esta clase). Los atributos que queremos almacenar son el nombre del producto, el nombre del comprador y el precio del producto. Inicialmente, el servidor creará un Producto con su nombre de producto y un precio de subasta inicial (el nombre del comprador estará inicialmente vacío). Luego, el servidor esperará a que 3 clientes diferentes se conecten y les enviará el producto. Cada cliente verá la información del producto en la consola, luego escribirá su nombre y el total que cada uno debe pagar por el producto, en una línea, separados por un espacio en blanco. 

	Por ejemplo:  michel 150

El servidor recogerá las respuestas de todos los clientes y les quitará la cantidad máxima. Luego, actualizará la información del producto con el precio actual y el nombre del comprador, y enviará el producto actualizado a los clientes, para que sepan quién ganó la subasta. Aquí puedes ver un ejemplo de cómo debería funcionar…

1. Inicialmente, el servidor crea un producto, con un nombre y un precio inicial. Por ejemplo, “Xbox One”, 100 euros.

2. Luego, esperará a que 3 clientes se conecten.

3. A continuación, enviará el objeto Product completo a cada cliente. Entonces verán esta información en sus consolas:

        Product name: Xbox One
        Product initial price: 100 euros

A continuación, se pedirá a cada cliente que introduzca su nombre y precio, en el mismo formato explicado anteriormente. Por ejemplo, podríamos tener estas tres ofertas de los 3 clientes diferentes:

	michel 150
	arturo 170
	felisa 120

El servidor recibirá estos 3 mensajes, los comparará y elegirá el que tenga la oferta más alta. Luego, actualizará los datos del producto con el nombre y el precio del comprador, y enviará la información a los clientes. Entonces, los clientes verían esta información como el resultado final:

    Final price: 170 euros
    Buyer's name: arturo

Llama a los proyectos Auction_Model (proyecto para almacenar la clase Product), Auction_Server y Auction_Client . También puede agregar cualquier clase o método adicional que pueda necesitar (por ejemplo, para administrar clientes conectados al servidor) 

## Ejercicio 6:

Crea una aplicación de multidifusión con los siguientes proyectos:

Un proyecto de servidor llamado MulticastMessage_Server que le pide al usuario que ingrese mensajes desde el teclado y los envía a todos los clientes conectados al grupo. El proceso terminará cuando el usuario escriba "finish".

Un proyecto de cliente llamado MulticastMessage_Client que se conecta al servidor e imprime en la consola cada mensaje recibido del servidor.

