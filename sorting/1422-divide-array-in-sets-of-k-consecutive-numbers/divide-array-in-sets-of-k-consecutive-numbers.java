class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 0)
                continue;

            for (int j = 0; j < k; j++) {
                int temp = j + nums[i];

                if (map.getOrDefault(temp, 0) == 0)
                    return false;
                map.put(temp, map.getOrDefault(temp, 0) - 1);
            }
        }
        return true;
    }
}