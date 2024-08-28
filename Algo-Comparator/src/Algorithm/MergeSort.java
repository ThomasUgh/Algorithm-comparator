package Algorithm;

public class MergeSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        char[] array = input.toCharArray();
        mergeSort(array, 0, array.length - 1);
        return new String(array);
    }

    private void mergeSort(char[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private void merge(char[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        char[] leftArray = new char[n1];
        char[] rightArray = new char[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (SortUtils.shouldSwap(leftArray[i], rightArray[j])) {
                array[k] = rightArray[j];
                j++;
            } else {
                array[k] = leftArray[i];
                i++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
