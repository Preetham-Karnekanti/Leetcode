class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() == 1)
            return s1.equals(s2);
        int freq[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return false;
        }
        int count = 0;
        int i = 0;
        int n = s1.length();
        while (i < n) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            i++;
        }
        if (count == 1 && s1.length() == 2)
            return false;
        return count == 2;
    }
}