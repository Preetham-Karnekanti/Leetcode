class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem == 0 && i > 1)
                return true;
            if (hm.containsKey(rem) && i - hm.get(rem) > 1)
                return true;
            hm.putIfAbsent(rem, i);
        }
        return false;
    }
}