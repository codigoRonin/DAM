public class Ejemplo7B {
    public static void main(String[] args) {
        SharedDataSyncronizedFinalBad sd = new SharedDataSyncronizedFinalBad();
        ProducerSynchronizedFinalBad p = new ProducerSynchronizedFinalBad(sd);
        ConsumerSynchronizedFinalBad c = new ConsumerSynchronizedFinalBad(sd);
        p.start();
        c.start();
    }
  
}
