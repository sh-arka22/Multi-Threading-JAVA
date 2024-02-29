package L0012_Semaphores;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    private Semaphore sem = new Semaphore(10);
    private int connections = 0;
    private Connection(){

    }
    public static Connection getInstance(){
        return instance;
    }

    public void connect(Object lock){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lock){
            connections++;
            System.out.println("current connections: " + connections);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lock){
            connections--;
        }

        sem.release();
    }
}
