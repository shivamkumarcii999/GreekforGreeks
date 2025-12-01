class Solution {

    static class Node {
        Node[] child = new Node[2];
        int cnt; // how many numbers have passed through this node
    }

    static void insert(Node root, int num) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (root.child[bit] == null)
                root.child[bit] = new Node();
            root = root.child[bit];
            root.cnt++;
        }
    }

    static int query(Node root, int num, int k) {
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            if (root == null) break;

            int bitNum = (num >> i) & 1;
            int bitK = (k >> i) & 1;

            if (bitK == 1) {
                // all numbers with same bit give XOR < k at this level
                if (root.child[bitNum] != null)
                    ans += root.child[bitNum].cnt;

                // move to branch where XOR bit becomes 1
                root = root.child[1 - bitNum];
            } else {
                // must match bit exactly
                root = root.child[bitNum];
            }
        }
        return ans;
    }

    public int cntPairs(int[] arr, int k) {
        Node root = new Node();
        int count = 0;

        for (int num : arr) {
            count += query(root, num, k);
            insert(root, num);
        }

        return count;
    }
}
