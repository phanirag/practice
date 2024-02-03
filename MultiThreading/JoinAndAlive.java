package MultiThreading;

public class JoinAndAlive {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                () -> {
                    for(int i=0; i<= 5;i++) {
                        System.out.println("Hi");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i<=5; i++) {
                        System.out.println("Hello");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        t1.start();
        Thread.sleep(10);
        t2.start();

        System.out.println(t1.isAlive());

        t1.join();
        t2.join();

        System.out.println(t1.isAlive());

        System.out.println("End");
    }
}
