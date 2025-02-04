class Solution {
    public int maxAscendingSum(int[] nums) {
        int i = 0;
        int max = 0;
        while(i < nums.length){
            int sum = nums[i];
            while(i < nums.length - 1 && nums[i] < nums[i + 1]){
                sum += nums[i + 1];
                i++;
            }
            i++;
            max = Math.max(max, sum);
        }
        return max;
    }
}