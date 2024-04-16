class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % p == 0)
            return 0;
        if (sum < p)
            return -1;
        long extra = sum % p;
        int len = nums.length;
        sum = 0;
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long rem = (sum % p + p) % p;
            hm.put(rem, i);
            long remToSearch = ((rem - extra) % p + p) % p;
            if (hm.containsKey(remToSearch)) {
                len = Math.min(len, i - hm.get(remToSearch));
            }
        }
        return len == nums.length ? -1 : len;
    }
}