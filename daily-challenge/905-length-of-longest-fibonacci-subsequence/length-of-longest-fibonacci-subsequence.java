class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++)
            map.put(arr[i], i);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                max = Math.max(max, f(i, j, arr));
            }
        }
        if (max == 0)
            return max;
        return 2 + max;
    }

    private int f(int i, int j, int[] arr) {
        int nxt = arr[i] + arr[j];
        int k = map.getOrDefault(nxt, -1);
        if (k == -1)
            return 0;
        return 1 + f(j, k, arr);
    }
}