public class EjemploDaemonThread {
    public static void main(String[] args) {
        Thread t = new MultiplierThread(8);

        t.setDaemon(true);
        t.start();
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     System.err.println("Error se interrumpio la espera");
        // }
        System.out.println("Finaliza el Proceso Principal");
    }
    
}
