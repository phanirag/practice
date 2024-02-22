package MultiThreading.CompletableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


public class SupplyAsycImpl {
    
    public static void main(String[] args) throws Exception {
        // List<Integer> values = supplyAsyncFutureWithoutCustomExecutor();
        // CompletableFuture<List<Integer>> values = supplyAsyncFutureThenApply();
        // supplyAsyncFutureThenAcceptOrThenRun();
        // supplyAsyncFutureThenAcceptOrThenRunAsync();
        // System.out.println(values);


        // get all threads 
        CompletableFuture<List<Integer>> values = supplyAsyncFutureThenApply();
        CompletableFuture<List<Integer>>values1 = supplyAsyncFutureThenApply();
        CompletableFuture<List<Integer>> values2 = supplyAsyncFutureThenApply();
        Void vFuture = CompletableFuture.allOf(values, values1, values2).join();
    }

    public static List<Integer> supplyAsyncFutureWithoutCustomExecutor() throws Exception {
        CompletableFuture<List<Integer>> completableFuture = CompletableFuture.supplyAsync(
            () -> {
                System.out.println(Thread.currentThread().getName());
                return IntStream.range(1, 10).boxed().toList();
            }
        );
        return completableFuture.get();
    }

    public static List<Integer> supplyAsyncFutureCustomExecutor() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<List<Integer>> completableFuture = CompletableFuture.supplyAsync(
            () -> {
                System.out.println(Thread.currentThread().getName());
                return IntStream.range(1, 10).boxed().toList();
            }, executorService
        );
        return completableFuture.get();
    }

    public static CompletableFuture<List<Integer>> supplyAsyncFutureThenApply() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<List<Integer>> completableFuture = CompletableFuture.supplyAsync(
            () -> {
                System.out.println(Thread.currentThread().getName());
                return IntStream.range(1, 10).boxed().toList();
            }, executorService
        ).thenApply((e) -> {
               return e.stream().map(i -> i * 2).toList(); 
        }).thenApply((e) -> {
            return e.stream().filter(i -> i > 4).toList();
        });
        return completableFuture;
    }

    // If I do not want to return value and run only the I can use this thenAccept or thenRun
    public static void supplyAsyncFutureThenAcceptOrThenRun() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
            () -> {
                System.out.println(Thread.currentThread().getName());
                return IntStream.range(1, 10).boxed().toList();
            }, executorService
        ).thenApply((e) -> {
            return e.stream().map(i -> i * 2).toList(); 
        }).thenApply((e) -> {
            return e.stream().filter(i -> i > 4).toList();
        }).thenAccept((e) -> {
            System.out.println(e);
        });

        completableFuture.get();
    }

    // for Async
    public static void supplyAsyncFutureThenAcceptOrThenRunAsync() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5 );
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
            () -> {
                System.out.println(Thread.currentThread().getName());
                return IntStream.range(1, 10).boxed().toList();
            }, executorService).thenApplyAsync((e) -> {
            System.out.println(Thread.currentThread().getName());
            return e.stream().map(i -> i * 2).toList(); 
        }, executorService).thenApplyAsync((e) -> {
            System.out.println(Thread.currentThread().getName());
            return e.stream().filter(i -> i > 4).toList();
        }, executorService  ).thenAcceptAsync((e) -> {
            System.out.println(e);
        },executorService);

        completableFuture.get();
    }
    
}
