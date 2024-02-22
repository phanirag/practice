package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RunnableImpl implements Runnable {
    public void run() {
        for(int i=0; i<=5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("R1 running and count is : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CallableImpl implements Callable {

    @Override
    public Object call() throws Exception {
        Integer l1 = 444;
        for(int i=0; i<=5; i++) {
            Thread.sleep(1000);
            System.out.println("Running callable : " + i);
        }
        return l1;
    }

} 
public class RunnableAndCallable {
    public static void main(String[] args) throws Exception {
        // runnableInterface();
        callableInterface();
    }

    private static void runnableInterface() {
        System.out.println("Begain execution");


        // 2 implementation to run runnable 
        // 1) add runnable to thread
        // 2) submit runnable to Executor services

        // we cannot return the result
        RunnableImpl runnableImpl = new RunnableImpl();
        Thread t1 = new Thread(runnableImpl);
        // t1.start();
        // t1.join();

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(runnableImpl);

        System.out.println("End execution");
    }

    @SuppressWarnings("unchecked")
    public static void callableInterface() throws Exception {
        System.out.println("Begain callable execution");

        CallableImpl callableImpl = new CallableImpl();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> o1 = service.submit(callableImpl);
        System.out.println("Callable return value is : " + o1.get().intValue());

        System.out.println("End callable execution");
    }
}
