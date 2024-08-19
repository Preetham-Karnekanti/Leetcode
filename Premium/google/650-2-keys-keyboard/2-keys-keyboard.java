class Solution {
    HashMap<String, Integer> hm;

    public int minSteps(int n) {
        if (n == 1)
            return 0;
        hm = new HashMap<>();
        return helper(n, 1, 1) + 1;
    }

    public int helper(int n, int a, int pasteCount) {
        if (n == a)
            return 0;
        if (n < a)
            return (int) 1e9;
        String key = a + ":" + pasteCount;
        if (hm.get(key) != null)
            return hm.get(key);
        int one = 1 + helper(n, a + pasteCount, pasteCount);
        int two = 2 + helper(n, 2 * a, a);
        hm.put(key, Math.min(one, two));
        return Math.min(one, two);
    }
}