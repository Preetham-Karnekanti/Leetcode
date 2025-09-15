class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        String words[] = text.split(" ");
        int freq[] = new int[26];
        for (int i = 0; i < brokenLetters.length(); i++)
            freq[brokenLetters.charAt(i) - 'a']++;
        for (int i = 0; i < words.length; i++) {
            if (canType(words[i], freq))
                count++;
        }
        return count;
    }

    public boolean canType(String word, int freq[]) {
        for (int i = 0; i < word.length(); i++) {
            if (freq[word.charAt(i) - 'a'] > 0)
                return false;
        }
        return true;
    }
}