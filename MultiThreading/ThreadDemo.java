package MultiThreading;


import java.util.stream.IntStream;

class Hi extends Thread{
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

class Hello extends Thread{
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
public class ThreadDemo{

    public static void main(String[] args) throws InterruptedException {
        Hi hi = new Hi();
        Hello hello = new Hello();

        hi.start();
        try{ Thread.sleep(10);}
        catch (Exception e){
            throw new RuntimeException(e);
        }
        hello.start();
    }
}
