package Algorithm;

public class HeapSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        var array = input.toCharArray();
        var n = array.length;

        buildHeap(array, n);

        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }

        return new String(array);
    }

    private void buildHeap(char[] array, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    private void heapify(char[] array, int n, int i) {
        var largest = i;
        var left = 2 * i + 1;
        var right = 2 * i + 2;

        if (left < n && shouldSwap(array[largest], array[left])) {
            largest = left;
        }

        if (right < n && shouldSwap(array[largest], array[right])) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    private boolean shouldSwap(char a, char b) {
        var categoryA = getCategory(a);
        var categoryB = getCategory(b);

        if (categoryA != categoryB) {
            return categoryA < categoryB;
        }

        return a < b;
    }

    private int getCategory(char c) {
        if (Character.isLowerCase(c)) {
            return 1;
        } else if (Character.isUpperCase(c)) {
            return 2;
        } else if (Character.isDigit(c)) {
            return 3;
        } else {
            return 4;
        }
    }

    private void swap(char[] array, int i, int j) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
