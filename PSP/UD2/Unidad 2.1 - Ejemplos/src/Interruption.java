public class Interruption {
    public static void main(String[] args) {
        Thread t = new Thread(new InterruptionThread());
        t.start();
        try {
            // Wait for a while...
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        t.interrupt();
      
    }
}
