class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int n = s.length();
        int count = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            while (left <= i && freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += n - i;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}