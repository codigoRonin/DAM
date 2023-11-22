public class Ejemplo1 {
    public static void main(String[] args) {
        Thread t = new CountingThread();
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.err.println("Error al unir hilo");
        }
        System.out.println("Proceso principal terminado");
    }
}
