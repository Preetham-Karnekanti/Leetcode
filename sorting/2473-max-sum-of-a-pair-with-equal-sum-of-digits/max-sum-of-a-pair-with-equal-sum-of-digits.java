class Solution {
    public int maximumSum(int[] nums) {
        int maxSum = -1;
        int [] maxNums = new int [82];
        for(int num : nums){
            int digitsSum = 0;
            int temp = num;
            while(temp > 0){
                digitsSum += temp%10;
                temp = temp/10;
            }
            if(maxNums[digitsSum] != 0){
                maxSum = Math.max(maxSum, num + maxNums[digitsSum]);
            }
            maxNums[digitsSum] = Math.max(num, maxNums[digitsSum]);
        }
        return maxSum;
    }
}