package Algorithm;

public class QuickSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        char[] array = input.toCharArray();
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
            if (shouldSwap(array[j], pivot)) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private boolean shouldSwap(char a, char b) {
        int categoryA = getCategory(a);
        int categoryB = getCategory(b);

        if (categoryA != categoryB) {
            return categoryA > categoryB;
        }

        return a > b;
    }

    private int getCategory(char c) {
        if (Character.isLowerCase(c)) {
            return 1;
        } else if (Character.isUpperCase(c)) {
            return 2;
        } else if (Character.isDigit(c)) {
            return 3;
        } else {
            return 4; // Sonderzeichen
        }
    }

    private void swap(char[] array, int i, int j) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
