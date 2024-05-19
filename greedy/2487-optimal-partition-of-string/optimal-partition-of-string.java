class Solution {
    public int partitionString(String s) {
        int freq[] = new int[26];
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] != 0) {
                freq = new int[26];
                count++;
            }
            freq[s.charAt(i) - 'a']++;
        }
        return count;
    }
}