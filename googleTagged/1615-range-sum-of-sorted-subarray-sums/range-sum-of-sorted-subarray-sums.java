class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                al.add(sum);
            }
        }
        int res = 0, mod = 1000000007;
        Collections.sort(al);
        for (int i = left - 1; i < right; i++) {
            res = (res + al.get(i)) % mod;
        }
        return res;
    }
}