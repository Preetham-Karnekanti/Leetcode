class Solution {
    HashMap<String, Integer> hm;

    public int minSteps(int n) {
        hm = new HashMap<>();
        return helper(n, 1, 0, 0);
    }

    public int helper(int n, int a, int copy, int pasteCount) {
        if (n == a)
            return 0;
        if (n < a)
            return (int) 1e9;
        String key = a + ":" + copy + ":" + pasteCount;
        if (hm.get(key) != null)
            return hm.get(key);
        if (copy == 0) {
            return 1 + helper(n, a, 1, a);
        }
        int one = 1 + helper(n, a + pasteCount, 1, pasteCount);
        int two = 1 + helper(n, a + pasteCount, 0, pasteCount);
        hm.put(key, Math.min(one, two));
        return Math.min(one, two);
    }
}