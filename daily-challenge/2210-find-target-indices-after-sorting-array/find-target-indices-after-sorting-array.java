class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanCount = 0;
        int targetCount = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target)
                lessThanCount++;

            if (nums[i] == target)
                targetCount++;
        }
        for (int j = 0; j < targetCount; j++) {
            list.add(lessThanCount + j);
        }
        return list;
    }
}