package MultiThreading;


import java.util.stream.IntStream;

class Hi1 implements Runnable{
    public void run() {
        for(int i=0; i<= 5; i++) {
            try {
                System.out.println("Hi");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Hello1 implements Runnable{
    public void run() {
        for(int i=0; i<= 5; i++) {
            try {
                System.out.println("Hello");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class RunnableDemo{

    public static void main(String[] args) throws InterruptedException {
        Hi1 hi = new Hi1();
        Hello1 hello = new Hello1();

        Thread t1 = new Thread(hi);
        t1.start();
        try{ Thread.sleep(10);}
        catch (Exception e){
            throw new RuntimeException(e);
        }
        Thread t2 = new Thread(hello);
        t2.start();
    }
}
