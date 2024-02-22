package MultiThreading;

public class Deadlock {
    public static void main(String[] args) {

        System.out.println("Start of execution");
        String s1 = "s1";
        String s2 = "s2";

        Thread t1 = new Thread(
            () -> {
                synchronized(s1) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("t1 has s1 lock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(s2) {
                        System.out.println("cannot execute this blcok");
                    }
                }
            }, "Thead - 1"
        );

        Thread t2 = new Thread(
            () -> {
                synchronized(s2) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("t2 has s2 lock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(s1) {
                        System.out.println("cannot execute this blcok");
                    }
                }
            }, "Thead - 2"
        );

        t1.start();
        t2.start();

        System.out.println("end of execution");
    }
}
