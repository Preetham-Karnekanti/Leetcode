class Solution {
    public int repeatedStringMatch(String a, String b) {
        int minRepeats = (int) Math.ceil(b.length() / a.length());
        for (int i = 0; i <= minRepeats + 2; i++) {
            String repeatA = a.repeat(i);
            if (repeatA.contains(b))
                return i;
        }

        return -1;
    }
}