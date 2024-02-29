package L005_ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

class Tmp {
    AtomicInteger integer;

    public Tmp(AtomicInteger integer) {
        this.integer = integer;
    }

    public void execute() {
        integer.decrementAndGet();
    }
}

public class Demo {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(10);
        for (int i = 0; i < 10; i++) {
            new Tmp(integer).execute();
            System.out.println(integer);
        }
    }
}
