public class CountingThread extends Thread {

    @Override
    public void run() {
        super.run();
        for(int i=1;i<=10;i++){
            System.out.println("Contando - " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Error durmiendo hilo");
            }
        }
        System.out.println("Hilo que cuenta terminando");
    }
}
