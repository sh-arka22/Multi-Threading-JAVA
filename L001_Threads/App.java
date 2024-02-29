package L001_Threads;
//class Runner extends Thread{
//    @Override
//    public void run() {
//        for(int i=0; i<11; i++){
//            System.out.println("hello " + i);
//            try {
//                Thread.sleep(10000);
//            }
//            catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//    }
//}
class Runner implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<11; i++){
            System.out.println("hello " + i);
            try {
                Thread.sleep(100);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
public class App {
    public static void main(String[] args) {
        //if we are using class extending Thread class we do this way
//        Runner run1 = new Runner();
//        Runner run2 = new Runner();
//        run1.start();
//        run2.start();



        //if we are using class implementing a Runnable Interface we do this way
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());
        t1.start();
        t2.start();

    }
}
