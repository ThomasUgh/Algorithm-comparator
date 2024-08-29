import Algorithm.*;

import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

public class Main {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/~`";
    private static final String UMLAUTS = "äöüÄÖÜ";

    private static final String ALL_CHARACTERS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS + UMLAUTS;

    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) throws InterruptedException {
        var input = generateRandomString(100000);
        out.println();

        SortAlgorithm[] algorithms = {
                new BubbleSort(),
                new QuickSort(),
                new HeapSort(),
                new SelectionSort(),
                new InsertionSort(),
                new MergeSort(),
                new ShellSort(),
        };

        ExecutorService executor = Executors.newFixedThreadPool(algorithms.length);

        var futures = new CompletableFuture[algorithms.length];

        for (int i = 0; i < algorithms.length; i++) {
            final SortAlgorithm algorithm = algorithms[i];
            futures[i] = CompletableFuture.runAsync(() -> {
                try {
                    var startTimeMillis = currentTimeMillis();
                    var startTimeNanos = nanoTime();
                    var output = algorithm.sort(input);
                    var endTimeMillis = currentTimeMillis();
                    var endTimeNanos = nanoTime();
                    var durationMillis = endTimeMillis - startTimeMillis;
                    var durationNanos = endTimeNanos - startTimeNanos;

                    out.println(algorithm.getClass().getSimpleName() + " took " + durationMillis + " ms / " + durationNanos + " ns");
                    //out.println(output);
                    out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, executor);
        }
        CompletableFuture.allOf(futures).join();

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static String generateRandomString(int length) {
        var result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            var index = RANDOM.nextInt(ALL_CHARACTERS.length());
            result.append(ALL_CHARACTERS.charAt(index));
        }
        return result.toString();
    }
}
