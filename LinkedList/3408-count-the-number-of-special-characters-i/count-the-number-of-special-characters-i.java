class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            hs.add(word.charAt(i));
        }
        for (Character ch : hs) {
            if (hs.contains((char) (ch - 32)))
                count++;
        }
        return count;
    }
}