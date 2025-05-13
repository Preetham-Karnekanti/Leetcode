class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        while (t-- > 0) {
            int nxt[] = new int[26];
            nxt[0] = freq[25];
            nxt[1] = (freq[0] + freq[25]) % MOD;
            for (int i = 2; i < 26; i++) {
                nxt[i] = freq[i - 1];
            }
            freq = nxt;
        }
        int len = 0;
        for (int i = 0; i < 26; i++)
            len = (len + freq[i]) % MOD;
        return len;
    }
}