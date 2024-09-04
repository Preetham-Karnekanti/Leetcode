class Solution {
    public int smallestCommonElement(int[][] arrays) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int m = arrays.length;
        int n = arrays[0].length;
        for (int i = 0; i < n; i++) {
            hm.put(arrays[0][i], 0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (hm.getOrDefault(arrays[i][j], -1) == i - 1) {
                    hm.put(arrays[i][j], i);
                    if (i == m - 1)
                        return arrays[i][j];
                }
            }
        }
        return -1;
    }
}