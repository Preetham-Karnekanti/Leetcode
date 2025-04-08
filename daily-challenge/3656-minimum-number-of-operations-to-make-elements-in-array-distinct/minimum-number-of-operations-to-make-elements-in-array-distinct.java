class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        int ops = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i += 3) {
            if (hm.size() == n - i)
                return ops;
            hm.put(nums[i], hm.get(nums[i]) - 1);
            if (hm.get(nums[i]) == 0)
                hm.remove(nums[i]);
            if (i + 1 < n) {
                hm.put(nums[i + 1], hm.get(nums[i + 1]) - 1);
                if (hm.get(nums[i + 1]) == 0)
                    hm.remove(nums[i + 1]);
            }
            if (i + 2 < n) {
                hm.put(nums[i + 2], hm.get(nums[i + 2]) - 1);
                if (hm.get(nums[i + 2]) == 0)
                    hm.remove(nums[i + 2]);
            }
            ops++;
        }
        return ops;
    }
}