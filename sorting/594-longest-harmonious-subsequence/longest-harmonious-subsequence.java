class Solution {
    public int findLHS(int[] nums) {
        int left = 0, answer = 0, right = 0;
        Arrays.sort(nums);

        while (right < nums.length) {

            if (nums[right] - nums[left] == 1) {
                answer = Math.max(answer, right - left + 1);
            }

            while (nums[right] - nums[left] > 1) {
                left++;
            }
            right++;
        }

        return answer;

    }
}