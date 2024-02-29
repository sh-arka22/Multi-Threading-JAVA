package L0012_Semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
//        Semaphore sem = new Semaphore(1);
//        sem.release();
//        sem.acquire();
//        System.out.println("Available permits: " + sem.availablePermits());

//        Connection.getInstance().connect();
        Object lock = new Object();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0; i<200; i++){
            executorService.submit(new Thread(()->{
                Connection.getInstance().connect(lock);
            }));
        }

        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
