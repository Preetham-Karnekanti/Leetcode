class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i[] : nums1) {
            hm.put(i[0], hm.getOrDefault(i[0], 0) + i[1]);
        }
        for (int i[] : nums2) {
            hm.put(i[0], hm.getOrDefault(i[0], 0) + i[1]);
        }
        int ans[][] = new int[hm.size()][2];
        int i = 0;
        for (int k : hm.keySet()) {
            ans[i][0] = k;
            ans[i++][1] = hm.get(k);
        }

        Arrays.sort(ans, (a, b) -> a[0] - b[0]);
        return ans;
    }
}