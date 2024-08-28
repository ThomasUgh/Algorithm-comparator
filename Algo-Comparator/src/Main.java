import Algorithm.BubbleSort;
import Algorithm.SelectionSort;
import Algorithm.SortAlgorithm;

import java.security.SecureRandom;

import static java.lang.System.*;

public class Main {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/~`";
    private static final String UMLAUTS = "äöüÄÖÜ";

    private static final String ALL_CHARACTERS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS + UMLAUTS;

    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        String input = generateRandomString(900);
        out.println("Generated Random String: " + input);
        out.println();

        SortAlgorithm[] algorithms = {
                new BubbleSort(),
                new SelectionSort(),
        };

        for (SortAlgorithm algorithm : algorithms) {
            var startTimeMillis = currentTimeMillis();
            var startTimeNanos = nanoTime();
            String sortedOutput = algorithm.sort(input);
            var endTimeMillis = currentTimeMillis();
            var endTimeNanos = nanoTime();
            var durationMillis = endTimeMillis - startTimeMillis;
            var durationNanos = endTimeNanos - startTimeNanos;

            out.println(algorithm.getClass().getSimpleName() + " took " + durationMillis + " ms / " + durationNanos + " ns");
            out.println("Sorted Output: " + sortedOutput);
            out.println();
        }
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
