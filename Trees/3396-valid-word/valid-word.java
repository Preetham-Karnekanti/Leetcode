class Solution {
    public boolean isValid(String word) {
        boolean hasVowel = false;
        boolean hasConsonant = false;
        if (word.length() < 3)
            return false;
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetterOrDigit(word.charAt(i)))
                return false;
            if(Character.isDigit(word.charAt(i)))
                continue;
            if (isVowel(word.charAt(i)))
                hasVowel = true;
            else {
                hasConsonant = true;
            }
        }
        return hasVowel && hasConsonant;
    }

    public boolean isVowel(char c) {
        String str = "aeiouAEIOU";
        return str.indexOf(c) != -1;
    }
}