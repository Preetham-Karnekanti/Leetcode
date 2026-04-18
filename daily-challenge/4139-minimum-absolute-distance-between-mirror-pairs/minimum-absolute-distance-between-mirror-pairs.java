class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int reverse = getReverse(nums[i]);
            if (hm.containsKey(nums[i])) {
                min = Math.min(min, i - hm.get(nums[i]));
            }
            hm.put(reverse, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int getReverse(int num) {
        int rev = 0;
        while (num != 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }
        return rev;
    }
}