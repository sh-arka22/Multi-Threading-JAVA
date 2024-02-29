package L009_Example_WaitAndNotify;

import java.util.LinkedList;

public class Processor {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    Object lock = new Object();
    public void produce() throws InterruptedException{
        int value = 0;
        while (true){
            Thread.sleep(500);
            synchronized (lock){
                list.add(value++);
                lock.notify();
                lock.wait();
            }
        }
    }

    public void consume() throws InterruptedException{
        while (true){
            synchronized (lock){
                lock.wait();
                while(list.size() >5){
                    System.out.print("List size= " + list.size());
                    int value = list.removeFirst();
                    System.out.println("; value id: " + value);
                }
                lock.notify();
            }

        }
    }
}
