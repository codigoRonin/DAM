public class InterruptionThread implements Runnable {

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Running");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        }
        System.out.println("Finished by an interruption");

    }
}
