public class Ejemplo3 {
    public static void main(String[] args) {
        Counter c = new Counter(100);

        Thread tinc = new Thread(new CounterIncRunnable(c));
        Thread tdec = new Thread(new CounterDecRunnable(c));
        
        tinc.start();
        tdec.start();
    }
}
