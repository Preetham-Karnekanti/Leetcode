class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : banned)
            hs.add(i);
        int sum = 0;
        int picked = 0;
        for (int i = 1; i <= n; i++) {
            if (hs.contains(i))
                continue;
            if (sum + i <= maxSum) {
                sum += i;
                picked++;
            } else
                return picked;
        }
        return picked;
    }
}