public class CounterCharThread implements Runnable {

    @Override
    public void run() {
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println(c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Error Hilo Interumpidos");
            }
        }

    }
}
