class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i], root);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, findMax(nums[i], root));
        }
        return max;
    }

    public void insert(int num, Trie root) {
        for (int i = 31; i >= 0; i--) {
            int bit = checkBit(num, i);
            if (root.arr[bit] == null)
                root.arr[bit] = new Trie();
            root = root.arr[bit];
        }
    }

    public int findMax(int num, Trie root) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = checkBit(num, i);
            if (root.arr[1 - bit] != null) {
                ans = ans + (1 << i);
                root = root.arr[1 - bit];
            } else
                root = root.arr[bit];
        }
        return ans;
    }

    public int checkBit(int num, int i) {
        num = num >> i;
        return num & 1;
    }
}

class Trie {
    Trie arr[];

    Trie() {
        arr = new Trie[2];
    }
}