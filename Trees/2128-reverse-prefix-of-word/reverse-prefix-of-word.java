class Solution {
    public String reversePrefix(String word, char c) {
        int j = word.indexOf(c);
        if (j == -1)
            return word;
        int i = 0;
        char ch[] = word.toCharArray();
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }
}