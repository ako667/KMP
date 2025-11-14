public class TestKMP {

    public static void main(String[] args) {

        System.out.println("=== KMP TEST SUITE ===\n");

        // --------------------------
        // 4.1 SHORT STRING TEST
        // --------------------------
        String text1 = "abcde";
        String pattern1 = "cd";
        int expected1 = 2;
        int actual1 = KMP.search(text1, pattern1);

        System.out.println("4.1 Short String Test");
        System.out.println("Text: \"" + text1 + "\"");
        System.out.println("Pattern: \"" + pattern1 + "\"");
        System.out.println("Expected Result: " + expected1);
        System.out.println("Actual Result:   " + actual1);
        System.out.println(actual1 == expected1 ? "STATUS: PASS\n" : "STATUS: FAIL\n");


        // --------------------------
        // 4.2 MEDIUM STRING TEST
        // --------------------------
        String text2 = "the quick brown fox jumps over the lazy dog";
        String pattern2 = "brown";
        int expected2 = 10;
        int actual2 = KMP.search(text2, pattern2);

        System.out.println("4.2 Medium-Length String Test");
        System.out.println("Text: \"" + text2 + "\"");
        System.out.println("Pattern: \"" + pattern2 + "\"");
        System.out.println("Expected Result: " + expected2);
        System.out.println("Actual Result:   " + actual2);
        System.out.println(actual2 == expected2 ? "STATUS: PASS\n" : "STATUS: FAIL\n");


        // --------------------------
        // 4.3 LONG STRING TEST
        // --------------------------
        StringBuilder longText = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            longText.append("abcabcabcd");
        }
        longText.append("TARGET");

        String pattern3 = "TARGET";
        int expected3 = 10000 * 10;  // each chunk is 10 chars → 100k total
        int actual3 = KMP.search(longText.toString(), pattern3);

        System.out.println("4.3 Long String Test (≈100,000 characters)");
        System.out.println("Text: \"abcabcabcd\" repeated 10,000 times + \"TARGET\"");
        System.out.println("Pattern: \"TARGET\"");
        System.out.println("Expected Result: " + expected3);
        System.out.println("Actual Result:   " + actual3);
        System.out.println(actual3 == expected3 ? "STATUS: PASS\n" : "STATUS: FAIL\n");

    }
}
