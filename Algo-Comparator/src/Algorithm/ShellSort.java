package Algorithm;

public class ShellSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        char[] array = input.toCharArray();
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                char temp = array[i];
                int j;
                for (j = i; j >= gap && SortUtils.shouldSwap(array[j - gap], temp); j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return new String(array);
    }
}
