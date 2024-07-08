class Solution {
    public int integerReplacement(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        return helper(n, hm);
    }

    public int helper(int n, HashMap<Integer, Integer> hm) {
        if (n == 1)
            return 0;
        if (n == Integer.MAX_VALUE)
            return 32;
        if (hm.containsKey(n))
            return hm.get(n);
        if (n % 2 == 0) {
            int steps = 1 + helper(n / 2, hm);
            hm.put(n, steps);
            return steps;
        } else {
            int steps = Math.min(helper(n - 1, hm), helper(n + 1, hm)) + 1;
            hm.put(n, steps);
            return steps;
        }
    }
}