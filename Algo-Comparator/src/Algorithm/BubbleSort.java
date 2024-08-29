package Algorithm;

public class BubbleSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        var array = input.toCharArray();
        var n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (SortUtils.shouldSwap(array[j], array[j + 1])) {
                    SortUtils.swap(array, j, j + 1);
                }
            }
        }
        return new String(array);
    }
}
