class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;

        int[] leftBoundary = new int[n]; 
        int[] rightBoundary = new int[n]; 
        for(int i = 0 ;i < n ; i ++){
            leftBoundary[i] = -1;
            rightBoundary[i] = n ;
        }

        Stack<Integer> leftStack = new Stack<>(); 
        Stack<Integer> rightStack = new Stack<>(); 

        for (int i = n - 1; i >= 0; i--) {
            while (!leftStack.empty() && nums[leftStack.peek()] > nums[i]) {
                leftBoundary[leftStack.pop()] = i;
            }
            leftStack.push(i);
        }

        for (int i = 0; i < n; i++) {
            while (!rightStack.empty() && nums[rightStack.peek()] > nums[i]) {
                rightBoundary[rightStack.pop()] = i;
            }
            rightStack.push(i);
        }

        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            if (leftBoundary[i] < k && rightBoundary[i] > k) {
                int subarrayScore = nums[i] * (rightBoundary[i] - leftBoundary[i] - 1);
                maxScore = Math.max(maxScore, subarrayScore);
            }
        }

        return maxScore;
    }
}