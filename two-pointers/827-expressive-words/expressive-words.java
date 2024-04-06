class Solution {
    public int expressiveWords(String s, String[] words) {
        char[] streched = s.toCharArray();
        int ans = 0;
        for (String word : words) {
            if (isValid(streched, word.toCharArray()))
                ans++;
        }
        return ans;
    }

    public boolean isValid(char[] streched, char[] word) {
        int i = 0;
        int j = 0;
        while (i < streched.length && j < word.length) {
            if (streched[i] != word[j])
                return false;
            char ch = streched[i];
            int count1 = 1;
            i++;
            j++;
            while (i < streched.length && streched[i] == ch) {
                i++;
                count1++;
            }

            int count2 = 1;
            while (j < word.length && word[j] == ch) {
                j++;
                count2++;
            }
            if (count1 == count2)
                continue;
            if (count1 < 3 || count2 > count1)
                return false;
        }
        return i == streched.length && j == word.length;
    }
}