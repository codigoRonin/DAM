public class MyThreadWaitingWithCountNumber extends Thread {
    Thread waitThread;
    int number=1;
    // Usaremos este constructor
    // Si el hilo no tiene qu esperar a nadie
    public MyThreadWaitingWithCountNumber() {
        waitThread = null;
    }
    // Usaremos este constructor
    // Si el hilo no tiene qu esperar a nadie
    public MyThreadWaitingWithCountNumber(Thread wt,int number) {
        waitThread = wt;
        this.number= number;
    }
    // Comprobamos que waitThread no es nulo,
    // y llamaremos al metodo join antes de ejecutar las instrucciones de nuestro run
    public void run() {
        if (waitThread != null){
            try {
                waitThread.join();
            } catch (InterruptedException e1) {
                System.err.println("Error uniendo hilo");
            }
        }
        for (int i = number; i <  number + 10; i++) {
            System.out.println("Esperando - " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Error durmiendo hilo");
            }
        }
    }
}