class Solution {
    public String sortVowels(String s) {
        char vowels[] = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowels[j] = ch;
                j++;
            }
        }
        Arrays.sort(vowels, 0, j);
        char[] ch = s.toCharArray();
        int k = 0;
        for (int i = 0; i < ch.length; i++) {
            if (isVowel(ch[i])) {
                ch[i] = vowels[k++];
            }
        }

        return new String(ch);
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
                || c == 'U') {
            return true;
        } else {
            return false;
        }
    }
}