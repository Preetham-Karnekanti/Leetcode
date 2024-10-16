class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int n = calories.length;
        long sum = 0;
        for (int i = 0; i < k; i++)
            sum += calories[i];
        int ans = 0;
        if (sum < lower)
            ans--;
        else if (sum > upper)
            ans++;
        int left = 0;
        for (int right = k; right < n; right++) {
            sum = sum - calories[left] + calories[right];
            left++;
            if (sum < lower)
                ans--;
            else if (sum > upper)
                ans++;
        }
        return ans;
    }
}