package Algorithm;

public class SortUtils {

    public static int getCategory(char c) {
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

    public static boolean shouldSwap(char a, char b) {
        int categoryA = getCategory(a);
        int categoryB = getCategory(b);

        if (categoryA != categoryB) {
            return categoryA > categoryB;
        }

        return a > b;
    }

    public static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
