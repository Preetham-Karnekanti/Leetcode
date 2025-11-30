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
        long targetRemainder = sum % p;
        int minLength = nums.length;
        long currentSum = 0;
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            currentSum = (currentSum + nums[i]) % p;
            long complement = (currentSum - targetRemainder + p) % p;
            
            if (hm.containsKey(complement)) {
                minLength = Math.min(minLength, i - hm.get(complement));
            }
            
            hm.put(currentSum, i);
        }
         return minLength == nums.length ? -1 : minLength;
    }
}