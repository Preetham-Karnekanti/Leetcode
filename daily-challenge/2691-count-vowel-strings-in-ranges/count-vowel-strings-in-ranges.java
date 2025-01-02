class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int prefix[] = new int[words.length];
        prefix[0] = isValid(words[0]) ? 1 : 0;
        for (int i = 1; i < words.length; i++) {
            if (isValid(words[i]))
                prefix[i] = prefix[i - 1] + 1;
            else
                prefix[i] = prefix[i - 1];
        }
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = prefix[r] - prefix[l] + (isValid(words[l]) ? 1 : 0);
        }
        return ans;
    }

    public boolean isValid(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }
}