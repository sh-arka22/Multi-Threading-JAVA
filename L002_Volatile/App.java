package L002_Volatile;

import java.util.Scanner;

public class App {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (running) {
                System.out.println("hello 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (running) {
                System.out.println("hello 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        running = false;
    }
}
