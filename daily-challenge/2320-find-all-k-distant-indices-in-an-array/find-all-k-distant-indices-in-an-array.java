class Solution {
    public List findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        int[] diffarr = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int l = i - k;
                int r = i + k + 1;
                if (l < 0)
                    diffarr[0] += 1;
                else
                    diffarr[l] += 1;
                if (r < n)
                    diffarr[r] -= 1;
            }
        }
        List ans = new ArrayList<>();
        if (diffarr[0] > 0)
            ans.add(0);
        for (int i = 1; i < n; i++) {
            diffarr[i] += diffarr[i - 1];
            if (diffarr[i] > 0)
                ans.add(i);
        }
        return ans;
    }
}