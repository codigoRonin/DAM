public class Ejemplo2 {
    public static void main(String[] args) {
        Thread t1 = new MyThreadWaiting();
        Thread t2 = new MyThreadWaiting(t1);

        t1.start();
        // El hilo t2 no empezará hasta que termine t1
        t2.start();
    }
}
