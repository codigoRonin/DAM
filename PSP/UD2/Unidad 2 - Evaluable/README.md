# ACTIVIDAD EVALUABLE 2.2

Crea programa con un menú de 10 opciones, dicho menú constará de 9 proyectos (ejercicios) y la opción 10 para finnalizará la ejecución del mismo. (Recuerda aplicar las buenas prácticas aprendidas el la primera práctica).

1. Crea un proyecto llamado Thread Race. Define una subclase que extienda de Thread llamada RunnerThread y crea 3 objetos de esta subclase. Cada uno tendrá su propio nombre A, B y C, y deberán contar del 1 al 1000. El programa principal deberá esperar a que finalicen todos sus hilos, y deberá dormir 100 ms después de cada iteración, y escribir el conteo actual para cada hilo. Por ejemplo:

        Thread A: 77  Thread B: 82   Thread C: 67
        Thread A: 121 Thread B: 124  Thread C: 117
        ...

2. Crea un proyecto llamado Thread Race Killed basado en el proyecto creado en el Ejercicio anterior. Modifica la aplicación creando una subclase que extienda de Thread llamada RunnerThreadFlag para que, tan pronto como el hilo A llegue a 700, se le pida que finalice (con una variable booleana). Siéntete libre de agregar todo el código que necesites a cada clase del proyecto.

3. Crea un proyecto llamado ThreadRaceJoin basado en el proyecto del proyecto 1. Modifica la aplicación creando una subclase que extienda de Thread llamada RunnerThreadJoin. Cambia el comportamiento de los tres hilo en ejecución (A, B y C) para que cada uno comience a ejecutarse cuando finalice el hilo anterior:

    El hilo A comenzará al principio del programa.
    El hilo B comenzará cuando finalice el hilo A.
    El hilo C comenzará cuando finalice el hilo B.
    El programa principal esperará hasta que el último hilo (C) finalice la carrera.

4. Crea un proyecto llamado Multiplier Threads Join basado en el proyecto del Ejercicio de las tablas de multiplicar de los apuntes. Para ello copia la subclase que extiende de Thread llamada MultiplierThread. Cambia el comportamiento de la aplicación principal para que espere a que finalice cada hilo antes de iniciar el siguiente. Por lo tanto, todas las tablas de multiplicar se mostrarán en orden:

        0 x 0 = 0
        0 x 1 = 0
        ...
        0 x 10 = 0
        1 x 0 = 0
        ...

5. Crea un proyecto llamado Bank Account Synchronized con estas clases y métodos:

    - Una clase BankAccount con un atributo llamado balance que almacenará cuánto dinero hay en la cuenta. Agregua un constructor para inicializar el dinero en la cuenta, y dos métodos addMoneyy takeOutMoney, que agregarán o quitarán la cantidad pasada como parámetro. Agregua también un método para recuperar el saldo actual de la cuenta getBalance.

            public BankAccount(int balance) { ... }
            public void addMoney(int money) { ... }
            public void takeOutMoney(int money) { ... }
            public int getBalance() { ... }

    - Una clase BankThreadSave con un atributo de tipo BankAccount. Para hacer esa clase puedes extender de la clase Thread o implementar  Runnable. En el método run, el hilo agregará 100€ a la cuenta bancaria por 5 veces, durmiendo 100 ms entre cada operación.

    - Una  BankThreadSpend con un atributo de tipo BankAccount. Para hacer esa clase puedes extender de la claseThread o implementar la interfaz Runnable. En el método run, el hilo sacará 100€ de la cuenta bancaria por 5 veces, durmiendo 100ms entre cada operación.

    Desde la clase principal, crea un objeto BankAccount y una array de 20 objetos  BankThreadSave y 20 objetos BankThreadSpend, utilizando todos ellos el mismo objeto BankAccount. Inicia todos y comprueba cómo cambia el saldo de la cuenta bancaria (imprime un mensaje en algún lugar para mostrar el saldo después de cada operación).

    En este punto, deberías haber notado que tu cuenta bancaria no funciona correctamente. Añade los mecanismos de sincronización que consideres para solucionar el problema.

6. Creda un proyecto Bank Account Synchronized Object basado en el ejercicio anterior. En este caso, no puedes sincronizar ningún método, solo puede sincronizar objetos. ¿Qué cambios agregaría al proyecto para asegurarse de que seguirá funcionando correctamente? Renombra todas las clases añadiendo la palabra Object al final, por ejemplo BankAccountObject

7. Crea un proyecto llamado Thread Race Priorities basado en el proyecto Thread Race. Modifica el código para que el hilo A tenga MAX_PRIORITY, el hilo B tenga NORM_PRIORITY y el hilo C tenga MIN_PRIORITY. Hazlo con  setPriority. (A mi con windows 11 no me respeta las prioridades, comentadme que hace con vuestro sistema operativo)

8. Crear un proyecto llamado Thread Race Priorities Random que cambie la asignación de prioridades del ejercicio anterior por la segunda opción explicada (números aleatorios y método yield/sleep).

9. Crea un proyecto llamado DishWasher. Vamos a simular un proceso de lavado de platos en casa, cuando alguien lava los platos y alguien más los seca. Crea las siguientes clases:

    - Una clase Dish con solo un atributo entero: el número de plato (para identificar los diferentes platos).
   
    - Una clase DishPile que almacenará hasta 5 platos. Tendrá un método wash que pondrá un plato en la pila (si hay espacio disponible) y un método dry que tomará un plato de la pila (si hay alguno). Tal vez necesite un parámetro Dish en el método wash para agregar un plato a la pila.
    
    - Un hilo Washer que recibirá un número N como parámetro y un objeto DishPile. En su método run pondrá (lavará) N platos en la pila, con una pausa de 50ms entre cada plato.

    - Un hilo Dryer que recibirá un número N como parámetro y un objeto  DishPile. En su método run, sacará (secará) N platos de la pila, con una pausa de 100 ms entre cada plato.
    
    - La clase principal creará el objeto DishPile y un hilo de cada tipo (Washery Dryer). Tendrán que lavar/secar 20 platos coordinadamente, por lo que el resultado debe ser algo así:

        Washed dish #1, total in pile: 1
        Drying dish #1, total in pile: 0
        Washed dish #2, total in pile: 1
        Drying dish #2, total in pile: 0
        Washed dish #3, total in pile: 1
        Washed dish #4, total in pile: 2
        Drying dish #4, total in pile: 1
        Washed dish #5, total in pile: 2
        Washed dish #6, total in pile: 3
        Drying dish #6, total in pile: 2
        Washed dish #7, total in pile: 3

## Criterios de calificación.

1. Cada apartado de este ejercicio cuya funcionalidad haya sido implementada correctamente tiene una puntuación de 1 puntos.

2.	La correcta creación del menú tiene una puntuación de 0,5 punto. (TODO debe funcionar acorde a la Evaluativa de la UD1)

3.	Los siguientes fallos reducen la puntuación de cada uno de los apartados:

    -	Resource leak: menos 0.5 por cada error.
    -	Unhandled Exception: menos 0.5 por cada error.

        -	Las excepciones deben capturarse lo más cerca posible al lugar en el que se produzcan y deben controlarse de forma específica, es decir, debemos evitar el uso de la clase padre Exception.

4. Cualquier apartado no funcional, es decir, que no cumpla con lo solicitado, podrá optar, tan solo al 20% del total de su calificación.

5. Se penalizará con una reducción de 0.2 puntos en cada apartado si no se utilizan prácticas de código limpio.

6. La correcta elaboración de los comentarios del código acorde al anexo I y las prácticas comentadas en clase tiene una puntuación de 0,5 punto.
