class Solution {

    // NOTE: method name MUST be removeKdig (not removeKdigits)
    public String removeKdig(String s, int k) {

        int n = s.length();
        if (k >= n) return "0";

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // greedy removal
            while (k > 0 && stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(ch);
        }

        // remove remaining digits from end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // remove leading zeros
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        if (idx == stack.length()) return "0";
        return stack.substring(idx);
    }
}
