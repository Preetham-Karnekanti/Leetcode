class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int time) {
        List<Integer> ans = new ArrayList<>();

        int n = arr.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i]) {
                dp1[i] = dp1[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (dp1[i] >= time && dp2[i] >= time) {
                ans.add(i);
            }
        }

        return ans;
    }
}