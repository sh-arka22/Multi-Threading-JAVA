package L004_SynchronizedLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private Object lock = new Object();
    public void stageOne(int i){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized(list1){
            list1.add(i);
        }
    }
    public void stageTwo(int i){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized(lock){
            list2.add(i);
        }
    }

    public void process(){
        for(int i=0; i<1000; i++){
            stageOne(i);
            stageTwo(i);
        }
    }

    public void main() {
        System.out.println("Starting..............");
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(()->{
            process();
        });
        Thread t2 = new Thread(()->{
            process();
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end-start));
        System.out.println("List1: " + list1.size() + "List2: " + list2.size());
        System.out.println(list1);
    }
}
