class Solution {
    Integer dp[];

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int a : arr){
            int prevNumber = hm.getOrDefault(a - difference, 0);
            hm.put(a, prevNumber + 1);
            ans = Math.max(ans,  prevNumber + 1);
        }
        return ans;
    }

    // public int helper(int arr[], int diff, int idx, int prev) {
    //     if (idx == arr.length)
    //         return 0;
    //     if (dp[idx][prev + 1] != null)
    //         return dp[idx][prev + 1];
    //     int notTake = helper(arr, diff, idx + 1, prev);
    //     int take = 0;
    //     if (prev == -1 || arr[idx] - arr[prev] == diff)
    //         take = 1 + helper(arr, diff, idx + 1, idx);
    //     return dp[idx][prev + 1] = Math.max(take, notTake);
    // }
}