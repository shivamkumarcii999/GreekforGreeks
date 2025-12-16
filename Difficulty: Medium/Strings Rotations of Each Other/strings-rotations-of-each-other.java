class Solution {

    public static boolean areRotations(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        String text = s1 + s1;
        return kmpSearch(text, s2);
    }

    // KMP search
    private static boolean kmpSearch(String text, String pattern) {
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // LPS array computation
    private static int[] computeLPS(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        int len = 0, i = 1;

        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}
