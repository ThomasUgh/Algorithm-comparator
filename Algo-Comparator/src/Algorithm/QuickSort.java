package Algorithm;

public class QuickSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        var array = input.toCharArray();
        quickSort(array, 0, array.length - 1);
        return new String(array);
    }

    private void quickSort(char[] array, int low, int high) {
        if (low < high) {
            var pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(char[] array, int low, int high) {
        var pivot = array[high];
        var i = low - 1;
        for (int j = low; j < high; j++) {
            if (!SortUtils.shouldSwap(array[j], pivot)) {
                i++;
                SortUtils.swap(array, i, j);
            }
        }
        SortUtils.swap(array, i + 1, high);
        return i + 1;
    }
}
