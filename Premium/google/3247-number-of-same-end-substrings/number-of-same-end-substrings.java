class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int freq[] = new int[26];
        int prefixSum[][] = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            prefixSum[i + 1] = freq.clone();
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int count = 0;
            for (int k = 0; k < 26; k++) {
                int frequency = prefixSum[end + 1][k] - prefixSum[start][k];
                count += (frequency) * (frequency + 1) / 2;
            }
            ans[i] = count;
        }
        return ans;
    }
}