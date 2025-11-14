// KMP (Knuth–Morris–Pratt) algorithm implementation in Java

public class KMP {

    // Builds the LPS (Longest Prefix Suffix) array
    private static int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int prefixLen = 0;
        int i = 1;

        // Build the LPS array in O(m)
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(prefixLen)) {
                prefixLen++;
                lps[i] = prefixLen;
                i++;
            } else {
                if (prefixLen != 0) {
                    prefixLen = lps[prefixLen - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP search algorithm: returns index of first match or -1
    public static int search(String text, String pattern) {
        if (pattern.isEmpty()) return 0;

        int[] lps = buildLPS(pattern);

        int i = 0; // index in text
        int j = 0; // index in pattern

        // Search in O(n)
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    return i - j; // found match
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // no match found
    }

    public static void main(String[] args) {
        String text = "Hello, this is a long example string to test KMP pattern searching.";
        String pattern = "example";

        int result = search(text, pattern);
        System.out.println("Search result index: " + result);
    }
}
