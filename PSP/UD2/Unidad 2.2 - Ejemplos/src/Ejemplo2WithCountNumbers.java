public class Ejemplo2WithCountNumbers {
    public static void main(String[] args) {
        Thread t1 = new MyThreadWaitingWithCountNumber();
        Thread t2 = new MyThreadWaitingWithCountNumber(t1, 11);
        Thread t3 = new MyThreadWaitingWithCountNumber(t2, 21);

        t1.start();
        // El hilo t2 no empezará hasta que termine t1
        t2.start();
        // El hilo t3 no empezará hasta que termine t2
        t3.start();
    }
}
