public class EjemploFinalUD2_1_Runnable implements Runnable {

    // Referencia al hilo actual
    Thread t;

    public void start2Threads() {
        // Creamos el primer hilo
        t = new Thread(this);
        t.start();

        // Sleep 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        // Create segundo hilo
        t = new Thread(this); // #1
        t.start();

      //  Sleep 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        // Destruimos el hilo
        t = null; // #2
    }

    @Override
    public void run() {
        // Almacenamos el tiempo inicial en milisegundos
        long ini = System.currentTimeMillis();
        while (t == Thread.currentThread()) {
            System.out.println("Running thread (" + ini + ") ");
            // Sleep durante 100 ms
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Finishing thread (" + ini + ") ");
    }
}
