class Solution {
    public int countCharacters(String[] words, String chars) {
        int freq[] = new int[26];
        int ans = 0;
        for (int i = 0; i < chars.length(); i++)
            freq[chars.charAt(i) - 'a']++;
        for (int i = 0; i < words.length; i++) {
            int freq2[] = new int[26];
            for (int j = 0; j < words[i].length(); j++)
                freq2[words[i].charAt(j) - 'a']++;
            boolean flag = true;
            for (int k = 0; k < 26; k++) {
                if (freq2[k] > freq[k]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans += words[i].length();
        }
        return ans;
    }
}