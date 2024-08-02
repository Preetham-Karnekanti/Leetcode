class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        
        // Step 2: Create a new array to store the wiggle sorted result
        int[] result = new int[nums.length];
        
        // Step 3: Use two pointers, one starting from the beginning and one from the middle
        int left = (nums.length - 1) / 2;
        int right = nums.length - 1;
        int index = 0;
        
        // Step 4: Fill the result array with wiggle sorted order
        while (index < nums.length) {
            if (index % 2 == 0) {
                result[index] = nums[left];
                left--;
            } else {
                result[index] = nums[right];
                right--;
            }
            index++;
        }
        
        // Step 5: Copy the result array back to the original array
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}