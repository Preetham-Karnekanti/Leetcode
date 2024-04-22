class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                hm.put(ch, i);
            } else
                hm.putIfAbsent(ch, i);
        }
        for (Character ch : hm.keySet()) {
            if (ch >= 'a' && ch <= 'z' && hm.get(ch) < hm.getOrDefault((char) (ch - 32), -1)) {
                count++;
            }
        }
        return count;
    }
}