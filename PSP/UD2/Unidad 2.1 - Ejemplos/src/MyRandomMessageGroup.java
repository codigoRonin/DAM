public class MyRandomMessageGroup {
    public static void main(String[] args) {
        ThreadGroup g = new ThreadGroup("Random messages");

        // MyRandomMessage m = new MyRandomMessage();
        Thread m = new Thread(new MyRandomMessage());
        
        Thread t1 = new Thread(g, m);
        Thread t2 = new Thread(g, m);
        Thread t3 = new Thread(g, m);
        t1.start();
        t2.start();
        t3.start();

        while (g.activeCount() == 3) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
        g.interrupt();
    }
}
