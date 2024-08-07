class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                capitals++;
        }
        char ch = word.charAt(0);
        boolean isFirstLetterCapital = ch >= 'A' && ch <= 'Z';
        return capitals == word.length() || capitals == 0 || (capitals == 1 && isFirstLetterCapital);
    }
}