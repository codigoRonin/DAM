public class CounterIncRunnableSynchronized implements Runnable {
    private CounterSynchronized  c;

  public CounterIncRunnableSynchronized(CounterSynchronized c) {
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
