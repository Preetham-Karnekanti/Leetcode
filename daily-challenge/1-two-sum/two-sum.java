class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int idx = 0;
        for (int i : nums) {
            if (hm.containsKey(target - i)) {
                return new int[] { hm.get(target - i), idx };
            }
            hm.put(i, idx++);
        }
        return new int[] { -1, -1 };
    }
}