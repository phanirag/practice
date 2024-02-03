package MultiThreading;

public class ThreadPriority {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                () -> {
                    for(int i=0; i<= 5;i++) {
                        System.out.println("Hi" + Thread.currentThread().getName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, "Hi Thread"
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i<=5; i++) {
                        System.out.println("Hello" + Thread.currentThread().getName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, "Hello Thread"
        );

//        t1.setName("Hi Thread");
//        t2.setName("Hello Thread");
        System.out.println(t1.getName());
        System.out.println(t2.getName());

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());


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
