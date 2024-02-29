package L011_DeadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private Account ac1 = new Account();
    private Account ac2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    public void firstThread() throws InterruptedException{
        Random random = new Random();
        for(int i=0; i<10000; i++){
            lock1.lock();
            lock2.lock();
            Account.tranfer(ac1, ac2, random.nextInt(100));
            lock1.unlock();
            lock2.unlock();
        }
    }

    public void secondThread() throws InterruptedException{
        Random random = new Random();
        for(int i=0; i<10000; i++){
            lock2.lock(); //writing the lock2 above causes the deadlock
            lock1.lock();
            Account.tranfer(ac2, ac1, random.nextInt(100));
            lock1.unlock();
            lock2.unlock();
        }
    }

    public void finished(){
        System.out.println("Account 1 balance: " + ac1.getBalance());
        System.out.println("Account 2 balance: " + ac2.getBalance());
        System.out.println("Total: " + (ac1.getBalance() +ac2.getBalance()));
    }
}
