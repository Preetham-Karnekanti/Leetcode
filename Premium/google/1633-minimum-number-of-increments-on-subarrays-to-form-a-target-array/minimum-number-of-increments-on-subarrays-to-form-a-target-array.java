class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int prev = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (target[i] > prev)
                res += (target[i] - prev);
            prev = target[i];
        }
        return res;
    }
}