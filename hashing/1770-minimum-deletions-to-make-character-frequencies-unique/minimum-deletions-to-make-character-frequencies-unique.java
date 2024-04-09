class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int count = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (hs.contains(freq[i]) && freq[i] != 0) {
                count++;
                freq[i]--;
            }
            hs.add(freq[i]);
        }
        return count;
    }
}