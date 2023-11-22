public class CounterIncRunnable implements Runnable {
  private Counter c;

  public CounterIncRunnable(Counter c) {
    this.c = c;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      c.increment();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {}
    }
    System.out.println("Finishing inc. Final value = " + c.getValue());
  }
}
