package Algorithm;

public class BubbleSort implements SortAlgorithm {

    @Override
    public String sort(String input) {
        char[] array = input.toCharArray();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shouldSwap(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
        return new String(array);
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
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
