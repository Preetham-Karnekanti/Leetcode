class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            mask = mask | (1 << allowed.charAt(i) - 'a');
        }

        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (int j = 0; j < word.length(); j++) {
                int bit = checkbit(mask, word.charAt(j) - 'a');
                if (bit == 0) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent)
                count++;
        }
        return count;
    }

    public int checkbit(int num, int i) {
        num = num >> i;
        return (num & 1);
    }
}