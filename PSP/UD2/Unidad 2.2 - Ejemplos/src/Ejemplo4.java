public class Ejemplo4 {
    public static void main(String[] args) {
        CounterSynchronized c = new CounterSynchronized(100);

        Thread tinc = new Thread(new CounterIncRunnableSynchronized(c));
        Thread tdec = new Thread(new CounterDecRunnableSynchronized(c));
        
        tinc.start();
        tdec.start();
    }
}
