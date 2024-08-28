package Algorithm;

public class InsertionSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        char[] array = input.toCharArray();
        int n = array.length;

        for (int i = 1; i < n; i++) {
            char key = array[i];
            int j = i - 1;

            while (j >= 0 && SortUtils.shouldSwap(array[j], key)) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        return new String(array);
    }
}
