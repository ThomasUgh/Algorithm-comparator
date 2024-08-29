package Algorithm;

public class SelectionSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        var array = input.toCharArray();
        var n = array.length;

        for (int i = 0; i < n - 1; i++) {
            var minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (SortUtils.shouldSwap(array[minIdx], array[j])) minIdx = j;
            }
            SortUtils.swap(array, i, minIdx);
        }

        return new String(array);
    }
}
