class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
    }

    public int countSubs(String s) {
        TrieNode root = new TrieNode();
        int count = 0;

        // Insert all suffixes into the Trie
        for (int i = 0; i < s.length(); i++) {
            TrieNode current = root;

            for (int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';

                // New substring found
                if (current.child[idx] == null) {
                    current.child[idx] = new TrieNode();
                    count++;
                }

                current = current.child[idx];
            }
        }

        return count;
    }
}
