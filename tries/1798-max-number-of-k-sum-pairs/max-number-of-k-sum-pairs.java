class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = k - nums[i];
            if (hm.containsKey(x)) {
                count++;
                hm.put(x, hm.get(x) - 1);
                if (hm.get(x) == 0)
                    hm.remove(x);
            } else {
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}