package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncImpl {
    public static void main(String[] args) throws Exception{
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        // completableFuture.get(); // here thread will be blocked
        //completableFuture.complete("return dummy data");
    
        // runAsyncFutureWithGlobalForkJoinPool();
        runAsyncFutureWithCustomExecutor();

    }

    // Run Asyc if the thred goal is to just run without return we can go with runAsync
    private static Void runAsyncFutureWithGlobalForkJoinPool() throws Exception{
        CompletableFuture<Void> cFuture = CompletableFuture.runAsync(() -> {
            for(int i=0; i<=5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Running completable future with thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        return cFuture.get();
    }

    private static Void runAsyncFutureWithCustomExecutor() throws Exception{
        ExecutorService service = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> cFuture = CompletableFuture.runAsync(() -> {
            for(int i=0; i<=5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Running completable future with thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, service);
        return cFuture.get();
    }

    // public static String supplyAsyncFuture() throws Exception {
    // }
}
