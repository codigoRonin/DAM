public class ConsumerSynchronizedFinal extends Thread {

  SharedDataSynchronizedFinal data;

  public ConsumerSynchronizedFinal(SharedDataSynchronizedFinal data) {
    this.data = data;
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      int n = data.get();
      System.out.println("Consumed number " + n);
      try {
        Thread.sleep(15);
      } catch (Exception e) {}
    }
  }
}
