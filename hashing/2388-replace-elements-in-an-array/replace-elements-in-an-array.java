class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }

        for (int i = 0; i < operations.length; i++) {
            nums[hm.get(operations[i][0])] = operations[i][1];
            hm.put(operations[i][1], hm.get(operations[i][0]));
        }

        return nums;
    }
}