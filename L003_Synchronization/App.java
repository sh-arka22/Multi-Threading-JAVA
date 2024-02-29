package L003_Synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class App {
    //Using volatile keyword ensures that changes to a variable are immediately visible to other threads. However, it does not provide atomicity for operations that involve multiple steps.
    static volatile int countGlobal = 0;
    public static synchronized void increament(){
        countGlobal++;
    }
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        Thread t1 = new Thread(()->{
           for(int i=0; i<10000; i++){
               count.getAndIncrement();
               increament();
           }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10000; i++){
                    count.getAndIncrement();
                    increament();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count.get());
        System.out.println(countGlobal);
    }
}
