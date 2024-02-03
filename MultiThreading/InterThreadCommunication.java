package MultiThreading;

class Q {
    int num;
    boolean setValue = false;
    public synchronized void set(int i) {
        while (setValue) {
            try { wait();} catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Put" + num);
        this.num = i;
        setValue = true;
        notify();
    }

    public synchronized void get() {
        while (!setValue) {
            try { wait();} catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Get" + num);
        setValue = false;
        notify();
    }
}

class Producer implements Runnable{

    Q q;

    public Producer(Q q) {
        this.q = q;
        Thread t1 = new Thread(this, "Producer");
        t1.start();
    }

    @Override
    public void run() {
        int i=0;
        while (true) {
            q.set(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Consumer implements Runnable {

    Q q;

    public Consumer(Q q) {
        this.q = q;
        Thread t1 = new Thread(this, "Consumer");
        t1.start();
    }
    @Override
    public void run() {
        while (true) {
            q.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class InterThreadCommunication {

    public static void main(String[] args) {
        Q q = new Q();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);


    }
}
