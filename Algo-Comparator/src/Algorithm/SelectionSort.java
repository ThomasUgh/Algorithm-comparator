package Algorithm;

public class SelectionSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        var array = input.toCharArray();
        var n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (shouldSwap(array[minIdx], array[j])) {
                    minIdx = j;
                }
            }
            swap(array, i, minIdx);
        }

        return new String(array);
    }

    private boolean shouldSwap(char a, char b) {
        var categoryA = getCategory(a);
        var categoryB = getCategory(b);

        if (categoryA == categoryB) {
            return a > b;
        }
        return categoryA > categoryB;

    }

    private int getCategory(char c) {
        if (Character.isLowerCase(c)) {
            return 1; // Kleinbuchstaben
        } else if (Character.isUpperCase(c)) {
            return 2; // Großbuchstaben
        } else if (Character.isDigit(c)) {
            return 3; // Zahlen
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
