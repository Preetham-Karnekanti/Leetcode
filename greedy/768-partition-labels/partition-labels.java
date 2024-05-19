public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] hashh = new int[26];
        
        for (int i = s.length() - 1; i > 0; --i)
            hashh[s.charAt(i) - 'a'] = Math.max(i, hashh[s.charAt(i) - 'a']);
        
        int hi = 0, sz = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            ++sz;
            hi = Math.max(hi, hashh[s.charAt(i) - 'a']);
            if (i == hi) {
                ans.add(sz);
                sz = 0;
            }
        }
        return ans;
    }
}