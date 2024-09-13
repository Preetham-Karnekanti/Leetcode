class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int pre[] = new int[arr.length];
        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre[i] = pre[i - 1] ^ arr[i];
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start == end)
                ans[i] = arr[start];
            else
                ans[i] = pre[start] ^ pre[end] ^ arr[start];
        }
        return ans;
    }
}