package L009_Example_WaitAndNotify;

public class App {
    public static void main(String[] args) throws InterruptedException{
        Processor processor = new Processor();
        Thread t1 = new Thread(()->{
            try {
                processor.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->{
            try {
                processor.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
