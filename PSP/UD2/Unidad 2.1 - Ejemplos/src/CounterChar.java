public class CounterChar {
    public static void main(String[] args) {
        Thread t = new Thread(new CounterCharThread());
        t.start();

        do {
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            System.out.println("hola");
        } while (t.isAlive());
        System.out.println("Hilo finalizado, y el programa tambien");
    }
}
