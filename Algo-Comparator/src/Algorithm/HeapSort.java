package Algorithm;

public class HeapSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        char[] array = input.toCharArray();
        int n = array.length;

        buildHeap(array, n);

        for (int i = n - 1; i > 0; i--) {
            SortUtils.swap(array, 0, i);
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
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && SortUtils.shouldSwap(array[largest], array[left])) {
            largest = left;
        }

        if (right < n && SortUtils.shouldSwap(array[largest], array[right])) {
            largest = right;
        }

        if (largest != i) {
            SortUtils.swap(array, i, largest);
            heapify(array, n, largest);
        }
    }
}
