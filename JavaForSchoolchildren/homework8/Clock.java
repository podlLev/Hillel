public class Clock implements Runnable {
  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      System.out.println("Tik");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
