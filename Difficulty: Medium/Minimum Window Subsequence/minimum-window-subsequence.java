class Solution {

    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int i = 0; i < n; i++) {
            // If first character matches, try to find subsequence
            if (s1.charAt(i) == s2.charAt(0)) {

                int p1 = i;
                int p2 = 0;

                // Forward scan to match s2 as subsequence
                while (p1 < n && p2 < m) {
                    if (s1.charAt(p1) == s2.charAt(p2)) {
                        p2++;
                    }
                    p1++;
                }

                // If full s2 matched
                if (p2 == m) {
                    int end = p1 - 1;

                    // Backward scan to minimize window
                    p2 = m - 1;
                    while (p2 >= 0) {
                        if (s1.charAt(end) == s2.charAt(p2)) {
                            p2--;
                        }
                        end--;
                    }
                    end++;

                    int windowLen = p1 - end;
                    if (windowLen < minLen) {
                        minLen = windowLen;
                        startIndex = end;
                    }
                }
            }
        }

        return startIndex == -1 ? "" : s1.substring(startIndex, startIndex + minLen);
    }
}
