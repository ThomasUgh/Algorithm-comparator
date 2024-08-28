import Algorithm.BubbleSort;
import Algorithm.SortAlgorithm;

public class Main {
    public static void main(String[] args) {
        var input = "a1B2c3b3A4D5e6F7g8H9t23ffvaexddv54ä4pvü423i0J!@#df3f22fwfsfsfsfsf3fwfsfs<fs<fs<fw3fsfsfsfsefs<f34232e32f3fbgb##sä29g33f";

        SortAlgorithm[] algorithms = {
                new BubbleSort(),
        };

        for (SortAlgorithm algorithm : algorithms) {
            var startTime = System.currentTimeMillis();
            String sortedOutput = algorithm.sort(input);
            var endTime = System.currentTimeMillis();
            var duration = endTime - startTime;

            System.out.println(algorithm.getClass().getSimpleName() + " took " + duration + " ns");
            System.out.println("Sorted Output: " + sortedOutput);
            System.out.println();
        }
    }
}