package L010_ReEntrantLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private int count = 0;
    private Lock lock;
    public Runner(Lock lock){
        this.lock = lock;
    }
    private void increment(){
        for(int i=0; i<10000; i++){
            count++;
        }
    }
    public void firstThread() throws InterruptedException{
        lock.lock();
        try{
            increment();
        }
        finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException{
        lock.lock();
        try{
            increment();
        }
        finally {
            lock.unlock();
        }
    }

    public void finished(){
        System.out.println(count);
    }
}
