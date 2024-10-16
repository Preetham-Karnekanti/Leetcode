class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.length() < k)
            return 0;
        int freq[] = new int[26];
        int count = 0;
        for (int i = 0; i < k; i++)
            freq[s.charAt(i) - 'a']++;
        if (hasOneOccurance(freq))
            count++;
        int left = 0;
        for (int right = k; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;
            freq[s.charAt(left) - 'a']--;
            left++;
            if (hasOneOccurance(freq))
                count++;
        }
        return count;
    }

    public boolean hasOneOccurance(int freq[]) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 1)
                return false;
        }
        return true;
    }
}