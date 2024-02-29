package L008_WaitAndNotify;

import java.util.Scanner;

public class Processor {
    public void produceOne() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer1 thread running");
            wait();
            System.out.println("Resumed1. ");
        }
    }

    public void produceTwo() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer2 thread running");
            wait();
            System.out.println("Resumed2. ");
        }
    }

    public void produceThree() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer3 thread running");
            wait();
            System.out.println("Resumed3. ");
        }
    }

    public void consume() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(1000);
        synchronized (this){
            System.out.println("Wating for the return key. ");
            scanner.nextLine();
            System.out.println("Return key pressed. ");
            notifyAll();
            //notify(); this is used to unlock only one same-object
        }
    }
}
