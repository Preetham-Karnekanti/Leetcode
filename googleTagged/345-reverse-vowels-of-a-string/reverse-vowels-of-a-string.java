class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char chArray[] = s.toCharArray();
        while (i < j) {
            while (i < j && isVowel(s.charAt(i)) == false)
                i++;
            while (i < j && isVowel(s.charAt(j)) == false)
                j--;
            if (i < j) {
                char temp = chArray[i];
                chArray[i] = chArray[j];
                chArray[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chArray);
    }

    public boolean isVowel(char a) {
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        hs.add('A');
        hs.add('E');
        hs.add('I');
        hs.add('O');
        hs.add('U');
        return hs.contains(a);
    }
}