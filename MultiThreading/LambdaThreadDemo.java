package MultiThreading;

public class LambdaThreadDemo {

    public static void main(String[] args) {
        Runnable o1 = () -> {
            for(int i =0; i<=5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable o2 = () -> {
            for(int i =0; i<=5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(o1);
        Thread t2 = new Thread(o2);

        t1.start();
        t2.start();
    }

}
