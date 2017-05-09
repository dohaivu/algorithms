package study.rx;

import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.*;

public class TestRx {
    public static void main(String[] args) {

        testExecutor();
    }

    private static void testRx() {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");
        Observable<Integer> lengths = source
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.newThread())
                .map(String::length);

        lengths.subscribe(sum -> System.out.println("Received " + sum +
                " on thread " + Thread.currentThread().getName()));

        lengths.subscribe(t -> System.out.println(t + " - " + Thread.currentThread().getName()));

        sleep(3000);
    }
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testExecutor() {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
        Future<Integer> future = executor.submit(task);
        System.out.println("future done? " + future.isDone());

        try {
            Integer result = future.get();

            System.out.println("future done? " + future.isDone());
            System.out.println("result: " + result);
        } catch (ExecutionException e) {
            System.err.println("tasks execution");
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}