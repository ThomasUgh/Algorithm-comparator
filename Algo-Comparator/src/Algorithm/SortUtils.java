package Algorithm;

public final class SortUtils {

    private SortUtils() {
        // Verhindert Instanziierung
    }

    public static int getCategory(final char c) {
        if (c >= 'a' && c <= 'z') {
            return 1; // setzt Kleinbuchstaben
        } else if (c >= 'A' && c <= 'Z') {
            return 2; // setzt Großbuchstaben
        } else if (c >= '0' && c <= '9') {
            return 3; // setzt Zahlen
        } else {
            return 4; // setzt Sonderzeichen
        }
    }

    public static boolean shouldSwap(final char a, final char b) {
        final int categoryA = getCategory(a);
        final int categoryB = getCategory(b);

        if (categoryA != categoryB) {
            return categoryA > categoryB;
        }
        return a > b;
    }

    public static void swap(final char[] array, final int i, final int j) {
        final char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
