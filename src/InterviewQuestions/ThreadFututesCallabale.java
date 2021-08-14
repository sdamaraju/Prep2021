package InterviewQuestions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadFututesCallabale {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(10);
        ex.execute(() -> { System.out.println("Runnabele executed"); });
        Future<Integer> a =  ex.submit(() -> {
            Thread.sleep(3000);
            return 10;});
        System.out.println("check 123");
        System.out.println("check 123");
        System.out.println("check 123");
        System.out.println("check 123");
        System.out.println(a.get());

        ex.shutdown();
    }
}
